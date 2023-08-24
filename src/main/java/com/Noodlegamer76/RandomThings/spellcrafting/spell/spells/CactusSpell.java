package com.Noodlegamer76.RandomThings.spellcrafting.spell.spells;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CactusSpell extends Spell {


    public CactusSpell(Level level, ServerPlayer player, ItemStack stack) {
        super(level, player, stack);
    }

    @Override
    public void activate() {
        player.hurt(level.damageSources().cactus(), 100);
    }

}
