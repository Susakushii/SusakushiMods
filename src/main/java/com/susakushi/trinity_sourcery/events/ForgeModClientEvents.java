package com.susakushi.trinity_sourcery.events;

import com.susakushi.trinity_sourcery.TrinitySourcery;
import com.susakushi.trinity_sourcery.gui.CharmHolderMenu;
import com.susakushi.trinity_sourcery.gui.CharmHolderMenuConfig;
import com.susakushi.trinity_sourcery.gui.CharmHolderMenuScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.ServerOpList;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkHooks;

@Mod.EventBusSubscriber(modid = TrinitySourcery.MOD_ID, value = Dist.CLIENT)
public class ForgeModClientEvents {
    //@SubscribeEvent
    //public static void onRClickInput(PlayerInteractEvent.RightClickItem event) {
//        Player player = event.getEntity();
//        if (player.getMainHandItem().getItem() == Items.DIAMOND) {
//            LocalPlayer localplayer = Minecraft.getInstance().player;
//            SimpleContainer simplecontainer = new SimpleContainer(6);
//            assert localplayer != null;
//            CharmHolderMenu menu = new CharmHolderMenu(Minecraft.getInstance().player.getId(),localplayer.getInventory(), simplecontainer);
//            localplayer.containerMenu = menu;
//            NetworkHooks.openScreen(ServerPlayer, new CharmHolderMenuScreen(menu, localplayer.getInventory()));
       // }
    }
