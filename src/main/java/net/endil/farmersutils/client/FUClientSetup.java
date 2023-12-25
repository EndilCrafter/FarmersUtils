package net.endil.farmersutils.client;

import net.endil.farmersutils.client.gui.screens.inventory.CrateScreen;
import net.endil.farmersutils.common.registry.FUMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class FUClientSetup {
    public static void init(final FMLClientSetupEvent event) {
        MenuScreens.register(FUMenuTypes.CRATE.get(), CrateScreen::new);
    }
}
