package com.susakushi.ben_10_magic_addon.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.susakushi.ben_10_magic_addon.curio.SimpleDescriptiveCurio;
import com.susakushi.ben_10_magic_addon.curio.slots.Curios;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BezelTalisman extends SimpleDescriptiveCurio {
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public BezelTalisman(Item.Properties properties, Map<Attribute, AttributeModifier> additionalAttributes) {
        super(properties);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        for (Map.Entry<Attribute, AttributeModifier> modifierEntry : additionalAttributes.entrySet()) {
            builder.put(modifierEntry.getKey(), modifierEntry.getValue());
        }
        this.defaultModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers( String slotIdentifier, ItemStack stack) {
        return (Objects.equals(slotIdentifier, Curios.RING_SLOT)) ? this.defaultModifiers : super.getAttributeModifiers(slotIdentifier, stack);
    }
}
