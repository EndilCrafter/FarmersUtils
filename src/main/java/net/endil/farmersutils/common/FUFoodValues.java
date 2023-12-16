package net.endil.farmersutils.common;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FUFoodValues {
    public static final FoodProperties BOILED_EGG = (new FoodProperties.Builder()
            .nutrition(2).saturationMod(1.6f)).build();
    public static final FoodProperties BOILED_GOLDEN_EGG = (new FoodProperties.Builder()
            .nutrition(3).saturationMod(2.4f))
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 0), 1.0F).build();
}
