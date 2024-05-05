package com.susakushi.trinity_sourcery.util;

import com.susakushi.trinity_sourcery.TrinitySourcery;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;

public class RenderUtil {
    public static final ResourceLocation BACKGROUND = new ResourceLocation(TrinitySourcery.MOD_ID, "textures/gui/background.png");

    public static void updateScreen(Screen pGuiScreen) {
        Minecraft minecraft = Minecraft.getInstance();
        ForgeHooksClient.clearGuiLayers(minecraft);
        Screen old = minecraft.screen;
        if (old != null && pGuiScreen != old) {
            old.removed();
        }
        minecraft.screen = pGuiScreen;
        pGuiScreen.init(minecraft, minecraft.getWindow().getGuiScaledWidth(), minecraft.getWindow().getGuiScaledHeight());
        minecraft.noRender = false;
        minecraft.updateTitle();
    }
}
