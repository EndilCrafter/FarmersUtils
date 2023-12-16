package net.endil.farmersutils.common.tag;

import net.endil.farmersutils.FarmersUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class FUTags {

    public static final TagKey<Item> CRATE_CAN_CONTAIN = item("crate_can_contain");


    private static TagKey<Item> item(String path) {
        return ItemTags.create(new ResourceLocation(FarmersUtils.MOD_ID, path));
    }

    private static TagKey<Block> block(String path) {
        return BlockTags.create(new ResourceLocation(FarmersUtils.MOD_ID, path));
    }
}
