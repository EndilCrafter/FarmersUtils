package net.endil.farmersutils.common.registry;

import com.google.common.collect.Sets;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUFoodValues;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class FUItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FarmersUtils.MOD_ID);

    public static LinkedHashSet<RegistryObject<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();
    //Bag
    public static final RegistryObject<Item> APPLE_BAG = registerWithTab("apple_bag",
            () -> new BlockItem(FUBlocks.APPLE_BAG.get(), basicItem()));
    public static final RegistryObject<Item> BROWN_MUSHROOM_BAG = registerWithTab("brown_mushroom_bag",
            () -> new BlockItem(FUBlocks.BROWN_MUSHROOM_BAG.get(), basicItem()));
    public static final RegistryObject<Item> COCOA_BEAN_BAG = registerWithTab("cocoa_bean_bag",
            () -> new BlockItem(FUBlocks.COCOA_BEAN_BAG.get(), basicItem()));
    public static final RegistryObject<Item> CRIMSON_FUNGUS_BAG = registerWithTab("crimson_fungus_bag",
            () -> new BlockItem(FUBlocks.CRIMSON_FUNGUS_BAG.get(), basicItem()));
    public static final RegistryObject<Item> GLOW_BERRY_BAG = registerWithTab("glow_berry_bag",
            () -> new BlockItem(FUBlocks.GLOW_BERRY_BAG.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_APPLE_BAG = registerWithTab("golden_apple_bag",
            () -> new BlockItem(FUBlocks.GOLDEN_APPLE_BAG.get(), basicItem()));
    public static final RegistryObject<Item> RED_MUSHROOM_BAG = registerWithTab("red_mushroom_bag",
            () -> new BlockItem(FUBlocks.RED_MUSHROOM_BAG.get(), basicItem()));
    public static final RegistryObject<Item> SWEET_BERRY_BAG = registerWithTab("sweet_berry_bag",
            () -> new BlockItem(FUBlocks.SWEET_BERRY_BAG.get(), basicItem()));
    public static final RegistryObject<Item> WARPED_FUNGUS_BAG = registerWithTab("warped_fungus_bag",
            () -> new BlockItem(FUBlocks.WARPED_FUNGUS_BAG.get(), basicItem()));

    //Other Storage
    public static final RegistryObject<Item> EGG_BOX = registerWithTab("egg_box",
            () -> new BlockItem(FUBlocks.EGG_BOX.get(), basicItem()));
    public static final RegistryObject<Item> KELP_BLOCK = registerWithTab("kelp_block",
            () -> new BlockItem(FUBlocks.KELP_BLOCK.get(), basicItem()));
    public static final RegistryObject<Item> SUGAR_CANE_BALE = registerWithTab("sugar_cane_bale",
            () -> new BlockItem(FUBlocks.SUGAR_CANE_BALE.get(), basicItem()));

    //Utils
    public static final RegistryObject<Item> CRATE = registerWithTab("crate",
            () -> new BlockItem(FUBlocks.CRATE.get(), basicItem().stacksTo(1)));
    public static final RegistryObject<Item> TRAY = registerWithTab("tray",
            () -> new BlockItem(FUBlocks.TRAY.get(), basicItem()));

    //Item
    public static final RegistryObject<Item> BOILED_EGG = registerWithTab("boiled_egg",
            () -> new Item(foodItem(FUFoodValues.BOILED_EGG)));

    //GolDelight Item

    public static final RegistryObject<Item> GOLDEN_MUSHROOM_BAG = registerWithTab("golden_mushroom_bag",
            () -> new BlockItem(FUBlocks.GOLDEN_MUSHROOM_BAG.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_COCOA_BEAN_BAG = registerWithTab("golden_cocoa_bean_bag",
            () -> new BlockItem(FUBlocks.GOLDEN_COCOA_BEAN_BAG.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_FUNGUS_BAG = registerWithTab("golden_fungus_bag",
            () -> new BlockItem(FUBlocks.GOLDEN_FUNGUS_BAG.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_GLOW_BERRY_BAG = registerWithTab("golden_glow_berry_bag",
            () -> new BlockItem(FUBlocks.GOLDEN_GLOW_BERRY_BAG.get(), basicItem()));
    public static final RegistryObject<Item> SWEET_GOLDEN_BERRY_BAG = registerWithTab("sweet_golden_berry_bag",
            () -> new BlockItem(FUBlocks.SWEET_GOLDEN_BERRY_BAG.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_EGG_BOX = registerWithTab("golden_egg_box",
            () -> new BlockItem(FUBlocks.GOLDEN_EGG_BOX.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_KELP_BLOCK = registerWithTab("golden_kelp_block",
            () -> new BlockItem(FUBlocks.GOLDEN_KELP_BLOCK.get(), basicItem()));
    public static final RegistryObject<Item> GOLDEN_SUGAR_CANE_BALE = registerWithTab("golden_sugar_cane_bale",
            () -> new BlockItem(FUBlocks.GOLDEN_SUGAR_CANE_BALE.get(), basicItem()));
    public static final RegistryObject<Item> BOILED_GOLDEN_EGG = registerWithTab("boiled_golden_egg",
            () -> new Item(foodItem(FUFoodValues.BOILED_GOLDEN_EGG)));

    public static RegistryObject<Item> registerWithTab(final String name, final Supplier<Item> supplier) {
        RegistryObject<Item> block = ITEMS.register(name, supplier);
        CREATIVE_TAB_ITEMS.add(block);
        return block;
    }

    public static Item.Properties basicItem() {
        return new Item.Properties();
    }

    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
