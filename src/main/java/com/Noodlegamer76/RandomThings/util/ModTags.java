package com.Noodlegamer76.RandomThings.util;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> RAINBOW_LOGS = tag("rainbow_logs");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(RandomThingsMod.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> RAINBOW_WOOD = tag("rainbow_logs");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(RandomThingsMod.MODID, name));
        }
    }
}
