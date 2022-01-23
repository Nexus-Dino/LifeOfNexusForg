package com.nexusdino.lifeofnexus.client.event;

import com.nexusdino.lifeofnexus.LifeOfNexus;
import com.nexusdino.lifeofnexus.client.ber.LightningSummonerRenderer;
import com.nexusdino.lifeofnexus.client.screen.LightningSummonerScreen;
import com.nexusdino.lifeofnexus.client.util.LONModelLayers;
import com.nexusdino.lifeofnexus.core.init.BlockEntityTypesInit;
import com.nexusdino.lifeofnexus.core.init.MenuTypesInit;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = LifeOfNexus.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {

	@SubscribeEvent
	public static void registerScreens(FMLClientSetupEvent event) {
		event.enqueueWork(
				() -> MenuScreens.register(MenuTypesInit.LIGHTNING_SUMMONER.get(), LightningSummonerScreen::new));
	}

	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(LONModelLayers.LIGHTNING_SUMMONER, LightningSummonerRenderer::createBodyLayer);
	}

	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(BlockEntityTypesInit.LIGHTNING_SUMMONER.get(),
				LightningSummonerRenderer::new);
	}
}
