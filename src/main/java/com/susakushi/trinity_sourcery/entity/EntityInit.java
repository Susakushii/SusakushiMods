package com.susakushi.trinity_sourcery.entity;

import com.susakushi.trinity_sourcery.TrinitySourcery;
import com.susakushi.trinity_sourcery.entity.custom.ExampleEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
            ForgeRegistries.ENTITY_TYPES, TrinitySourcery.MOD_ID);

    public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITIES.register("example_entity",
            () -> EntityType.Builder.<ExampleEntity>of(ExampleEntity::new, MobCategory.CREATURE).immuneTo(Blocks.POWDER_SNOW)
                    .sized(1.0f,2.5f).build(new ResourceLocation(com.susakushi.trinity_sourcery.TrinitySourcery.MOD_ID,"example_entity").toString())
    );

    public static void register(IEventBus eventBus){
        ENTITIES.register(eventBus);
    }
}
