package com.Noodlegamer76.RandomThings.Entities.projectiles;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class ThrownTntEntity extends AbstractArrow {
    public int ticks = 0;

    public float rotSpeed = 1F;
    public float rotation = 0.1F;


    public int riseSpeed = 0;
    public int riseVelocity = 0;

    float power = 0f;

    Player attacker = null;

    public ThrownTntEntity(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public ThrownTntEntity(EntityType<? extends AbstractArrow> pEntityType, @Nullable Player attacker, Level pLevel, float power) {
        super(pEntityType, attacker, pLevel);
        this.attacker = attacker;
        this.power = power;
    }

    @Override
    protected ItemStack getPickupItem() {
        return null;
    }

    @Override
    protected void onHit(HitResult pResult) {
        if(attacker == null) {
            level().explode(null, getX(), getY(), getZ(), 4.0f, Level.ExplosionInteraction.TNT);
        }
        else {
            level().explode(null, level().damageSources().explosion(attacker, attacker), new ExplosionDamageCalculator(), getX(), getY(), getZ(), power, false, Level.ExplosionInteraction.TNT);
        }
        super.onHit(pResult);
        this.discard();
    }

    @Override
    public void tick() {
        super.tick();
        ticks++;
        if(rotation > 360f) {
            rotation = 0.2f;
        }
        if(rotation <= 360f) {
            rotation += 0.2f;
        }
    }
}
