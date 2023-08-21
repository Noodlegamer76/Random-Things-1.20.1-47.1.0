package com.Noodlegamer76.RandomThings.BlockEntities;

import com.Noodlegamer76.RandomThings.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TntChestBlockEntity extends ChestBlockEntity {
    public TntChestBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityInit.TNT_CHEST.get(), pos, blockState);
    }
}
