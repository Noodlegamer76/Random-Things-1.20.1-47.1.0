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

public class test extends Feature<NoneFeatureConfiguration> {
    public test(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        RandomSource random = context.random();
        LevelAccessor levelAccessor = context.level();
        BlockPos origin = context.origin();
        BlockPos current = origin;

        NoneFeatureConfiguration config = context.config();

        // pls dont laugh at my bad algorithm
        if (levelAccessor.isEmptyBlock(origin) && levelAccessor.getBlockState(origin.below()).is(BlockTags.DIRT)) {
            for(int i = 0;i < 10; i++) {
                double xm = (double) random.nextIntBetweenInclusive(1, 199) / 100;
                double ym = (double) random.nextIntBetweenInclusive(1, 199) / 100;
                double zm = (double) random.nextIntBetweenInclusive(1, 199) / 100;

                double x = 0;
                double y = 0;
                double z = 0;

                for(int f = 0;f < 100; f++) {

                    if (xm < 1) x -= xm;
                    else if (xm >= 1) x += xm;
                    if(x >= 2.99) x -= 1.5;
                    else if(x <= 0.01) x += 1.5;
                    switch ((int) x) {
                        case 0: current = current.west(); break;
                        case 2: break;
                        case 3: current = current.east(); break;
                    }

                    if (ym < 1) y -= ym;
                    else if (ym >= 1) y += ym;
                    if(y >= 2.99) y -= 1.5;
                    else if(y <= 0.01) y += 1.5;
                    switch ((int) y) {
                        case 0: current = current.above(); break;
                        case 2: break;
                        case 3: current = current.below(); break;
                    }

                    if (zm < 1) z -= zm;
                    else if (zm >= 1) z += zm;
                    if(z >= 2.99) z -= 1.5;
                    else if(z <= 0.01) z += 1.5;
                    switch ((int) z) {
                        case 0: current = current.north(); break;
                        case 2: break;
                        case 3: current = current.south(); break;
                    }

                   /* switch (direction) {
                        case 1: {current = current.below(1); break;}
                        case 2: {current = current.above(1); break;}
                        case 3: {current = current.east(1); break;}
                        case 4: {current = current.west(1); break;}
                        case 5: {current = current.north(1); break;}
                        case 6: {current = current.south(1); break;}
                    }*/
                    levelAccessor.setBlock(current, Blocks.WHITE_CONCRETE.defaultBlockState(), 3);
                }
                current = origin;
            }
            return true;
        }
        else return false;
    }
}
