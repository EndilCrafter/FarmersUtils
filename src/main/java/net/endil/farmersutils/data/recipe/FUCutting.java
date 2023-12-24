package net.endil.farmersutils.data.recipe;

import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.registry.FUItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.function.Consumer;

public class FUCutting {
    public static void register(Consumer<FinishedRecipe> consumer) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.APPLE), Ingredient.of(ForgeTags.TOOLS_KNIVES), FUItems.APPLE_SLICE.get(), 8)
                .build(consumer, new ResourceLocation(FarmersUtils.MOD_ID, "cutting/apple_slice"));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.GOLDEN_APPLE), Ingredient.of(ForgeTags.TOOLS_KNIVES), FUItems.GOLDEN_APPLE_SLICE.get(), 8)
                .build(consumer, new ResourceLocation(FarmersUtils.MOD_ID, "cutting/golden_apple_slice"));
    }
}
