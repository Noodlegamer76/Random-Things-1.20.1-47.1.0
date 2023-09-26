package com.Noodlegamer76.RandomThings.enchantment;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;

public class ExplosionEnchantment extends Enchantment {
    public ExplosionEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }


    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if(!pAttacker.level().isClientSide) {
            pAttacker.level().explode(pAttacker, pTarget.getX(), pTarget.getY(), pTarget.getZ(), (float) pLevel / 1.5f + 4f / 2f, Level.ExplosionInteraction.TNT);
            pAttacker.getMainHandItem().hurtAndBreak(pLevel * 3, pAttacker, e -> {});
        }
        super.doPostHurt(pAttacker, pTarget, pLevel);
    }

    @Override
    public int getMaxCost(int pLevel) {
        return pLevel * 3 + 5;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}
