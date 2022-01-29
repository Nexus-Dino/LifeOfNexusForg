package com.nexusdino.lifeofnexus.common.blockentity;

import com.nexusdino.lifeofnexus.LifeOfNexus;
import com.nexusdino.lifeofnexus.core.init.BlockEntityTypesInit;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MultiFurnaceBlockEntity extends AbstractFurnaceBlockEntity {

	public MultiFurnaceBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
		super(BlockEntityTypesInit.MULTI_FURNACE.get(), pWorldPosition, pBlockState, RecipeType.SMELTING);
	}

	@Override
	protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
		return null;
	}
	
	@Override
	protected Component getDefaultName() {
		return new TranslatableComponent("container." + LifeOfNexus.MOD_ID + ".multi_furnace");
	}
}
