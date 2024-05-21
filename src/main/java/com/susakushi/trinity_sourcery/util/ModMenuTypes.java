package com.susakushi.trinity_sourcery.util;

import com.susakushi.trinity_sourcery.TrinitySourcery;
import com.susakushi.trinity_sourcery.gui.CharmHolderMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, TrinitySourcery.MOD_ID);

    public static final RegistryObject<MenuType<CharmHolderMenu>> CHARM_HOLDER_MENU = MENU_TYPES.register("charm_holder_menu",
    () -> IForgeMenuType.create(CharmHolderMenu::new));

    public void register(IEventBus eventBus){
        MENU_TYPES.register(eventBus);
    }
}
