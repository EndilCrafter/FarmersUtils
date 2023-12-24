package net.endil.farmersutils.data.recipe;

import net.endil.farmersutils.common.registry.FUItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
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
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, FUItems.TRAY.get())
                .requires(Ingredient.of(Items.BOWL))
                .unlockedBy("has_bowl", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOWL))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, FUItems.DRYING_RACK.get())
                .pattern("SSS")
                .pattern("I I")
                .define('S', Ingredient.of(Items.STRING))
                .define('I', Ingredient.of(Items.STICK))
                .unlockedBy("has_string", InventoryChangeTrigger.TriggerInstance.hasItems(Items.STRING))
                .save(consumer);
    }
}
