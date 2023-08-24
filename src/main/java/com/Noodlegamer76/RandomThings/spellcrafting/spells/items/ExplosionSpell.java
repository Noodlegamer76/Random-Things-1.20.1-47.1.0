package com.Noodlegamer76.RandomThings.spellcrafting.spells.items;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;

public class ExplosionSpell extends SpellItem {
    public ExplosionSpell(Properties properties) {
        super(properties);
    }

    public static void activate(Level level, ServerPlayer player, ItemStack stack) {
    BlockPos blockPos = player.blockPosition();
        level.explode(null, level.damageSources().explosion(player, player), new ExplosionDamageCalculator(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 20.0F, false, Level.ExplosionInteraction.TNT);
    }
}
