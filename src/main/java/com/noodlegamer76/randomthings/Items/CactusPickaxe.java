package com.noodlegamer76.randomthings.Items;

import com.noodlegamer76.randomthings.util.ToolTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class CactusPickaxe extends PickaxeItem {
    public CactusPickaxe(ToolTiers.ModItemTier cactus, int addAttackDamageToBase, float addAttackSpeedToBase, Properties properties) {
        super(cactus, addAttackDamageToBase, addAttackSpeedToBase, properties);
    }

    @Override
    public boolean mineBlock(ItemStack item, Level level, BlockState blockState, BlockPos BlockPos, LivingEntity player) {
        if (!level.isClientSide && blockState.getDestroySpeed(level, BlockPos) != 0.0F) {
            item.hurtAndBreak(1, player, (entity) -> {
                entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
            player.hurt(level.damageSources().cactus(), 1);
        }
        return true;
    }
    @Override
    public boolean hurtEnemy(ItemStack item, LivingEntity target, LivingEntity player) {
        item.hurtAndBreak(2, player, (p_41007_) -> {
            p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });
        Level level = player.level();
        if (!level.isClientSide) {
            player.hurt(level.damageSources().cactus(), 1);
        }
        return true;
    }
}
