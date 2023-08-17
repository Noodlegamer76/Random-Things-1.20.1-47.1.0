package com.Noodlegamer76.RandomThings.Events;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.client.renderer.*;
import com.Noodlegamer76.RandomThings.init.EntityInit;
import com.Noodlegamer76.RandomThings.init.BlockEntityInit;
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
        //event.registerLayerDefinition(PrimedTntX5Model.LAYER_LOCATION, PrimedTntX5Model::createBodyLayer);
    }

}
