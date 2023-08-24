package com.Noodlegamer76.RandomThings.spellcrafting.spell.spells;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

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

    public Spell(Level level, ServerPlayer player, ItemStack castItem){
        this.level = level;
        this.player = player;
        this.castItem = castItem;
    }

    public void activate() {
    }
}
