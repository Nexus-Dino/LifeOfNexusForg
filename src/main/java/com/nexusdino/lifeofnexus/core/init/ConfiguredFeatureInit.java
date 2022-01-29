package com.nexusdino.lifeofnexus.core.init;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class ConfiguredFeatureInit {
	public static final ConfiguredFeature<OreConfiguration, ?> ORE_SCYTHONITE = FeatureUtils.register("ore_scythonite", Feature.ORE.configured(new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.SCYTHONITE_ORE.get().defaultBlockState(), 10)));
	public static final ConfiguredFeature<OreConfiguration, ?> ORE_POSSESSED_NETHEROSCYTHE = FeatureUtils.register("ore_possessed_netheroscythe", Feature.ORE.configured(new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES, BlockInit.POSSESSED_NETHEROSCYTHE_ORE.get().defaultBlockState(), 10)));
}
