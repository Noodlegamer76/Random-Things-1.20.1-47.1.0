package com.Noodlegamer76.RandomThings.world;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.init.BlockInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> RAINBOW_KEY = registerKey("rainbow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RAINBOW_ORE = registerKey("rainbow_ore");

    static RuleTest ruletest = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);
    static RuleTest ruletest1 = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    static RuleTest ruletest2 = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    static RuleTest ruletest3 = new BlockMatchTest(Blocks.NETHERRACK);
    static RuleTest ruletest4 = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
    static RuleTest airTest = new BlockMatchTest(Blocks.AIR);

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, RAINBOW_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockInit.RAINBOW_LOG.get()),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.simple(BlockInit.RAINBOW_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());


        register(context, RAINBOW_ORE, Feature.ORE, new OreConfiguration(
                List.of(OreConfiguration.target(ruletest1, BlockInit.RAINBOW_ORE.get().defaultBlockState()),
                        OreConfiguration.target(ruletest2, BlockInit.DEEPSLATE_RAINBOW_ORE.get().defaultBlockState())),
                4));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(RandomThingsMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {

        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
