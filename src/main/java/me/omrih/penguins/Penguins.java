package me.omrih.penguins;

import me.omrih.penguins.entity.PenguinEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Penguins implements ModInitializer {
    public static final String MOD_ID = "penguins";

    public static final EntityType<PenguinEntity> PENGUIN = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "penguin"),
            EntityType.Builder.create(PenguinEntity::new, SpawnGroup.CREATURE).dimensions(0.75f, 0.75f).build("penguin")
    );

    public static final Item PENGUIN_SPAWN_EGG = new SpawnEggItem(PENGUIN, 0xADD4F3, 0x2B6899, new Item.Settings());

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(PENGUIN, PenguinEntity.createMobAttributes());

        Registry.register(Registries.ITEM, Identifier.of("penguins", "penguin_spawn_egg"), PENGUIN_SPAWN_EGG);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(PENGUIN_SPAWN_EGG));
    }
}
