package com.noodlegamer76.randomthings.blockentities;

import com.noodlegamer76.randomthings.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TntChestBlockEntity extends ChestBlockEntity {
    public TntChestBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityInit.TNT_CHEST.get(), pos, blockState);
    }
}
