package com.Noodlegamer76.RandomThings.spellcrafting.wand;

import com.Noodlegamer76.RandomThings.spellcrafting.modifier.items.ModifierItem;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.items.ExplosionSpellItem;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.items.SpellItem;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.spells.ExplosionSpell;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.spells.Spell;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class WandCast {
    IItemHandler handler;
    CompoundTag nbt = new CompoundTag();

    int casts = 1;
    //how many spells are cast every time the players activates the spell

    float castDelay = 20;
    //measured in ticks, how long it takes to case the next spell in the wand queue

    float rechargeTime = 20;
    //measured in ticks, when the spell queue reaches the end, the wand much charge this long in seconds to refresh the spell queue

    int maxMana = 100;
    //how much mana the wand holds when full

    float manaRechargeSpeed = 1;
    //a flat number representing how much mana is regenerated per tick

    int capacity = 27;
    //how many slots are available to put spells and modifiers into



    public WandCast(Level level, ServerPlayer  player, ItemStack castItem) {
        //inventory slots index starts at 0

        //make handler and nbt
        LazyOptional<IItemHandler> iItemHandler = castItem.getCapability(ForgeCapabilities.ITEM_HANDLER, null);
        iItemHandler.ifPresent(this::setHandler);
        nbt = castItem.getTag();

        //get get which slot the cast should start at and get which item is in the current slot
        int slot = nbt.getInt("slot");
        ItemStack current = handler.getStackInSlot(slot);

        //get instance here
        

        //updates or resets which slot the wand should start on
        if (slot + 1 >= capacity) {
            nbt.putInt("slot", 0);
        }
        else {
            nbt.putInt("slot", slot + 1);
        }



        cast(level, player, castItem);

    }

    public void cast(Level level, ServerPlayer player, ItemStack castItem) {
        Item item = handler.getStackInSlot(0).getItem();
        capacity = nbt.getInt("capacity");

    }

    public void setHandler(IItemHandler handler) {
        this.handler = handler;
    }
}
