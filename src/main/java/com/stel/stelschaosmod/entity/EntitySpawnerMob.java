package com.stel.stelschaosmod.entity;

import com.google.common.collect.Sets;
import com.stel.stelschaosmod.Config;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.spawner.AbstractSpawner;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class EntitySpawnerMob extends CreatureEntity {


    private Random rand = new Random(java.lang.System.currentTimeMillis());
    private Collection<EntityType<?>> entityTypes = ForgeRegistries.ENTITIES.getValues();
    private ArrayList<EntityType> entities;
    private World worldIn;
    private EntityType entityType;
    private AbstractSpawner mobSpawnerLogic = new AbstractSpawner() {
        @Override
        public void broadcastEvent(int id) { }
        @Override
        public World getWorld() {
            return worldIn;
        }
        @Override
        public BlockPos getSpawnerPosition() {
            return EntitySpawnerMob.this.getPosition();
        }
    };

    public EntitySpawnerMob(final EntityType<? extends CreatureEntity> entityType, World worldIn) {
        super(entityType, worldIn);
        this.worldIn = worldIn;
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return !EntitySpawnerMob.this.hasCustomName();
    }


    /**
     * updates the spawners logic
     */
    @Override
    public void tick()
    {
        super.tick();
        this.mobSpawnerLogic.tick();
    }

    public boolean canBeLeashedTo(PlayerEntity player) {
        return true;
    }
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.mobSpawnerLogic.read(compound);
        if(compound.hasUniqueId("spawnerEntity"))
        {
            String string = compound.getString("spawnerEntity");
            ResourceLocation res = new ResourceLocation(string);
            entityType = ForgeRegistries.ENTITIES.getValue(res);
            assert entityType != null;
            this.mobSpawnerLogic.setEntityType(entityType);
        }
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        this.mobSpawnerLogic.write(compound);
        if (entityType != null )
            compound.putString("spawnerEntity", entityType.toString());
    }

    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
            filterEntities();
            entityType = entities.get(rand.nextInt(entities.size()));
            mobSpawnerLogic.setEntityType(entityType);
            mobSpawnerLogic.setDelayToMin(1);
            return spawnDataIn;
    }

    private void filterEntities()
    {
        Set<String> whitelist = Sets.newHashSet(Config.instance.getSpawnerBlacklist());
        entityTypes = entityTypes.stream().filter(e -> !whitelist.contains(e.getRegistryName().toString())).collect(Collectors.toList());
        entities = new ArrayList<>(entityTypes);
    }
}
