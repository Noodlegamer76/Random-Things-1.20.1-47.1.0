package com.Noodlegamer76.RandomThings.Events;

import com.Noodlegamer76.RandomThings.client.renderer.BEWLR.BEWLR;
import com.Noodlegamer76.RandomThings.init.ItemInit;
import com.Noodlegamer76.RandomThings.menus.WandScreen;
import com.Noodlegamer76.RandomThings.init.MenuTypeInit;
import com.Noodlegamer76.RandomThings.partcle.ModParticle;
import com.Noodlegamer76.RandomThings.partcle.custom.ConfettiParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetupEvent {
    public static BEWLR bewlr = new BEWLR();
    @SubscribeEvent
    void clientSetup(FMLClientSetupEvent event) {




    }

    @SubscribeEvent
    void RegisterParticleProviders(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticle.CONFETTI.get(),
                ConfettiParticles.Provider::new);
    }
}
