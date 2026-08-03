package net.johntdex.icecreamd.item;

import net.johntdex.icecreamd.IceCreamdelight;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class IngredientItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(IceCreamdelight.MODID);

    //Ice Cream
    public static final DeferredItem<Item> VANILLA_ICE_CREAM = ITEMS.register("vanilla_ice_cream", () -> new Item(new Item.Properties()
            .food( new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build())));
    public static final DeferredItem<Item> CHOCOLATE_ICE_CREAM = ITEMS.register("chocolate_ice_cream", () -> new Item(new Item.Properties()
            .food( new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build())));
    public static final DeferredItem<Item> BERRY_ICE_CREAM = ITEMS.register("berry_ice_cream", () -> new Item(new Item.Properties()
            .food( new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build())));
    public static final DeferredItem<Item> CARAMEL_ICE_CREAM = ITEMS.register("caramel_ice_cream", () -> new Item(new Item.Properties()
            .food( new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build())));
    public static final DeferredItem<Item> CHORUS_ICE_CREAM = ITEMS.register("chorus_ice_cream", () -> new Item(new Item.Properties()
            .food( new FoodProperties.Builder()
                    .alwaysEdible()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build())));
    public static final DeferredItem<Item> GLOWBERRY_ICE_CREAM = ITEMS.register("glowberry_ice_cream", () -> new Item(new Item.Properties()
            .food( new FoodProperties.Builder()
                    .alwaysEdible()
                    .nutrition(4)
                    .saturationModifier(0.6f)
                    .build())));

    //Ingredients
    public static final DeferredItem<Item> WAFER = ITEMS.register("wafer", () -> new Item(new Item.Properties()
            .food( new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(0.1f)
                    .build())));
    public static final DeferredItem<Item> CREAM = ITEMS.register("cream", () -> new Item(new Item.Properties()
            .food( new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.3f)
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0), 0.7f)
                    .build())));
    public static final DeferredItem<Item> DISTILLED_SPIRIT = ITEMS.register("distilled_spirit", () -> new Item(new Item.Properties()
            .food( new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationModifier(0.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 1.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 2), 1.0f)
                    .build())));
    public static final DeferredItem<Item> PASTEURIZED_MILK = ITEMS.register("pasteurized_milk", () -> new PasteurizedMilkItem(new Item.Properties()
            .food( new FoodProperties.Builder()
                    .alwaysEdible()
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0), 1.0f)
                    .build())));
    public static final DeferredItem<Item> PASTEURIZED_MILK_BOTTLE = ITEMS.register("pasteurized_milk_bottle", () -> new Item(new Item.Properties()
            .food( new FoodProperties.Builder()
                    .alwaysEdible()
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 0), 1.0f)
                    .build())));
    public static final DeferredItem<Item> UNCOOKED_WAFER = ITEMS.register("uncooked_wafer", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CARAMEL = ITEMS.register("caramel", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> VANILLA_EXTRACT = ITEMS.register("vanilla_extract", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WHEAT_FLOUR = ITEMS.register("wheat_flour", () -> new Item(new Item.Properties()));

    public static void register(IEventBus bus) { ITEMS.register(bus); }
}

