package com.Noodlegamer76.RandomThings.init;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RandomThingsMod.MODID);
    //public static final RegistryObject<EntityType<PrimedTntX5>> PRIMED_TNTX5 = ENTITIES.register("primed_tntx5",
    //        () -> EntityType.Builder.<PrimedTntX5>of(PrimedTntX5::new, MobCategory.MISC).fireImmune().sized(0.98F, 0.98F).clientTrackingRange(10).updateInterval(10).build("primed_tntx5"));

}