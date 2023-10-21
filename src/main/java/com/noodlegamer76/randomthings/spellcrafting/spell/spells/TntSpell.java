package com.noodlegamer76.randomthings.spellcrafting.spell.spells;

import com.noodlegamer76.randomthings.entities.projectiles.ThrownTntEntity;
import com.noodlegamer76.randomthings.init.EntityInit;
import com.noodlegamer76.randomthings.spellcrafting.modifier.modifier.Modifiers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

public class TntSpell extends Spell {
    public TntSpell(Level level, ServerPlayer player, ItemStack castItem, ArrayList<Modifiers> modifiers) {
        super(level, player, castItem, modifiers);
    }

    @Override
    public void activate() {
        ThrownTntEntity thrownTnt = new ThrownTntEntity(EntityInit.THROWN_TNT.get(), player, level, 4.0f);
        thrownTnt.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
        level.addFreshEntity(thrownTnt);
        System.out.println("TNTNTNTNTN");
    }
}
