package net.endil.farmersutils.common;

import net.endil.farmersutils.common.crafting.condition.GolDelightStorageEnabledCondition;
import net.endil.farmersutils.common.crafting.condition.NethersDelightStorageEnabledCondition;
import net.endil.farmersutils.common.crafting.condition.VanillaStorageEnabledCondition;
import net.endil.farmersutils.common.crafting.condition.compat.*;
import net.endil.farmersutils.common.crafting.condition.storage.*;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class FUCommonSetup {
    public static void init(final FMLCommonSetupEvent event) {
        CraftingHelper.register(new VanillaStorageEnabledCondition.Serializer());
        CraftingHelper.register(new AppleBagEnabledCondition.Serializer());
        CraftingHelper.register(new BrownMushroomBagEnabledCondition.Serializer());
        CraftingHelper.register(new CocoaBeanBagEnabledCondition.Serializer());
        CraftingHelper.register(new CrimsonFungusBagEnabledCondition.Serializer());
        CraftingHelper.register(new EggBoxEnabledCondition.Serializer());
        CraftingHelper.register(new GlowBerryBagEnabledCondition.Serializer());
        CraftingHelper.register(new GoldenAppleBagEnabledCondition.Serializer());
        CraftingHelper.register(new KelpBlockEnabledCondition.Serializer());
        CraftingHelper.register(new RedMushroomBagEnabledCondition.Serializer());
        CraftingHelper.register(new SugarCaneBaleEnabledCondition.Serializer());
        CraftingHelper.register(new SweetBerryBagEnabledCondition.Serializer());
        CraftingHelper.register(new WarpedFungusBagEnabledCondition.Serializer());

        CraftingHelper.register(new GolDelightStorageEnabledCondition.Serializer());
        CraftingHelper.register(new GoldenMushroomBagEnabledCondition.Serializer());
        CraftingHelper.register(new GoldenCocoaBeanBagEnabledCondition.Serializer());
        CraftingHelper.register(new GoldenFungusBagEnabledCondition.Serializer());
        CraftingHelper.register(new GoldenEggBoxEnabledCondition.Serializer());
        CraftingHelper.register(new GoldenGlowBerryBagEnabledCondition.Serializer());
        CraftingHelper.register(new GoldenKelpBlockEnabledCondition.Serializer());
        CraftingHelper.register(new GoldenSugarCaneBaleEnabledCondition.Serializer());
        CraftingHelper.register(new SweetGoldenBerryBagEnabledCondition.Serializer());

        CraftingHelper.register(new NethersDelightStorageEnabledCondition.Serializer());
        CraftingHelper.register(new PropelpearlBagEnabledCondition.Serializer());
        CraftingHelper.register(new PropelplantCaneBaleEnabledCondition.Serializer());

        CraftingHelper.register(new GoldelpearlBagEnabledCondition.Serializer());
        CraftingHelper.register(new GoldelplantCaneBaleEnabledCondition.Serializer());
    }
}
