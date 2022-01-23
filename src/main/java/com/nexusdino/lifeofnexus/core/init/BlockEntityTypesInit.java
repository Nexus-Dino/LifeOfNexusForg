package com.nexusdino.lifeofnexus.core.init;

import com.nexusdino.lifeofnexus.LifeOfNexus;
import com.nexusdino.lifeofnexus.common.blockentity.LightningSummonerBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockEntityTypesInit {

	private BlockEntityTypesInit() {
	}

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, LifeOfNexus.MOD_ID);

	public static final RegistryObject<BlockEntityType<LightningSummonerBlockEntity>> LIGHTNING_SUMMONER = BLOCK_ENTITIES
			.register("zenomite_ore", () -> BlockEntityType.Builder.of(LightningSummonerBlockEntity::new,
					BlockInit.LIGHTNING_SUMMONER.get()).build(null));
}
