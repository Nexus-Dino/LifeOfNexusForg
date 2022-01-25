package com.nexusdino.lifeofnexus.core.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class OreGenInit {
	public static final List<PlacedFeature> OVERWORLD_ORES = new ArrayList<>();
	public static final List<PlacedFeature> END_ORES = new ArrayList<>();
	public static final List<PlacedFeature> NETHER_ORES = new ArrayList<>();

	public static final RuleTest END_TEST = new BlockMatchTest(Blocks.END_STONE);

	public static void registerOres() {
		final ConfiguredFeature<OreConfiguration, ?> oreScythonite = FeatureUtils.register("ore_scythonite",
				Feature.ORE.configured(new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
						BlockInit.SCYTHONITE_ORE.get().defaultBlockState(), 10)));

		final PlacedFeature oreScythonitePlaced = PlacementUtils.register("ore_scythonite_placed",
				oreScythonite.placed(OrePlacements.commonOrePlacement(2000,
						HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(20)))));
		OVERWORLD_ORES.add(oreScythonitePlaced);
	}
}
