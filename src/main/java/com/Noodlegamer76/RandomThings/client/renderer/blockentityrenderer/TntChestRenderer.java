package com.Noodlegamer76.RandomThings.client.renderer.blockentityrenderer;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;

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
