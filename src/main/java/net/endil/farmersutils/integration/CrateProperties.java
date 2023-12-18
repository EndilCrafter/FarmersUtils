package net.endil.farmersutils.integration;

import com.google.common.base.Preconditions;
import mezz.jei.api.gui.handlers.IGuiProperties;
import net.endil.farmersutils.client.gui.screens.inventory.CrateScreen;
import net.endil.farmersutils.common.world.inventory.CrateMenu;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import org.jetbrains.annotations.Nullable;

public class CrateProperties implements IGuiProperties {
    private final Class<? extends Screen> screenClass;
    private final int guiLeft;
    private final int guiTop;
    private final int guiXSize;
    private final int guiYSize;
    private final int screenWidth;
    private final int screenHeight;

    public CrateProperties(Class<? extends Screen> screenClass, int guiLeft, int guiTop, int guiXSize, int guiYSize, int screenWidth, int screenHeight) {
        Preconditions.checkArgument(guiXSize > 0, "guiXSize must be > 0");
        Preconditions.checkArgument(guiYSize > 0, "guiYSize must be > 0");
        Preconditions.checkArgument(screenWidth > 0, "screenWidth must be > 0");
        Preconditions.checkArgument(screenHeight > 0, "screenHeight must be > 0");
        this.screenClass = screenClass;
        this.guiLeft = guiLeft;
        this.guiTop = guiTop;
        this.guiXSize = guiXSize;
        this.guiYSize = guiYSize;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    @Nullable
    public static CrateProperties create(AbstractContainerScreen<CrateMenu> containerScreen) {
        if (containerScreen.width <= 0 || containerScreen.height <= 0) {
            return null;
        }
        return new CrateProperties(
                containerScreen.getClass(),
                containerScreen.getGuiLeft(),
                containerScreen.getGuiTop(),
                containerScreen.getXSize(),
                containerScreen.getYSize(),
                containerScreen.width,
                containerScreen.height
        );
    }

    @Override
    public Class<? extends Screen> getScreenClass() {
        return CrateScreen.class;
    }

    @Override
    public int getGuiLeft() {
        return (this.screenWidth - 230) / 2;
    }

    @Override
    public int getGuiTop() {
        return (this.screenHeight - 222) / 2;
    }

    @Override
    public int getGuiXSize() {
        return 230;
    }

    @Override
    public int getGuiYSize() {
        return 222;
    }

    @Override
    public int getScreenWidth() {
        return this.screenWidth;
    }

    @Override
    public int getScreenHeight() {
        return this.screenHeight;
    }
}
