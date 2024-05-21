package com.susakushi.trinity_sourcery.item.custom;

import com.susakushi.trinity_sourcery.gui.CharmHolderMenu;
import com.susakushi.trinity_sourcery.gui.CharmHolderMenuConfig;
import com.susakushi.trinity_sourcery.gui.CharmHolderMenuScreen;
import com.susakushi.trinity_sourcery.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

import java.util.Map;
import java.util.UUID;


public class CharmHolder extends BezelTalisman{
    public CharmHolder() {
        super(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.UNCOMMON),
                Map.of(
                        AttributeRegistry.LIGHTNING_SPELL_POWER.get(),
                        new AttributeModifier(UUID.randomUUID(),"Weapon modifier",.25,AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.LIGHTNING_MAGIC_RESIST.get(),
                        new AttributeModifier(UUID.randomUUID(),"Weapon modifier",1,AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.MAX_MANA.get(),
                        new AttributeModifier(UUID.randomUUID(),"Weapon modifier",250,AttributeModifier.Operation.ADDITION)
                ));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        LocalPlayer localplayer = Minecraft.getInstance().player;
        SimpleContainer simplecontainer = new SimpleContainer(3);
        assert localplayer != null;
        CharmHolderMenu menu = new CharmHolderMenu(Minecraft.getInstance().player.getId(),localplayer.getInventory(), simplecontainer);
        localplayer.containerMenu = menu;
        Minecraft.getInstance().setScreen(new CharmHolderMenuScreen(menu, localplayer.getInventory(), Component.translatable("gui.custom_gui_title")));
        return InteractionResultHolder.success(stack);
    }

}
