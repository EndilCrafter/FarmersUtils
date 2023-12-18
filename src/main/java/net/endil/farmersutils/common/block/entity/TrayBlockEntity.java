package net.endil.farmersutils.common.block.entity;

import net.endil.farmersutils.common.registry.FUBlockEntityTypes;
import net.endil.farmersutils.common.world.inventory.TrayMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;

public class TrayBlockEntity extends BaseContainerBlockEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(4, ItemStack.EMPTY);

    public TrayBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(FUBlockEntityTypes.TRAY.get(), pPos, pBlockState);
    }

    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        ContainerHelper.saveAllItems(pTag, this.items, false);
    }

    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.loadFromTag(pTag);
    }

    public void loadFromTag(CompoundTag pTag) {
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (pTag.contains("Items", 9)) {
            ContainerHelper.loadAllItems(pTag, this.items);
        }
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("farmersutils.container.tray");
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return new TrayMenu(pContainerId, pInventory, this);
    }

    @Override
    public int getContainerSize() {
        return 4;
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return this.items.stream().allMatch(ItemStack::isEmpty);
    }

    @Override
    public ItemStack getItem(int slot) {
        return this.items.get(slot);
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        ItemStack itemstack = ContainerHelper.removeItem(this.items, slot, amount);
        if (!itemstack.isEmpty()) {
            this.setChanged();
        }

        return itemstack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(this.items, slot);
    }

    @Override
    public void setItem(int pSlot, ItemStack pStack) {
        this.items.set(pSlot, pStack);
        if (pStack.getCount() > this.getMaxStackSize()) {
            pStack.setCount(this.getMaxStackSize());
        }

        this.setChanged();
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return Container.stillValidBlockEntity(this, pPlayer);
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    public Vec2 getTrayItemOffset(int index) {
        final float X_OFFSET = 0.3F;
        final float Y_OFFSET = 0.2F;
        final Vec2[] OFFSETS = {
                new Vec2(X_OFFSET, Y_OFFSET),
                new Vec2(0.0F, Y_OFFSET),
                new Vec2(-X_OFFSET, Y_OFFSET),
                new Vec2(X_OFFSET, -Y_OFFSET)
        };
        return OFFSETS[index];
    }
}
