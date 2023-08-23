package com.Noodlegamer76.RandomThings.datagen;

import com.Noodlegamer76.RandomThings.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        polished(pWriter, RecipeCategory.DECORATIONS, ItemInit.BRICK_SMALL09.get(), Blocks.BRICKS);

        woodFromLogs(pWriter, ItemInit.RAINBOW_WOOD.get(), ItemInit.RAINBOW_LOG.get());


        fenceBuilder(ItemInit.RAINBOW_FENCE.get(), Ingredient.of(ItemInit.RAINBOW_PLANKS.get()));
        fenceGateBuilder(ItemInit.RAINBOW_FENCE_GATE.get(), Ingredient.of(ItemInit.RAINBOW_PLANKS.get()));
        doorBuilder(ItemInit.RAINBOW_DOOR.get(), Ingredient.of(ItemInit.RAINBOW_PLANKS.get()));
        wall(pWriter, RecipeCategory.DECORATIONS, ItemInit.RAINBOW_WALL.get(), ItemInit.RAINBOW_PLANKS.get());
        trapdoorBuilder(ItemInit.RAINBOW_TRAPDOOR.get(), Ingredient.of(ItemInit.RAINBOW_PLANKS.get()));
        pressurePlate(pWriter, ItemInit.RAINBOW_PRESSURE_PLATE.get(), ItemInit.RAINBOW_PLANKS.get());
        buttonBuilder(ItemInit.RAINBOW_BUTTON.get(), Ingredient.of(ItemInit.RAINBOW_PLANKS.get()));
        stairBuilder(ItemInit.RAINBOW_STAIRS.get(), Ingredient.of(ItemInit.RAINBOW_PLANKS.get()));
        slabBuilder(RecipeCategory.DECORATIONS, ItemInit.RAINBOW_SLAB.get(), Ingredient.of(ItemInit.RAINBOW_PLANKS.get()));


    }
}
