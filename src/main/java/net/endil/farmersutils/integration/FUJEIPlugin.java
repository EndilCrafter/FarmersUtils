package net.endil.farmersutils.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.gui.handlers.IGuiContainerHandler;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.client.gui.screens.inventory.CrateScreen;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class FUJEIPlugin implements IModPlugin {
    private static final ResourceLocation ID = new ResourceLocation(FarmersUtils.MOD_ID, "jei_plugin");

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addGuiContainerHandler(CrateScreen.class, new IGuiContainerHandler<>() {
            @Override
            public List<Rect2i> getGuiExtraAreas(CrateScreen containerScreen) {
                return IGuiContainerHandler.super.getGuiExtraAreas(containerScreen);
            }
        });
    }

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }
}
