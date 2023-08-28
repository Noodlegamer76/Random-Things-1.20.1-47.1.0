package com.Noodlegamer76.RandomThings.spellcrafting.wand;

import com.Noodlegamer76.RandomThings.spellcrafting.modifier.items.ModifierItem;
import com.Noodlegamer76.RandomThings.spellcrafting.modifier.items.TestModifierItem;
import com.Noodlegamer76.RandomThings.spellcrafting.modifier.modifier.Modifiers;
import com.Noodlegamer76.RandomThings.spellcrafting.modifier.modifier.TestModifier;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.items.CactusSpellItem;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.items.ExplosionSpellItem;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.items.SpellItem;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.items.TntSpellItem;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.spells.CactusSpell;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.spells.ExplosionSpell;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.spells.TntSpell;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

import java.util.ArrayList;

public class WandCast {
    IItemHandler handler;
    CompoundTag nbt;

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

    ArrayList<Modifiers> modifiers = new ArrayList<>();

    boolean shouldCast = true;


    public WandCast(Level level, ServerPlayer  player, ItemStack castItem) {
        //inventory slots index starts at 0

        //make handler and nbt
        LazyOptional<IItemHandler> iItemHandler = castItem.getCapability(ForgeCapabilities.ITEM_HANDLER, null);
        iItemHandler.ifPresent(this::setHandler);
        nbt = castItem.getTag();

        //get which slot the cast should start at and get which item is in the current slot
        capacity = nbt.getInt("capacity");

        castSpell(level, player, castItem);

    }

    public void castSpell(Level level, ServerPlayer  player, ItemStack castItem) {
        while (shouldCast) {
            int slot = nbt.getInt("slot");
            ItemStack current = handler.getStackInSlot(slot);


            if (current.getItem() instanceof  ModifierItem) {
                if (current.getItem() instanceof TestModifierItem) {
                    System.out.println("TEST MOD");
                    modifiers.add(new TestModifier());
                }
            }


            else if (current.getItem() instanceof SpellItem) {

                if (current.getItem() instanceof ExplosionSpellItem) {
                    System.out.println("EXPLOSION SPELL ITEM");
                    new ExplosionSpell(level, player, castItem, modifiers);
                }

                else if (current.getItem() instanceof CactusSpellItem) {
                    System.out.println("CACTUS SPELL ITEM");
                    new CactusSpell(level, player, castItem, modifiers);
                }

                else if (current.getItem() instanceof TntSpellItem) {
                    System.out.println("TNT SPELL");
                    new TntSpell(level, player, castItem, modifiers);
                }
                casts--;
            }

            System.out.println(slot);

            setSlot(slot);
            if (casts <= 0) {
                shouldCast = false;
            }
        }
    }

    //updates or resets which slot the wand should start on
    private void setSlot(int slot) {
        if (slot + 1 >= capacity) {
            nbt.putInt("slot", 0);
            shouldCast = false;
            System.out.println("RESET");
        }
        else {
            nbt.putInt("slot", slot + 1);
        }
    }

    public void setHandler(IItemHandler handler) {
        this.handler = handler;
    }
}
