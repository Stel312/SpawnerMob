package com.stel.spawnermob.common.core.events;

import com.stel.spawnermob.common.entity.mobs.EntityImprovedWitherLvl1;
import com.stel.spawnermob.common.entity.mobs.EntityImprovedWitherLvl2;
import com.stel.spawnermob.common.entity.mobs.EntityImprovedWitherLvl3;
import com.stel.spawnermob.common.entity.mobs.EntitySpawnerMob;
import com.stel.spawnermob.common.lib.Strings;
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
                .id(new ResourceLocation(Strings.SpawnerMob, Strings.SpawnerMob), 33).name(Strings.SpawnerMob)
                .tracker(64, 2, false).egg(0x4c3e30, 0xf0f0f)
                .spawn(EnumCreatureType.CREATURE, 1, 1, 1, ForgeRegistries.BIOMES.getValuesCollection())
                .build());
        event.getRegistry().register(EntityEntryBuilder.create().entity(EntityImprovedWitherLvl3.class)
                .id(new ResourceLocation(Strings.ImprovedWitherLvl3, Strings.ImprovedWitherLvl3), 33)
                .name(Strings.ImprovedWitherLvl3).tracker(64, 2, false).build());
        event.getRegistry().register(EntityEntryBuilder.create().entity(EntityImprovedWitherLvl2.class)
                .id(new ResourceLocation(Strings.ImprovedWitherLvl2, Strings.ImprovedWitherLvl2), 33)
                .name(Strings.ImprovedWitherLvl2).tracker(64, 2, false).build());
        event.getRegistry().register(EntityEntryBuilder.create().entity(EntityImprovedWitherLvl1.class)
                .id(new ResourceLocation(Strings.ImprovedWitherLvl1, Strings.ImprovedWitherLvl1), 33)
                .name(Strings.ImprovedWitherLvl1).tracker(64, 2, false).build());
    }
}
