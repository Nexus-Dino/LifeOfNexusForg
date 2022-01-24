//package com.nexusdino.lifeofnexus.common.block;
//
//import java.util.Random;
//
//import com.nexusdino.lifeofnexus.common.block.grower.MahoganyTreeGrower;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.world.level.block.SaplingBlock;
//import net.minecraft.world.level.block.grower.AbstractTreeGrower;
//import net.minecraft.world.level.block.state.BlockState;
//
//public class MahoganySaplingBlock extends SaplingBlock {
//	
//	private final MahoganyTreeGrower grower;
//
//	public MahoganySaplingBlock(AbstractTreeGrower pTreeGrower, Properties pProperties) {
//		super(pTreeGrower, pProperties);
//		this.grower = (MahoganyTreeGrower) pTreeGrower;
//	}
//
//	@Override
//	public void advanceTree(ServerLevel pLevel, BlockPos pPos, BlockState pState, Random pRand) {
//		if (pState.getValue(STAGE) == 0)
//			pLevel.setBlock(pPos, pState, UPDATE_NONE);
//		else
//			this.grower.growTree(pLevel, pLevel.getChunkSource().getGenerator(), pPos, pState, pRand);
//	}
//}
