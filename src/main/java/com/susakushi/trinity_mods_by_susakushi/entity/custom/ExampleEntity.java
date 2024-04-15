package com.susakushi.trinity_mods_by_susakushi.entity.custom;

import com.susakushi.trinity_mods_by_susakushi.entity.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class ExampleEntity extends Monster {


    public ExampleEntity(EntityType<ExampleEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ExampleEntity(Level level, double x, double y, double z){
        this(EntityInit.EXAMPLE_ENTITY.get(), level);
        setPos(x,y,z);
    }

    public ExampleEntity(Level level, BlockPos position){
        this(level, position.getX(),position.getY(),position.getZ());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0,new FloatGoal(this));
        this.goalSelector.addGoal(1,new LookAtPlayerGoal(this, Player.class,6.0f));
        this.goalSelector.addGoal(3,new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes(){
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,100)
                .add(Attributes.ATTACK_DAMAGE,4)
                .add(Attributes.MOVEMENT_SPEED,1.00)
                .add(Attributes.ARMOR,20)
                .add(Attributes.ARMOR_TOUGHNESS,5)
                .add(Attributes.FOLLOW_RANGE, 10);
    }

}
