package net.endil.farmersutils.common.world.inventory;

import net.endil.farmersutils.common.tag.FUTags;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class CrateSlot extends Slot {
    public CrateSlot(Container pContainer, int pSlot, int pX, int pY) {
        super(pContainer, pSlot, pX, pY);
    }

    public boolean mayPlace(ItemStack pStack) {
        return pStack.is(FUTags.CRATE_CAN_CONTAIN);
    }
}
