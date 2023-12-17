package net.endil.farmersutils.common.crafting.condition.compat;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class GoldenKelpBlockEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public GoldenKelpBlockEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_GOLDEN_KELP_BLOCK.get();
    }

    public static class Serializer implements IConditionSerializer<GoldenKelpBlockEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "golden_kelp_block_enabled");
        }

        @Override
        public void write(JsonObject json, GoldenKelpBlockEnabledCondition value) {

        }

        @Override
        public GoldenKelpBlockEnabledCondition read(JsonObject json) {
            return new GoldenKelpBlockEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
