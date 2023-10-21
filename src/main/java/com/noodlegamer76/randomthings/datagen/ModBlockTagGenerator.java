package com.noodlegamer76.randomthings.datagen;

import com.noodlegamer76.randomthings.init.BlockInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider  {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockInit.DEEPSLATE_RAINBOW_ORE.get())
                .add(BlockInit.RAINBOW_ORE.get())
                .add(BlockInit.BRICK_SMALL09.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BlockInit.RAINBOW_BUTTON.get(),
                        BlockInit.RAINBOW_TRAPDOOR.get(),
                        BlockInit.RAINBOW_WALL.get(),
                        BlockInit.RAINBOW_FENCE_GATE.get(),
                        BlockInit.RAINBOW_SLAB.get(),
                        BlockInit.RAINBOW_DOOR.get(),
                        BlockInit.RAINBOW_FENCE.get(),
                        BlockInit.RAINBOW_PLANKS.get(),
                        BlockInit.RAINBOW_STAIRS.get(),
                        BlockInit.RAINBOW_PRESSURE_PLATE.get(),
                        BlockInit.RAINBOW_WOOD.get(),
                        BlockInit.STRIPPED_RAINBOW_LOG.get(),
                        BlockInit.RAINBOW_LOG.get(),
                        BlockInit.STRIPPED_RAINBOW_WOOD.get(),
                        BlockInit.CACTUS_CHEST.get(),
                        BlockInit.TNT_CHEST.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(BlockInit.QUICK_SAND.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(BlockInit.RAINBOW_LEAVES.get());



        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockInit.DEEPSLATE_RAINBOW_ORE.get(),
                        BlockInit.RAINBOW_ORE.get());


        this.tag(BlockTags.FENCES)
                .add(BlockInit.RAINBOW_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(BlockInit.RAINBOW_FENCE_GATE.get());

        this.tag(BlockTags.WALLS)
                .add(BlockInit.RAINBOW_WALL.get());

        this.tag(BlockTags.PLANKS)
                .add(BlockInit.RAINBOW_PLANKS.get());

        this.tag(BlockTags.LOGS)
                .add(BlockInit.RAINBOW_LOG.get());

        this.tag(BlockTags.BUTTONS)
                .add(BlockInit.RAINBOW_BUTTON.get());

        this.tag(BlockTags.STAIRS)
                .add(BlockInit.RAINBOW_STAIRS.get());

        this.tag(BlockTags.SLABS)
                .add(BlockInit.RAINBOW_SLAB.get());

        this.tag(BlockTags.BUTTONS)
                .add(BlockInit.RAINBOW_BUTTON.get());

        this.tag(BlockTags.PRESSURE_PLATES)
                .add(BlockInit.RAINBOW_PRESSURE_PLATE.get());



    }
}
