package net.endil.farmersutils.common.crafting.condition.compat;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class GoldenSugarCaneBaleEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public GoldenSugarCaneBaleEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_GOLDEN_SUGAR_CANE_BALE.get();
    }

    public static class Serializer implements IConditionSerializer<GoldenSugarCaneBaleEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "golden_sugar_cane_bale_enabled");
        }

        @Override
        public void write(JsonObject json, GoldenSugarCaneBaleEnabledCondition value) {

        }

        @Override
        public GoldenSugarCaneBaleEnabledCondition read(JsonObject json) {
            return new GoldenSugarCaneBaleEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
