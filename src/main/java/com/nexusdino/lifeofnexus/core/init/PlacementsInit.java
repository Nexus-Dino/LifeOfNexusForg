package com.nexusdino.lifeofnexus.core.init;

import com.nexusdino.lifeofnexus.LifeOfNexus;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PlacementsInit {
	public static final PlacedFeature ORE_SCYTHONITE_PLACED = PlacementUtils
			.register("ore_scythonite_placed", ConfiguredFeatureInit.ORE_SCYTHONITE.placed(CountPlacement.of(39)));

	public static void register() {
		Registry.register(BuiltinRegistries.PLACED_FEATURE,
				new ResourceLocation(LifeOfNexus.MOD_ID, "ore_scythonite_placed"), ORE_SCYTHONITE_PLACED);
	}
}
