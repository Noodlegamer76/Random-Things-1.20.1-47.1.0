package com.Noodlegamer76.RandomThings.init;

import com.Noodlegamer76.RandomThings.Blocks.CactusChest;
import com.Noodlegamer76.RandomThings.RandomThingsMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RandomThingsMod.MODID);

    public static final RegistryObject<Block> BRICK_SMALL09 = BLOCKS.register("brick_small09", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> CACTUS_CHEST = BLOCKS.register("cactus_chest", () -> new CactusChest(BlockBehaviour.Properties.copy(Blocks.CHEST)));


}
