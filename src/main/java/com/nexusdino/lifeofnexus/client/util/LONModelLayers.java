package com.nexusdino.lifeofnexus.client.util;

import com.nexusdino.lifeofnexus.LifeOfNexus;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class LONModelLayers {
	public static final ModelLayerLocation LIGHTNING_SUMMONER = register("lightning_summoner");

	private static ModelLayerLocation register(String name) {
		return register(name, "main");
	}

	private static ModelLayerLocation register(String name, String main) {
		return new ModelLayerLocation(new ResourceLocation(LifeOfNexus.MOD_ID, name), main);
	}
}
