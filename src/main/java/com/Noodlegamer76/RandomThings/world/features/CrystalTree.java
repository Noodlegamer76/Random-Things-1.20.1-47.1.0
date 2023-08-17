package com.Noodlegamer76.RandomThings.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;

public class CrystalTree extends Feature<TreeConfiguration> {
    public CrystalTree(Codec<TreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<TreeConfiguration> context) {
        RandomSource random = context.random();
        LevelAccessor levelAccessor = context.level();
        BlockPos origin = context.origin();
        BlockPos current = origin;

        TreeConfiguration config = context.config();
        
        if (levelAccessor.isEmptyBlock(origin) && levelAccessor.getBlockState(origin.below()).is(BlockTags.DIRT)) {
            return true;
        }
        else return false;
    }
}
