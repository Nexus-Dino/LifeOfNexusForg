package com.nexusdino.lifeofnexus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nexusdino.lifeofnexus.core.init.ItemInit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("lifeofnexus")
public class LifeOfNexus {
	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "lifeofnexus";

	public LifeOfNexus() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemInit.ITEMS.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
}
