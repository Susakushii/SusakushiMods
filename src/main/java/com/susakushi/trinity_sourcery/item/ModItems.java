package com.susakushi.trinity_sourcery.item;

import com.susakushi.trinity_sourcery.TrinitySourcery;
import com.susakushi.trinity_sourcery.curio.CurioBaseItem;
import com.susakushi.trinity_sourcery.curio.SimpleAttributeCurio;
import com.susakushi.trinity_sourcery.item.custom.*;
import com.susakushi.trinity_sourcery.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class ModItems implements ICurioItem {

    //public static final RegistryObject<CurioBaseItem> SILVER_RING = ITEMS.register("silver_ring", () -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.MAX_MANA.get(), new AttributeModifier("mana", 25, AttributeModifier.Operation.ADDITION)))

    //public static final RegistryObject<CurioBaseItem>THE_KEY_STONE_OF_BEZEL_RING = ITEMS.register("the_keystone_of_bezel_ring", BezelTalisman::new);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TrinitySourcery.MOD_ID);

    public static final RegistryObject<CurioBaseItem> CHARM_OF_LUCKY = ITEMS.register("charm_of_luck", LuckyTalisman::new);

    public static final RegistryObject<CurioBaseItem> CHARM_OF_REINCARNATION = ITEMS.register("charm_of_reincarnation", ReincarnationTalisman::new);

    public static final RegistryObject<CurioBaseItem> CHARM_OF_FIRE = ITEMS.register("charm_of_fire", FireTalisman::new);

    public static final RegistryObject<CurioBaseItem> CHARM_OF_ELECTRICITY = ITEMS.register("charm_of_electricity",ElectricTalisman::new);

    public static final RegistryObject<CurioBaseItem> CHARM_OF_TELEKINESIS = ITEMS.register("charm_of_telekinesis", TelekinesisTalisman::new);

    public static final RegistryObject<CurioBaseItem> THE_KEY_STONE_OF_BEZEL = ITEMS.register("the_keystone_of_bezel",() -> new SimpleAttributeCurio(ItemPropertiesHelper.equipment().stacksTo(1), AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("spell power", 0.3, AttributeModifier.Operation.MULTIPLY_TOTAL)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
