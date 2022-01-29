package com.nexusdino.lifeofnexus.world.gen;

import java.util.List;
import java.util.function.Supplier;

import com.nexusdino.lifeofnexus.LifeOfNexus;

import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = LifeOfNexus.MOD_ID, bus = Bus.FORGE)
public class WorldEvents {

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void loadOres(BiomeLoadingEvent event) {
		List<Supplier<PlacedFeature>> base = event.getGeneration()
				.getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

		switch (event.getCategory()) {
		case THEEND -> LifeOfNexus.END_ORES.forEach(ore -> base.add(() -> ore));
		case NETHER -> LifeOfNexus.NETHER_ORES.forEach(ore -> base.add(() -> ore));
		default -> LifeOfNexus.OVERWORLD_ORES.forEach(ore -> base.add(() -> ore));
		}
	}
}
