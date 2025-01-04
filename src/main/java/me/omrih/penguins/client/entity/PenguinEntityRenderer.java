package me.omrih.penguins.client.entity;

import me.omrih.penguins.client.PenguinsClient;
import me.omrih.penguins.entity.PenguinEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PenguinEntityRenderer extends MobEntityRenderer<PenguinEntity, PenguinEntityModel> {

    public PenguinEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PenguinEntityModel(context.getPart(PenguinsClient.MODEL_PENGUIN_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(PenguinEntity entity) {
        return Identifier.of("penguins", "textures/entity/penguin/penguin.png");
    }
}
