package com.susakushi.trinity_sourcery.datagen;

import com.susakushi.trinity_sourcery.TrinitySourcery;
import com.susakushi.trinity_sourcery.curio.CurioBaseItem;
import com.susakushi.trinity_sourcery.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TrinitySourcery.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleCurioItem(ModItems.CHARM_OF_ELECTRICITY);
        simpleCurioItem(ModItems.CHARM_OF_FIRE);
        simpleCurioItem(ModItems.CHARM_OF_LUCKY);
        simpleCurioItem(ModItems.CHARM_OF_REINCARNATION);
        simpleCurioItem(ModItems.CHARM_OF_TELEKINESIS);
        simpleCurioItem(ModItems.THE_KEY_STONE_OF_BEZEL);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TrinitySourcery.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleCurioItem(RegistryObject<CurioBaseItem> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TrinitySourcery.MOD_ID,"item/" + item.getId().getPath()));
    }
}
