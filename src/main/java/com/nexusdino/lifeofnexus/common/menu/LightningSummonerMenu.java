package com.nexusdino.lifeofnexus.common.menu;

import com.nexusdino.lifeofnexus.core.init.BlockInit;
import com.nexusdino.lifeofnexus.core.init.MenuTypesInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

@SuppressWarnings("unused")
public class LightningSummonerMenu extends AbstractContainerMenu {
	private final BlockEntity blockEntity;
	private final Player player;
	private final IItemHandler playerInv;

	public LightningSummonerMenu(final int pContainerId, Level level, BlockPos pos, Inventory playerInventory,
			Player player) {
		super(MenuTypesInit.LIGHTNING_SUMMONER.get(), pContainerId);
		this.blockEntity = level.getBlockEntity(pos);
		this.player = player;
		this.playerInv = new InvWrapper(playerInventory);
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return stillValid(ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()), pPlayer,
				BlockInit.LIGHTNING_SUMMONER.get());
	}
}
