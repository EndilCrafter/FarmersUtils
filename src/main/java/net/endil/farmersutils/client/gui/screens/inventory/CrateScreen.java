package net.endil.farmersutils.client.gui.screens.inventory;

import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.world.inventory.CrateMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CrateScreen extends AbstractContainerScreen<CrateMenu> {
    private static final ResourceLocation CONTAINER_TEXTURE = new ResourceLocation(FarmersUtils.MOD_ID, "textures/gui/container/crate.png");
    protected int imageWidth = 256;
    protected int imageHeight = 222;

    public CrateScreen(CrateMenu crate, Inventory inventory, Component title) {
        super(crate, inventory, title);
        ++this.imageHeight;
    }

    public void render(GuiGraphics gui, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(gui);
        super.render(gui, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(gui, pMouseX, pMouseY);
    }

    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        pGuiGraphics.blit(CONTAINER_TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics gui, int pMouseX, int pMouseY) {
        gui.drawString(this.font, this.title, -17, -23, 4210752, false);

        gui.drawString(this.font, this.playerInventoryTitle, 8, (this.imageHeight - 125 + 2), 4210752, false);
    }
}
