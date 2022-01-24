package com.nexusdino.lifeofnexus.common.material;

import java.util.function.Supplier;

import com.nexusdino.lifeofnexus.core.init.ItemInit;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

@SuppressWarnings("deprecation")
public enum LONArmorMaterials implements ArmorMaterial {

	SCYTHONITE("scythonite", 37, new int[] { 6, 10, 8, 5 }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
			() -> Ingredient.of(ItemInit.SCYTHONITE_INGOT.get()));

	private static final int[] HEALTH_PER_SLOT = new int[] { 13, 15, 16, 11 };
	private final String name;
	private final int durabilityMultiplier;
	private final int[] slotProtections;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyLoadedValue<Ingredient> repairIngredient;

	private LONArmorMaterials(String name, int durabilityMul, int[] slotProts, int enchantmentValue,
			SoundEvent equipSound, float toughness, float knockback, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMul;
		this.slotProtections = slotProts;
		this.enchantmentValue = enchantmentValue;
		this.sound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockback;
		this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
	}

	public int getDurabilityForSlot(EquipmentSlot pSlot) {
		return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
	}

	public int getDefenseForSlot(EquipmentSlot pSlot) {
		return this.slotProtections[pSlot.getIndex()];
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public SoundEvent getEquipSound() {
		return this.sound;
	}

	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	/**
	 * Gets the percentage of knockback resistance provided by armor of the
	 * material.
	 */
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
