package com.nexusdino.lifeofnexus.common.material;

import com.nexusdino.lifeofnexus.core.init.ItemInit;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class LONTiers {
	public static final ForgeTier SCYTHONITE = new ForgeTier(4, 30000, 6f, 7f, 67, Tags.Blocks.NEEDS_GOLD_TOOL,
			() -> Ingredient.of(ItemInit.SCYTHONITE_INGOT.get()));
}
