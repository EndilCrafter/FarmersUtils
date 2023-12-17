package net.endil.farmersutils.common;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class FUConfiguration {
    //Common
    public static final String CATEGORY_SETTINGS = "settings";
    public static final String CATEGORY_STORAGES = "storages";
    public static final String CATEGORY_COMPATS = "compats";
    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;
    public static ForgeConfigSpec.BooleanValue ENABLE_VANILLA_INGREDIENT_STORAGES;
    public static ForgeConfigSpec.BooleanValue ENABLE_GOLDELIGHT_INGREDIENT_STORAGES;
    public static ForgeConfigSpec.BooleanValue ENABLE_APPLE_BAG;
    public static ForgeConfigSpec.BooleanValue ENABLE_BROWN_MUSHROOM_BAG;
    public static ForgeConfigSpec.BooleanValue ENABLE_COCOA_BEAN_BAG;
    public static ForgeConfigSpec.BooleanValue ENABLE_CRIMSON_FUNGUS_BAG;
    public static ForgeConfigSpec.BooleanValue ENABLE_EGG_BOX;
    public static ForgeConfigSpec.BooleanValue ENABLE_GLOW_BERRY_BAG;
    public static ForgeConfigSpec.BooleanValue ENABLE_GOLDEN_APPLE_BAG;
    public static ForgeConfigSpec.BooleanValue ENABLE_KELP_BLOCK;
    public static ForgeConfigSpec.BooleanValue ENABLE_RED_MUSHROOM_BAG;
    public static ForgeConfigSpec.BooleanValue ENABLE_SUGAR_CANE_BALE;
    public static ForgeConfigSpec.BooleanValue ENABLE_SWEET_BERRY_BAG;
    public static ForgeConfigSpec.BooleanValue ENABLE_WARPED_FUNGUS_BAG;
    public static ForgeConfigSpec.BooleanValue ENABLE_GOLDEN_MUSHROOM_BAG;
    public static ForgeConfigSpec.BooleanValue ENABLE_GOLDEN_COCOA_BEAN_BAG;
    public static ForgeConfigSpec.BooleanValue ENABLE_GOLDEN_FUNGUS_BAG;
    public static ForgeConfigSpec.BooleanValue ENABLE_GOLDEN_EGG_BOX;
    public static ForgeConfigSpec.BooleanValue ENABLE_GOLDEN_GLOW_BERRY_BAG;
    public static ForgeConfigSpec.BooleanValue ENABLE_GOLDEN_KELP_BLOCK;
    public static ForgeConfigSpec.BooleanValue ENABLE_GOLDEN_SUGAR_CANE_BALE;
    public static ForgeConfigSpec.BooleanValue ENABLE_SWEET_GOLDEN_BERRY_BAG;


    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        //GENERAL
        COMMON_BUILDER.translation("config.farmersutils.general_settings").push(CATEGORY_SETTINGS);

        ENABLE_VANILLA_INGREDIENT_STORAGES = COMMON_BUILDER.translation("config.farmersutils.general_settings.enable_storages")
                .define("enableVanillaIngredientStorages", true);
        ENABLE_GOLDELIGHT_INGREDIENT_STORAGES = COMMON_BUILDER.translation("config.farmersutils.general_settings.enable_goldelight_storages")
                .define("enableGolDelightIngredientStorages", true);
        COMMON_BUILDER.pop();

        //STORAGES
        COMMON_BUILDER.translation("config.farmersutils.storages").push(CATEGORY_STORAGES);

        ENABLE_APPLE_BAG = COMMON_BUILDER.translation("config.farmersutils.storages.enable_apple_bag")
                .define("enableAppleBag", true);
        ENABLE_BROWN_MUSHROOM_BAG = COMMON_BUILDER.translation("config.farmersutils.storages.enable_brown_mushroom_bag")
                .define("enableBrownMushroomBag", true);
        ENABLE_COCOA_BEAN_BAG = COMMON_BUILDER.translation("config.farmersutils.storages.enable_cocoa_bean_bag")
                .define("enableCocoaBeanBag", true);
        ENABLE_CRIMSON_FUNGUS_BAG = COMMON_BUILDER.translation("config.farmersutils.storages.enable_crimson_fungus_bag")
                .define("enableCrimsonFungusBag", true);
        ENABLE_GLOW_BERRY_BAG = COMMON_BUILDER.translation("config.farmersutils.storages.enable_glow_berry_bag")
                .define("enableGlowBerryBag", true);
        ENABLE_GOLDEN_APPLE_BAG = COMMON_BUILDER.translation("config.farmersutils.storages.enable_golden_apple_bag")
                .define("enableGoldenAppleBag", true);
        ENABLE_EGG_BOX = COMMON_BUILDER.translation("config.farmersutils.storages.enable_egg_box")
                .define("enableEggBox", true);
        ENABLE_KELP_BLOCK = COMMON_BUILDER.translation("config.farmersutils.storages.enable_kelp_block")
                .define("enableKelpBlock", true);
        ENABLE_RED_MUSHROOM_BAG = COMMON_BUILDER.translation("config.farmersutils.storages.enable_red_mushroom_bag")
                .define("enableRedMushroomBag", true);
        ENABLE_SUGAR_CANE_BALE = COMMON_BUILDER.translation("config.farmersutils.storages.enable_sugar_cane_bale")
                .define("enableSugarCaneBale", true);
        ENABLE_SWEET_BERRY_BAG = COMMON_BUILDER.translation("config.farmersutils.storages.enable_sweet_berry_bag")
                .define("enableSweetBerry", true);
        ENABLE_WARPED_FUNGUS_BAG = COMMON_BUILDER.translation("config.farmersutils.storages.enable_warped_fungus_bag")
                .define("enableWarpedFungusBag", true);
        COMMON_BUILDER.pop();

        //COMPATS
        COMMON_BUILDER.translation("config.farmersutils.compats").push(CATEGORY_COMPATS);

        ENABLE_GOLDEN_MUSHROOM_BAG = COMMON_BUILDER.translation("config.farmersutils.compats.enable_golden_mushroom_bag")
                .define("enableGoldenMushroomBag", true);
        ENABLE_GOLDEN_COCOA_BEAN_BAG = COMMON_BUILDER.translation("config.farmersutils.compats.enable_golden_cocoa_bean_bag")
                .define("enableGoldenCocoaBeanBag", true);
        ENABLE_GOLDEN_FUNGUS_BAG = COMMON_BUILDER.translation("config.farmersutils.compats.enable_golden_fungus_bag")
                .define("enableGoldenFungusBag", true);
        ENABLE_GOLDEN_GLOW_BERRY_BAG = COMMON_BUILDER.translation("config.farmersutils.compats.enable_golden_glow_berry_bag")
                .define("enableGoldenGlowBerryBag", true);
        ENABLE_GOLDEN_EGG_BOX = COMMON_BUILDER.translation("config.farmersutils.compats.enable_golden_egg_box")
                .define("enableGoldenEggBox", true);
        ENABLE_GOLDEN_KELP_BLOCK = COMMON_BUILDER.translation("config.farmersutils.compats.enable_golden_kelp_block")
                .define("enableGoldenKelpBlock", true);
        ENABLE_GOLDEN_SUGAR_CANE_BALE = COMMON_BUILDER.translation("config.farmersutils.compats.enable_golden_sugar_cane_bale")
                .define("enableGoldenSugarCaneBale", true);
        ENABLE_SWEET_GOLDEN_BERRY_BAG = COMMON_BUILDER.translation("config.farmersutils.compats.enable_sweet_golden_berry_bag")
                .define("enableSweetGoldenBerry", true);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}
