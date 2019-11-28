package com.stel.stelschaosmod.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.spawner.AbstractSpawner;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntitySpawnerMob extends CreatureEntity {
    private boolean canDespawn = true;
    private Random rand = new Random(java.lang.System.currentTimeMillis());
    private final List<EntityType> entities = new ArrayList<EntityType>(ForgeRegistries.ENTITIES.getValues());

    //private World worldIn;
    private EntityType entityType;
    private BlockPos blockPos;

    private AbstractSpawner mobSpawnerLogic = new AbstractSpawner() {
        @Override
        public void broadcastEvent(int id) {

        }

        @Override
        public World getWorld() {
            return this.getWorld();
        }

        @Override
        public BlockPos getSpawnerPosition() {
            blockPos = EntitySpawnerMob.this.getPosition();
            return blockPos;
        }
    };

    public EntitySpawnerMob(final EntityType<? extends EntitySpawnerMob> entityType, World worldIn) {
        super(entityType, worldIn);
        //this.worldIn = worldIn;
        //this.canDespawn = canDespawn;
        //this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
        this.goalSelector.addGoal(1, new SwimGoal(this));
    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return canDespawn;
    }

    @Override
    protected void registerAttributes() {
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }


    /**
     * updates the spawners logic
     */
    @Override
    public void tick()
    {
        this.mobSpawnerLogic.tick();

    }


    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.mobSpawnerLogic.read(compound);
        if(compound.hasUniqueId("spawnerEntity"))
        {
            String string = compound.getString("spawnerEntity");
            entityType.setRegistryName(string);
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
            //super.onInitialSpawn(difficultyInstance, entityLivingData);
            blockPos = EntitySpawnerMob.this.getPosition();
            entityType = entities.get(rand.nextInt(entities.size()));
            mobSpawnerLogic.setEntityType(entityType);
            mobSpawnerLogic.setDelayToMin(1);

            return spawnDataIn;

    }
}
