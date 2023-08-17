package com.Noodlegamer76.RandomThings.init;

import com.Noodlegamer76.RandomThings.Blocks.CactusChest;
import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.world.features.CrystalTree;
import com.Noodlegamer76.RandomThings.world.features.test;
import com.Noodlegamer76.RandomThings.world.features.testconfig;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

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
}
