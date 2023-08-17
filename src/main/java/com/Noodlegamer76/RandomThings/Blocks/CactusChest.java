package com.Noodlegamer76.RandomThings.Blocks;

import com.Noodlegamer76.RandomThings.BlockEntities.CactusChestBlockEntity;
import com.Noodlegamer76.RandomThings.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.TrappedChestBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;

public class CactusChest extends ChestBlock {
    public CactusChest(BlockBehaviour.Properties properties) {
        super(properties, () -> {
            return BlockEntityInit.CACTUS_CHEST.get();
        });
    }
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CactusChestBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        player.hurt(level.damageSources().cactus(), 1);
        return super.use(state, level, pos, player, hand, blockHitResult);
    }
}
