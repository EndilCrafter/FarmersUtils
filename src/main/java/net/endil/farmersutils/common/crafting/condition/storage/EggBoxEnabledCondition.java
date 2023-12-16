package net.endil.farmersutils.common.crafting.condition.storage;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class EggBoxEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public EggBoxEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_EGG_BOX.get();
    }

    public static class Serializer implements IConditionSerializer<EggBoxEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "egg_box_enabled");
        }

        @Override
        public void write(JsonObject json, EggBoxEnabledCondition value) {

        }

        @Override
        public EggBoxEnabledCondition read(JsonObject json) {
            return new EggBoxEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
