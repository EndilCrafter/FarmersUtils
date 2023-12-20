package net.endil.farmersutils.common.crafting.condition.compat;

import com.google.gson.JsonObject;
import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.common.FUConfiguration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class PropelplantCaneBaleEnabledCondition implements ICondition {
    private final ResourceLocation location;

    public PropelplantCaneBaleEnabledCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
        return FUConfiguration.ENABLE_PROPELPLANT_CANE_BALE.get();
    }

    public static class Serializer implements IConditionSerializer<PropelplantCaneBaleEnabledCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(FarmersUtils.MOD_ID, "propelplant_cane_bale_enabled");
        }

        @Override
        public void write(JsonObject json, PropelplantCaneBaleEnabledCondition value) {

        }

        @Override
        public PropelplantCaneBaleEnabledCondition read(JsonObject json) {
            return new PropelplantCaneBaleEnabledCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
