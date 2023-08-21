package com.Noodlegamer76.RandomThings.init;

import com.Noodlegamer76.RandomThings.Block.CactusChest;
import com.Noodlegamer76.RandomThings.Block.ModFlammableRotatedPillarBlock;
import com.Noodlegamer76.RandomThings.Block.TntChest;
import com.Noodlegamer76.RandomThings.RandomThingsMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RandomThingsMod.MODID);

    public static final RegistryObject<Block> BRICK_SMALL09 = BLOCKS.register("brick_small09",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)));

    public static final RegistryObject<Block> CACTUS_CHEST = BLOCKS.register("cactus_chest",
            () -> new CactusChest(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final RegistryObject<Block> TNT_CHEST = BLOCKS.register("tnt_chest",
            () -> new TntChest(BlockBehaviour.Properties.copy(Blocks.CHEST)));
    public static final RegistryObject<Block> QUICK_SAND = BLOCKS.register("quick_sand",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND)
            .speedFactor(0.15f).jumpFactor(0.0f)));

    public static final RegistryObject<Block> RAINBOW_ORE = BLOCKS.register("rainbow_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_RAINBOW_ORE = BLOCKS.register("deepslate_rainbow_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));

    public static final RegistryObject<Block> RAINBOW_LOG = BLOCKS.register("rainbow_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_RAINBOW_LOG = BLOCKS.register("stripped_rainbow_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> RAINBOW_WOOD = BLOCKS.register("rainbow_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_RAINBOW_WOOD = BLOCKS.register("stripped_rainbow_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> RAINBOW_PLANKS = BLOCKS.register("rainbow_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
    });
    public static final RegistryObject<Block> RAINBOW_LEAVES = BLOCKS.register("rainbow_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> RAINBOW_SAPLING = BLOCKS.register("rainbow_sapling",
            () -> new SaplingBlock(null, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));



}
