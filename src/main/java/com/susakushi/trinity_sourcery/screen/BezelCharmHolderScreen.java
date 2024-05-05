package com.susakushi.trinity_sourcery.screen;

import com.susakushi.trinity_sourcery.util.RenderUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

@OnlyIn(Dist.CLIENT)
public class BezelCharmHolderScreen extends Screen {

    private final ItemStackHandler itemStackHandler = new ItemStackHandler(6);
    private static final int CHARM01 = 0;
    private static final int CHARM02 = 1;
    private static final int CHARM03 = 2;
    private static final int CHARM04 = 3;
    private static final int CHARM05 = 4;
    private static final int CHARM06 = 5;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();


    private final int imageWidth = 176;
    private final int imageHeight = 166;
    private int leftPos;
    private int topPos;

    public BezelCharmHolderScreen() {
        super(Component.empty());
    }

    @Override
    protected void init() {
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        pGuiGraphics.blit(RenderUtil.BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        for (Renderable renderable : this.renderables) {
            renderable.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        }
    }

}
