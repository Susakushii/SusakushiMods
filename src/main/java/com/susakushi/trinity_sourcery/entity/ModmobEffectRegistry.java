package com.susakushi.trinity_sourcery.entity;

import com.susakushi.trinity_sourcery.TrinitySourcery;
import io.redspace.ironsspellbooks.effect.SummonTimer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModmobEffectRegistry {
    public static final DeferredRegister<MobEffect> MOB_EFFECT_DEFERRED_REGISTER = DeferredRegister.create(Registries.MOB_EFFECT, TrinitySourcery.MOD_ID);

    public static final RegistryObject<SummonTimer> ICE_GOLEM = MOB_EFFECT_DEFERRED_REGISTER.register("ice_golem_timer",
            () -> new SummonTimer(MobEffectCategory.BENEFICIAL,0xbea925));

    public static void register(IEventBus eventBus) {
        MOB_EFFECT_DEFERRED_REGISTER.register(eventBus);
    }
}
