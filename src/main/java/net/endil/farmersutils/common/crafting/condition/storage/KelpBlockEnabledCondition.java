package net.endil.farmersutils.common.crafting.condition.storage;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class KelpBlockEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public KelpBlockEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_KELP_BLOCK.get();
    }

    public static class Serializer implements IConditionSerializer<KelpBlockEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "kelp_block_enabled");
        }

        @Override
        public void write(JsonObject json, KelpBlockEnabledCondition value) {

        }

        @Override
        public KelpBlockEnabledCondition read(JsonObject json) {
            return new KelpBlockEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
