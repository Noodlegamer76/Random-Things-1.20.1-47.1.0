package com.Noodlegamer76.RandomThings.init;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RandomThingsMod.MODID);

    public static RegistryObject<CreativeModeTab> RANDOM_THINGS_TAB = CREATIVE_TABS.register("randomthings", () -> CreativeModeTab.builder()
            .title(Component.translatable("random_things.creative_tab"))
            .icon(() -> new ItemStack(ItemInit.CHEESE_ITEM.get()))
            .build());
}
