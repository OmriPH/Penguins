package me.omrih.penguins.client.model;

import me.omrih.penguins.entity.PenguinEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

import static me.omrih.penguins.Penguins.MOD_ID;

public class PenguinEntityModel extends DefaultedEntityGeoModel<PenguinEntity> {
    public PenguinEntityModel() {
        super(ResourceLocation.fromNamespaceAndPath(MOD_ID, "penguin"));
    }
}
