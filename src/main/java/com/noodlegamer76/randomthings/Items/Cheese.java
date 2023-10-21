package com.noodlegamer76.randomthings.Items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

public class Cheese extends Item {
    public Cheese(Properties properties) {
        super(CheeseProperties(properties));
    }
    public static Properties CheeseProperties(Properties properties) {
        properties.food(new FoodProperties.Builder().nutrition(2).saturationMod(2).build());
        properties.requiredFeatures();
        return properties;
    }
}
