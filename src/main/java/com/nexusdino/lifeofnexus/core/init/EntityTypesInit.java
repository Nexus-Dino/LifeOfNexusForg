//package com.nexusdino.lifeofnexus.core.init;
//
//import com.nexusdino.lifeofnexus.LifeOfNexus;
//import com.nexusdino.lifeofnexus.common.entity.Oryx;
//
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.MobCategory;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//public class EntityTypesInit {
//	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
//			LifeOfNexus.MOD_ID);
//
//	public static final RegistryObject<EntityType<Oryx>> ORYX = ENTITIES.register("oryx",
//			() -> EntityType.Builder.of(Oryx::new, MobCategory.CREATURE)
//					.build(new ResourceLocation(LifeOfNexus.MOD_ID, "textures/entity/oryx/oryx.png").toString()));
//}
