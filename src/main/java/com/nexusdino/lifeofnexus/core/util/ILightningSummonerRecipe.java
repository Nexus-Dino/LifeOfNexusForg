package com.nexusdino.lifeofnexus.core.util;

import java.util.Optional;

import com.nexusdino.lifeofnexus.LifeOfNexus;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public interface ILightningSummonerRecipe extends Recipe<Container> {
	ResourceLocation TYPE_ID = new ResourceLocation(LifeOfNexus.MOD_ID, "lightning");

	@Override
	default RecipeType<?> getType() {
		if (Optional.of(TYPE_ID).isPresent())
			return Registry.RECIPE_TYPE.getOptional(TYPE_ID).get();
		else
			return null;
	}

	@Override
	default boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	default boolean isSpecial() {
		return true;
	}
}
