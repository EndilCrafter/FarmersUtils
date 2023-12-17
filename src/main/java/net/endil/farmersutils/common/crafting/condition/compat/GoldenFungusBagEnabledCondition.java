package net.endil.farmersutils.common.crafting.condition.compat;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class GoldenFungusBagEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public GoldenFungusBagEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_GOLDEN_FUNGUS_BAG.get();
    }

    public static class Serializer implements IConditionSerializer<GoldenFungusBagEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "golden_fungus_bag_enabled");
        }

        @Override
        public void write(JsonObject json, GoldenFungusBagEnabledCondition value) {

        }

        @Override
        public GoldenFungusBagEnabledCondition read(JsonObject json) {
            return new GoldenFungusBagEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
