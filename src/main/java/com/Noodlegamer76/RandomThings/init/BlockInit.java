package com.Noodlegamer76.RandomThings.init;

import com.Noodlegamer76.RandomThings.Block.CactusChest;
import com.Noodlegamer76.RandomThings.Block.FallingWebBlock;
import com.Noodlegamer76.RandomThings.Block.ModFlammableRotatedPillarBlock;
import com.Noodlegamer76.RandomThings.Block.TntChest;
import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.world.tree.RainbowTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.Vec3;
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
            () -> new FallingWebBlock(BlockBehaviour.Properties.copy(Blocks.SAND)
            .speedFactor(0.0f).jumpFactor(0.0f).mapColor(MapColor.WOOL).forceSolidOn().noCollission()));
    public static final RegistryObject<Block> QUICKER_SAND = BLOCKS.register("quicker_sand",
            () -> new FallingWebBlock(BlockBehaviour.Properties.copy(QUICK_SAND.get())){
                @Override
                public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
                    pEntity.makeStuckInBlock(pState, new Vec3(0.25D, (double)0.025F, 0.25D));
                }
            });

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
            () -> new SaplingBlock(new RainbowTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> RAINBOW_SLAB = BLOCKS.register("rainbow_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)) {
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
    public static final RegistryObject<Block> RAINBOW_STAIRS = BLOCKS.register("rainbow_stairs",
            () -> new StairBlock(RAINBOW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)) {
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
    public static final RegistryObject<Block> RAINBOW_DOOR = BLOCKS.register("rainbow_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final RegistryObject<Block> RAINBOW_BUTTON = BLOCKS.register("rainbow_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 20, true));
    public static final RegistryObject<Block> RAINBOW_PRESSURE_PLATE = BLOCKS.register("rainbow_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public static final RegistryObject<Block> RAINBOW_FENCE = BLOCKS.register("rainbow_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> RAINBOW_FENCE_GATE = BLOCKS.register("rainbow_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> RAINBOW_TRAPDOOR = BLOCKS.register("rainbow_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final RegistryObject<Block> RAINBOW_WALL = BLOCKS.register("rainbow_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));



}
