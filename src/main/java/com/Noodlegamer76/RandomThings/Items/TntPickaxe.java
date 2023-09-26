package com.Noodlegamer76.RandomThings.Items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class TntPickaxe extends PickaxeItem {
    public TntPickaxe(Tiers stone, int addAttackDamageToBase, float addAttackSpeedToBase, Properties properties) {
        super(stone, addAttackDamageToBase, addAttackSpeedToBase, properties);
    }

    @Override
    public boolean mineBlock(ItemStack item, Level level, BlockState blockState, BlockPos blockPos, LivingEntity player) {
        if (!level.isClientSide && blockState.getDestroySpeed(level, blockPos) != 0.0F) {
            item.hurtAndBreak(1, player, (entity) -> {
                entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
            level.explode(null, level.damageSources().explosion(player, player), new ExplosionDamageCalculator(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 2.0F, false, Level.ExplosionInteraction.TNT);
        }
        return true;
    }
}
