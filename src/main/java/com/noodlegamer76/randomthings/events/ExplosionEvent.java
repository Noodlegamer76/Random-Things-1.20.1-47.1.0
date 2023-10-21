package com.noodlegamer76.randomthings.events;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.eventbus.api.SubscribeEvent;
public class ExplosionEvent {
    Explosion explosion;
    @SubscribeEvent
    public void ExplosionEvent(net.minecraftforge.event.level.ExplosionEvent event){
        this.explosion = event.getExplosion();
    }
    @SubscribeEvent
    public void LivingHurtEvent(net.minecraftforge.event.entity.living.LivingHurtEvent event) {
        DamageSource damageSource = event.getSource();
        Entity entity = damageSource.getEntity();
    }
}
