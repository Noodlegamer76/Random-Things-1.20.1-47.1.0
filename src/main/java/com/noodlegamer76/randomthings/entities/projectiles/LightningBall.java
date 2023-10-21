package com.noodlegamer76.randomthings.entities.projectiles;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class LightningBall extends Projectile {
    public float rotSpeed = 1000F;
    public float rotation = 0.1F;

    public int ticks = 0;
    public LightningBall(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    @Override
    protected void defineSynchedData() {
    }

    @Override
    public void setDeltaMovement(Vec3 pDeltaMovement) {

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
