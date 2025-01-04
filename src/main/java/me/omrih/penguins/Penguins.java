package me.omrih.penguins;

import me.omrih.penguins.entity.PenguinEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Penguins implements ModInitializer {
    public static final String MOD_ID = "penguins";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final EntityType<PenguinEntity> PENGUIN = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("penguins", "penguin"),
            EntityType.Builder.create(PenguinEntity::new, SpawnGroup.CREATURE).dimensions(0.75f, 0.75f).build("penguin")
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(PENGUIN, PenguinEntity.createMobAttributes());
    }
}
