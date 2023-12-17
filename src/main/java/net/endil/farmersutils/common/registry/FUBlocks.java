package net.endil.farmersutils.common.registry;

import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.block.CrateBlock;
import net.endil.farmersutils.common.block.EggBoxBlock;
import net.endil.farmersutils.common.block.TrayBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FUBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FarmersUtils.MOD_ID);

    //Compact Storage
    public static final RegistryObject<Block> APPLE_BAG = BLOCKS.register("apple_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> BROWN_MUSHROOM_BAG = BLOCKS.register("brown_mushroom_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> COCOA_BEAN_BAG = BLOCKS.register("cocoa_bean_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> CRIMSON_FUNGUS_BAG = BLOCKS.register("crimson_fungus_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> EGG_BOX = BLOCKS.register("egg_box",
            () -> new EggBoxBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).instabreak()));
    public static final RegistryObject<Block> GLOW_BERRY_BAG = BLOCKS.register("glow_berry_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> GOLDEN_APPLE_BAG = BLOCKS.register("golden_apple_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(MapColor.GOLD)));
    public static final RegistryObject<Block> KELP_BLOCK = BLOCKS.register("kelp_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DRIED_KELP_BLOCK).mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.WET_GRASS)));
    public static final RegistryObject<Block> RED_MUSHROOM_BAG = BLOCKS.register("red_mushroom_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> SUGAR_CANE_BALE = BLOCKS.register("sugar_cane_bale",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> SWEET_BERRY_BAG = BLOCKS.register("sweet_berry_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> WARPED_FUNGUS_BAG = BLOCKS.register("warped_fungus_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

    //GolDelight Storage

    public static final RegistryObject<Block> GOLDEN_MUSHROOM_BAG = BLOCKS.register("golden_mushroom_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(MapColor.GOLD)));
    public static final RegistryObject<Block> GOLDEN_COCOA_BEAN_BAG = BLOCKS.register("golden_cocoa_bean_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(MapColor.GOLD)));
    public static final RegistryObject<Block> GOLDEN_FUNGUS_BAG = BLOCKS.register("golden_fungus_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(MapColor.GOLD)));
    public static final RegistryObject<Block> GOLDEN_EGG_BOX = BLOCKS.register("golden_egg_box",
            () -> new EggBoxBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).instabreak()));
    public static final RegistryObject<Block> GOLDEN_GLOW_BERRY_BAG = BLOCKS.register("golden_glow_berry_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(MapColor.GOLD)));
    public static final RegistryObject<Block> GOLDEN_KELP_BLOCK = BLOCKS.register("golden_kelp_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DRIED_KELP_BLOCK).mapColor(MapColor.GOLD).sound(SoundType.WET_GRASS)));
    public static final RegistryObject<Block> GOLDEN_SUGAR_CANE_BALE = BLOCKS.register("golden_sugar_cane_bale",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).mapColor(MapColor.GOLD)));
    public static final RegistryObject<Block> SWEET_GOLDEN_BERRY_BAG = BLOCKS.register("sweet_golden_berry_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).mapColor(MapColor.GOLD)));

    //Utils
    public static final RegistryObject<Block> CRATE = BLOCKS.register("crate",
            () -> new CrateBlock(BlockBehaviour.Properties.copy(Blocks.COMPOSTER).noOcclusion()));
    public static final RegistryObject<Block> TRAY = BLOCKS.register("tray",
            () -> new TrayBlock(BlockBehaviour.Properties.copy(Blocks.COMPOSTER).noOcclusion().instabreak()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
