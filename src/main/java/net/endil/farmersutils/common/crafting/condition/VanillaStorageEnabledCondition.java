package net.endil.farmersutils.common.crafting.condition;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class VanillaStorageEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public VanillaStorageEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_VANILLA_INGREDIENT_STORAGES.get();
    }

    public static class Serializer implements IConditionSerializer<VanillaStorageEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "vanilla_storages_enabled");
        }

        @Override
        public void write(JsonObject json, VanillaStorageEnabledCondition value) {

        }

        @Override
        public VanillaStorageEnabledCondition read(JsonObject json) {
            return new VanillaStorageEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
