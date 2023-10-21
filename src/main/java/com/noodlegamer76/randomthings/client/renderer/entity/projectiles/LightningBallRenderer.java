package com.noodlegamer76.randomthings.client.renderer.entity.projectiles;

import com.noodlegamer76.randomthings.entities.projectiles.LightningBall;
import com.noodlegamer76.randomthings.RandomThingsMod;
import com.noodlegamer76.randomthings.client.models.LightningBallModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LightningBallRenderer extends EntityRenderer<LightningBall> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(RandomThingsMod.MODID, "textures/entity/projectiles/lightning_ball.png");
    private final LightningBallModel<LightningBall> model;

    public LightningBallRenderer(EntityRendererProvider.Context manager) {
        super(manager);
        this.model = new LightningBallModel<>(manager.bakeLayer(LightningBallModel.LAYER_LOCATION));
    }


    @Override
    public void render(LightningBall entity, float pEntityYaw, float pPartialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int pPackedLight) {
        poseStack.pushPose();
        poseStack.scale(1.0F, 1.0F, 1.0F);

        this.model.setupAnim(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = multiBufferSource.getBuffer(this.model.renderType(TEXTURE));


        SpinPoseStack.spinPoseStack(entity, poseStack);

        this.model.renderToBuffer(poseStack, vertexconsumer, pPackedLight, 0, 1.0F, 1.0F, 1.0F, 1.0F);

        poseStack.popPose();
        super.render(entity, pEntityYaw, pPartialTick, poseStack, multiBufferSource, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(LightningBall pEntity) {
        return TEXTURE;
    }
}