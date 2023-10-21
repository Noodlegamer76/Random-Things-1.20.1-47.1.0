package com.noodlegamer76.randomthings.datagen;

import com.noodlegamer76.randomthings.init.BlockInit;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(BlockInit.BRICK_SMALL09.get());
        dropSelf(BlockInit.CACTUS_CHEST.get());
        dropSelf(BlockInit.TNT_CHEST.get());
        dropSelf(BlockInit.QUICK_SAND.get());
        add(BlockInit.RAINBOW_ORE.get(),
                (block -> createOreDrop(BlockInit.RAINBOW_ORE.get(), Items.STICK)));
        add(BlockInit.DEEPSLATE_RAINBOW_ORE.get(),
                (block -> createOreDrop(BlockInit.DEEPSLATE_RAINBOW_ORE.get(), Items.DIAMOND)));
        dropSelf(BlockInit.RAINBOW_LOG.get());
        dropSelf(BlockInit.STRIPPED_RAINBOW_LOG.get());
        dropSelf(BlockInit.RAINBOW_WOOD.get());
        dropSelf(BlockInit.STRIPPED_RAINBOW_WOOD.get());
        dropSelf(BlockInit.RAINBOW_PLANKS.get());
        dropSelf(BlockInit.RAINBOW_SAPLING.get());
        dropSelf(BlockInit.RAINBOW_STAIRS.get());
        dropSelf(BlockInit.RAINBOW_WALL.get());
        dropSelf(BlockInit.RAINBOW_FENCE.get());
        dropSelf(BlockInit.RAINBOW_FENCE_GATE.get());
        dropSelf(BlockInit.RAINBOW_BUTTON.get());
        dropSelf(BlockInit.RAINBOW_PRESSURE_PLATE.get());
        dropSelf(BlockInit.RAINBOW_TRAPDOOR.get());
        dropSelf(BlockInit.QUICKER_SAND.get());
        dropSelf(BlockInit.CRYSTALLIZED_STONE.get());
        dropSelf(BlockInit.CRYSTALLIZED_GRASS_BLOCK.get());
        dropSelf(BlockInit.CRYSTALLIZED_DIRT.get());

        this.add(BlockInit.RAINBOW_SLAB.get(),
                block -> createSlabItemTable(BlockInit.RAINBOW_SLAB.get()));
        this.add(BlockInit.RAINBOW_DOOR.get(),
                block -> createDoorTable(BlockInit.RAINBOW_DOOR.get()));

        this.add(BlockInit.RAINBOW_LEAVES.get(), (block) ->
                createLeavesDrops(block, BlockInit.RAINBOW_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
