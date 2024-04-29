package com.susakushi.trinity_mods_by_susakushi.spells;

import com.susakushi.trinity_mods_by_susakushi.TrinityModsbySusakushi;
import com.susakushi.trinity_mods_by_susakushi.entity.ModmobEffectRegistry;
import com.susakushi.trinity_mods_by_susakushi.entity.custom.ExampleEntity;
import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

import java.util.Optional;

@AutoSpellConfig
public class SummonIceGolemSpell extends AbstractSpell {

    @Override
    public ResourceLocation getSpellResource() {
        return new ResourceLocation(TrinityModsbySusakushi.MOD_ID,"summon_ice_golem");
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.RARE)
            .setSchoolResource(SchoolRegistry.ICE_RESOURCE)
            .setMaxLevel(10)
            .setCooldownSeconds(180)
            .build();

    public SummonIceGolemSpell() {
        this.manaCostPerLevel = 10;
        this.baseSpellPower = 4;
        this.spellPowerPerLevel = 1;
        this.castTime = 20;
        this.baseManaCost = 50;
    }


    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public CastType getCastType() {
        return CastType.LONG;
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(SoundEvents.EVOKER_PREPARE_SUMMON);
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        int summonTime = 20 * 60 * 10;

        ExampleEntity iceGolem = new ExampleEntity(world, entity);
        iceGolem.setPos(entity.position());

        iceGolem.getAttributes().getInstance(Attributes.ATTACK_DAMAGE).setBaseValue(getGolemDamage(spellLevel, entity));
        iceGolem.getAttributes().getInstance(Attributes.MAX_HEALTH).setBaseValue(getGolemHealth(spellLevel, entity));
        iceGolem.setHealth(iceGolem.getMaxHealth());

        world.addFreshEntity(iceGolem);

        iceGolem.addEffect(new MobEffectInstance(ModmobEffectRegistry.ICE_GOLEM.get(), summonTime, 0, false, false, false));
        int effectAmplifier = 0;
        if (entity.hasEffect(ModmobEffectRegistry.ICE_GOLEM.get()))
            effectAmplifier += entity.getEffect(ModmobEffectRegistry.ICE_GOLEM.get()).getAmplifier() + 1;
        entity.addEffect(new MobEffectInstance(ModmobEffectRegistry.ICE_GOLEM.get(), summonTime, effectAmplifier, false, false, true));

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    private float getGolemHealth(int spellLevel, LivingEntity caster) {
        return 20 + getLevel(spellLevel, caster) * 4;
    }

    private float getGolemDamage(int spellLevel, LivingEntity caster) {
        return getSpellPower(spellLevel, caster);
    }

}
