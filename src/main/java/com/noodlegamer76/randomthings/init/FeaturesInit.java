package com.noodlegamer76.randomthings.init;

import com.noodlegamer76.randomthings.RandomThingsMod;
import com.noodlegamer76.randomthings.world.features.CrystalTree;
import com.noodlegamer76.randomthings.world.features.SphereFeature;
import com.noodlegamer76.randomthings.world.features.test;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FeaturesInit {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, RandomThingsMod.MODID);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> TEST = FEATURES.register(
            "test",
            () -> new test(NoneFeatureConfiguration.CODEC)
    );
    public static final RegistryObject<Feature<TreeConfiguration>> CRYSTAL_TREE = FEATURES.register(
            "crystal_tree",
            () -> new CrystalTree(TreeConfiguration.CODEC)
    );
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> SPHERE = FEATURES.register(
            "sphere",
            () -> new SphereFeature(NoneFeatureConfiguration.CODEC)
    );
    public static final RegistryObject<Feature<OreConfiguration>> RAINBOW_ORE = FEATURES.register(
            "rainbow_ore",
            () -> new OreFeature(OreConfiguration.CODEC)
    );
}
