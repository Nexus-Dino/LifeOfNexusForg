package com.nexusdino.lifeofnexus.data.recipe;

import java.util.Objects;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nexusdino.lifeofnexus.LifeOfNexus;
import com.nexusdino.lifeofnexus.core.util.ILightningSummonerRecipe;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class LightningSummonerRecipe implements ILightningSummonerRecipe {

	public enum Weather {
		CLEAR, RAIN, THUNDERING;

		public static Weather getWeatherByString(String s) {
			return Objects.equals(s, "thundering") ? THUNDERING : Objects.equals(s, "rain") ? RAIN : CLEAR;
		}
	}
	
	public static class Type implements RecipeType<LightningSummonerRecipe> {
		
		@Override
		public String toString() {
			return LifeOfNexus.MOD_ID + ":lightning_summoner_recipe";
		}
	}

	private final ResourceLocation id;
	private final ItemStack output;
	private final NonNullList<Ingredient> recipeItems;
	private final Weather weather;

	public LightningSummonerRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems,
			Weather weather) {
		this.id = id;
		this.output = output;
		this.recipeItems = recipeItems;
		this.weather = weather;
	}

	@Override
	public boolean matches(Container inv, Level worldIn) {
		// Checks for correct focus (Glass Pane)
		if (recipeItems.get(0).test(inv.getItem(0)))
			return recipeItems.get(1).test(inv.getItem(1));

		return false;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipeItems;
	}

	@Override
	public ItemStack assemble(Container inv) {
		return output;
	}

	@Override
	public ItemStack getResultItem() {
		return output.copy();
	}

	public Weather getWeather() {
		return this.weather;
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return new Serializer();
	}

	public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>>
			implements RecipeSerializer<LightningSummonerRecipe> {

		@Override
		public LightningSummonerRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
			ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));
			String weather = GsonHelper.getAsString(json, "weather");

			JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
			NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
			}

			return new LightningSummonerRecipe(recipeId, output, inputs, Weather.getWeatherByString(weather));
		}

		@Override
		public LightningSummonerRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf buffer) {
			NonNullList<Ingredient> inputs = NonNullList.withSize(buffer.readInt(), Ingredient.EMPTY);

			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromNetwork(buffer));
			}

			ItemStack output = buffer.readItem();
			return new LightningSummonerRecipe(pRecipeId, output, inputs, buffer.readEnum(Weather.class));
		}

		@Override
		public void toNetwork(FriendlyByteBuf buffer, LightningSummonerRecipe recipe) {
			buffer.writeInt(recipe.getIngredients().size());
			for (Ingredient ing : recipe.getIngredients()) {
				ing.toNetwork(buffer);
			}
			buffer.writeItemStack(recipe.getResultItem(), false);
			buffer.writeEnum(recipe.weather);
		}

	}
}
