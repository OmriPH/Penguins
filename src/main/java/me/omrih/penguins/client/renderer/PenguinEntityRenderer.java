package me.omrih.penguins.client.renderer;

import me.omrih.penguins.client.model.PenguinEntityModel;
import me.omrih.penguins.entity.PenguinEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PenguinEntityRenderer extends GeoEntityRenderer<PenguinEntity> {
    public PenguinEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PenguinEntityModel());
    }
}
