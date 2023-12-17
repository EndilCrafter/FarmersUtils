package net.endil.farmersutils.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.endil.farmersutils.common.block.entity.TrayBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TrayRenderer implements BlockEntityRenderer<TrayBlockEntity> {
    @Override
    public void render(TrayBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {

    }
}
