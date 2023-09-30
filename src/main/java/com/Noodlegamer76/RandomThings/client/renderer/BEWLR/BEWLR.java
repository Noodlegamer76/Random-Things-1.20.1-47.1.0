package com.Noodlegamer76.RandomThings.client.renderer.BEWLR;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.client.models.ThrownTntModel;
import com.Noodlegamer76.RandomThings.Entities.projectiles.ThrownTntEntity;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.items.TntSpellItem;
import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

public class BEWLR extends BlockEntityWithoutLevelRenderer {
    ThrownTntModel<ThrownTntEntity> thrownTntModel;
    public static final ResourceLocation TEXTURE = new ResourceLocation(RandomThingsMod.MODID, "textures/entity/projectiles/thrown_tnt.png");

    public BEWLR() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());


    }

    public void setThrownTntModel(ThrownTntModel<ThrownTntEntity> model) {
        this.thrownTntModel = model;
    }



    @Override
    public void renderByItem(ItemStack pStack, ItemDisplayContext pDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int pPackedLight, int pPackedOverlay) {

        poseStack.pushPose();
        //ISSUE: EVERY ITEMSTACK RUNS THIS METHOD

        int i = TntSpellItem.ticks;


   //     VertexConsumer vertexConsumers = Minecraft.getInstance().renderBuffers().bufferSource().getBuffer(RenderType.entityCutout(TEXTURE));
   //     thrownTntModel.renderToBuffer(poseStack, vertexConsumers, pPackedLight, pPackedOverlay, 1f, 1f, 1f, 1f);

        VertexConsumer vertexconsumer = multiBufferSource.getBuffer(this.thrownTntModel.renderType(TEXTURE));



        if (i / 5 % 2 == 0) {
            i = OverlayTexture.pack(OverlayTexture.u(1.0F), 10);
        } else {
            i = OverlayTexture.NO_OVERLAY;
        }

        poseStack.scale(0.5f, 0.5f, 0.5f);
       // poseStack.translate(0, 0.5, 0);
       // SpinPoseStack.spinPoseStack(1F,TntSpellItem.rotation, poseStack);
       // poseStack.translate(0, -1, 0);

        this.thrownTntModel.renderToBuffer(poseStack, vertexconsumer, pPackedLight, i, 1.0F, 1.0F, 1.0F, 1.0F);

        poseStack.popPose();
    }
}
