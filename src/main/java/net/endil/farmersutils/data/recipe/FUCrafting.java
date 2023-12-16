package net.endil.farmersutils.data.recipe;

import net.endil.farmersutils.common.registry.FUItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class FUCrafting {
    public static void register(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, FUItems.CRATE.get())
                .pattern("S S")
                .pattern("S S")
                .pattern("SWS")
                .define('S', Ingredient.of(Items.STICK))
                .define('W', Ingredient.of(ItemTags.WOODEN_SLABS))
                .unlockedBy("has_stick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(consumer);
    }
}
