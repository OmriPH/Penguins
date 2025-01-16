package me.omrih.penguins;

import me.omrih.penguins.entity.PenguinEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.biome.Biomes;

public class Penguins implements ModInitializer {
    public static final String MOD_ID = "penguins";

    public static final EntityType<PenguinEntity> PENGUIN = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "penguin"),
            EntityType.Builder.of(PenguinEntity::new, MobCategory.CREATURE).sized(0.75f, 0.75f).build("penguin")
    );

    public static final Item PENGUIN_SPAWN_EGG = new SpawnEggItem(PENGUIN, 0xADD4F3, 0x2B6899, new Item.Properties());

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(PENGUIN, PenguinEntity.createMobAttributes());
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                Biomes.SNOWY_PLAINS,
                Biomes.FROZEN_OCEAN,
                Biomes.DEEP_FROZEN_OCEAN,
                Biomes.FROZEN_PEAKS,
                Biomes.FROZEN_RIVER
        ), MobCategory.CREATURE, PENGUIN, 30, 1, 2);

        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath("penguins", "penguin_spawn_egg"), PENGUIN_SPAWN_EGG);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(content -> content.accept(PENGUIN_SPAWN_EGG));
    }
}
