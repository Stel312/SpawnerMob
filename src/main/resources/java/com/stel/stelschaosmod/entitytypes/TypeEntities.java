package com.stel.stelschaosmod.entitytypes;

import com.stel.stelschaosmod.entity.EntityRedfish;
import com.stel.stelschaosmod.entity.EntitySpawnerMob;
import com.stel.stelschaosmod.lib.Strings;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.util.registry.Registry;

public class TypeEntities {

    public static final EntityType<EntitySpawnerMob> spawnerMobEntityType = register(Strings.SpawnerMob, EntityType
            .Builder.create(EntitySpawnerMob::new, EntityClassification.CREATURE).size(1,1));
    public static final EntityType<CreatureEntity> redfishEntityType = register(Strings.SpawnerMob, EntityType.Builder
            .create(EntityRedfish::new, EntityClassification.CREATURE).size(1,1));
    private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
        return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
    }
}
