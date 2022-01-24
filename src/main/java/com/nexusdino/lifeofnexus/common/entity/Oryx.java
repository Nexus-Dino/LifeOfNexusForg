//package com.nexusdino.lifeofnexus.common.entity;
//
//import com.nexusdino.lifeofnexus.core.init.EntityTypesInit;
//
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.world.entity.AgeableMob;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.Mob;
//import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
//import net.minecraft.world.entity.ai.attributes.Attributes;
//import net.minecraft.world.entity.ai.goal.BreedGoal;
//import net.minecraft.world.entity.ai.goal.FloatGoal;
//import net.minecraft.world.entity.ai.goal.FollowParentGoal;
//import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
//import net.minecraft.world.entity.ai.goal.PanicGoal;
//import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
//import net.minecraft.world.entity.ai.goal.TemptGoal;
//import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
//import net.minecraft.world.entity.animal.Animal;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Blocks;
//
//public class Oryx extends Animal {
//
//	public Oryx(EntityType<? extends Animal> p_27557_, Level p_27558_) {
//		super(p_27557_, p_27558_);
//	}
//
//	public static AttributeSupplier.Builder createAttributes() {
//		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.2F)
//				.add(Attributes.ATTACK_DAMAGE, 2.0D);
//	}
//
//	@Override
//	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
//		return EntityTypesInit.ORYX.get().create(p_146743_);
//	}
//
//	@Override
//	protected void registerGoals() {
//		this.goalSelector.addGoal(0, new FloatGoal(this));
//		this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
//		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
//		this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, Ingredient.of(Blocks.GRASS.asItem()), false));
//		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
//		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
//		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
//		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
//	}
//}
