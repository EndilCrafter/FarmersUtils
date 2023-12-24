package net.endil.farmersutils.common.registry;

import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.crafting.DryingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FURecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, FarmersUtils.MOD_ID);

    public static final RegistryObject<RecipeType<DryingRecipe>> DRYING = RECIPE_TYPES.register("drying",
            () -> registerRecipeType("drying"));


    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }

    public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
        return new RecipeType<>() {
            public String toString() {
                return FarmersUtils.MOD_ID + ":" + identifier;
            }
        };
    }
}
