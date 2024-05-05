package com.susakushi.trinity_sourcery.events;

import com.susakushi.trinity_sourcery.TrinitySourcery;
import com.susakushi.trinity_sourcery.screen.BezelCharmHolderScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TrinitySourcery.MOD_ID, value = Dist.CLIENT)
public class ForgeModClientEvents {
    @SubscribeEvent
    public static void onRClickInput(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        if (player.getMainHandItem().getItem() == Items.DIAMOND){
            System.out.println("AAAAAAAAAA");
            Minecraft minecraft = Minecraft.getInstance();
            minecraft.setScreen(new BezelCharmHolderScreen());
        }
    }
}
