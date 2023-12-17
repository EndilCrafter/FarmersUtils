package net.endil.farmersutils.common.crafting.condition.compat;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class GoldenGlowBerryBagEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public GoldenGlowBerryBagEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_GOLDEN_GLOW_BERRY_BAG.get();
    }

    public static class Serializer implements IConditionSerializer<GoldenGlowBerryBagEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "golden_glow_berry_bag_enabled");
        }

        @Override
        public void write(JsonObject json, GoldenGlowBerryBagEnabledCondition value) {

        }

        @Override
        public GoldenGlowBerryBagEnabledCondition read(JsonObject json) {
            return new GoldenGlowBerryBagEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
