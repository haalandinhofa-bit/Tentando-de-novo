package com.vexhorror.client.renderer;

import com.vexhorror.client.model.PlaceholderStalkerModel;
import com.vexhorror.entity.VexStalker;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

/** Renderer provisório; usa a textura vanilla de zumbi até chegar a textura definitiva. */
public class PlaceholderStalkerRenderer extends MobRenderer<VexStalker, PlaceholderStalkerModel> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation("minecraft", "textures/entity/zombie/zombie.png");

    public PlaceholderStalkerRenderer(EntityRendererProvider.Context context) {
        super(context, new PlaceholderStalkerModel(context.bakeLayer(PlaceholderStalkerModel.LAYER_LOCATION)), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(VexStalker entity) {
        return TEXTURE;
    }
}