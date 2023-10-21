package com.noodlegamer76.randomthings.client.renderer.blockentityrenderer;

import com.noodlegamer76.randomthings.RandomThingsMod;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
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
    public void render(BlockEntity blockEntity, float pPartialTick, PoseStack ps, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
  /*      ModelResourceLocation modelLocation = new ModelResourceLocation(new ResourceLocation(RandomThingsMod.MODID, "Block/brick_small09"), "normal");
        BakedModel bakedModel = Minecraft.getInstance().getModelManager().getModel(modelLocation);




        blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(h -> {
            ItemStack stack = Items.DIAMOND.getDefaultInstance();
            if (!stack.isEmpty()) {
                ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
                for(int i = 0;i < 100;i++) {
                    ps.pushPose();
                    ps.scale((float) Math.random() * 100, (float) Math.random() * 100, (float) Math.random() * 100);
                    ps.translate(Math.random() * 100 - 50.00, Math.random() * 100 - 50.00, Math.random() * 100 - 50.00);
                    //itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, LightTexture.FULL_BRIGHT, pPackedOverlay, ps, pBuffer, Minecraft.getInstance().level, 0);
                    blockEntity.getLevel().explode(stack.getEntityRepresentation(),
                            blockEntity.getBlockPos().getX() + (Math.random() * 120) - 60,
                            blockEntity.getBlockPos().getY() + (Math.random() * 120) - 60,
                            blockEntity.getBlockPos().getZ() + (Math.random() * 120) - 60,
                            4f, Level.ExplosionInteraction.BLOCK);
                    ps.popPose();
                }
            }
        });
*/

    super.render(blockEntity, pPartialTick, ps, pBuffer, pPackedLight, pPackedOverlay);
    }

}
