package com.susakushi.trinity_sourcery.gui;

import com.susakushi.trinity_sourcery.item.ModItems;
import com.susakushi.trinity_sourcery.util.ModMenuTypes;
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
    private final Inventory playerInventory;
    private final Container charmHolderInventory;

    // Client constructor
    public CharmHolderMenu(int containerId, Inventory playerInv, FriendlyByteBuf additionalData) {
        this(containerId, playerInv, new Container() {
            @Override
            public void clearContent() {

            }

            @Override
            public int getContainerSize() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public ItemStack getItem(int i) {
                return null;
            }

            @Override
            public ItemStack removeItem(int i, int i1) {
                return null;
            }

            @Override
            public ItemStack removeItemNoUpdate(int i) {
                return null;
            }

            @Override
            public void setItem(int i, ItemStack itemStack) {

            }

            @Override
            public void setChanged() {

            }

            @Override
            public boolean stillValid(Player player) {
                return false;
            }
        });
    }

    // Server constructor
    public CharmHolderMenu(int containerId, Inventory playerInv, Container charmHolderInventory) {
        super(ModMenuTypes.CHARM_HOLDER_MENU.get(), containerId);
        this.playerInventory = playerInv;
        this.charmHolderInventory = charmHolderInventory;

        // Add 6 slots for the charm holder inventory
        for (int i = 0; i < 6; i++) {
            this.addSlot(new Slot(charmHolderInventory, i, 8 + i * 18, 20));
        }

        // Add slots for the player's inventory and hotbar
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 51 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInv, i, 8 + i * 18, 109));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        // Implementation remains the same
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        // Implementation remains the same
        return false;
    }
}


