package net.johntdex.icecreamd.datagen;

import net.johntdex.icecreamd.item.IngredientItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;

import java.util.concurrent.CompletableFuture;

public class ICDRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ICDRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, IngredientItem.VANILLA_EXTRACT.get(), 4)
                .requires(DataComponentIngredient.of(false, DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER), Items.POTION))
                .requires(Ingredient.of(Items.AZURE_BLUET, Items.OXEYE_DAISY, Items.LILY_OF_THE_VALLEY, Items.WHITE_TULIP))
                .requires(IngredientItem.DISTILLED_SPIRIT)
                .unlockedBy("has_azure_bluet", has(Items.AZURE_BLUET))
                .unlockedBy("has_oxeye_daisy", has(Items.OXEYE_DAISY))
                .unlockedBy("has_lily_of_the_valley", has(Items.LILY_OF_THE_VALLEY))
                .unlockedBy("has_white_tulip", has(Items.WHITE_TULIP))
                .save(recipeOutput);






    }
}
