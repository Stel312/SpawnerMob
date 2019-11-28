package com.stel.stelschaosmod.common.core.events;

import com.stel.stelschaosmod.common.entity.mobs.*;
import com.stel.stelschaosmod.common.lib.Strings;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import javax.annotation.Syntax;

@Mod.EventBusSubscriber
public class ForgeEventHandler {

    @SubscribeEvent
    public static void entityRegistration(RegistryEvent.Register<EntityEntry> event) {
        event.getRegistry().register(EntityEntryBuilder.create().entity(EntityRedfish.class)
                .id(new ResourceLocation(Strings.Redfish, Strings.Redfish), 33).name(Strings.Redfish)
                .tracker(64, 2, false).egg( 0xff0000, 0xf00000)
                .spawn(EnumCreatureType.CREATURE, 100, 1, 1, ForgeRegistries.BIOMES.getValuesCollection())
                .build());

        event.getRegistry().register(EntityEntryBuilder.create().entity(EntitySpawnerMob.class)
                .id(new ResourceLocation(Strings.SpawnerMob, Strings.SpawnerMob), 34).name(Strings.SpawnerMob)
                .tracker(64, 2, false).egg(0x4c3e30, 0xf0f0f)
                .spawn(EnumCreatureType.CREATURE, 1, 1, 1, ForgeRegistries.BIOMES.getValuesCollection())
                .build());



        /*event.getRegistry().register(EntityEntryBuilder.create().entity(EntityImprovedWitherLvl3.class)
                .id(new ResourceLocation(Strings.ImprovedWitherLvl3, Strings.ImprovedWitherLvl3), 35)
                .name(Strings.ImprovedWitherLvl3).tracker(64, 2, false).build());
        event.getRegistry().register(EntityEntryBuilder.create().entity(EntityImprovedWitherLvl2.class)
                .id(new ResourceLocation(Strings.ImprovedWitherLvl2, Strings.ImprovedWitherLvl2), 36)
                .name(Strings.ImprovedWitherLvl2).tracker(64, 2, false).build());
        event.getRegistry().register(EntityEntryBuilder.create().entity(EntityImprovedWitherLvl1.class)
                .id(new ResourceLocation(Strings.ImprovedWitherLvl1, Strings.ImprovedWitherLvl1), 37)
                .name(Strings.ImprovedWitherLvl1).tracker(64, 2, false).build());*/

    }


}
