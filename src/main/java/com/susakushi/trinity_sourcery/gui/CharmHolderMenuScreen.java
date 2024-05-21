package com.susakushi.trinity_sourcery.gui;

import com.susakushi.trinity_sourcery.TrinitySourcery;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class CharmHolderMenuScreen extends AbstractContainerScreen<CharmHolderMenu> {

    private static final ResourceLocation CONTAINER_BACKGROUND = new ResourceLocation(TrinitySourcery.MOD_ID,"textures/gui/container/background.png");

    public CharmHolderMenuScreen(CharmHolderMenu menu, Inventory inventory, Component pTitle){
        super(menu,inventory,Component.empty());

        this.imageHeight = 165;
        this.imageWidth = 175;
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float v, int i, int i1) {
        guiGraphics.blit(CONTAINER_BACKGROUND,this.leftPos,this.topPos, 0,0,this.imageWidth,this.imageHeight);
    }
}
