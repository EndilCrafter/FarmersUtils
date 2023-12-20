package net.endil.farmersutils.common.crafting.condition.compat;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class PropelpearlBagEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public PropelpearlBagEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_PROPELPEARL_BAG.get();
    }

    public static class Serializer implements IConditionSerializer<PropelpearlBagEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "propelpearl_bag_enabled");
        }

        @Override
        public void write(JsonObject json, PropelpearlBagEnabledCondition value) {

        }

        @Override
        public PropelpearlBagEnabledCondition read(JsonObject json) {
            return new PropelpearlBagEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
