package net.endil.farmersutils.common.world.inventory;

import net.endil.farmersutils.common.tag.FUTags;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class TraySlot extends Slot {
    public TraySlot(Container pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
    }

    @Override
    public boolean mayPlace(ItemStack pStack) {
        return pStack.isEdible() || pStack.is(FUTags.TRAY_CAN_SERVE);
    }
}
