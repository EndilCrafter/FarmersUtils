package net.endil.farmersutils.common.crafting.condition.compat;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class GoldenEggBoxEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public GoldenEggBoxEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_GOLDEN_EGG_BOX.get();
    }

    public static class Serializer implements IConditionSerializer<GoldenEggBoxEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "golden_egg_box_enabled");
        }

        @Override
        public void write(JsonObject json, GoldenEggBoxEnabledCondition value) {

        }

        @Override
        public GoldenEggBoxEnabledCondition read(JsonObject json) {
            return new GoldenEggBoxEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
