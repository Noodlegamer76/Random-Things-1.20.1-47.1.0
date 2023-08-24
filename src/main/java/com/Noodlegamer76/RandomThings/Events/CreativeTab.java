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
            event.accept(ItemInit.CHEESE_ITEM);
            event.accept(ItemInit.CACTUS_PICKAXE);
            event.accept(ItemInit.CACTUS_SWORD);
            event.accept(ItemInit.BRICK_SMALL09);
            event.accept(ItemInit.WAND);
            event.accept(ItemInit.BLUE_SHOVEL);
            event.accept(ItemInit.CACTUS_CHEST);
            event.accept(ItemInit.CACTUS_SHIELD);
            event.accept(ItemInit.TNT_PICKAXE);
            event.accept(ItemInit.CHEESE_SANDWICH);
            event.accept(ItemInit.IRON_KNIFE);
            event.accept(ItemInit.YOUTUBER_PICKAXE);
            event.accept(ItemInit.TNT_CHEST);
            event.accept(ItemInit.QUICK_SAND);
            event.accept(ItemInit.QUICKER_SOUND);
            event.accept(ItemInit.RAINBOW_ORE);
            event.accept(ItemInit.DEEPSLATE_RAINBOW_ORE);
            event.accept(ItemInit.RAINBOW_LOG);
            event.accept(ItemInit.STRIPPED_RAINBOW_LOG);
            event.accept(ItemInit.RAINBOW_WOOD);
            event.accept(ItemInit.STRIPPED_RAINBOW_WOOD);
            event.accept(ItemInit.RAINBOW_LEAVES);
            event.accept(ItemInit.RAINBOW_SAPLING);
            event.accept(ItemInit.RAINBOW_PLANKS);
            event.accept(ItemInit.RAINBOW_SLAB);
            event.accept(ItemInit.RAINBOW_STAIRS);
            event.accept(ItemInit.RAINBOW_DOOR);
            event.accept(ItemInit.RAINBOW_FENCE);
            event.accept(ItemInit.RAINBOW_FENCE_GATE);
            event.accept(ItemInit.RAINBOW_WALL);
            event.accept(ItemInit.RAINBOW_BUTTON);
            event.accept(ItemInit.RAINBOW_PRESSURE_PLATE);
            event.accept(ItemInit.RAINBOW_TRAPDOOR);
        }
    }
}
