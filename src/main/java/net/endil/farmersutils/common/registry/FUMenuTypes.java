package net.endil.farmersutils.common.registry;

import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.world.inventory.CrateMenu;
import net.endil.farmersutils.common.world.inventory.TrayMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FUMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, FarmersUtils.MOD_ID);

    public static final RegistryObject<MenuType<CrateMenu>> CRATE = MENUS.register("crate",
            () -> IForgeMenuType.create((containerId, inventory, friendlyByteBuf) -> new CrateMenu(containerId, inventory)));
    public static final RegistryObject<MenuType<TrayMenu>> TRAY = MENUS.register("tray",
            () -> IForgeMenuType.create((containerId, inventory, friendlyByteBuf) -> new TrayMenu(containerId, inventory)));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
