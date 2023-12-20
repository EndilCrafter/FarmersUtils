package net.endil.farmersutils.common.crafting.condition.compat;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class GoldelpearlBagEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public GoldelpearlBagEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_GOLDELPEARL_BAG.get();
    }

    public static class Serializer implements IConditionSerializer<GoldelpearlBagEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "goldelpearl_bag_enabled");
        }

        @Override
        public void write(JsonObject json, GoldelpearlBagEnabledCondition value) {

        }

        @Override
        public GoldelpearlBagEnabledCondition read(JsonObject json) {
            return new GoldelpearlBagEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
