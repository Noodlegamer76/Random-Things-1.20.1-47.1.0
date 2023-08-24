package com.Noodlegamer76.RandomThings.Items;

import com.Noodlegamer76.RandomThings.menus.WandMenu;
import com.Noodlegamer76.RandomThings.spellcrafting.wand.WandCast;
import io.netty.buffer.Unpooled;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;

public class Wand extends Item {
    public Wand(Item.Properties properties) {
        super(properties);
    }
    WandInventoryCapability capability;

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(level, player, hand);
        ItemStack itemstack = ar.getObject();
        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();
        if (player instanceof ServerPlayer serverPlayer) {
            ItemStack item = player.getItemInHand(hand);


            if (serverPlayer.isCrouching()) {
                NetworkHooks.openScreen(serverPlayer, new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return Component.literal(String.valueOf("hello"));
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                        FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                        packetBuffer.writeBlockPos(player.blockPosition());
                        packetBuffer.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                        return new WandMenu(id, inventory, packetBuffer);
                    }
                }, buf -> {
                    buf.writeBlockPos(player.blockPosition());
                    buf.writeByte(hand == InteractionHand.MAIN_HAND ? 0 : 1);
                });
            }
            if (!serverPlayer.isCrouching()) {
                    new WandCast((ServerPlayer)  player, level, item);
            }
        }

        return ar;
    }

    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag compound) {
        WandInventoryCapability capability = new WandInventoryCapability();
        return capability;
    }

    @Override
    public CompoundTag getShareTag(ItemStack stack) {
        CompoundTag nbt = super.getShareTag(stack);
        if (nbt != null) {
            stack.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                    .ifPresent(capability -> nbt.put("Inventory", ((ItemStackHandler) capability).serializeNBT()));
        }
        return nbt;
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundTag nbt) {
        super.readShareTag(stack, nbt);
        if (nbt != null) {
            stack.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                    .ifPresent(capability -> ((ItemStackHandler) capability).deserializeNBT((CompoundTag) nbt.get("Inventory")));
        }
    }
}
