package com.Noodlegamer76.RandomThings.spellcrafting.wand;

import com.Noodlegamer76.RandomThings.spellcrafting.spells.items.CactusSpell;
import com.Noodlegamer76.RandomThings.spellcrafting.spells.items.ExplosionSpell;
import com.Noodlegamer76.RandomThings.spellcrafting.spells.items.SpellItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class WandCast {
    IItemHandler handler;

    public WandCast(ServerPlayer player, Level level, ItemStack castItem) {
        //inventory slots index starts at 0

        LazyOptional<IItemHandler> iItemHandler = castItem.getCapability(ForgeCapabilities.ITEM_HANDLER, null);
        iItemHandler.ifPresent(this::setHandler);
        cast(player, level, castItem);

    }

    public void cast(ServerPlayer player, Level level, ItemStack castItem) {
        Item item = handler.getStackInSlot(0).getItem();
        if (item instanceof SpellItem) {
            if (item instanceof ExplosionSpell) {
                ExplosionSpell.activate(level, player, castItem);
            }
            else if (item instanceof CactusSpell) {
                CactusSpell.activate(level, player, castItem);
            }
            else {
                player.drop(true);
            }
        }
    }

    public void setHandler(IItemHandler handler) {
        this.handler = handler;
    }
}
