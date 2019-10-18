package com.Stel.SpawnerMob.common.core.proxy;

import com.Stel.SpawnerMob.SpawnerMob;
import com.Stel.SpawnerMob.common.Entity.Mobs.EntitySpawnerMob;
import com.Stel.SpawnerMob.common.lib.Reference;
import com.Stel.SpawnerMob.common.lib.Strings;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {


    }


    public void init(FMLInitializationEvent event)
    {   int entityID = 0;
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, Strings.SpawnerMob),  EntitySpawnerMob.class, Strings.SpawnerMob, entityID++, SpawnerMob.instance, 64, 3, true, 000000, 22222);
        EntityRegistry.addSpawn(EntitySpawnerMob.class, 10, 10, 10, EnumCreatureType.CREATURE, (Biome) ForgeRegistries.BIOMES.getValuesCollection());

    }


    public void postInit(FMLInitializationEvent event)
    {

    }
}
