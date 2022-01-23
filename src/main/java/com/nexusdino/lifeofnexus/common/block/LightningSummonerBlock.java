package com.nexusdino.lifeofnexus.common.block;

import com.nexusdino.lifeofnexus.common.blockentity.LightningSummonerBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class LightningSummonerBlock extends BaseEntityBlock {

	public LightningSummonerBlock() {
		super(BlockBehaviour.Properties.of(Material.METAL).strength(15f).sound(SoundType.METAL));
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new LightningSummonerBlockEntity(pPos, pState);
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
			BlockEntityType<T> pBlockEntityType) {
		return ($0, $1, $2, pBlockEntity) -> {
			if (pBlockEntity instanceof LightningSummonerBlockEntity lsbe) {
				lsbe.tickOnServer();
			}
		};
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pHit) {

		return InteractionResult.SUCCESS;
	}
}
