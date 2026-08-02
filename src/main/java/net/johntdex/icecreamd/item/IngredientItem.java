package net.johntdex.icecreamd.item;

import net.johntdex.icecreamd.IceCreamdelight;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class IngredientItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(IceCreamdelight.MODID);

    //Ice Cream
    public static final DeferredItem<Item> VANILLA_ICE_CREAM = ITEMS.register("vanilla_ice_cream", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHOCOLATE_ICE_CREAM = ITEMS.register("chocolate_ice_cream", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BERRY_ICE_CREAM = ITEMS.register("berry_ice_cream", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CARAMEL_ICE_CREAM = ITEMS.register("caramel_ice_cream", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHORUS_ICE_CREAM = ITEMS.register("chorus_ice_cream", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GLOWBERRY_ICE_CREAM = ITEMS.register("glowberry_ice_cream", () -> new Item(new Item.Properties()));

    //Ingredients
    public static final DeferredItem<Item> CARAMEL = ITEMS.register("caramel", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DISTILLED_SPIRIT = ITEMS.register("distilled_spirit", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> VANILLA_EXTRACT = ITEMS.register("vanilla_extract", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PASTERURIZED_MILK = ITEMS.register("pasteurized_milk", () -> new Item(new Item.Properties()));

    public static void register(IEventBus bus) { ITEMS.register(bus); }
}

