package net.endil.farmersutils.data;

import net.endil.farmersutils.FarmersUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = FarmersUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), FULootTables.create(output));
        gen.addProvider(event.includeClient(), new FUBlockStates(output, helper));
        FUBlockTags blockTags = gen.addProvider(event.includeServer(), new FUBlockTags(output, provider, helper));
        gen.addProvider(event.includeClient(), new FUItemModels(output, helper));
        gen.addProvider(event.includeServer(), new FUItemTags(output, provider, blockTags.contentsGetter(), helper));
        gen.addProvider(event.includeServer(), new FURecipes(output));
    }
}
