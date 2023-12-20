package net.endil.farmersutils.data;

import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.registry.FUBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;

public class FUBlockStates extends BlockStateProvider {
    private static final int DEFAULT_ANGLE_OFFSET = 180;

    public FUBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FarmersUtils.MOD_ID, exFileHelper);
    }

    private String blockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(FarmersUtils.MOD_ID, "block/" + path);
    }

    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(resourceBlock(blockName(block)), models().existingFileHelper);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (RegistryObject<Block> blockRegistryObject : Arrays.asList(FUBlocks.APPLE_BAG, FUBlocks.BROWN_MUSHROOM_BAG, FUBlocks.COCOA_BEAN_BAG, FUBlocks.CRIMSON_FUNGUS_BAG, FUBlocks.GLOW_BERRY_BAG, FUBlocks.GOLDEN_APPLE_BAG, FUBlocks.RED_MUSHROOM_BAG, FUBlocks.SWEET_BERRY_BAG, FUBlocks.WARPED_FUNGUS_BAG,
                FUBlocks.GOLDEN_MUSHROOM_BAG, FUBlocks.GOLDEN_COCOA_BEAN_BAG, FUBlocks.GOLDEN_FUNGUS_BAG, FUBlocks.GOLDEN_GLOW_BERRY_BAG, FUBlocks.SWEET_GOLDEN_BERRY_BAG, FUBlocks.PROPELPEARL_BAG, FUBlocks.GOLDELPEARL_BAG)) {
            bag(blockRegistryObject);
        }
        axisBlock((RotatedPillarBlock) FUBlocks.SUGAR_CANE_BALE.get());
        axisBlock((RotatedPillarBlock) FUBlocks.GOLDEN_SUGAR_CANE_BALE.get());
        axisBlock((RotatedPillarBlock) FUBlocks.PROPELPLANT_CANE_BALE.get());
        axisBlock((RotatedPillarBlock) FUBlocks.GOLDELPLANT_CANE_BALE.get());
    }

    private void blockItem(RegistryObject<Block> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(FarmersUtils.MOD_ID + ":block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void bag(RegistryObject<Block> bag) {
        String Bag = blockName(bag.get());
        simpleBlock(bag.get(), models().withExistingParent(Bag, "cube")
                .texture("particle", resourceBlock(Bag + "_top"))
                .texture("down", resourceBlock("bag_bottom"))
                .texture("up", resourceBlock(Bag + "_top"))
                .texture("north", resourceBlock("bag_side_tied"))
                .texture("south", resourceBlock("bag_side_tied"))
                .texture("east", resourceBlock("bag_side"))
                .texture("west", resourceBlock("bag_side")));
    }
}
