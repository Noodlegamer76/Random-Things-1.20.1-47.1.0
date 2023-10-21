package com.noodlegamer76.randomthings.spellcrafting.spell.spells;

import com.noodlegamer76.randomthings.spellcrafting.modifier.modifier.Modifiers;
import com.noodlegamer76.randomthings.spellcrafting.modifier.modifier.TestModifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

public class CactusSpell extends Spell {

    int damageMultiplier;

    public CactusSpell(Level level, ServerPlayer player, ItemStack stack, ArrayList<Modifiers> modifiers) {
        super(level, player, stack, modifiers);
    }

    @Override
    public void calculate() {
        for(int i = 0;i < modifiers.size();i++) {
            if (modifiers.get(i) instanceof TestModifier) {
                damageMultiplier += 1;
            }
        }
    }

    @Override
    public void activate() {
        player.hurt(level.damageSources().cactus(), 1 * damageMultiplier);
    }

}
