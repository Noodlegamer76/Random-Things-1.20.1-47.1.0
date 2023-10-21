package com.noodlegamer76.randomthings.spellcrafting.spell.spells;

import com.noodlegamer76.randomthings.spellcrafting.modifier.modifier.Modifiers;
import com.noodlegamer76.randomthings.spellcrafting.modifier.modifier.TestModifier;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

public class ExplosionSpell extends Spell {
    int explosionMultiplier = 1;
    public ExplosionSpell(Level level, ServerPlayer player, ItemStack stack, ArrayList<Modifiers> modifiers) {
        super(level, player, stack, modifiers);
    }

    @Override
    public void calculate() {
        for(int i = 0;i < modifiers.size();i++) {
            if (modifiers.get(i) instanceof TestModifier) {
                explosionMultiplier += 1;
            }
        }
    }

    @Override
    public void activate() {
        BlockPos blockPos = player.blockPosition();
        level.explode(null, level.damageSources().explosion(player, player), new ExplosionDamageCalculator(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 4 * explosionMultiplier, false, Level.ExplosionInteraction.TNT);
    }

}
