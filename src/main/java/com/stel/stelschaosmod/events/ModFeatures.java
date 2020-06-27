package com.stel.stelschaosmod.events;

import com.stel.stelschaosmod.lib.Reference;
import com.stel.stelschaosmod.structures.GnomeStructure;
import com.stel.stelschaosmod.structures.GnomeVillagePieces;
import com.stel.stelschaosmod.structures.GnomeVillagePools;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFeatures {

    public static Structure<VillageConfig> GnomeVillages = new GnomeStructure(VillageConfig::deserialize);
    public static IStructurePieceType GVP = GnomeVillagePieces.Village::new;
    private static VillageConfig villageConfig = new VillageConfig(Reference.MODID + ":village/gnome/town_center", 6);
    @SubscribeEvent
    public static void setup(final FMLCommonSetupEvent event) {
        List<Structure<?>> village = new ArrayList(Feature.ILLAGER_STRUCTURES);
        village.add(GnomeVillages);
        Feature.ILLAGER_STRUCTURES = village;
        for (Biome biome : ForgeRegistries.BIOMES) {
            biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
                    GnomeVillages.withConfiguration(villageConfig)
                            .withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
            if (biome == Biomes.DARK_FOREST_HILLS || biome == Biomes.DARK_FOREST) {
                biome.addStructure(GnomeVillages.withConfiguration(villageConfig));
            }
        }
    }

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        GnomeVillagePools.init();
        registerFeature(event.getRegistry(), GnomeVillages, "gnomevillage");
        register(GVP, "GVP");
    }

    static IStructurePieceType register(IStructurePieceType p_214750_0_, String key)
    {
        return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), p_214750_0_);
    }

    private static <T extends IForgeRegistryEntry<T>> void registerFeature(IForgeRegistry<T> registry, T entry, String registryKey) {
        ResourceLocation r = new ResourceLocation(Reference.MODID, registryKey);
        entry.setRegistryName(r);
        registry.register(entry);
    }
}
