package com.Noodlegamer76.RandomThings.Items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GravityGauntlet extends Item {
    public GravityGauntlet(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos location = pContext.getClickedPos();
        Level level = pContext.getLevel();
        BlockState state = level.getBlockState(location);

     //   for(int i = 0;i < 1000;i++) {
     //       pContext.getLevel().addParticle(ParticleTypes.CLOUD, location.getCenter().x, location.getCenter().y, location.getCenter().z, Math.random() - 0.5, Math.random() - 0.5, Math.random() - 0.5);
     //   }

        if (FallingBlock.isFree(level.getBlockState(location.below())) && location.getY() >= level.getMinBuildHeight()) {
            FallingBlockEntity.fall(level, location, state);
        }


        return super.useOn(pContext);
    }
}
