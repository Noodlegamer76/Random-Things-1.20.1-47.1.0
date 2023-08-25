package com.Noodlegamer76.RandomThings.init;

import com.Noodlegamer76.RandomThings.Entities.FireBall;
import com.Noodlegamer76.RandomThings.RandomThingsMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RandomThingsMod.MODID);
    public static final RegistryObject<EntityType<FireBall>> FIRE_BALL = ENTITIES.register("fire_ball",
            () -> EntityType.Builder.<FireBall>of(FireBall::new, MobCategory.MISC).fireImmune().sized(0.25F, 0.25F).clientTrackingRange(10).updateInterval(10).build("fire_ball"));

}