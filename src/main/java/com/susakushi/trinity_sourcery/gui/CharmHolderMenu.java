package com.susakushi.trinity_sourcery.gui;

import com.susakushi.trinity_sourcery.item.ModItems;
import com.susakushi.trinity_sourcery.util.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
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

        createPlayerHotbar(playerInv);
        createPlayerInventory(playerInv);
        createItemInventory(charmHolderInventory);
    }

    private void createItemInventory(Container charmHolderInventory) {
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 3; column++) {
                addSlot(new Slot(charmHolderInventory, column + (row * 3), 26 + (column * 54), 14 + (row * 37)));
            }
        }
    }

    private void createPlayerInventory(Inventory playerInv) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInv, 9 + column + (row * 9), 8 + (column * 18), 84 + (row * 18)));

            }
        }
    }

    private void createPlayerHotbar(Inventory playerInv) {
        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInv, column, 8 + (column * 18),142));
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


