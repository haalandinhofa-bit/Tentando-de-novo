package com.vexhorror.client;

import com.vexhorror.VexHorror;
import com.vexhorror.client.model.PlaceholderStalkerModel;
import com.vexhorror.client.renderer.PlaceholderStalkerRenderer;
import com.vexhorror.registry.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VexHorror.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class VexHorrorClient {
    private VexHorrorClient() {}

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PlaceholderStalkerModel.LAYER_LOCATION, PlaceholderStalkerModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.VEX_STALKER.get(), PlaceholderStalkerRenderer::new);
    }
}