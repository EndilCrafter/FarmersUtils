package net.endil.farmersutils.data.recipe;

import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.registry.FUItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import java.util.function.Consumer;

public class FUCooking {
    public static void register(Consumer<FinishedRecipe> consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(FUItems.BOILED_EGG.get(), 1, 200, 0.35f)
                .addIngredient(Items.EGG)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC).unlockedByItems("has_egg", Items.EGG)
                .build(consumer, new ResourceLocation(FarmersUtils.MOD_ID, "cooking/boiled_egg"));
    }
}
