package com.susakushi.trinity_sourcery.events;


import com.susakushi.trinity_sourcery.TrinitySourcery;
import com.susakushi.trinity_sourcery.entity.EntityInit;
import com.susakushi.trinity_sourcery.entity.custom.ExampleEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TrinitySourcery.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event){
        event.put(EntityInit.EXAMPLE_ENTITY.get(), ExampleEntity.createAttributes().build());
    }

}
