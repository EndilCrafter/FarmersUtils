package net.endil.farmersutils.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DriedMeatItem extends Item {
    public DriedMeatItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 48;
    }
}
