package net.endil.farmersutils.data;

import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.registry.FUItems;
import net.endil.farmersutils.common.tag.FUCompatTags;
import net.endil.farmersutils.common.tag.FUTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FUItemTags extends ItemTagsProvider {
    public FUItemTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, FarmersUtils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(FUTags.CRATE_CAN_CONTAIN).addTag(Tags.Items.CROPS);

        this.tag(FUCompatTags.DIET_FRUITS)
                .add(FUItems.APPLE_SLICE.get(), FUItems.GOLDEN_APPLE_SLICE.get(), FUItems.DRIED_APPLE_SLICE.get(), FUItems.DRIED_GOLDEN_APPLE_SLICE.get());
        this.tag(FUCompatTags.DIET_PROTEINS)
                .add(FUItems.DRIED_BEEF.get(), FUItems.DRIED_CHICKEN.get(), FUItems.DRIED_COD_SLICE.get(), FUItems.DRIED_MUTTON.get(),
                        FUItems.DRIED_PORKCHOP.get(), FUItems.DRIED_RABBIT.get(), FUItems.DRIED_SALMON_SLICE.get(), FUItems.BOILED_EGG.get(),
                        FUItems.DRIED_GOLDEN_BEEF.get(), FUItems.DRIED_GOLDEN_CHICKEN.get(), FUItems.DRIED_GOLDEN_COD_SLICE.get(), FUItems.DRIED_GOLDEN_MUTTON.get(),
                        FUItems.DRIED_GOLDEN_PORKCHOP.get(), FUItems.DRIED_GOLDEN_RABBIT.get(), FUItems.DRIED_GOLDEN_SALMON_SLICE.get(), FUItems.BOILED_GOLDEN_EGG.get());
    }
}
