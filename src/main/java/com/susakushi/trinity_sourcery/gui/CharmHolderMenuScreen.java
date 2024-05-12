package com.susakushi.trinity_sourcery.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CharmHolderMenuScreen extends AbstractContainerScreen<CharmHolderMenu> {

    private static final ResourceLocation CONTAINER_BACKGROUND = new ResourceLocation("textures/gui/background.png");
    private final int containerRows = 6;

    public CharmHolderMenuScreen(CharmHolderMenu menu, Inventory inventory){
        super(menu,inventory,Component.translatable("gui.custom_gui_title"));
        this.imageHeight = 114 * 18;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    public void render(GuiGraphics graphics, int x, int y, float partialTicks) {
        this.renderBackground(graphics);
        super.render(graphics, x, y, partialTicks);
        this.renderTooltip(graphics, x, y);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTicks, int x, int y) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        graphics.blit(CONTAINER_BACKGROUND, i, j, 0, 0, this.imageWidth, this.containerRows);
        graphics.blit(CONTAINER_BACKGROUND, i, j + this.containerRows, 0, 126, this.imageWidth, 96);
    }
}
