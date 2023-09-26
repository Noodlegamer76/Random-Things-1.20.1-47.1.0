package com.Noodlegamer76.RandomThings.Events;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.client.models.FireBallModel;
import com.Noodlegamer76.RandomThings.client.models.LightningBallModel;
import com.Noodlegamer76.RandomThings.client.models.ShieldModModel;
import com.Noodlegamer76.RandomThings.client.models.ThrownTntModel;
import com.Noodlegamer76.RandomThings.client.renderer.entity.projectiles.FireBallRenderer;
import com.Noodlegamer76.RandomThings.client.renderer.entity.projectiles.LightningBallRenderer;
import com.Noodlegamer76.RandomThings.client.renderer.entity.projectiles.ThrownTntRenderer;
import com.Noodlegamer76.RandomThings.client.renderer.blockentityrenderer.CactusChestRenderer;
import com.Noodlegamer76.RandomThings.client.renderer.blockentityrenderer.TntChestRenderer;
import com.Noodlegamer76.RandomThings.init.BlockEntityInit;
import com.Noodlegamer76.RandomThings.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RandomThingsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EntityRenderer {
    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.FIRE_BALL.get(), FireBallRenderer::new);
        event.registerEntityRenderer(EntityInit.THROWN_TNT.get(), ThrownTntRenderer::new);
        event.registerEntityRenderer(EntityInit.LIGHTNING_BALL.get(), LightningBallRenderer::new);

        event.registerBlockEntityRenderer(BlockEntityInit.CACTUS_CHEST.get(), CactusChestRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityInit.TNT_CHEST.get(), TntChestRenderer::new);


    }
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
       event.registerLayerDefinition(ShieldModModel.LAYER_LOCATION, ShieldModModel::createBodyLayer);
       event.registerLayerDefinition(FireBallModel.LAYER_LOCATION, FireBallModel::createBodyLayer);
        event.registerLayerDefinition(ThrownTntModel.LAYER_LOCATION, ThrownTntModel::createBodyLayer);
        event.registerLayerDefinition(LightningBallModel.LAYER_LOCATION, LightningBallModel::createBodyLayer);
    }

}
