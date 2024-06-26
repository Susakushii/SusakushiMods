package com.susakushi.trinity_sourcery;

import com.mojang.logging.LogUtils;
import com.susakushi.trinity_sourcery.block.ModBlocks;
import com.susakushi.trinity_sourcery.curio.slots.Curios;
import com.susakushi.trinity_sourcery.entity.EntityInit;
import com.susakushi.trinity_sourcery.entity.ModmobEffectRegistry;
import com.susakushi.trinity_sourcery.gui.CharmHolderMenuScreen;
import com.susakushi.trinity_sourcery.item.ModCreativeTabs;
import com.susakushi.trinity_sourcery.item.ModItems;
import com.susakushi.trinity_sourcery.item.magicAtributesIronSpells.AttributeRegistry;
import com.susakushi.trinity_sourcery.item.magicAtributesIronSpells.ModSpellRegistry;
import com.susakushi.trinity_sourcery.util.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TrinitySourcery.MOD_ID)
public class TrinitySourcery {
    public static final String MOD_ID = "trinity_sourcery";
    public static final Logger LOGGER = LogUtils.getLogger();

    public TrinitySourcery() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        EntityInit.register(modEventBus);
        ModmobEffectRegistry.register(modEventBus);
        ModSpellRegistry.SPELLS.register(modEventBus);
        ModMenuTypes.MENU_TYPES.register(modEventBus);

        //Magic!
        AttributeRegistry.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        Curios.registerCurioSlot(Curios.RING_SLOT, 2, false, null);
        //Curios.registerCurioSlot(Curios.NECKLACE_SLOT, 1, false, null);
        //Curios.registerCurioSlot(Curios.SPELLBOOK_SLOT, 1, false, new ResourceLocation("curios:slot/spellbook_slot"));
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                ()-> SlotTypePreset.CHARM.getMessageBuilder().build());

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.CHARM_HOLDER_MENU.get(), CharmHolderMenuScreen::new);
        }
    }
}
