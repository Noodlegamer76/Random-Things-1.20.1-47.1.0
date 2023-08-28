package com.Noodlegamer76.RandomThings.init;

import com.Noodlegamer76.RandomThings.Entities.projectiles.FireBall;
import com.Noodlegamer76.RandomThings.Entities.projectiles.ThrownTntEntity;
import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.Entities.projectiles.LightningBall;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RandomThingsMod.MODID);
    public static final RegistryObject<EntityType<FireBall>> FIRE_BALL = ENTITIES.register("fire_ball",
            () -> EntityType.Builder.<FireBall>of(FireBall::new, MobCategory.MISC).fireImmune().sized(0.25F, 0.25F).clientTrackingRange(10).updateInterval(10).build("fire_ball"));
    public static final RegistryObject<EntityType<ThrownTntEntity>> THROWN_TNT = ENTITIES.register("thrown_tnt",
            () -> EntityType.Builder.<ThrownTntEntity>of(ThrownTntEntity::new, MobCategory.MISC).fireImmune().sized(1F, 1F).clientTrackingRange(10).updateInterval(10).build("thrown_tnt"));
    public static final RegistryObject<EntityType<LightningBall>> LIGHTNING_BALL = ENTITIES.register("lightning_ball",
            () -> EntityType.Builder.<LightningBall>of(LightningBall::new, MobCategory.MISC).fireImmune().sized(1F, 1F).clientTrackingRange(10).updateInterval(10).build("thrown_tnt"));

}