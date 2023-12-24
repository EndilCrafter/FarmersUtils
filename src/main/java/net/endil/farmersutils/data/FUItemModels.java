package net.endil.farmersutils.data;

import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.registry.FUBlocks;
import net.endil.farmersutils.common.registry.FUItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Collectors;

import static vectorwing.farmersdelight.data.ItemModels.takeAll;

public class FUItemModels extends ItemModelProvider {
    public FUItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FarmersUtils.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Set<Item> items = ForgeRegistries.ITEMS.getValues().stream().filter(i -> FarmersUtils.MOD_ID.equals(ForgeRegistries.ITEMS.getKey(i).getNamespace()))
                .collect(Collectors.toSet());

        items.remove(FUItems.EGG_BOX.get());
        spriteModel(FUBlocks.EGG_BOX);
        items.remove(FUItems.GOLDEN_EGG_BOX.get());
        spriteModel(FUBlocks.GOLDEN_EGG_BOX);

        items.remove(FUItems.CRATE.get());

        takeAll(items, i -> i instanceof BlockItem).forEach(item -> blockBasedModel(item, ""));
        simpleModel(FUItems.APPLE_SLICE);
        simpleModel(FUItems.GOLDEN_APPLE_SLICE);
        simpleModel(FUItems.DRIED_APPLE_SLICE);
        simpleModel(FUItems.DRIED_GOLDEN_APPLE_SLICE);
        simpleModel(FUItems.DRIED_BEEF);
        simpleModel(FUItems.DRIED_CHICKEN);
        simpleModel(FUItems.DRIED_COD_SLICE);
        simpleModel(FUItems.DRIED_MUTTON);
        simpleModel(FUItems.DRIED_PORKCHOP);
        simpleModel(FUItems.DRIED_RABBIT);
        simpleModel(FUItems.DRIED_SALMON_SLICE);
        simpleModel(FUItems.BOILED_EGG);
        simpleModel(FUItems.DRIED_GOLDEN_BEEF);
        simpleModel(FUItems.DRIED_GOLDEN_CHICKEN);
        simpleModel(FUItems.DRIED_GOLDEN_COD_SLICE);
        simpleModel(FUItems.DRIED_GOLDEN_MUTTON);
        simpleModel(FUItems.DRIED_GOLDEN_PORKCHOP);
        simpleModel(FUItems.DRIED_GOLDEN_RABBIT);
        simpleModel(FUItems.DRIED_GOLDEN_SALMON_SLICE);
        simpleModel(FUItems.BOILED_GOLDEN_EGG);
    }

    private ItemModelBuilder simpleModel(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FarmersUtils.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldModel(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FarmersUtils.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder spriteModel(RegistryObject<Block> block) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FarmersUtils.MOD_ID, "item/" + block.getId().getPath()));
    }

    private ItemModelBuilder plantModel(RegistryObject<Block> plant) {
        return withExistingParent(plant.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FarmersUtils.MOD_ID, "block/" + plant.getId().getPath()));
    }

    public void blockBasedModel(Item item, String suffix) {
        withExistingParent(itemName(item), resourceBlock(itemName(item) + suffix));
    }

    private String itemName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(FarmersUtils.MOD_ID, "block/" + path);
    }

    public ResourceLocation resourceItem(String path) {
        return new ResourceLocation(FarmersUtils.MOD_ID, "item/" + path);
    }
}
