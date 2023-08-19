package com.Noodlegamer76.RandomThings.client.renderer.blockentityrenderer;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.init.BlockEntityInit;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;

public class CactusChestRenderer extends ChestRenderer {
    public static final Material CHEST_LOCATION = new Material(Sheets.CHEST_SHEET, new ResourceLocation(RandomThingsMod.MODID, "entity/chest/cactus_normal"));
    public static final Material CHEST_LOCATION_LEFT = new Material(Sheets.CHEST_SHEET, new ResourceLocation(RandomThingsMod.MODID, "entity/chest/cactus_left"));
    public static final Material CHEST_LOCATION_RIGHT = new Material(Sheets.CHEST_SHEET, new ResourceLocation(RandomThingsMod.MODID, "entity/chest/cactus_right"));
    public CactusChestRenderer(BlockEntityRendererProvider.Context context) {
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

    @Override
    public void render(BlockEntity blockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
    super.render(blockEntity, pPartialTick, pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
    }

}
