package com.Noodlegamer76.RandomThings.Items;

import com.Noodlegamer76.RandomThings.menus.WandScreen;
import com.Noodlegamer76.RandomThings.init.ItemInit;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class WandInventoryCapability implements ICapabilitySerializable<CompoundTag> {
    public boolean isCreated = false;
    public Double first = 0.0;
    public Double second = 0.0;
    public Double third = 0.0;

    public static final Capability<WandInventoryCapability> WAND_INVENTORY_CAPABILITY =
            CapabilityManager.get(new CapabilityToken<WandInventoryCapability>(){});
    boolean test;
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onItemDropped(ItemTossEvent event) {
        if (event.getEntity().getItem().getItem() == ItemInit.WAND.get()) {
            if (Minecraft.getInstance().screen instanceof WandScreen) {
                Minecraft.getInstance().player.closeContainer();
            }
        }
    }

    private final LazyOptional<ItemStackHandler> inventory = LazyOptional.of(this::createItemHandler);

    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
        return capability == ForgeCapabilities.ITEM_HANDLER ? this.inventory.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = getItemHandler().serializeNBT();
        return nbt;
    }
    @Override
    public void deserializeNBT(CompoundTag nbt) {
        getItemHandler().deserializeNBT(nbt);
        isCreated = nbt.getBoolean("is_created");
    }

    private ItemStackHandler createItemHandler() {
        return new ItemStackHandler(27) {
            @Override
            public int getSlotLimit(int slot) {
                return 1;
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return stack.getItem() != ItemInit.WAND.get();
            }

            @Override
            public void setSize(int size) {
            }

        };
    }

    public void create() {
        if(!Dist.CLIENT.isClient()) {
            inventory.ifPresent(item -> {
                ItemStack stack = item.getStackInSlot(1);
                stack.setCount(stack.getCount() + 1);
                item.setStackInSlot(1, stack);
            });
        }
    }
    public void cast() {
        if(!isCreated) {
            create();
        }
    }

    private ItemStackHandler getItemHandler() {
        return inventory.orElseThrow(RuntimeException::new);
    }
}
