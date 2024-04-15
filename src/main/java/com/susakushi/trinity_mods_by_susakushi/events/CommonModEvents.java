package com.susakushi.trinity_mods_by_susakushi.events;


import com.susakushi.trinity_mods_by_susakushi.TrinityModsbySusakushi;
import com.susakushi.trinity_mods_by_susakushi.entity.EntityInit;
import com.susakushi.trinity_mods_by_susakushi.entity.custom.ExampleEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TrinityModsbySusakushi.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event){
        event.put(EntityInit.EXAMPLE_ENTITY.get(), ExampleEntity.createAttributes().build());
    }

}
