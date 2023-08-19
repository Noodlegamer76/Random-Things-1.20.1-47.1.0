package com.Noodlegamer76.RandomThings.init;

import com.Noodlegamer76.RandomThings.Items.*;
import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.spellcrafting.modifiers.items.ModifierItem;
import com.Noodlegamer76.RandomThings.spellcrafting.spells.items.SpellItem;
import com.Noodlegamer76.RandomThings.util.ToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RandomThingsMod.MODID);
    //Items
    public static final RegistryObject<Item> CHEESE_ITEM = ITEMS.register("cheese", () -> new Cheese(new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_SWORD = ITEMS.register("cactus_sword", () -> new CactusSword(ToolTiers.ModItemTier.CACTUS, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_PICKAXE = ITEMS.register("cactus_pickaxe", () -> new CactusPickaxe(ToolTiers.ModItemTier.CACTUS, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> WAND = ITEMS.register("wand", () -> new Wand(new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SHOVEL = ITEMS.register("blue_shovel", () -> new ShovelItem(ToolTiers.ModItemTier.BLUE, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> IRON_KNIFE = ITEMS.register("iron_knife", () -> new SwordItem(Tiers.IRON, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> CHEESE_SANDWICH = ITEMS.register("cheese_sandwich", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TNT_PICKAXE = ITEMS.register("tnt_pickaxe", () -> new TntPickaxe(Tiers.STONE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_SHIELD = ITEMS.register("cactus_shield", () -> new CactusShield(new Item.Properties()));
    public static final RegistryObject<Item> YOUTUBER_PICKAXE = ITEMS.register("youtuber_pickaxe", () -> new YoutuberPickaxe(ToolTiers.ModItemTier.YOUTUBER, 1, -2.8F, new Item.Properties()));

    public static final RegistryObject<Item> MODIFIER_ITEM = ITEMS.register("modifier_item", () -> new ModifierItem(new Item.Properties()));
    public static final RegistryObject<Item> SPELL_ITEM = ITEMS.register("spell_item", () -> new SpellItem(new Item.Properties()));


    //BlockItems
    public static final RegistryObject<Item> BRICK_SMALL09 = ITEMS.register("brick_small09", () -> new BlockItem(BlockInit.BRICK_SMALL09.get(), new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_CHEST = ITEMS.register("cactus_chest", () -> new BlockItem(BlockInit.CACTUS_CHEST.get(), new Item.Properties()));

}
