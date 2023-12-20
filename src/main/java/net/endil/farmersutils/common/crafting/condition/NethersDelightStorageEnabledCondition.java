package net.endil.farmersutils.common.crafting.condition;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class NethersDelightStorageEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public NethersDelightStorageEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_NETHERSDELIGHT_INGREDIENT_STORAGES.get();
    }

    public static class Serializer implements IConditionSerializer<NethersDelightStorageEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "nethersdelight_storages_enabled");
        }

        @Override
        public void write(JsonObject json, NethersDelightStorageEnabledCondition value) {

        }

        @Override
        public NethersDelightStorageEnabledCondition read(JsonObject json) {
            return new NethersDelightStorageEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
