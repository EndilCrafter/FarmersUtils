package net.endil.farmersutils.common;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FUFoodValues {
    public static final FoodProperties APPLE_SLICE = (new FoodProperties.Builder()
            .nutrition(1).saturationMod(0.6f)).fast().build();
    public static final FoodProperties GOLDEN_APPLE_SLICE = (new FoodProperties.Builder()
            .nutrition(1).saturationMod(2.4f))
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 300, 0), 1.0F).alwaysEat().fast().build();
    public static final FoodProperties BOILED_EGG = (new FoodProperties.Builder()
            .nutrition(2).saturationMod(1.2f)).build();
    public static final FoodProperties DRIED_APPLE_SLICE = (new FoodProperties.Builder()
            .nutrition(1).saturationMod(1.8f)).fast().build();
    public static final FoodProperties DRIED_GOLDEN_APPLE_SLICE = (new FoodProperties.Builder()
            .nutrition(1).saturationMod(2.4f))
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600, 0), 1.0F).alwaysEat().fast().build();
    public static final FoodProperties DRIED_BEEF = (new FoodProperties.Builder()
            .nutrition(4).saturationMod(2.4f)).meat().build();
    public static final FoodProperties DRIED_CHICKEN = (new FoodProperties.Builder()
            .nutrition(3).saturationMod(1.8f)).meat().build();
    public static final FoodProperties DRIED_COD_SLICE = (new FoodProperties.Builder()
            .nutrition(2).saturationMod(1.5f)).build();
    public static final FoodProperties DRIED_MUTTON = (new FoodProperties.Builder()
            .nutrition(3).saturationMod(2.4f)).meat().build();
    public static final FoodProperties DRIED_PORKCHOP = (new FoodProperties.Builder()
            .nutrition(4).saturationMod(2.4f)).meat().build();
    public static final FoodProperties DRIED_RABBIT = (new FoodProperties.Builder()
            .nutrition(3).saturationMod(1.8f)).meat().build();
    public static final FoodProperties DRIED_SALMON_SLICE = (new FoodProperties.Builder()
            .nutrition(2).saturationMod(2.4f)).meat().build();


    public static final FoodProperties BOILED_GOLDEN_EGG = (new FoodProperties.Builder()
            .nutrition(3).saturationMod(1.8f))
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties DRIED_GOLDEN_BEEF = (new FoodProperties.Builder()
            .nutrition(5).saturationMod(3.6f)).meat().build();
    public static final FoodProperties DRIED_GOLDEN_CHICKEN = (new FoodProperties.Builder()
            .nutrition(4).saturationMod(3.0f))
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 2400, 0), 1.0F).alwaysEat().meat().build();
    public static final FoodProperties DRIED_GOLDEN_COD_SLICE = (new FoodProperties.Builder()
            .nutrition(2).saturationMod(1.5f))
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1200, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties DRIED_GOLDEN_MUTTON = (new FoodProperties.Builder()
            .nutrition(4).saturationMod(3.6f)).meat().build();
    public static final FoodProperties DRIED_GOLDEN_PORKCHOP = (new FoodProperties.Builder()
            .nutrition(5).saturationMod(3.6f)).meat().build();
    public static final FoodProperties DRIED_GOLDEN_RABBIT = (new FoodProperties.Builder()
            .nutrition(4).saturationMod(3.6f)).meat().build();
    public static final FoodProperties DRIED_GOLDEN_SALMON_SLICE = (new FoodProperties.Builder()
            .nutrition(2).saturationMod(2.4f))
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2100, 0), 1.0F).alwaysEat().build();
}
