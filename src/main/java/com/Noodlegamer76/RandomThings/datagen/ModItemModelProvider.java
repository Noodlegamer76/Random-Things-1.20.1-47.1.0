package com.Noodlegamer76.RandomThings.datagen;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.init.BlockInit;
import com.Noodlegamer76.RandomThings.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RandomThingsMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handHeldItem(ItemInit.YOUTUBER_PICKAXE);
        saplingItem(BlockInit.RAINBOW_SAPLING);
    //    slabItem(BlockInit.RAINBOW_SLAB);
        simpleBlockItem(BlockInit.RAINBOW_DOOR);

        fenceItem(BlockInit.RAINBOW_FENCE, BlockInit.RAINBOW_PLANKS);
        buttonItem(BlockInit.RAINBOW_BUTTON, BlockInit.RAINBOW_PLANKS);
        wallItem(BlockInit.RAINBOW_WALL, BlockInit.RAINBOW_PLANKS);

        evenSimplerBlockItem(BlockInit.RAINBOW_FENCE_GATE);
        evenSimplerBlockItem(BlockInit.RAINBOW_SLAB);
        evenSimplerBlockItem(BlockInit.RAINBOW_STAIRS);
        evenSimplerBlockItem(BlockInit.RAINBOW_PRESSURE_PLATE);

        trapdoorItem(BlockInit.RAINBOW_TRAPDOOR);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RandomThingsMod.MODID, "block/" + item.getId().getPath()));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(RandomThingsMod.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(RandomThingsMod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(RandomThingsMod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(RandomThingsMod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RandomThingsMod.MODID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> block) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RandomThingsMod.MODID, "item/" + block.getId().getPath()));
    }
    private ItemModelBuilder slabItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("block/slab")).texture("layer0",
                new ResourceLocation(RandomThingsMod.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handHeldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(RandomThingsMod.MODID, "item/" + item.getId().getPath()));
    }

}
