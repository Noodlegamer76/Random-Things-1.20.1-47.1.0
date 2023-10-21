package com.noodlegamer76.randomthings.menus;

import com.noodlegamer76.randomthings.spellcrafting.spell.items.SpellItem;
import com.noodlegamer76.randomthings.spellcrafting.modifier.items.ModifierItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class SpellAndModifierSlot extends SlotItemHandler {
    private final Predicate<ItemStack> validator;
    public SpellAndModifierSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition, Predicate<ItemStack> validator) {
        super(itemHandler, index, xPosition, yPosition);
        this.validator = validator;
    }
    public SpellAndModifierSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        this(itemHandler, index, xPosition, yPosition, itemStack -> false);
    }
    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return stack.getItem() instanceof ModifierItem || stack.getItem() instanceof SpellItem;

    }
}
