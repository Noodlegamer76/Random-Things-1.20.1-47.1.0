package com.Noodlegamer76.RandomThings.init;

import com.Noodlegamer76.RandomThings.Items.*;
import com.Noodlegamer76.RandomThings.RandomThingsMod;
import com.Noodlegamer76.RandomThings.spellcrafting.modifier.items.ModifierItem;
import com.Noodlegamer76.RandomThings.spellcrafting.modifier.items.TestModifierItem;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.items.CactusSpellItem;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.items.ExplosionSpellItem;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.items.SpellItem;
import com.Noodlegamer76.RandomThings.spellcrafting.spell.items.TntSpellItem;
import com.Noodlegamer76.RandomThings.util.ToolTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RandomThingsMod.MODID);

    //Items
    public static final RegistryObject<Item> CHEESE_ITEM = ITEMS.register("cheese",
            () -> new Cheese(new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_SWORD = ITEMS.register("cactus_sword",
            () -> new CactusSword(ToolTiers.ModItemTier.CACTUS, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_PICKAXE = ITEMS.register("cactus_pickaxe",
            () -> new CactusPickaxe(ToolTiers.ModItemTier.CACTUS, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> WAND = ITEMS.register("wand",
            () -> new Wand(new Item.Properties()));
    public static final RegistryObject<Item> BLUE_SHOVEL = ITEMS.register("blue_shovel",
            () -> new ShovelItem(ToolTiers.ModItemTier.BLUE, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> IRON_KNIFE = ITEMS.register("iron_knife",
            () -> new SwordItem(Tiers.IRON, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> CHEESE_SANDWICH = ITEMS.register("cheese_sandwich",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TNT_PICKAXE = ITEMS.register("tnt_pickaxe",
            () -> new TntPickaxe(Tiers.STONE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_SHIELD = ITEMS.register("cactus_shield",
            () -> new CactusShield(new Item.Properties()));
    public static final RegistryObject<Item> YOUTUBER_PICKAXE = ITEMS.register("youtuber_pickaxe",
            () -> new YoutuberPickaxe(ToolTiers.ModItemTier.YOUTUBER, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_GEM = ITEMS.register("rainbow_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRAVITY_GAUNTLET = ITEMS.register("gravity_gauntlet",
            () -> new GravityGauntlet(new Item.Properties()));

    public static final RegistryObject<Item> MODIFIER_ITEM = ITEMS.register("modifier_item",
            () -> new ModifierItem(new Item.Properties()));
    public static final RegistryObject<Item> TEST_MODIFIER = ITEMS.register("test_modifier",
            () -> new TestModifierItem(new Item.Properties()));
    public static final RegistryObject<Item> SPELL_ITEM = ITEMS.register("spell_item",
            () -> new SpellItem(new Item.Properties()));
    public static final RegistryObject<Item> EXPLOSION_SPELL = ITEMS.register("explosion_spell",
            () -> new ExplosionSpellItem(new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_SPELL = ITEMS.register("cactus_spell",
            () -> new CactusSpellItem(new Item.Properties()));
    public static final RegistryObject<Item> TNT_LAUNCH_SPELL = ITEMS.register("tnt_launch_spell",
            () -> new TntSpellItem(new Item.Properties()));


    //BlockItems
    public static final RegistryObject<Item> BRICK_SMALL09 = ITEMS.register("brick_small09",
            () -> new BlockItem(BlockInit.BRICK_SMALL09.get(), new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_CHEST = ITEMS.register("cactus_chest",
            () -> new BlockItem(BlockInit.CACTUS_CHEST.get(), new Item.Properties()));
    public static final RegistryObject<Item> TNT_CHEST = ITEMS.register("tnt_chest",
            () -> new BlockItem(BlockInit.TNT_CHEST.get(), new Item.Properties()));
    public static final RegistryObject<Item> QUICK_SAND = ITEMS.register("quick_sand",
            () -> new BlockItem(BlockInit.QUICK_SAND.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_ORE = ITEMS.register("rainbow_ore",
            () -> new BlockItem(BlockInit.RAINBOW_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_RAINBOW_ORE = ITEMS.register("deepslate_rainbow_ore",
            () -> new BlockItem(BlockInit.DEEPSLATE_RAINBOW_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_LOG = ITEMS.register("rainbow_log",
            () -> new BlockItem(BlockInit.RAINBOW_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_RAINBOW_LOG = ITEMS.register("stripped_rainbow_log",
            () -> new BlockItem(BlockInit.STRIPPED_RAINBOW_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_WOOD = ITEMS.register("rainbow_wood",
            () -> new BlockItem(BlockInit.RAINBOW_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_RAINBOW_WOOD = ITEMS.register("stripped_rainbow_wood",
            () -> new BlockItem(BlockInit.STRIPPED_RAINBOW_WOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_PLANKS = ITEMS.register("rainbow_planks",
            () -> new BlockItem(BlockInit.RAINBOW_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_LEAVES = ITEMS.register("rainbow_leaves",
            () -> new BlockItem(BlockInit.RAINBOW_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_SAPLING = ITEMS.register("rainbow_sapling",
            () -> new BlockItem(BlockInit.RAINBOW_SAPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_SLAB = ITEMS.register("rainbow_slab",
            () -> new BlockItem(BlockInit.RAINBOW_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_STAIRS = ITEMS.register("rainbow_stairs",
            () -> new BlockItem(BlockInit.RAINBOW_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_DOOR = ITEMS.register("rainbow_door",
            () -> new BlockItem(BlockInit.RAINBOW_DOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_FENCE = ITEMS.register("rainbow_fence",
            () -> new BlockItem(BlockInit.RAINBOW_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_FENCE_GATE = ITEMS.register("rainbow_fence_gate",
            () -> new BlockItem(BlockInit.RAINBOW_FENCE_GATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_BUTTON = ITEMS.register("rainbow_button",
            () -> new BlockItem(BlockInit.RAINBOW_BUTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_PRESSURE_PLATE = ITEMS.register("rainbow_pressure_plate",
            () -> new BlockItem(BlockInit.RAINBOW_PRESSURE_PLATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_WALL = ITEMS.register("rainbow_wall",
            () -> new BlockItem(BlockInit.RAINBOW_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_TRAPDOOR = ITEMS.register("rainbow_trapdoor",
            () -> new BlockItem(BlockInit.RAINBOW_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> QUICKER_SOUND = ITEMS.register("quicker_sand",
            () -> new BlockItem(BlockInit.QUICKER_SAND.get(), new Item.Properties()));
    public static final RegistryObject<Item> CRYSTALLIZED_STONE = ITEMS.register("crystallized_stone",
            () -> new BlockItem(BlockInit.CRYSTALLIZED_STONE.get(), new Item.Properties()));


}
