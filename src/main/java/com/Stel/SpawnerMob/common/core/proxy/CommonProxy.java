package com.Stel.SpawnerMob.common.core.proxy;

import com.Stel.SpawnerMob.common.Entity.Mobs.EntitySpawnerMob;
import com.Stel.SpawnerMob.common.core.helper.EntityHelper;
import com.Stel.SpawnerMob.common.lib.Strings;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.ArrayList;
import java.util.List;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {


    }


    public void init(FMLInitializationEvent event)
    {
        List<Biome> othersBiomes = new ArrayList<>();


        EntityHelper.registerEntity(Strings.SpawnerMob, EntitySpawnerMob.class, 0xDACAB0, 0xC50033);

        EntityRegistry.addSpawn(EntitySpawnerMob.class, 1, 1, 100, EnumCreatureType.CREATURE, Biomes.MESA);

    }


    public void postInit(FMLInitializationEvent event)
    {

    }
}
