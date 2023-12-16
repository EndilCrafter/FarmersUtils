package net.endil.farmersutils.data;

import net.endil.farmersutils.data.loot.FUBlockLoot;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class FULootTables {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(FUBlockLoot::new, LootContextParamSets.BLOCK)
        ));
    }
}
