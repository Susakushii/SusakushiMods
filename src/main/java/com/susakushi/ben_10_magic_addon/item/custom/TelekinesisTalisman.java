package com.susakushi.ben_10_magic_addon.item.custom;

import com.susakushi.ben_10_magic_addon.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Rarity;

import java.util.Map;
import java.util.UUID;


public class TelekinesisTalisman extends BezelTalisman{
    //"018e8b77-0243-763c-a5d3-8fd6a4146848"

    public TelekinesisTalisman() {
        super(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.UNCOMMON),
                Map.of(
                        AttributeRegistry.ENDER_SPELL_POWER.get(),
                        new AttributeModifier(UUID.randomUUID(),"Weapon modifier",.25,AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.ENDER_MAGIC_RESIST.get(),
                        new AttributeModifier(UUID.randomUUID(),"Weapon modifier",1,AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.MAX_MANA.get(),
                        new AttributeModifier(UUID.randomUUID(),"Weapon modifier",250,AttributeModifier.Operation.ADDITION)
        ));
    }
}

