package net.endil.farmersutils.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DriedFishItem extends Item {
    public DriedFishItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 24;
    }
}
