package net.endil.farmersutils.common.crafting.condition.storage;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class RedMushroomBagEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public RedMushroomBagEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_RED_MUSHROOM_BAG.get();
    }

    public static class Serializer implements IConditionSerializer<RedMushroomBagEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "red_mushroom_bag_enabled");
        }

        @Override
        public void write(JsonObject json, RedMushroomBagEnabledCondition value) {

        }

        @Override
        public RedMushroomBagEnabledCondition read(JsonObject json) {
            return new RedMushroomBagEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
