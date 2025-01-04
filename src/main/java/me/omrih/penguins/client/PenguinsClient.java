package me.omrih.penguins.client;

import me.omrih.penguins.Penguins;
import me.omrih.penguins.client.entity.PenguinEntityModel;
import me.omrih.penguins.client.entity.PenguinEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class PenguinsClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_PENGUIN_LAYER = new EntityModelLayer(Identifier.of("penguins", "penguin"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Penguins.PENGUIN, PenguinEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_PENGUIN_LAYER, PenguinEntityModel::getTexturedModelData);
    }
}
