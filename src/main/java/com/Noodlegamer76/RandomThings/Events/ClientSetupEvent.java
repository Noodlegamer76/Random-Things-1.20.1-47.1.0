package com.Noodlegamer76.RandomThings.Events;

import com.Noodlegamer76.RandomThings.menus.WandScreen;
import com.Noodlegamer76.RandomThings.init.MenuTypeInit;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.resources.model.ModelResourceLocation;
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
}
