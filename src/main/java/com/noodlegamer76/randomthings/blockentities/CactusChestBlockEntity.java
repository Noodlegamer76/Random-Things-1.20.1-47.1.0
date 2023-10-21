package com.noodlegamer76.randomthings.blockentities;

import com.noodlegamer76.randomthings.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CactusChestBlockEntity extends ChestBlockEntity {
    public CactusChestBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityInit.CACTUS_CHEST.get(), pos, blockState);
    }

    @Override
    protected AbstractContainerMenu createMenu(int p_59082_, Inventory p_59083_) {
        return super.createMenu(p_59082_, p_59083_);
    }
}