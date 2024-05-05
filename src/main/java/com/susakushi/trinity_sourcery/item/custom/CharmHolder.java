package com.susakushi.trinity_sourcery.item.custom;

import com.susakushi.trinity_sourcery.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

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
}
