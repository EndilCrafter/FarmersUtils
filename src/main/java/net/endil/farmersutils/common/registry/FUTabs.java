package net.endil.farmersutils.common.registry;

import net.endil.farmersutils.FarmersUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class FUTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FarmersUtils.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FU_TAB = TABS.register(FarmersUtils.MOD_ID,
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.farmersutils"))
                    .icon(() -> new ItemStack(FUItems.CRATE.get()))
                    .displayItems((parameters, output) -> FUItems.CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get())))
                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
