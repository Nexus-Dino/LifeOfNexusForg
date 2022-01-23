package com.nexusdino.lifeofnexus.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class OreTrackerItem extends Item {

	public OreTrackerItem(Properties pProperties) {
		super(pProperties);
	}

	@SuppressWarnings("unused")
	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		Level level = pContext.getLevel();
		if (level.isClientSide()) {
			BlockPos clickedPos = pContext.getClickedPos();
			Player player = pContext.getPlayer();
			boolean hasFoundBlock = false;

			for (int i = 0; i < clickedPos.getY() + 64; i++) {
				Block blockBelow = level.getBlockState(clickedPos.below(i)).getBlock();

				if (isValuable(blockBelow)) {
					outputCoords(clickedPos, player, blockBelow);
					hasFoundBlock = true;
					break;
				}
			}
		}
		pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
				(player) -> player.broadcastBreakEvent(player.getUsedItemHand()));
		return InteractionResult.SUCCESS;
	}

	private void outputCoords(BlockPos pos, Player player, Block block) {
		player.sendMessage(new TextComponent("Found " + block.asItem().getRegistryName().toString()), player.getUUID());
	}

	private boolean isValuable(Block block) {
		return block == Blocks.DIAMOND_ORE || block == Blocks.GOLD_ORE || block == Blocks.ANCIENT_DEBRIS
				|| block == Blocks.COAL_ORE || block == Blocks.IRON_ORE || block == Blocks.IRON_ORE
				|| block == Blocks.REDSTONE_ORE || block == Blocks.LAPIS_ORE || block == Blocks.COPPER_ORE
				|| block == Blocks.DEEPSLATE_DIAMOND_ORE || block == Blocks.DEEPSLATE_GOLD_ORE
				|| block == Blocks.ANCIENT_DEBRIS || block == Blocks.DEEPSLATE_COAL_ORE
				|| block == Blocks.DEEPSLATE_IRON_ORE || block == Blocks.DEEPSLATE_IRON_ORE
				|| block == Blocks.DEEPSLATE_REDSTONE_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE
				|| block == Blocks.DEEPSLATE_COPPER_ORE || block == Blocks.EMERALD_ORE
				|| block == Blocks.DEEPSLATE_EMERALD_ORE;
	}
}
