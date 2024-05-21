package com.susakushi.trinity_sourcery.item.custom;

import com.susakushi.trinity_sourcery.gui.CharmHolderMenu;
import com.susakushi.trinity_sourcery.gui.CharmHolderMenuScreen;
import com.susakushi.trinity_sourcery.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

import java.util.Map;
import java.util.UUID;


public class ElectricTalisman extends BezelTalisman{
    //"018e8b77-0243-763c-a5d3-8fd6a4146848"

    public ElectricTalisman() {
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
}

