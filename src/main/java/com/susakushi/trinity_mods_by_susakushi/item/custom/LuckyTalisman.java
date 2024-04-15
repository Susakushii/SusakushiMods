package com.susakushi.trinity_mods_by_susakushi.item.custom;

import com.susakushi.trinity_mods_by_susakushi.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import java.util.Map;
import java.util.UUID;


public class LuckyTalisman extends BezelTalisman{
    //"018e8b77-0243-763c-a5d3-8fd6a4146848"

    public LuckyTalisman() {
        super(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.UNCOMMON),
                Map.of(
                        AttributeRegistry.COOLDOWN_REDUCTION.get(),
                        new AttributeModifier(UUID.randomUUID(),"Weapon modifier",.25,AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.MANA_REGEN.get(),
                        new AttributeModifier(UUID.randomUUID(),"Weapon modifier",.25,AttributeModifier.Operation.MULTIPLY_BASE),
                        AttributeRegistry.CAST_TIME_REDUCTION.get(),
                        new AttributeModifier(UUID.randomUUID(),"Weapon modifier",.35,AttributeModifier.Operation.MULTIPLY_BASE)
        ));
    }
}

