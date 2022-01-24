package com.nexusdino.lifeofnexus.core.init;

import java.util.function.Supplier;

import com.nexusdino.lifeofnexus.LifeOfNexus;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			LifeOfNexus.MOD_ID);

	public static final RegistryObject<Block> SCYTHONITE_ORE = register("scythonite_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));

	private static <I extends Block> RegistryObject<I> register(String name, Supplier<? extends I> sup) {
		RegistryObject<I> toReturn = BLOCKS.register(name, sup);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
		ItemInit.ITEMS.register(name,
				() -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	}
}
