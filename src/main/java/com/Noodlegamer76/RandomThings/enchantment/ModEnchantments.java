package com.Noodlegamer76.RandomThings.enchantment;

import com.Noodlegamer76.RandomThings.RandomThingsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(Registries.ENCHANTMENT, RandomThingsMod.MODID);

    public static RegistryObject<Enchantment> EXPLOSION =
            ENCHANTMENTS.register("explosion",
                    () -> new ExplosionEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));
    public static RegistryObject<Enchantment> VEIN_MINER =
            ENCHANTMENTS.register("vein_miner",
                    () -> new VeinMinerEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND));
}
