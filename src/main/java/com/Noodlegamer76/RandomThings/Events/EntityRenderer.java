package com.Noodlegamer76.RandomThings.Events;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.client.models.ShieldModModel;
import com.Noodlegamer76.RandomThings.client.renderer.blockentityrenderer.CactusChestRenderer;
import com.Noodlegamer76.RandomThings.init.BlockEntityInit;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RandomThingsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EntityRenderer {
    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        //event.registerEntityRenderer(EntityInit.PRIMED_TNTX5.get(), PrimedTntX5Renderer::new);
        event.registerBlockEntityRenderer(BlockEntityInit.CACTUS_CHEST.get(), CactusChestRenderer::new);
    }
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
       event.registerLayerDefinition(ShieldModModel.LAYER_LOCATION, ShieldModModel::createBodyLayer);
    }

}
