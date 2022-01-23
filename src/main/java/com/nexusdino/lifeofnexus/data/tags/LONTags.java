package com.nexusdino.lifeofnexus.data.tags;

import com.nexusdino.lifeofnexus.LifeOfNexus;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class LONTags {
	
	public static class Blocks {
		public static final Tags.IOptionalNamedTag<Block> createTag(String name) {
			return BlockTags.createOptional(new ResourceLocation(LifeOfNexus.MOD_ID, name));
		}
	}
	
	public static class Items {
		public static final Tags.IOptionalNamedTag<Item> createTag(String name) {
			return ItemTags.createOptional(new ResourceLocation(LifeOfNexus.MOD_ID, name));
		}
	}
	
	public static class Entities {
		public static final Tags.IOptionalNamedTag<EntityType<?>> createTag(String name) {
			return EntityTypeTags.createOptional(new ResourceLocation(LifeOfNexus.MOD_ID, name));
		}
	}
}
