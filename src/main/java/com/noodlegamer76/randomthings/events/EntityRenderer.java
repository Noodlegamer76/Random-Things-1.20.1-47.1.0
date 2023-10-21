package com.noodlegamer76.randomthings.events;

import com.noodlegamer76.randomthings.RandomThingsMod;
import com.noodlegamer76.randomthings.client.models.FireBallModel;
import com.noodlegamer76.randomthings.client.models.LightningBallModel;
import com.noodlegamer76.randomthings.client.models.ShieldModModel;
import com.noodlegamer76.randomthings.client.models.ThrownTntModel;
import com.noodlegamer76.randomthings.client.renderer.entity.projectiles.FireBallRenderer;
import com.noodlegamer76.randomthings.client.renderer.entity.projectiles.LightningBallRenderer;
import com.noodlegamer76.randomthings.client.renderer.entity.projectiles.ThrownTntRenderer;
import com.noodlegamer76.randomthings.client.renderer.blockentityrenderer.CactusChestRenderer;
import com.noodlegamer76.randomthings.client.renderer.blockentityrenderer.TntChestRenderer;
import com.noodlegamer76.randomthings.init.BlockEntityInit;
import com.noodlegamer76.randomthings.init.EntityInit;
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
