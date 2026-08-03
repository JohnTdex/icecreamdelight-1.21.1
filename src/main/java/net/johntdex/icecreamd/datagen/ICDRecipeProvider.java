package net.johntdex.icecreamd.datagen;

import com.mojang.serialization.Decoder;
import net.johntdex.icecreamd.IceCreamdelight;
import net.johntdex.icecreamd.item.IngredientItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.Util.prefix;

public class ICDRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ICDRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static final int FAST_COOKING   = 100;   // 5 seconds
    public static final int NORMAL_COOKING = 200;   // 10 seconds
    public static final int SLOW_COOKING   = 400;   // 20 seconds

    private static final TagKey<Item> MILK_BOTTLES = ItemTags.create(
            ResourceLocation.fromNamespaceAndPath("c", "drinks/milk"));


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        //Shapeless Recipes

        //Vanilla Extract #Endangered #SaveVanilla
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, IngredientItem.VANILLA_EXTRACT.get(), 4)
                .requires(DataComponentIngredient.of(false, DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER), Items.POTION))
                .requires(Ingredient.of(Items.AZURE_BLUET, Items.OXEYE_DAISY, Items.LILY_OF_THE_VALLEY, Items.WHITE_TULIP))
                .requires(IngredientItem.DISTILLED_SPIRIT)
                .unlockedBy("has_azure_bluet", has(Items.AZURE_BLUET))
                .unlockedBy("has_oxeye_daisy", has(Items.OXEYE_DAISY))
                .unlockedBy("has_lily_of_the_valley", has(Items.LILY_OF_THE_VALLEY))
                .unlockedBy("has_white_tulip", has(Items.WHITE_TULIP))
                .save(recipeOutput);

        //Distilled Spirit
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, IngredientItem.DISTILLED_SPIRIT.get(), 1)
                .requires(DataComponentIngredient.of(false, DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER), Items.POTION))
                .requires(Ingredient.of(Items.SUGAR_CANE, Items.BAMBOO))
                .requires(Ingredient.of(Items.FERMENTED_SPIDER_EYE))
                .unlockedBy("has_sugar_cane", has(Items.SUGAR_CANE))
                .unlockedBy("has_bamboo", has(Items.BAMBOO))
                .unlockedBy("has_fermented_spider_eye", has(Items.FERMENTED_SPIDER_EYE))
                .save(recipeOutput);

        //Crem
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, IngredientItem.CREAM.get(), 1)
                .requires(Ingredient.of(MILK_BOTTLES))
                .requires(Ingredient.of(Items.SUGAR))
                .unlockedBy("has_milk_bottle", has(MILK_BOTTLES))
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(recipeOutput);

        //Uncooked Wafer
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, IngredientItem.UNCOOKED_WAFER.get(), 1)
                .requires(Ingredient.of(Items.WHEAT))
                .requires(Ingredient.of(Items.SUGAR))
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .save(recipeOutput);

        //Pastorized Mulk bottle
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, IngredientItem.PASTEURIZED_MILK_BOTTLE.get())

        //Ice Cram time


        //skillet and Cooking (non pot) Recipes

        //Pasteurized mulk iykyk
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.MILK_BUCKET), RecipeCategory.FOOD, IngredientItem.PASTEURIZED_MILK.get(), 0.35f, FAST_COOKING)
                .unlockedBy("has_milk_bucket", has(Items.MILK_BUCKET))
                .save(recipeOutput);

        //Pasteurized Mulk but smoked
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.MILK_BUCKET), RecipeCategory.FOOD, IngredientItem.PASTEURIZED_MILK.get(), 0.35f, FAST_COOKING)
                .unlockedBy("has_milk_bucket", has(Items.MILK_BUCKET))
                .save(recipeOutput, prefix("pasteurized_milk_bucket_from_smoking"));

        //Caramel cammel
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.SUGAR), RecipeCategory.FOOD, IngredientItem.CARAMEL.get(), 0.35f, FAST_COOKING)
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(recipeOutput);

        //caramel cammel but Skillet
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Items.SUGAR), RecipeCategory.FOOD, IngredientItem.CARAMEL.get(), 0.35f, SLOW_COOKING)
                .unlockedBy("has_sugar", has(Items.SUGAR))
                .save(recipeOutput, prefix("caramel_from_campfire_cooking"));

        //skilleteded wafur
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(IngredientItem.UNCOOKED_WAFER.get()), RecipeCategory.FOOD, IngredientItem.WAFER.get(), 0.35f, FAST_COOKING)
                .unlockedBy("has_uncooked_wafer", has(IngredientItem.UNCOOKED_WAFER.get()))
                .save(recipeOutput, prefix("wafer_from_campfire_cooking"));

        //Cutting Board Recipe
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.WHEAT), Ingredient.of(CommonTags.Items.TOOLS_KNIFE), IngredientItem.WHEAT_FLOUR.get(), 2)
                .build(recipeOutput, prefix("cutting/wheat"));

        //Cooking Pot




    }
    private static ResourceLocation prefix(String path) {
        return ResourceLocation.fromNamespaceAndPath(IceCreamdelight.MODID, path);
    }
}
