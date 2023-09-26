package com.Noodlegamer76.RandomThings.client.renderer.item;

import com.Noodlegamer76.RandomThings.client.models.ShieldModModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class CactusShieldRenderer extends BlockEntityWithoutLevelRenderer {
    ModelLayerLocation LAYER_LOCATION = ShieldModModel.LAYER_LOCATION; // Use your actual model's LAYER_LOCATION
    // Create the ModelResourceLocation based on the ModelLayerLocation
    ModelResourceLocation modelLocation = new ModelResourceLocation(LAYER_LOCATION.getModel(), LAYER_LOCATION.getLayer());

    BakedModel bakedModel = Minecraft.getInstance().getModelManager().getModel(modelLocation);


    public CactusShieldRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher, EntityModelSet entityModelSet) {
        super(blockEntityRenderDispatcher, entityModelSet);

    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext transform, PoseStack ps, MultiBufferSource buffers, int light, int overlay) {
        ps.pushPose();
        Minecraft.getInstance().getItemRenderer().render(stack, transform, true, ps, buffers, light, overlay, bakedModel);
        ps.popPose();

    }
}
