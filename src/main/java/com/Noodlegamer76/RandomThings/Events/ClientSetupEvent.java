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
        event.enqueueWork(
                // Assume RegistryObject<MenuType<MyMenu>> MY_MENU
                // Assume MyContainerScreen<MyMenu> which takes in three parameters
                () -> MenuScreens.register(MenuTypeInit.WAND_MENU.get(), WandScreen::new));

        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));




    }

    @SubscribeEvent
    void RegisterParticleProviders(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticle.CONFETTI.get(),
                ConfettiParticles.Provider::new);
    }
}
