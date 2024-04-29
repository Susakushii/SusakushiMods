package com.susakushi.trinity_mods_by_susakushi.item.magicAtributesIronSpells;

import com.susakushi.trinity_mods_by_susakushi.TrinityModsbySusakushi;
import com.susakushi.trinity_mods_by_susakushi.spells.SummonIceGolemSpell;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModSpellRegistry {
    public static final DeferredRegister<AbstractSpell> SPELLS = DeferredRegister.create(SpellRegistry.SPELL_REGISTRY_KEY, TrinityModsbySusakushi.MOD_ID);

    public static void register(IEventBus eventBus) {
        SPELLS.register(eventBus);
    }

    public static RegistryObject<AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }

    public static final RegistryObject<AbstractSpell> SUMMON_ICE_GOLEM = registerSpell(new SummonIceGolemSpell());
}
