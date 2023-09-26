package com.Noodlegamer76.RandomThings.datagen;

import com.Noodlegamer76.RandomThings.init.ItemInit;
import com.Noodlegamer76.RandomThings.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }
    private static final ItemLike RAINBOW_PLANKS = ItemInit.RAINBOW_PLANKS.get();

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        polished(pWriter, RecipeCategory.DECORATIONS, ItemInit.BRICK_SMALL09.get(), Blocks.BRICKS);


        //RAINBOW WOOD SET
        planksFromLogs(pWriter, ItemInit.RAINBOW_PLANKS.get(), ModTags.Items.RAINBOW_WOOD, 4);

        wall(pWriter, RecipeCategory.DECORATIONS, ItemInit.RAINBOW_WALL.get(), ItemInit.RAINBOW_PLANKS.get());
        slab(pWriter, RecipeCategory.DECORATIONS, ItemInit.RAINBOW_SLAB.get(), ItemInit.RAINBOW_PLANKS.get());
        pressurePlate(pWriter, ItemInit.RAINBOW_PRESSURE_PLATE.get(), ItemInit.RAINBOW_PLANKS.get());
        fenceBuilder(ItemInit.RAINBOW_FENCE.get(), Ingredient.of(RAINBOW_PLANKS)).unlockedBy(getHasName(RAINBOW_PLANKS), has(RAINBOW_PLANKS)).save(pWriter);
        fenceGateBuilder(ItemInit.RAINBOW_FENCE_GATE.get(), Ingredient.of(RAINBOW_PLANKS)).unlockedBy(getHasName(RAINBOW_PLANKS), has(RAINBOW_PLANKS)).save(pWriter);
        doorBuilder(ItemInit.RAINBOW_DOOR.get(), Ingredient.of(RAINBOW_PLANKS)).unlockedBy(getHasName(RAINBOW_PLANKS), has(RAINBOW_PLANKS)).save(pWriter);
        trapdoorBuilder(ItemInit.RAINBOW_TRAPDOOR.get(), Ingredient.of(RAINBOW_PLANKS)).unlockedBy(getHasName(RAINBOW_PLANKS), has(RAINBOW_PLANKS)).save(pWriter);
        buttonBuilder(ItemInit.RAINBOW_BUTTON.get(), Ingredient.of(RAINBOW_PLANKS)).unlockedBy(getHasName(RAINBOW_PLANKS), has(RAINBOW_PLANKS)).save(pWriter);
        stairBuilder(ItemInit.RAINBOW_STAIRS.get(), Ingredient.of(RAINBOW_PLANKS)).unlockedBy(getHasName(RAINBOW_PLANKS), has(RAINBOW_PLANKS)).save(pWriter);





    }
}
