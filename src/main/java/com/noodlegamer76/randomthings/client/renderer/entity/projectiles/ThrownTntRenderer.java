package com.noodlegamer76.randomthings.client.renderer.entity.projectiles;

import com.noodlegamer76.randomthings.entities.projectiles.ThrownTntEntity;
import com.noodlegamer76.randomthings.events.RegisterParticleProviders;
import com.noodlegamer76.randomthings.RandomThingsMod;
import com.noodlegamer76.randomthings.client.models.ThrownTntModel;
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
public class ThrownTntRenderer extends EntityRenderer<ThrownTntEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(RandomThingsMod.MODID, "textures/entity/projectiles/thrown_tnt.png");
    private final ThrownTntModel<ThrownTntEntity> model;

    public ThrownTntRenderer(EntityRendererProvider.Context manager) {
        super(manager);
        this.model = new ThrownTntModel<>(manager.bakeLayer(ThrownTntModel.LAYER_LOCATION));
        RegisterParticleProviders.bewlr.setThrownTntModel(this.model);
    }



    @Override
    public void render(ThrownTntEntity entity, float pEntityYaw, float pPartialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int pPackedLight) {
        poseStack.pushPose();
        poseStack.scale(1.0F, 1.0F, 1.0F);

        this.model.setupAnim(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = multiBufferSource.getBuffer(this.model.renderType(TEXTURE));


        int i = entity.ticks;

        if (i / 5 % 2 == 0) {
            i = OverlayTexture.pack(OverlayTexture.u(1.0F), 10);
        } else {
            i = OverlayTexture.NO_OVERLAY;
        }

        poseStack.translate(0, 0.5, 0);
        SpinPoseStack.spinPoseStack(entity, poseStack);
        poseStack.translate(0, -0.5, 0);

        this.model.renderToBuffer(poseStack, vertexconsumer, pPackedLight, i, 1.0F, 1.0F, 1.0F, 1.0F);

        poseStack.popPose();
        super.render(entity, pEntityYaw, pPartialTick, poseStack, multiBufferSource, pPackedLight);
    }



    @Override
    public ResourceLocation getTextureLocation(ThrownTntEntity arrow) {
        return TEXTURE;
    }
}