package com.susakushi.trinity_sourcery.item;

import com.susakushi.trinity_sourcery.TrinitySourcery;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TrinitySourcery.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.THE_KEY_STONE_OF_BEZEL.get()))
                    .title(Component.translatable("creativetab.trinity_sourcery"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.CHARM_OF_LUCKY.get());
                        pOutput.accept(ModItems.CHARM_OF_ELECTRICITY.get());
                        pOutput.accept(ModItems.CHARM_OF_FIRE.get());
                        pOutput.accept(ModItems.CHARM_OF_REINCARNATION.get());
                        pOutput.accept(ModItems.CHARM_OF_TELEKINESIS.get());
                        pOutput.accept(ModItems.THE_KEY_STONE_OF_BEZEL.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
