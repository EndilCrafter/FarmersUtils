package net.endil.farmersutils.data;

import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.registry.FUBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class FUBlockTags extends BlockTagsProvider {
    public FUBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FarmersUtils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(FUBlocks.CRATE.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(FUBlocks.KELP_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(FUBlocks.GOLDEN_KELP_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(FUBlocks.SUGAR_CANE_BALE.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(FUBlocks.GOLDEN_SUGAR_CANE_BALE.get());
        for (RegistryObject<Block> blockRegistryObject : Arrays.asList(FUBlocks.APPLE_BAG, FUBlocks.BROWN_MUSHROOM_BAG, FUBlocks.COCOA_BEAN_BAG, FUBlocks.CRIMSON_FUNGUS_BAG, FUBlocks.GLOW_BERRY_BAG, FUBlocks.GOLDEN_APPLE_BAG, FUBlocks.RED_MUSHROOM_BAG, FUBlocks.SWEET_BERRY_BAG, FUBlocks.WARPED_FUNGUS_BAG,
                FUBlocks.GOLDEN_MUSHROOM_BAG, FUBlocks.GOLDEN_COCOA_BEAN_BAG, FUBlocks.GOLDEN_FUNGUS_BAG, FUBlocks.GOLDEN_GLOW_BERRY_BAG, FUBlocks.SWEET_GOLDEN_BERRY_BAG)) {
            this.tag(ModTags.MINEABLE_WITH_KNIFE).add(blockRegistryObject.get());
            this.tag(ModTags.STRAW_BLOCKS).add(blockRegistryObject.get());
        }

    }
}
