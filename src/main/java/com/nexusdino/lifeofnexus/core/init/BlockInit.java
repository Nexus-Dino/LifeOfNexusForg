package com.nexusdino.lifeofnexus.core.init;

import java.util.function.Supplier;

import com.nexusdino.lifeofnexus.LifeOfNexus;
import com.nexusdino.lifeofnexus.common.block.LightningSummonerBlock;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockInit {

	private BlockInit() {
	}

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			LifeOfNexus.MOD_ID);

	public static final RegistryObject<Block> ZENOMITE_ORE = registerBlock("zenomite_ore",
			() -> new OreBlock(BlockBehaviour.Properties.of(Material.METAL), UniformInt.of(5, 9))); // The second
																									// argument is the
																									// xpRange.

	public static final RegistryObject<Block> LIGHTNING_SUMMONER = registerBlock("lightning_summoner",
			LightningSummonerBlock::new);

	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	private static <T extends Block> Item registerBlockItem(String name, RegistryObject<T> block) {
		return ItemInit.ITEMS
				.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)))
				.get();
	}
}
