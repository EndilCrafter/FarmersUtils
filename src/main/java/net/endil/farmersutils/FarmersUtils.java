package net.endil.farmersutils;

import com.mojang.logging.LogUtils;
import net.endil.farmersutils.client.FUClientSetup;
import net.endil.farmersutils.common.FUCommonSetup;
import net.endil.farmersutils.common.FUConfiguration;
import net.endil.farmersutils.common.registry.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(FarmersUtils.MOD_ID)
public class FarmersUtils {

    public static final String MOD_ID = "farmersutils";

    private static final Logger LOGGER = LogUtils.getLogger();

    public FarmersUtils() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(FUCommonSetup::init);
        modEventBus.addListener(FUClientSetup::init);

        FUBlockEntityTypes.register(modEventBus);
        FUBlocks.register(modEventBus);
        FUItems.register(modEventBus);
        FUMenuTypes.register(modEventBus);
        FUTabs.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FUConfiguration.COMMON_CONFIG);

        MinecraftForge.EVENT_BUS.register(this);


        modEventBus.addListener(this::addCreative);

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
