//package com.nexusdino.lifeofnexus.common.item;
//
//import java.util.List;
//import java.util.Objects;
//
//import org.jetbrains.annotations.Nullable;
//
//import net.minecraft.client.gui.screens.Screen;
//import net.minecraft.client.renderer.EffectInstance;
//import net.minecraft.core.BlockPos;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.effect.MobEffects;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.CreativeModeTab;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.context.UseOnContext;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.BaseFireBlock;
//import net.minecraft.world.level.block.state.BlockState;
//
//public class MonsterCatalystItem extends Item {
//
//	public MonsterCatalystItem() {
//		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC));
//	}
//	
//	@Override
//	public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
//		Level world = context.getWorld();
//
//		if (!world.isClientSide) {
//			Player playerEntity = Objects.requireNonNull(context.getPlayer());
//			BlockState clickedBlock = world.getBlockState(context.getClickedPos());
//
//			rightClickOnCertainBlockState(clickedBlock, context, playerEntity);
//			stack.damageItem(1, playerEntity, player -> player.sendBreakAnimation(context.getHand()));
//		}
//
//		return super.onItemUseFirst(stack, context);
//	}
//
//	@Override
//	public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {
//		Player player = (Player) livingEntity;
//
//		if (!player.level.isClientSide()) {
//			boolean hasPlayerFireResistance = !Objects.equals(player.getActivePotionEffect(Effects.FIRE_RESISTANCE),
//					null);
//
//			if (!hasPlayerFireResistance) {
//				player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200));
//
//				if (this.ran.nextFloat() > 0.6f) {
//					stack.damageItem(1, player, p -> CuriosApi.getCuriosHelper()
//							.onBrokenCurio(SlotTypePreset.CHARM.getIdentifier(), index, p));
//				}
//			}
//		}
//
//		ICurioItem.super.curioTick(identifier, index, livingEntity, stack);
//	}
//
//	@Override
//	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
//		return super.onItemRightClick(worldIn, playerIn, handIn);
//	}
//
//	@Override
//	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip,
//			ITooltipFlag flagIn) {
//
//		if (Screen.hasShiftDown()) {
//			tooltip.add(new TranslationTextComponent("tooltip.tutorialmod.firestone_shift"));
//		} else {
//			tooltip.add(new TranslationTextComponent("tooltip.tutorialmod.firestone"));
//		}
//		super.addInformation(stack, worldIn, tooltip, flagIn);
//	}
//
//	private void rightClickOnCertainBlockState(BlockState clickedBlock, ItemUseContext context,
//			PlayerEntity playerEntity) {
//		boolean playerIsNotOnFire = !playerEntity.isBurning();
//
//		if (random.nextFloat() > 0.5f) {
//			lightEntityOnFire(playerEntity, 6);
//		} else if (playerIsNotOnFire && blockIsValidForResistance(clickedBlock)) {
//			gainFireResistanceAndDestroyBlock(playerEntity, context.getWorld(), context.getPos());
//		} else {
//			lightGroundOnFire(context);
//		}
//	}
//
//	private boolean blockIsValidForResistance(BlockState clickedBlock) {
//		return clickedBlock.isIn(TutorialTags.Blocks.MONSTER_CATALYST_BLOCKS);
//	}
//
//	public static void lightEntityOnFire(Entity entity, int second) {
//		entity.setFire(second);
//	}
//
//	private void gainFireResistanceAndDestroyBlock(PlayerEntity playerEntity, World world, BlockPos pos) {
//		gainFireResistance(playerEntity);
//		world.destroyBlock(pos, false);
//	}
//
//	public static void gainFireResistance(PlayerEntity playerEntity) {
//		playerEntity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 200));
//	}
//
//	public static void lightGroundOnFire(UseOnContext context) {
//		PlayerEntity playerentity = context.getPlayer();
//		Level world = context.getLevel();
//		BlockPos blockpos = context.getClickedPos().offset(context.getFace());
//
//		if (BaseFireBlock.canLightBlock(world, blockpos, context.getPlacementHorizontalFacing())) {
//			world.playSound(playerentity, blockpos, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
//					random.nextFloat() * 0.4F + 0.8F);
//
//			BlockState blockstate = BaseFireBlock.getFireForPlacement(world, blockpos);
//			world.setBlockState(blockpos, blockstate, 11);
//		}
//	}
//
//	@Override
//	public ItemStack getContainerItem(ItemStack itemStack) {
//		ItemStack container = itemStack.copy();
//		if (container.attemptDamageItem(1, random, null)) {
//			return ItemStack.EMPTY;
//		} else {
//			return container;
//		}
//	}
//
//	@Override
//	public boolean hasContainerItem(ItemStack stack) {
//		return true;
//	}
//}
