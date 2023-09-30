package com.Noodlegamer76.RandomThings.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SphereFeature extends Feature<NoneFeatureConfiguration> {
    public SphereFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        RandomSource random = pContext.random();
        LevelAccessor levelAccessor = pContext.level();
        BlockPos origin = pContext.origin();


        if (levelAccessor.isEmptyBlock(origin) && levelAccessor.getBlockState(origin.below()).is(BlockTags.DIRT)) {


            //creates a sphere the size of the outer radius, blocks under the inner radius aren't affected
            int outerRadius = 16;
            int innerRadius = 3;
            int innerRadiusSqr = outerRadius * outerRadius;
            int outerRadiusSqr = innerRadius * innerRadius;
            BlockPos.MutableBlockPos current = new BlockPos.MutableBlockPos();

            for (int x = origin.getX() - outerRadius; x <= origin.getX() + outerRadius; x++) {
                for (int y = origin.getY() - outerRadius; y <= origin.getY() + outerRadius; y++) {
                    for (int z = origin.getZ() - outerRadius; z <= origin.getZ() + outerRadius; z++) {
                        current.set(x, y, z);
                        double distance = origin.distSqr(current);

                        if (distance <= innerRadiusSqr && distance >= outerRadiusSqr) {
                            pContext.level().setBlock(current, Blocks.OAK_LOG.defaultBlockState(), 3);
                        }
                    }
                }
            }

            return true;
        }
        return false;
    }
}
