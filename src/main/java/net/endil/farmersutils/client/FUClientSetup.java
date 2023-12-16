package net.endil.farmersutils.client;

import net.endil.farmersutils.client.gui.screens.inventory.CrateScreen;
import net.endil.farmersutils.common.registry.FUMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class FUClientSetup {
    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> MenuScreens.register(FUMenuTypes.CRATE.get(), CrateScreen::new));
    }
}
