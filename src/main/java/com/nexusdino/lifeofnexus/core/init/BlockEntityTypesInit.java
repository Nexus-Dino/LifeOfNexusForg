package com.nexusdino.lifeofnexus.core.init;

import com.nexusdino.lifeofnexus.LifeOfNexus;
import com.nexusdino.lifeofnexus.common.blockentity.MultiFurnaceBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityTypesInit {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, LifeOfNexus.MOD_ID);

	public static final RegistryObject<BlockEntityType<MultiFurnaceBlockEntity>> MULTI_FURNACE = BLOCK_ENTITIES
			.register("multi_furnace", () -> BlockEntityType.Builder.of(MultiFurnaceBlockEntity::new,
							BlockInit.MULTI_FURNACE.get()).build(null));
}
