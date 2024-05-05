package com.susakushi.trinity_sourcery.entity.custom;

import com.susakushi.trinity_sourcery.entity.EntityInit;
import com.susakushi.trinity_sourcery.entity.ModmobEffectRegistry;
import com.susakushi.trinity_sourcery.entity.ia.GolemAttackGoal;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.entity.mobs.MagicSummon;
import io.redspace.ironsspellbooks.entity.mobs.goals.*;
import io.redspace.ironsspellbooks.util.OwnerHelper;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class ExampleEntity extends Animal implements MagicSummon {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(ExampleEntity.class, EntityDataSerializers.BOOLEAN);

    public ExampleEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    protected LivingEntity cachedSummoner;
    protected UUID summonerUUID;

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeOut = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeOut = 0;

    public ExampleEntity(Level pLevel, LivingEntity owner) {
        this(EntityInit.EXAMPLE_ENTITY.get(), pLevel);
        setSummoner(owner);
    }


    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()){
            setupAnimationsStates();
        }
    }

    private void setupAnimationsStates(){
        if(this.idleAnimationTimeOut <=0){
            this.idleAnimationTimeOut = this.random.nextInt(40)*80;
            this.idleAnimationState.start(this.tickCount);
        }else {
            --this.idleAnimationTimeOut;
        }

        if(this.isAttacking() && attackAnimationTimeOut <= 0){
            attackAnimationTimeOut = 30; //tempo da animação em ticks
            attackAnimationState.start(this.tickCount);
        }else {
            --this.attackAnimationTimeOut;
        }

        if(!this.isAttacking()){
            attackAnimationState.stop();
        }

    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING){
            f = Math.min(pPartialTick * 6f,1f);
        }else {
            f = 0;
        }

        this.walkAnimation.update(f,0.2f);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new GolemAttackGoal(this,1.7D,true));
        this.goalSelector.addGoal(2, new GenericFollowOwnerGoal(this, this::getSummoner, 0.9f, 7, 3, false, 25));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));

        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));

        this.targetSelector.addGoal(1, new GenericOwnerHurtByTargetGoal(this, this::getSummoner));
        this.targetSelector.addGoal(1, new GenericOwnerHurtTargetGoal(this, this::getSummoner));
        this.targetSelector.addGoal(1, new GenericCopyOwnerTargetGoal(this, this::getSummoner));
        this.targetSelector.addGoal(1, (new GenericHurtByTargetGoal(this, (entity) -> entity == getSummoner())).setAlertOthers());
    }

    public static AttributeSupplier.Builder createAttributes(){
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,200)
                .add(Attributes.ATTACK_DAMAGE,6)
                .add(Attributes.MOVEMENT_SPEED,0.40D)
                .add(Attributes.ARMOR,20)
                .add(Attributes.ARMOR_TOUGHNESS,5)
                .add(Attributes.FOLLOW_RANGE, 7)
                .add(Attributes.ATTACK_KNOCKBACK,1)
                .add(Attributes.ATTACK_SPEED,2);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SNOW_GOLEM_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SNOW_GOLEM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SNOW_GOLEM_DEATH;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    public LivingEntity getSummoner() {
        return OwnerHelper.getAndCacheOwner(level(), cachedSummoner, summonerUUID);
    }

    public void setSummoner(@javax.annotation.Nullable LivingEntity owner) {
        if (owner != null) {
            this.summonerUUID = owner.getUUID();
            this.cachedSummoner = owner;
        }
    }

    @Override
    public void die(DamageSource pDamageSource) {
        this.onDeathHelper();
        super.die(pDamageSource);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.summonerUUID = OwnerHelper.deserializeOwner(compoundTag);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        OwnerHelper.serializeOwner(compoundTag, summonerUUID);
    }

    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking(){
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING,false);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        return Utils.doMeleeAttack(this, pEntity, SpellRegistry.SUMMON_POLAR_BEAR_SPELL.get().getDamageSource(this, getSummoner()));
    }

    @Override
    public boolean isAlliedTo(Entity pEntity) {
        return super.isAlliedTo(pEntity) || this.isAlliedHelper(pEntity);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (shouldIgnoreDamage(pSource))
            return false;
        return super.hurt(pSource, pAmount);
    }

    @Override
    public void onRemovedFromWorld() {
        this.onRemovedHelper(this, ModmobEffectRegistry.ICE_GOLEM.get());
        super.onRemovedFromWorld();
    }


    @Override
    public void onUnSummon() {
        if (!level().isClientSide) {
            MagicManager.spawnParticles(level(), ParticleTypes.POOF, getX(), getY(), getZ(), 25, .4, .8, .4, .03, false);
            discard();
        }
    }
}
