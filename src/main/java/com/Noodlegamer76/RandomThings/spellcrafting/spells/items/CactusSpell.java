package com.Noodlegamer76.RandomThings.spellcrafting.spells.items;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;

public class CactusSpell extends SpellItem {
    public CactusSpell(Properties properties) {
        super(properties);
    }

    public static void activate(Level level, ServerPlayer player, ItemStack stack) {
        player.hurt(level.damageSources().cactus(), 100);
    }
}
