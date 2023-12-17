package net.endil.farmersutils.common.world.inventory;

import net.endil.farmersutils.common.block.entity.CrateBlockEntity;
import net.endil.farmersutils.common.registry.FUMenuTypes;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.SlotItemHandler;

public class CrateMenu extends AbstractContainerMenu {
    private static final int CONTAINER_SIZE = 72;
    private final Container container;

    public CrateMenu(int pContainerId, Inventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, new SimpleContainer(72));
    }

    public CrateMenu(int pContainerId, Inventory inventory, Container container) {
        super(FUMenuTypes.CRATE.get(), pContainerId);
        checkContainerSize(container, 72);
        this.container = container;
        container.startOpen(inventory.player);

        int i = 6;
        int j = 12;

        for (int k = 0; k < 6; ++k) {
            for (int l = 0; l < 12; ++l) {
                this.addSlot(new CrateSlot(container, l + k * 12, -19 + l * 18, -11 + k * 18));
            }
        }

        for (int i1 = 0; i1 < 3; ++i1) {
            for (int k1 = 0; k1 < 9; ++k1) {
                this.addSlot(new Slot(inventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 111 + i1 * 18));
            }
        }

        for (int j1 = 0; j1 < 9; ++j1) {
            this.addSlot(new Slot(inventory, j1, 8 + j1 * 18, 169));
        }
    }

    public boolean stillValid(Player pPlayer) {
        return this.container.stillValid(pPlayer);
    }

    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(itemstack1, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.container.stopOpen(pPlayer);
    }

    public Container getContainer() {
        return this.container;
    }
}
