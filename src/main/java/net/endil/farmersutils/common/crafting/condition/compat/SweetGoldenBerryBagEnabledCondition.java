package net.endil.farmersutils.common.crafting.condition.compat;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class SweetGoldenBerryBagEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public SweetGoldenBerryBagEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_SWEET_GOLDEN_BERRY_BAG.get();
    }

    public static class Serializer implements IConditionSerializer<SweetGoldenBerryBagEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "sweet_golden_berry_bag_enabled");
        }

        @Override
        public void write(JsonObject json, SweetGoldenBerryBagEnabledCondition value) {

        }

        @Override
        public SweetGoldenBerryBagEnabledCondition read(JsonObject json) {
            return new SweetGoldenBerryBagEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
