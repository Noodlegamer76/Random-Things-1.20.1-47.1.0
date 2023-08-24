package com.Noodlegamer76.RandomThings.spellcrafting.spell.items;

import com.Noodlegamer76.RandomThings.spellcrafting.spell.spells.Spell;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SpellItem extends Item {
    public SpellItem(Properties properties) {
        super(properties);
    }

    public static Spell getSpell(Level level, ServerPlayer player, ItemStack stack) {
        return new Spell(level, player, stack);
    }
}
