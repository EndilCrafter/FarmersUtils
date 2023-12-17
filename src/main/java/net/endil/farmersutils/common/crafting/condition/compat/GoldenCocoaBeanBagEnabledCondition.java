package net.endil.farmersutils.common.crafting.condition.compat;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class GoldenCocoaBeanBagEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public GoldenCocoaBeanBagEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_GOLDEN_COCOA_BEAN_BAG.get();
    }

    public static class Serializer implements IConditionSerializer<GoldenCocoaBeanBagEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "golden_cocoa_bean_bag_enabled");
        }

        @Override
        public void write(JsonObject json, GoldenCocoaBeanBagEnabledCondition value) {

        }

        @Override
        public GoldenCocoaBeanBagEnabledCondition read(JsonObject json) {
            return new GoldenCocoaBeanBagEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
