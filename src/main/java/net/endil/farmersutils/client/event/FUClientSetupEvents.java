package net.endil.farmersutils.client.event;

import net.endil.farmersutils.FarmersUtils;
import net.endil.farmersutils.client.renderer.blockentity.DryingRackRenderer;
import net.endil.farmersutils.client.renderer.blockentity.TrayRenderer;
import net.endil.farmersutils.common.registry.FUBlockEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FarmersUtils.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FUClientSetupEvents {
    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(FUBlockEntityTypes.DRYING_RACK.get(), DryingRackRenderer::new);
        event.registerBlockEntityRenderer(FUBlockEntityTypes.TRAY.get(), TrayRenderer::new);
    }
}
