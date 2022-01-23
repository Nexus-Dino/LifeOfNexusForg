package com.nexusdino.lifeofnexus.core.init;

import com.nexusdino.lifeofnexus.LifeOfNexus;
import com.nexusdino.lifeofnexus.data.recipe.LightningSummonerRecipe;

import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class RecipeInit {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister
			.create(ForgeRegistries.RECIPE_SERIALIZERS, LifeOfNexus.MOD_ID);

	public static final RegistryObject<LightningSummonerRecipe.Serializer> LIGHTNING_SERIALIZER = SERIALIZERS
			.register("lightning", LightningSummonerRecipe.Serializer::new);

	public static RecipeType<LightningSummonerRecipe> LIGHTNING_RECIPE = 
			new LightningSummonerRecipe.Type();

	public static void register(IEventBus eventBus) {
		SERIALIZERS.register(eventBus);

		Registry.register(Registry.RECIPE_TYPE, LightningSummonerRecipe.TYPE_ID, LIGHTNING_RECIPE);
	}
}
