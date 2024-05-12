package com.susakushi.trinity_sourcery.gui;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

public class CharmHolderMenuConfig implements ContainerListener {

    public static final String INVENTORY_TAG = "Inventory";
    public static final String EXTENDED_TAG = "Extended";

    private SimpleContainer inventory;
    private LazyOptional<?> itemHandler = null;

    private void createInventory() {
        SimpleContainer simplecontainer = this.inventory;
        this.inventory = new SimpleContainer(54);
        if (simplecontainer != null) {
            simplecontainer.removeListener((net.minecraft.world.ContainerListener) this);
            int i = Math.min(simplecontainer.getContainerSize(), this.inventory.getContainerSize());

            for (int j = 0; j < i; ++j) {
                ItemStack itemstack = simplecontainer.getItem(j);
                if (!itemstack.isEmpty()) {
                    this.inventory.setItem(j, itemstack.copy());
                }
            }
        }

        this.inventory.addListener((net.minecraft.world.ContainerListener) this);
        this.itemHandler = LazyOptional.of(() -> new InvWrapper(this.inventory));
    }

    public CharmHolderMenuConfig(int inventory){
        this.createInventory();
    }

    public SimpleContainer getInventory() {
        return this.inventory;
    }


    @Override
    public void componentAdded(ContainerEvent e) {

    }

    @Override
    public void componentRemoved(ContainerEvent e) {

    }
}
