package com.stel.stelschaosmod.events;

import com.stel.stelschaosmod.blocks.SourceBlock;
import com.stel.stelschaosmod.entitytypes.TypeEntities;
import com.stel.stelschaosmod.lib.Reference;
import com.stel.stelschaosmod.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventHandler {
    private static Biome.SpawnListEntry entry = null;

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(TypeEntities.redfishEntityType,
                TypeEntities.spawnerMobEntityType);
    }

    @SubscribeEvent
    public static void registerSpawn(final ModConfig.Loading event) {
        Collection<Biome> biomes = ForgeRegistries.BIOMES.getValues();
        entry = new Biome.SpawnListEntry(TypeEntities.spawnerMobEntityType,1,1,1);
        biomes.stream().map(biome -> biome.getSpawns(EntityClassification.CREATURE)).forEach(list -> list.add(entry));

    }

    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new SpawnEggItem(TypeEntities.redfishEntityType, 0xFF0000, 0x0F0000,
                        new Item.Properties().group(ItemGroup.MISC))
                        .setRegistryName(Reference.MODID + ":"  + Strings.Redfish + "_egg"),
               new SpawnEggItem(TypeEntities.spawnerMobEntityType, 0x000000, 0xFFFFFF,
                        new Item.Properties().group(ItemGroup.MISC))
                        .setRegistryName(Reference.MODID + ":" + Strings.SpawnerMob + "_egg"));
    }

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(new SourceBlock()
                .setRegistryName(new ResourceLocation(Reference.MODID, Strings.BlockSourceBlock)));
    }
}
