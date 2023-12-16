package net.endil.farmersutils.common.crafting.condition.storage;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class WarpedFungusBagEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public WarpedFungusBagEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_WARPED_FUNGUS_BAG.get();
    }

    public static class Serializer implements IConditionSerializer<WarpedFungusBagEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "warped_fungus_bag_enabled");
        }

        @Override
        public void write(JsonObject json, WarpedFungusBagEnabledCondition value) {

        }

        @Override
        public WarpedFungusBagEnabledCondition read(JsonObject json) {
            return new WarpedFungusBagEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
