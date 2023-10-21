package com.noodlegamer76.randomthings.client.renderer.entity.projectiles;

import com.noodlegamer76.randomthings.entities.projectiles.FireBall;
import com.noodlegamer76.randomthings.RandomThingsMod;
import com.noodlegamer76.randomthings.client.models.FireBallModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FireBallRenderer extends EntityRenderer<FireBall> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(RandomThingsMod.MODID, "textures/entity/projectiles/fire_ball.png");
    private final FireBallModel<FireBall> model;

    public FireBallRenderer(EntityRendererProvider.Context manager) {
        super(manager);
        this.model = new FireBallModel<>(manager.bakeLayer(FireBallModel.LAYER_LOCATION));
    }

    @Override
    public void render(FireBall entity, float pEntityYaw, float pPartialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int pPackedLight) {
        poseStack.pushPose();
        poseStack.scale(1.0F, 1.0F, 1.0F);
        this.model.setupAnim(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = multiBufferSource.getBuffer(this.model.renderType(TEXTURE));

        this.model.renderToBuffer(poseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        poseStack.popPose();

        super.render(entity, pEntityYaw, pPartialTick, poseStack, multiBufferSource, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(FireBall arrow) {
        return TEXTURE;
    }
}