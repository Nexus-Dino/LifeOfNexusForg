package com.nexusdino.lifeofnexus.data.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nexusdino.lifeofnexus.LifeOfNexus;
import com.nexusdino.lifeofnexus.core.init.BlockInit;
import com.nexusdino.lifeofnexus.data.recipe.LightningSummonerRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class LightningSummonerRecipeCategory implements IRecipeCategory<LightningSummonerRecipe> {
	public static final ResourceLocation UID = new ResourceLocation(LifeOfNexus.MOD_ID, "lightning");
	public static final ResourceLocation TEXTURE = new ResourceLocation(LifeOfNexus.MOD_ID,
			"textures/gui/lightning_channeler_gui.png");

	private final IDrawable background;
	private final IDrawable icon;
	private final IDrawableStatic lightningBolt;

	public LightningSummonerRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM,
				new ItemStack(BlockInit.LIGHTNING_SUMMONER.get()));
		this.lightningBolt = helper.createDrawable(TEXTURE, 176, 0, 13, 17);
	}

	@Override
	public ResourceLocation getUid() {
		return UID;
	}

	@Override
	public Class<? extends LightningSummonerRecipe> getRecipeClass() {
		return LightningSummonerRecipe.class;
	}

	@Override
	public Component getTitle() {
		return BlockInit.LIGHTNING_SUMMONER.get().getName();
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setIngredients(LightningSummonerRecipe recipe, IIngredients ingredients) {
		ingredients.setInputIngredients(recipe.getIngredients());
		ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, LightningSummonerRecipe recipe, IIngredients ingredients) {
		recipeLayout.getItemStacks().init(0, true, 79, 30);
		recipeLayout.getItemStacks().init(1, true, 79, 52);

		recipeLayout.getItemStacks().init(2, false, 102, 42);
		recipeLayout.getItemStacks().set(ingredients);
	}

	@Override
	public void draw(LightningSummonerRecipe recipe, PoseStack stack, double mouseX, double mouseY) {
		if (recipe.getWeather() == LightningSummonerRecipe.Weather.THUNDERING) {
			this.lightningBolt.draw(stack, 82, 9);
		}
	}
}
