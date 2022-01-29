package com.nexusdino.lifeofnexus.core.init;

import com.nexusdino.lifeofnexus.LifeOfNexus;

import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PlacementInit {
	public static final PlacedFeature ORE_SCYTHONITE_PLACED = PlacementUtils.register("ore_scythonite_placed", ConfiguredFeatureInit.ORE_SCYTHONITE.placed(OrePlacements.commonOrePlacement(2000, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(20)))));
	public static final PlacedFeature ORE_POSSESSED_NETHEROSCYTHE_PLACED = PlacementUtils.register("ore_possessed_netheroscythe_placed", ConfiguredFeatureInit.ORE_POSSESSED_NETHEROSCYTHE.placed(OrePlacements.rareOrePlacement(2000, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(20)))));
	
	public static void addOresToLists() {
		LifeOfNexus.OVERWORLD_ORES.add(ORE_SCYTHONITE_PLACED);
		LifeOfNexus.NETHER_ORES.add(ORE_POSSESSED_NETHEROSCYTHE_PLACED);
	}
}
