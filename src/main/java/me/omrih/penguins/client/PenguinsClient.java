package me.omrih.penguins.client;

import me.omrih.penguins.Penguins;
import me.omrih.penguins.client.renderer.PenguinEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class PenguinsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Penguins.PENGUIN, PenguinEntityRenderer::new);
    }
}
