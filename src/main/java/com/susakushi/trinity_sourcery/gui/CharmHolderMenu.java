package com.susakushi.trinity_sourcery.gui;

import com.susakushi.trinity_sourcery.gui.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class CharmHolderMenu extends AbstractContainerMenu {

    private final Container charmholderContainer;
    private final int containerRows;

    public CharmHolderMenu(int id, Inventory inventory, Container container) {
        super(MenuType.GENERIC_9x6, id);
        checkContainerSize(container, 6);
        this.charmholderContainer = container;
        this.containerRows = 6;
        container.startOpen(inventory.player);
        int i = (this.containerRows - 4) * 18;

        for (int j = 0; j < this.containerRows; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new CharmHSlots(container, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

    }

    public CharmHolderMenu(@Nullable MenuType<?> pMenuType, int pContainerId, Container charmholderContainer, CharmHolderMenuConfig charmHolderMenuConfig, int containerRows) {
        super(pMenuType, pContainerId);
        this.charmholderContainer = charmholderContainer;
        this.containerRows = containerRows;
    }

    public static class CharmHSlots extends Slot {

        public CharmHSlots(Container container, int slot, int x, int y) {
            super(container, slot, x, y);
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }
}
