package com.nexusdino.lifeofnexus.core.init;

import com.nexusdino.lifeofnexus.LifeOfNexus;
import com.nexusdino.lifeofnexus.common.material.LONArmorMaterials;
import com.nexusdino.lifeofnexus.common.material.LONTiers;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			LifeOfNexus.MOD_ID);

	public static final RegistryObject<Item> SCYTHONITE_INGOT = ITEMS.register("scythonite_ingot",
			() -> new Item(new Item.Properties().tab(LifeOfNexus.TAB_ITEMS).fireResistant()));

	public static final RegistryObject<Item> SCYTHONITE_PICKAXE = ITEMS.register("scythonite_pickaxe",
			() -> new PickaxeItem(LONTiers.SCYTHONITE, 5, 8f,
					new Item.Properties().tab(LifeOfNexus.TAB_ITEMS).fireResistant()));

	public static final RegistryObject<Item> SCYTHONITE_AXE = ITEMS.register("scythonite_axe",
			() -> new AxeItem(LONTiers.SCYTHONITE, 10, 8f,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

	public static final RegistryObject<Item> SCYTHONITE_SWORD = ITEMS.register("scythonite_sword",
			() -> new SwordItem(LONTiers.SCYTHONITE, 7, 8f,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

	public static final RegistryObject<Item> SCYTHONITE_SHOVEL = ITEMS.register("scythonite_shovel",
			() -> new ShovelItem(LONTiers.SCYTHONITE, 3, 8f,
					new Item.Properties().tab(LifeOfNexus.TAB_ITEMS).fireResistant()));

	public static final RegistryObject<Item> SCYTHONITE_HOE = ITEMS.register("scythonite_hoe",
			() -> new HoeItem(LONTiers.SCYTHONITE, 2, 8f,
					new Item.Properties().tab(LifeOfNexus.TAB_ITEMS).fireResistant()));

	public static final RegistryObject<Item> SCYTHONITE_HELMET = ITEMS.register("scythonite_helmet",
			() -> new ArmorItem(LONArmorMaterials.SCYTHONITE, EquipmentSlot.HEAD,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

	public static final RegistryObject<Item> SCYTHONITE_CHESTPLATE = ITEMS.register("scythonite_chestplate",
			() -> new ArmorItem(LONArmorMaterials.SCYTHONITE, EquipmentSlot.CHEST,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

	public static final RegistryObject<Item> SCYTHONITE_LEGGINGS = ITEMS.register("scythonite_leggings",
			() -> new ArmorItem(LONArmorMaterials.SCYTHONITE, EquipmentSlot.LEGS,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

	public static final RegistryObject<Item> SCYTHONITE_BOOTS = ITEMS.register("scythonite_boots",
			() -> new ArmorItem(LONArmorMaterials.SCYTHONITE, EquipmentSlot.FEET,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
}
