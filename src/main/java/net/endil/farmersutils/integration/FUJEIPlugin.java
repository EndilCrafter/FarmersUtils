package net.endil.farmersutils.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.client.gui.screens.inventory.CrateScreen;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class FUJEIPlugin implements IModPlugin {
    private static final ResourceLocation ID = new ResourceLocation(FarmersUtils.MOD_ID, "jei_plugin");

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addGuiScreenHandler(CrateScreen.class, CrateProperties::create);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }
}
