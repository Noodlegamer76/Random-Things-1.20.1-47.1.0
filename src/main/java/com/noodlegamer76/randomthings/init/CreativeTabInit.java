package com.noodlegamer76.randomthings.init;

import com.noodlegamer76.randomthings.RandomThingsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RandomThingsMod.MODID);

    public static RegistryObject<CreativeModeTab> RANDOM_THINGS_TAB = CREATIVE_TABS.register("random_things_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("random_things.creative_tab"))
            .icon(() -> new ItemStack(ItemInit.CHEESE_ITEM.get()))
            .build());
}
