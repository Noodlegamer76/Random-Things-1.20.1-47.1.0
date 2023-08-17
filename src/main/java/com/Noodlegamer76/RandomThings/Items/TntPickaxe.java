package com.Noodlegamer76.RandomThings.Items;

import com.Noodlegamer76.RandomThings.util.ToolTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
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
            level.explode(player, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 4.0F, Level.ExplosionInteraction.TNT);
        }
        return true;
    }
}
