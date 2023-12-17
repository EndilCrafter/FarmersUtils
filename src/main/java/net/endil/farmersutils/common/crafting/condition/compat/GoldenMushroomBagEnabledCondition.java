package net.endil.farmersutils.common.crafting.condition.compat;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class GoldenMushroomBagEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public GoldenMushroomBagEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_GOLDEN_MUSHROOM_BAG.get();
    }

    public static class Serializer implements IConditionSerializer<GoldenMushroomBagEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "golden_mushroom_bag_enabled");
        }

        @Override
        public void write(JsonObject json, GoldenMushroomBagEnabledCondition value) {

        }

        @Override
        public GoldenMushroomBagEnabledCondition read(JsonObject json) {
            return new GoldenMushroomBagEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
