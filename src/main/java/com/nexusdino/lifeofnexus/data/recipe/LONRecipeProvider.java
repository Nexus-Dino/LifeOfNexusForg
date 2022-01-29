package com.nexusdino.lifeofnexus.data.recipe;

import java.util.function.Consumer;

import com.nexusdino.lifeofnexus.core.init.BlockInit;
import com.nexusdino.lifeofnexus.core.init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class LONRecipeProvider extends RecipeProvider implements IConditionBuilder {

	public LONRecipeProvider(DataGenerator pGenerator) {
		super(pGenerator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
		ShapedRecipeBuilder.shaped(BlockInit.SCYTHONITE_BLOCK.get()).define('I', ItemInit.SCYTHONITE_INGOT.get())
				.pattern("III")
				.pattern("III")
				.pattern("III")
				.unlockedBy("has_item", has(BlockInit.SCYTHONITE_BLOCK.get())).save(pFinishedRecipeConsumer);
	}
}
