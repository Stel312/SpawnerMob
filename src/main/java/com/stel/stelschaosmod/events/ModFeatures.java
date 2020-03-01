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

import java.util.Locale;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFeatures {

    public static Structure<VillageConfig> GnomeVillages = new GnomeStructure(VillageConfig::deserialize);
    public static IStructurePieceType GVP = GnomeVillagePieces.Village::new;

    @SubscribeEvent
    public static void setup(final FMLCommonSetupEvent event) {

        for (Biome biome : ForgeRegistries.BIOMES) {
            //if (biome == Biomes.DARK_FOREST) {
            VillageConfig villageConfig = new VillageConfig(Reference.MODID + ":village/gnome/houses", 6);
                biome.addStructure(GnomeVillages.withConfiguration(villageConfig));
                biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
                        GnomeVillages.withConfiguration(villageConfig)
                                .withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

            //}
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
