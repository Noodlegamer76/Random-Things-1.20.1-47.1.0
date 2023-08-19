package com.Noodlegamer76.RandomThings.util;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class ToolTiers {
    public enum ModItemTier implements Tier {
        CACTUS(1, 131, 4.0F, 1.0F, 5, () -> {
            return Ingredient.of(Items.CACTUS);
        }),
        BLUE(2, 250, 6.0F, 2.0F, 14, () -> {
            return Ingredient.of(Items.IRON_INGOT);
        }),
        YOUTUBER(1000, 20202002, 99999.0F, 99999.0F, 9999, () -> {
            return Ingredient.of(Items.IRON_INGOT);
        });

        private final int level;
        private final int uses;
        private final float speed;
        private final float damage;
        private final int enchantmentValue;
        private final LazyLoadedValue<Ingredient> repairIngredient;

        ModItemTier(int level, int durability, float miningSpeed, float damage, int enchantability, Supplier<Ingredient> repairIngredient) {
            this.level = level;
            this.uses = durability;
            this.speed = miningSpeed;
            this.damage = damage;
            this.enchantmentValue = enchantability;
            this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
        }

        public int getUses() {
            return this.uses;
        }

        public float getSpeed() {
            return this.speed;
        }

        public float getAttackDamageBonus() {
            return this.damage;
        }

        public int getLevel() {
            return this.level;
        }

        public int getEnchantmentValue() {
            return this.enchantmentValue;
        }

        public Ingredient getRepairIngredient() {
            return this.repairIngredient.get();
        }
    }
}
