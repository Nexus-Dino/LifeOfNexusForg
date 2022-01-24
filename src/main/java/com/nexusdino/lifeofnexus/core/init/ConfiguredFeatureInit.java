package com.nexusdino.lifeofnexus.core.init;

import com.nexusdino.lifeofnexus.LifeOfNexus;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class ConfiguredFeatureInit {
	public static final ConfiguredFeature<OreConfiguration, ?> ORE_SCYTHONITE = FeatureUtils.register("ore_scythonite",
			Feature.ORE.configured(new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES,
					BlockInit.SCYTHONITE_ORE.get().defaultBlockState(), 9)));

	public static void register() {
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new ResourceLocation(LifeOfNexus.MOD_ID, "ore_scythonite"), ORE_SCYTHONITE);
	}
}
