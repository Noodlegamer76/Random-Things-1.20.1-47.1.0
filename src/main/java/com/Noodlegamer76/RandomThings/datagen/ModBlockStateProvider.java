package com.Noodlegamer76.RandomThings.datagen;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RandomThingsMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlockInit.BRICK_SMALL09);
        blockWithItem(BlockInit.RAINBOW_ORE);
        blockWithItem(BlockInit.DEEPSLATE_RAINBOW_ORE);
        blockWithItem(BlockInit.RAINBOW_LEAVES);

        blockWithItem(BlockInit.RAINBOW_PLANKS);
        blockWithItem(BlockInit.QUICK_SAND);
        blockWithItem(BlockInit.QUICKER_SAND);

        saplingBlock(BlockInit.RAINBOW_SAPLING);

        final ResourceLocation RAINBOW_PLANKS_TEXTURE = new ResourceLocation(RandomThingsMod.MODID, "Block/rainbow_planks");
        final ResourceLocation RAINBOW_LOG_SIDE_TEXTURE = new ResourceLocation(RandomThingsMod.MODID, "Block/rainbow_log_side");
        final ResourceLocation STRIPPED_RAINBOW_LOG_SIDE_TEXTURE = new ResourceLocation(RandomThingsMod.MODID, "Block/stripped_rainbow_log_side");

        slabBlock((SlabBlock) BlockInit.RAINBOW_SLAB.get(), RAINBOW_PLANKS_TEXTURE,
                RAINBOW_PLANKS_TEXTURE);
        stairsBlock((StairBlock) BlockInit.RAINBOW_STAIRS.get(), RAINBOW_PLANKS_TEXTURE);

        buttonBlock((ButtonBlock) BlockInit.RAINBOW_BUTTON.get(), RAINBOW_PLANKS_TEXTURE);
        pressurePlateBlock((PressurePlateBlock) BlockInit.RAINBOW_PRESSURE_PLATE.get(), RAINBOW_PLANKS_TEXTURE);

        fenceBlock((FenceBlock) BlockInit.RAINBOW_FENCE.get(), RAINBOW_PLANKS_TEXTURE);
        fenceGateBlock((FenceGateBlock) BlockInit.RAINBOW_FENCE_GATE.get(), RAINBOW_PLANKS_TEXTURE);
        wallBlock((WallBlock) BlockInit.RAINBOW_WALL.get(), RAINBOW_PLANKS_TEXTURE);

        doorBlockWithRenderType((DoorBlock) BlockInit.RAINBOW_DOOR.get(), modLoc("Block/rainbow_door_bottom"), modLoc("Block/rainbow_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) BlockInit.RAINBOW_TRAPDOOR.get(), modLoc("Block/rainbow_trapdoor"), true, "cutout");

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
