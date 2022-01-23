package com.nexusdino.lifeofnexus.data.jei;

import java.util.Objects;
import java.util.stream.Collectors;

import com.nexusdino.lifeofnexus.LifeOfNexus;
import com.nexusdino.lifeofnexus.core.init.RecipeInit;
import com.nexusdino.lifeofnexus.data.recipe.LightningSummonerRecipe;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

@JeiPlugin
public class LONJeiPlugin implements IModPlugin {
	private final ResourceLocation UID = new ResourceLocation(LifeOfNexus.MOD_ID, "jei_plugin");

	@Override
	public ResourceLocation getPluginUid() {
		return UID;
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		IGuiHelper helper = registration.getJeiHelpers().getGuiHelper();
		registration.addRecipeCategories(new LightningSummonerRecipeCategory(helper));
	}

	@SuppressWarnings("resource")
	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		registration.addRecipes(
				rm.getAllRecipesFor(RecipeInit.LIGHTNING_RECIPE).stream()
						.filter(r -> r instanceof LightningSummonerRecipe).collect(Collectors.toList()),
				LightningSummonerRecipeCategory.UID);
	}
}
