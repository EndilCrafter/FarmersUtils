package net.endil.farmersutils.common.crafting.condition;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class GolDelightStorageEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public GolDelightStorageEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_GOLDELIGHT_INGREDIENT_STORAGES.get();
    }

    public static class Serializer implements IConditionSerializer<GolDelightStorageEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "goldelight_storages_enabled");
        }

        @Override
        public void write(JsonObject json, GolDelightStorageEnabledCondition value) {

        }

        @Override
        public GolDelightStorageEnabledCondition read(JsonObject json) {
            return new GolDelightStorageEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
