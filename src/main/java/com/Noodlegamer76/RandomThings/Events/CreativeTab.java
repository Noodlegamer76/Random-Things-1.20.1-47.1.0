package com.Noodlegamer76.RandomThings.Events;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.init.CreativeTabInit;
import com.Noodlegamer76.RandomThings.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTab {


    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        // Add to ingredients tab
        if (event.getTabKey() == CreativeTabInit.RANDOM_THINGS_TAB.getKey()) {
            event.accept(ItemInit.CHEESE_ITEM.get());
            event.accept(ItemInit.CACTUS_PICKAXE.get());
            event.accept(ItemInit.CACTUS_SWORD.get());
            event.accept(ItemInit.BRICK_SMALL09.get());
            event.accept(ItemInit.WAND.get());
            event.accept(ItemInit.BLUE_SHOVEL.get());
            event.accept(ItemInit.CACTUS_CHEST.get());
        }
    }
}
