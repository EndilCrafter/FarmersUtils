package net.endil.farmersutils.common.crafting.condition.storage;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class AppleBagEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public AppleBagEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_APPLE_BAG.get();
    }

    public static class Serializer implements IConditionSerializer<AppleBagEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "apple_bag_enabled");
        }

        @Override
        public void write(JsonObject json, AppleBagEnabledCondition value) {

        }

        @Override
        public AppleBagEnabledCondition read(JsonObject json) {
            return new AppleBagEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
