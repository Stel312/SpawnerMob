package com.Stel.SpawnerMob.common.core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ListOfEntities {
    List<ResourceLocation> entities = new ArrayList<ResourceLocation>(EntityList.ENTITY_EGGS.keySet());


    ListOfEntities() {

    }

}
