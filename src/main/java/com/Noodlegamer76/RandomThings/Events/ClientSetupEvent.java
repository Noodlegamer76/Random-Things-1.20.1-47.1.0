package com.Noodlegamer76.RandomThings.Events;

import com.Noodlegamer76.RandomThings.menus.WandScreen;
import com.Noodlegamer76.RandomThings.init.MenuTypeInit;
import com.Noodlegamer76.RandomThings.partcle.ModParticle;
import com.Noodlegamer76.RandomThings.partcle.custom.ConfettiParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetupEvent {
    @SubscribeEvent
    void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(
                // Assume RegistryObject<MenuType<MyMenu>> MY_MENU
                // Assume MyContainerScreen<MyMenu> which takes in three parameters
                () -> MenuScreens.register(MenuTypeInit.WAND_MENU.get(), WandScreen::new));
    }

    @SubscribeEvent
    void RegisterParticleProviders(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticle.CONFETTI.get(),
                ConfettiParticles.Provider::new);
    }
}
