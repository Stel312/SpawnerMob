package com.stel.stelschaosmod.events;

import com.google.common.eventbus.Subscribe;
import com.stel.stelschaosmod.blocks.SourceBlock;
import com.stel.stelschaosmod.entity.EntityRedfish;
import com.stel.stelschaosmod.entity.EntitySpawnerMob;
import com.stel.stelschaosmod.entitytypes.TypeEntities;
import com.stel.stelschaosmod.lib.Reference;
import com.stel.stelschaosmod.lib.Strings;
import com.stel.stelschaosmod.model.mob.ModelRedfish;
import com.stel.stelschaosmod.model.mob.ModelSpawnerMob;
import com.stel.stelschaosmod.render.RenderMob;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeEventHandler {
    private static Biome.SpawnListEntry entry = null;
    private static Collection<Biome> biomes = null;

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(TypeEntities.redfishEntityType,
                TypeEntities.spawnerMobEntityType);
        new Biome.SpawnListEntry(TypeEntities.redfishEntityType, 1,1,1);
    }
    @SubscribeEvent
    public static void registerSpawn(final ModConfig.Loading event) {

        biomes = ForgeRegistries.BIOMES.getValues();

        entry = new Biome.SpawnListEntry(TypeEntities.redfishEntityType,3,1,1);
        biomes.stream().map(biome -> biome.getSpawns(EntityClassification.CREATURE)).forEach(list -> list.add(entry));
        entry = new Biome.SpawnListEntry(TypeEntities.spawnerMobEntityType,5,1,1);
        biomes.stream().map(biome -> biome.getSpawns(EntityClassification.CREATURE)).forEach(list -> list.add(entry));
    }

    @SubscribeEvent
    public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new SpawnEggItem(TypeEntities.redfishEntityType, 0xFF0000, 0x0F0000,
                        new Item.Properties().group(ItemGroup.MISC))
                        .setRegistryName(new ResourceLocation(Reference.MODID, Strings.Redfish+"_egg")),
                new SpawnEggItem(TypeEntities.spawnerMobEntityType, 0x000000, 0xFFFFFF,
                        new Item.Properties().group(ItemGroup.MISC))
                        .setRegistryName(new ResourceLocation(Reference.MODID, Strings.SpawnerMob+"_egg")));
    }

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(new SourceBlock()
                .setRegistryName(new ResourceLocation(Reference.MODID, Strings.BlockSourceBlock)));
    }

    @Subscribe
    public void registerEntityRenders(RenderLivingEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityRedfish.class, (IRenderFactory) new RenderMob
                (Minecraft.getInstance().getRenderManager(), new ModelRedfish(), 1, Strings.Redfish));

        RenderingRegistry.registerEntityRenderingHandler(EntitySpawnerMob.class, (IRenderFactory) new RenderMob
                (Minecraft.getInstance().getRenderManager(), new ModelSpawnerMob(), 1, Strings.SpawnerMob));

    }
}
