package com.Noodlegamer76.RandomThings.init;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.menus.WandMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypeInit {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, RandomThingsMod.MODID);
    public static final RegistryObject<MenuType<WandMenu>> WAND_MENU = MENU_TYPES.register("wand_menu", () -> IForgeMenuType.create(WandMenu::new));
}
