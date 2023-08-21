package com.Noodlegamer76.RandomThings.client.renderer.blockentityrenderer;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.init.BlockEntityInit;
import com.Noodlegamer76.RandomThings.init.ItemInit;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleDescription;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class TntChestRenderer extends ChestRenderer {
    public static final Material CHEST_LOCATION = new Material(Sheets.CHEST_SHEET, new ResourceLocation(RandomThingsMod.MODID, "entity/chest/tnt_normal"));
    public static final Material CHEST_LOCATION_LEFT = new Material(Sheets.CHEST_SHEET, new ResourceLocation(RandomThingsMod.MODID, "entity/chest/tnt_left"));
    public static final Material CHEST_LOCATION_RIGHT = new Material(Sheets.CHEST_SHEET, new ResourceLocation(RandomThingsMod.MODID, "entity/chest/tnt_right"));
    public TntChestRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected Material getMaterial(BlockEntity blockEntity, ChestType chestType) {
        return chooseMaterial(chestType, CHEST_LOCATION, CHEST_LOCATION_LEFT, CHEST_LOCATION_RIGHT);
    }
    public static Material chooseMaterial(ChestType pChestType, Material pDoubleMaterial, Material pLeftMaterial, Material pRightMaterial) {
        switch (pChestType) {
            case LEFT:
                return new Material(Sheets.CHEST_SHEET, CHEST_LOCATION_LEFT.texture());
            case RIGHT:
                return new Material(Sheets.CHEST_SHEET, CHEST_LOCATION_RIGHT.texture());
            case SINGLE:
            default:
                return new Material(Sheets.CHEST_SHEET, CHEST_LOCATION.texture());
        }
    }

}
