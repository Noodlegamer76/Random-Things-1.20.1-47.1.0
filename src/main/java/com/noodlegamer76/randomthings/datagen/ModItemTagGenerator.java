package com.noodlegamer76.randomthings.datagen;

import com.noodlegamer76.randomthings.RandomThingsMod;
import com.noodlegamer76.randomthings.init.ItemInit;
import com.noodlegamer76.randomthings.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture,
                               CompletableFuture<TagLookup<Block>> tagLookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, providerCompletableFuture, tagLookupCompletableFuture, RandomThingsMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {


        this.tag(ModTags.Items.RAINBOW_WOOD)
                .add(ItemInit.RAINBOW_LOG.get())
                .add(ItemInit.STRIPPED_RAINBOW_LOG.get())
                .add(ItemInit.RAINBOW_WOOD.get())
                .add(ItemInit.STRIPPED_RAINBOW_WOOD.get());

        this.tag(ItemTags.LOGS)
                .add(ItemInit.RAINBOW_LOG.get());

        this.tag(ItemTags.BUTTONS)
                .add(ItemInit.RAINBOW_BUTTON.get());

        this.tag(ItemTags.PLANKS)
                .add(ItemInit.RAINBOW_PLANKS.get());

        this.tag(ItemTags.PICKAXES)
                .add(ItemInit.YOUTUBER_PICKAXE.get())
                .add(ItemInit.TNT_PICKAXE.get())
                .add(ItemInit.CACTUS_PICKAXE.get());

        this.tag(ItemTags.SHOVELS)
                .add(ItemInit.BLUE_SHOVEL.get());

        this.tag(ItemTags.SWORDS)
                .add(ItemInit.STRIPPED_RAINBOW_WOOD.get());

        this.tag(ItemTags.STAIRS)
                .add(ItemInit.RAINBOW_STAIRS.get());

        this.tag(ItemTags.SLABS)
                .add(ItemInit.RAINBOW_SLAB.get());

        this.tag(ItemTags.FENCES)
                .add(ItemInit.RAINBOW_FENCE.get());

        this.tag(ItemTags.FENCE_GATES)
                .add(ItemInit.RAINBOW_FENCE_GATE.get());

        this.tag(ItemTags.WALLS)
                .add(ItemInit.RAINBOW_WALL.get());

        this.tag(ItemTags.DOORS)
                .add(ItemInit.RAINBOW_DOOR.get());
    }
}
