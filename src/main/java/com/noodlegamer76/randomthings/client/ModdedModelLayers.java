package com.noodlegamer76.randomthings.client;

import com.noodlegamer76.randomthings.RandomThingsMod;
import com.google.common.collect.Sets;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Set;
import java.util.stream.Stream;

public class ModdedModelLayers extends ModelLayers {
    @OnlyIn(Dist.CLIENT)
    private static final Set<ModelLayerLocation> MOD_MODELS = Sets.newHashSet();
    public static final ModelLayerLocation FIRE_BALL = register("fire_ball");
    public static final ModelLayerLocation THROWN_TNT = new ModelLayerLocation(new ResourceLocation(RandomThingsMod.MODID, "thrown_tnt_model"), "main");


    private static ModelLayerLocation register(String p_171294_) {
        return register(p_171294_, "main");
    }

    private static ModelLayerLocation register(String p_171296_, String p_171297_) {
        ModelLayerLocation modellayerlocation = createLocation(p_171296_, p_171297_);
        if (!MOD_MODELS.add(modellayerlocation)) {
            throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
        } else {
            return modellayerlocation;
        }
    }

    private static ModelLayerLocation createLocation(String p_171301_, String p_171302_) {
        return new ModelLayerLocation(new ResourceLocation("minecraft", p_171301_), p_171302_);
    }

    private static ModelLayerLocation registerInnerArmor(String p_171299_) {
        return register(p_171299_, "inner_armor");
    }

    private static ModelLayerLocation registerOuterArmor(String p_171304_) {
        return register(p_171304_, "outer_armor");
    }

    public static ModelLayerLocation createRaftModelName(Boat.Type p_252002_) {
        return createLocation("raft/" + p_252002_.getName(), "main");
    }

    public static ModelLayerLocation createChestRaftModelName(Boat.Type p_248520_) {
        return createLocation("chest_raft/" + p_248520_.getName(), "main");
    }

    public static ModelLayerLocation createBoatModelName(Boat.Type p_171290_) {
        return createLocation("boat/" + p_171290_.getName(), "main");
    }

    public static ModelLayerLocation createChestBoatModelName(Boat.Type p_233551_) {
        return createLocation("chest_boat/" + p_233551_.getName(), "main");
    }

    public static ModelLayerLocation createSignModelName(WoodType p_171292_) {
        ResourceLocation location = new ResourceLocation(p_171292_.name());
        return new ModelLayerLocation(new ResourceLocation(location.getNamespace(), "sign/" + location.getPath()), "main");
    }

    public static ModelLayerLocation createHangingSignModelName(WoodType p_252225_) {
        ResourceLocation location = new ResourceLocation(p_252225_.name());
        return new ModelLayerLocation(new ResourceLocation(location.getNamespace(), "hanging_sign/" + location.getPath()), "main");
    }

    public static Stream<ModelLayerLocation> getKnownLocations() {
        return MOD_MODELS.stream();
    }
}


