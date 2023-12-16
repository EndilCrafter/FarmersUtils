package net.endil.farmersutils.common.crafting.condition.storage;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class SweetBerryBagEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public SweetBerryBagEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_SWEET_BERRY_BAG.get();
    }

    public static class Serializer implements IConditionSerializer<SweetBerryBagEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "sweet_berry_bag_enabled");
        }

        @Override
        public void write(JsonObject json, SweetBerryBagEnabledCondition value) {

        }

        @Override
        public SweetBerryBagEnabledCondition read(JsonObject json) {
            return new SweetBerryBagEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
