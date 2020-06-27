package com.stel.stelschaosmod.entitytypes;

import com.stel.stelschaosmod.entity.EntityGnome;
import com.stel.stelschaosmod.entity.EntityRedfish;
import com.stel.stelschaosmod.entity.EntitySpawnerMob;
import com.stel.stelschaosmod.lib.Reference;
import com.stel.stelschaosmod.lib.Strings;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.util.ResourceLocation;

public class TypeEntities {

    public static final EntityType<CreatureEntity> spawnerMobEntityType = (EntityType<CreatureEntity>) EntityType
            .Builder.create(EntitySpawnerMob::new, EntityClassification.CREATURE)
            .setUpdateInterval(1)
            .setTrackingRange(80)
            .size(1,1).build(Reference.MODID + ":" + Strings.SpawnerMob)
            .setRegistryName(new ResourceLocation(Reference.MODID, Strings.SpawnerMob));

    public static final EntityType<CreatureEntity> redfishEntityType = (EntityType<CreatureEntity>) EntityType.Builder
            .create(EntityRedfish::new, EntityClassification.CREATURE)
            .setUpdateInterval(1)
            .setTrackingRange(80)
            .size(.4f,.4f)
            .build(Reference.MODID + ":" + Strings.Redfish)
            .setRegistryName(new ResourceLocation(Reference.MODID, Strings.Redfish));
    public static final EntityType<CreatureEntity> gnomeEntityType = (EntityType<CreatureEntity>) EntityType.Builder
            .create(EntityGnome::new, EntityClassification.MISC)
            .setUpdateInterval(1)
            .setTrackingRange(80)
            .size(1f,1f)
            .build(Reference.MODID + ":" + Strings.Gnome)
            .setRegistryName(new ResourceLocation(Reference.MODID, Strings.Gnome));
            //(EntityType<CreatureEntity>) EntityType.Builder.create(EntityGnome::new, EntityClassification.MISC)
            //.size(0.6F, 1.95F);

}
