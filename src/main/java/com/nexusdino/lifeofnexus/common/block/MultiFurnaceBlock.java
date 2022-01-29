package com.nexusdino.lifeofnexus.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlastFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class MultiFurnaceBlock extends AbstractFurnaceBlock {

	public MultiFurnaceBlock() {
		super(BlockBehaviour.Properties.of(Material.METAL).strength(15f).requiresCorrectToolForDrops());
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return null;
	}
	
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
			BlockEntityType<T> pBlockEntityType) {
		return createFurnaceTicker(pLevel, pBlockEntityType, null);
	}

	@Override
	protected void openContainer(Level pLevel, BlockPos pPos, Player pPlayer) {
		BlockEntity blockentity = pLevel.getBlockEntity(pPos);
		if (blockentity instanceof BlastFurnaceBlockEntity) {
			pPlayer.openMenu((MenuProvider) blockentity);
			pPlayer.awardStat(Stats.INTERACT_WITH_BLAST_FURNACE);
		}
	}
}
