package com.noodlegamer76.randomthings.spellcrafting.spell.spells;

import com.noodlegamer76.randomthings.spellcrafting.modifier.modifier.Modifiers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

public class Spell {


    float xSpread = 0;
    float ySpread = 0;
    //the potential random spread of your spells projectiles

    float velocityMultiplier = 1;
    //(hidden in noita) changes the velocity of projectiles

    int projectileMaxLife = 100;
    //how long (in ticks) the projectile will last until it disappears

    Level level;
    ServerPlayer player;
    ItemStack castItem;
    ArrayList modifiers;

    public Spell(Level level, ServerPlayer player, ItemStack castItem, ArrayList<Modifiers> modifiers){
        this.level = level;
        this.player = player;
        this.castItem = castItem;
        this.modifiers = modifiers;
        this.calculate();
        this.activate();
    }

    public void calculate() {
    }

    public void activate() {
    }
}
