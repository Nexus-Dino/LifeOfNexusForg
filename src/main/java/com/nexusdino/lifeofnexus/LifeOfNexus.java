package com.nexusdino.lifeofnexus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nexusdino.lifeofnexus.core.init.BlockInit;
import com.nexusdino.lifeofnexus.core.init.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LifeOfNexus.MOD_ID)
public class LifeOfNexus {
	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "lifeofnexus";

	public LifeOfNexus() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		BlockInit.BLOCKS.register(bus);
		ItemInit.ITEMS.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public static final CreativeModeTab TAB_ITEMS = new CreativeModeTab(MOD_ID) {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ItemInit.SCYTHONITE_INGOT.get());
		}
	};
}
