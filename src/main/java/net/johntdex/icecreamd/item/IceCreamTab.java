package net.johntdex.icecreamd.item;

import net.johntdex.icecreamd.IceCreamdelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class IceCreamTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IceCreamdelight.MODID);

    public static final Supplier<CreativeModeTab> ICE_CREAM_TAB = CREATIVE_MODE_TABS.register("ice_cream_tab", () -> CreativeModeTab.builder()
            .icon(() -> IngredientItem.VANILLA_ICE_CREAM.get().getDefaultInstance())
            .title(Component.translatable("creativetab.icecreamdelight.ice_cream_tab"))
            .displayItems((itemDisplayParameters, output) -> {


                output.accept(IngredientItem.VANILLA_ICE_CREAM);
                output.accept(IngredientItem.CHOCOLATE_ICE_CREAM);
                output.accept(IngredientItem.BERRY_ICE_CREAM);
                output.accept(IngredientItem.CARAMEL_ICE_CREAM);
                output.accept(IngredientItem.CHORUS_ICE_CREAM);
                output.accept(IngredientItem.GLOWBERRY_ICE_CREAM);

                output.accept(IngredientItem.CARAMEL);
                output.accept(IngredientItem.DISTILLED_SPIRIT);
                output.accept(IngredientItem.VANILLA_EXTRACT);
                output.accept(IngredientItem.PASTERURIZED_MILK);

            })
            .build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
