package com.Noodlegamer76.RandomThings.Items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class YoutuberPickaxe extends PickaxeItem {
    public YoutuberPickaxe(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_) {
        super(p_42961_, p_42962_, p_42963_, p_42964_);
    }

    @Override
    public boolean mineBlock(ItemStack item, Level level, BlockState blockState, BlockPos blockPos, LivingEntity player) {
    if (!level.isClientSide) {
        BlockPos current = blockPos;
        for(int i = 0;i < 100;i++) {
            int offset = (int) ((Math.random() * (6 - 1)) + 1);
            switch (offset) {
                case 1: {current = current.above(1); break;}
                case 2: {current = current.below(1); break;}
                case 3: {current = current.east(1); break;}
                case 4: {current = current.west(1); break;}
                case 5: {current = current.north(1); break;}
                case 6: {current = current.south(1); break;}
                default: player.hurt(level.damageSources().cactus(), 1);
            }
            level.destroyBlock(current, true, player);
            level.explode(player, current.getX(), current.getY(), current.getZ(), 4, Level.ExplosionInteraction.TNT);
        }
    }
        return true;
    }
}
