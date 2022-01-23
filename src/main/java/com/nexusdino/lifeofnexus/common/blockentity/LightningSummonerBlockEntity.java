package com.nexusdino.lifeofnexus.common.blockentity;

import java.util.Optional;

import javax.annotation.Nonnull;

import com.nexusdino.lifeofnexus.core.init.BlockEntityTypesInit;
import com.nexusdino.lifeofnexus.data.recipe.LightningSummonerRecipe;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.level.SimpleContainer;
import net.minecraft.level.entity.EntityType;
import net.minecraft.level.entity.MobSpawnType;
import net.minecraft.level.item.ItemStack;
import net.minecraft.level.level.block.entity.BlockEntity;
import net.minecraft.level.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class LightningSummonerBlockEntity extends BlockEntity {

	private final ItemStackHandler itemHandler = createHandler();
	private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

	public LightningSummonerBlockEntity(BlockPos plevelPosition, BlockState pBlockState) {
		super(BlockEntityTypesInit.LIGHTNING_SUMMONER.get(), plevelPosition, pBlockState);
	}

	@Override
	public void load(CompoundTag nbt) {
		itemHandler.deserializeNBT(nbt.getCompound("inv"));
		super.load(nbt);
	}

	@SuppressWarnings({"resource", "unused"})
	private void strikeLightning() {
		if (!this.getLevel().isClientSide)
			EntityType.LIGHTNING_BOLT.spawn((ServerLevel) level, null, null, levelPosition, MobSpawnType.TRIGGERED,
					true, true);
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		compound.put("inv", itemHandler.serializeNBT());
		super.saveAdditional(compound);
	}

	public void craft() {
		SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			inv.setItem(i, itemHandler.getStackInSlot(i));
		}

        Optional<LightningSummonerRecipe> recipe = level.getRecipeManager()
                .getRecipe(ModRecipeTypes.LIGHTNING_RECIPE, inv, level);

        recipe.ifPresent(iRecipe -> {
            ItemStack output = iRecipe.getResultItem();

            if(iRecipe.getWeather().equals(LightningSummonerRecipe.Weather.CLEAR) &&
                    !level.isRaining()) {
                craftTheItem(output);
            }

            if(iRecipe.getWeather().equals(LightningSummonerRecipe.Weather.RAIN) &&
                    level.isRaining()) {
                craftTheItem(output);
            }

            if(iRecipe.getWeather().equals(LightningSummonerRecipe.Weather.THUNDERING) &&
                    level.isThundering()) {
                strikeLightning();
                craftTheItem(output);
            }

		setChanged();

	}

	protected void craftTheItem(ItemStack output) {
		itemHandler.extractItem(0, 1, false);
		itemHandler.extractItem(1, 1, false);
		itemHandler.insertItem(1, output, false);
	}

	public void tickOnServer() {
		if (!level.isClientSide)
			return;
		
		craft();
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(2) {

			@Override
			protected void onContentsChanged(int slot) {
				setChanged();
			}

			@Override
			public boolean isItemValid(int slot, ItemStack stack) {
				return true; // TODO change this.
			}

			@Override
			public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
				if (!isItemValid(slot, stack))
					return stack;
				else
					return super.extractItem(slot, slot, simulate);
			}
		};
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return handler.cast();
		else
			return super.getCapability(cap, side);
	}
}
