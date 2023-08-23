package com.Noodlegamer76.RandomThings.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class RainbowOre extends Feature<OreConfiguration> {
    public RainbowOre(Codec<OreConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<OreConfiguration> pContext) {
        return true;
    }
}
