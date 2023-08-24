package com.Noodlegamer76.RandomThings.Block;

import com.Noodlegamer76.RandomThings.BlockEntities.TntChestBlockEntity;
import com.Noodlegamer76.RandomThings.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TntChest extends ChestBlock {
    public TntChest(BlockBehaviour.Properties properties) {
        super(properties, BlockEntityInit.TNT_CHEST::get);
        properties.explosionResistance(600);
    }
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TntChestBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if (!level.isClientSide()) {
            level.explode(null, level.damageSources().explosion(player, player), new ExplosionDamageCalculator(), pos.getX(), pos.getY(), pos.getZ(), 16.0F, false, Level.ExplosionInteraction.TNT);
        }
        return super.use(state, level, pos, player, hand, blockHitResult);
    }
}
