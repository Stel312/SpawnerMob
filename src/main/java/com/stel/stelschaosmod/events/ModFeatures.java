package com.stel.stelschaosmod.events;

import com.stel.stelschaosmod.lib.Reference;
import com.stel.stelschaosmod.structures.GnomeStructure;
import com.stel.stelschaosmod.structures.GnomeVillagePieces;
import com.stel.stelschaosmod.structures.GnomeVillagePools;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.structure.VillagePieces;
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
import java.util.Random;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFeatures {
    //public static Structure<VillageConfig> GnomeVillages = new GnomeStructure(VillageConfig::deserialize);
    public static Structure<VillageConfig> GnomeVillages = register("gnomevillages", new GnomeStructure(VillageConfig::deserialize));
    public static IStructurePieceType GVP;

    @SubscribeEvent
    public void setup(final FMLCommonSetupEvent event) {
        GnomeVillagePools.init();
        for (Biome biome : ForgeRegistries.BIOMES) {
            biome.addStructure(GnomeVillages.withConfiguration(new VillageConfig("village/gnome/houses", 6)));
            biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
                    GnomeVillages.withConfiguration(new VillageConfig("village/gnome/houses", 6))
                            .withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        }
    }

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        IForgeRegistry<Feature<?>> registry = event.getRegistry();
        //registerFeature(registry, GnomeVillages, "gnomevillages");
        GVP = register(GnomeVillagePieces.Village::new, "GVP");
    }
    private static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, F value) {
        return (F)(Registry.<Feature<?>>register(Registry.FEATURE, key, value));
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
