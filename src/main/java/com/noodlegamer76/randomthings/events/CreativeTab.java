package com.noodlegamer76.randomthings.events;

import com.noodlegamer76.randomthings.init.CreativeTabInit;
import com.noodlegamer76.randomthings.init.ItemInit;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

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
            event.accept(ItemInit.TEST_MODIFIER);
            event.accept(ItemInit.CACTUS_SPELL);
            event.accept(ItemInit.EXPLOSION_SPELL);
            event.accept(ItemInit.TNT_LAUNCH_SPELL);
            event.accept(ItemInit.RAINBOW_GEM);
            event.accept(ItemInit.CRYSTALLIZED_STONE);
            event.accept(ItemInit.CRYSTALLIZED_GRASS_BLOCK);
            event.accept(ItemInit.CRYSTALLIZED_DIRT);
        }
    }
}
