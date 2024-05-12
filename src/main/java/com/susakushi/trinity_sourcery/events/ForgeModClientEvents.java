package com.susakushi.trinity_sourcery.events;

import com.susakushi.trinity_sourcery.TrinitySourcery;
import com.susakushi.trinity_sourcery.gui.CharmHolderMenu;
import com.susakushi.trinity_sourcery.gui.CharmHolderMenuConfig;
import com.susakushi.trinity_sourcery.gui.CharmHolderMenuScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkHooks;

@Mod.EventBusSubscriber(modid = TrinitySourcery.MOD_ID, value = Dist.CLIENT)
public class ForgeModClientEvents {
    @SubscribeEvent
    public static void onRClickInput(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        if (player.getMainHandItem().getItem() == Items.DIAMOND) {
            LocalPlayer localplayer = Minecraft.getInstance().player;
            SimpleContainer simplecontainer = new SimpleContainer(3);
            assert localplayer != null;
            CharmHolderMenu menu = new CharmHolderMenu(Minecraft.getInstance().player.getId(),localplayer.getInventory(), simplecontainer);
            localplayer.containerMenu = menu;
            Minecraft.getInstance().setScreen(new CharmHolderMenuScreen(menu, localplayer.getInventory()));
        }
    }
}
