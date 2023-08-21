package com.Noodlegamer76.RandomThings.Block;

import com.Noodlegamer76.RandomThings.BlockEntities.CactusChestBlockEntity;
import com.Noodlegamer76.RandomThings.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CactusChest extends ChestBlock {
    public CactusChest(BlockBehaviour.Properties properties) {
        super(properties, BlockEntityInit.CACTUS_CHEST::get);
    }
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CactusChestBlockEntity(pos, state);
    }
    @Override
    public void entityInside(BlockState p_51148_, Level p_51149_, BlockPos p_51150_, Entity p_51151_) {
        p_51151_.hurt(p_51149_.damageSources().cactus(), 1.0F);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        player.hurt(level.damageSources().cactus(), 1);
        return super.use(state, level, pos, player, hand, blockHitResult);
    }
}
