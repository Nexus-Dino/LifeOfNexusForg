package com.nexusdino.lifeofnexus.core.init;

import com.nexusdino.lifeofnexus.LifeOfNexus;
import com.nexusdino.lifeofnexus.common.menu.LightningSummonerMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class MenuTypesInit {

	private MenuTypesInit() {
	}

	public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.CONTAINERS,
			LifeOfNexus.MOD_ID);

	public static final RegistryObject<MenuType<LightningSummonerMenu>> LIGHTNING_SUMMONER = MENUS
			.register("lightning_summoner", () -> IForgeMenuType.create((windowId, inv, data) -> {
				BlockPos pos = data.readBlockPos();
				Level world = inv.player.getLevel();
				return new LightningSummonerMenu(windowId, world, pos, inv, inv.player);
			}));
}
