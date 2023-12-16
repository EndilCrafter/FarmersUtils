package net.endil.farmersutils.common.crafting.condition.storage;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class GlowBerryBagEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public GlowBerryBagEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_GLOW_BERRY_BAG.get();
    }

    public static class Serializer implements IConditionSerializer<GlowBerryBagEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "glow_berry_bag_enabled");
        }

        @Override
        public void write(JsonObject json, GlowBerryBagEnabledCondition value) {

        }

        @Override
        public GlowBerryBagEnabledCondition read(JsonObject json) {
            return new GlowBerryBagEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
