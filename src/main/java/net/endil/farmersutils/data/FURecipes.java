package net.endil.farmersutils.data;

import net.endil.farmersutils.data.recipe.FUCooking;
import net.endil.farmersutils.data.recipe.FUCrafting;
import net.endil.farmersutils.data.recipe.FUCutting;
import net.endil.farmersutils.data.recipe.FUSmelting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class FURecipes extends RecipeProvider {
    public FURecipes(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        FUCrafting.register(consumer);
        FUSmelting.register(consumer);
        FUCooking.register(consumer);
        FUCutting.register(consumer);
    }
}
