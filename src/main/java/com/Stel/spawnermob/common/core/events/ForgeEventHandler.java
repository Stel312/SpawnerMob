package com.Stel.spawnermob.common.core.events;

import com.Stel.spawnermob.common.Entity.Mobs.EntitySpawnerMob;
import com.Stel.spawnermob.common.lib.Strings;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Mod.EventBusSubscriber
public class ForgeEventHandler {

    @SubscribeEvent
    public static void entityRegistration(RegistryEvent.Register<EntityEntry> event) {
        event.getRegistry().register(EntityEntryBuilder.create().entity(EntitySpawnerMob.class)
                .id(new ResourceLocation(Strings.SpawnerMob, Strings.SpawnerMob), 33).name(Strings.SpawnerMob).tracker(64, 2, false)
                .egg(0x4c3e30, 0xf0f0f)
                .spawn(EnumCreatureType.AMBIENT, 1, 1, 1, ForgeRegistries.BIOMES.getValuesCollection())
                .build());
    }
}
