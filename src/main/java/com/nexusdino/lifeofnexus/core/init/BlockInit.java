package com.nexusdino.lifeofnexus.core.init;

import java.util.function.Supplier;

import com.nexusdino.lifeofnexus.LifeOfNexus;
import com.nexusdino.lifeofnexus.common.block.MultiFurnaceBlock;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			LifeOfNexus.MOD_ID);

	public static final RegistryObject<Block> SCYTHONITE_ORE = registerBlock("scythonite_ore",
			() -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops(),
					UniformInt.of(4, 8)));

	public static final RegistryObject<Block> POSSESSED_NETHEROSCYTHE_ORE = registerBlock("scythonite_ore",
			() -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops(),
					UniformInt.of(4, 8)));

	public static final RegistryObject<Block> SCYTHONITE_BLOCK = registerBlock("scythonite_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> MULTI_FURNACE = registerBlock("multi_furnace", MultiFurnaceBlock::new);

	private static <I extends Block> RegistryObject<I> registerBlock(String name, Supplier<? extends I> sup) {
		RegistryObject<I> toReturn = BLOCKS.register(name, sup);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	private static <T extends Block> Item registerBlockItem(String name, RegistryObject<T> block) {
		return ItemInit.ITEMS
				.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)))
				.get();
	}
}
