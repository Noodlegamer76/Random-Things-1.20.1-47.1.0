package com.noodlegamer76.randomthings.entities.projectiles;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class FireBall extends AbstractArrow {

    int life = 0;

    public FireBall(EntityType<FireBall> entityType, Level level) {
        super(entityType, level);
    }

    public FireBall(EntityType<FireBall> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
    }

    public FireBall(EntityType<FireBall> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
    }


    @Override
    protected void onHitEntity(EntityHitResult ray) {
        super.onHitEntity(ray);
    }

    @Override
    protected void onHitBlock(BlockHitResult ray) {
        super.onHitBlock(ray);
        this.discard();
    }

    @Override
    public void setDeltaMovement(Vec3 pDeltaMovement) {

    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public void tick() {

        life++;
        if (life > 500) {
            this.discard();
        }
        super.tick();
    }
}
