package me.omrih.penguins.client.entity;

import me.omrih.penguins.entity.PenguinEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

import static me.omrih.penguins.Penguins.MOD_ID;

public class PenguinEntityModel extends DefaultedEntityGeoModel<PenguinEntity> {
    public PenguinEntityModel() {
        super(Identifier.of(MOD_ID, "penguin"));
    }
}
