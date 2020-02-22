package com.stel.stelschaosmod.entity;

import com.stel.stelschaosmod.main.StelsConfig;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.spawner.AbstractSpawner;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Random;

public class EntitySpawnerMob extends CreatureEntity {

    private Random rand = new Random(java.lang.System.currentTimeMillis());
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
        //this.targetSelector.addGoal(1, new ZombiePigmanEntity.HurtByAggressorGoal(this));
        //this.targetSelector.addGoal(2, new ZombiePigmanEntity.TargetAggressorGoal(this));
        //TODO add goal for spawning instead of using spawer logic
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }


    protected void registerAttributes() {

    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return !EntitySpawnerMob.this.hasCustomName();
    }

    @Override
    public void tick()
    {
        super.tick();
        this.mobSpawnerLogic.tick();
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.mobSpawnerLogic.read(compound);
        if(compound.hasUniqueId("spawnerEntity"))
        {
            String string = compound.getString("spawnerEntity");
            ResourceLocation res = new ResourceLocation(string);
            this.entityType = ForgeRegistries.ENTITIES.getValue(res);
            if (this.entityType != null )
                this.mobSpawnerLogic.setEntityType(this.entityType);
        }
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        this.mobSpawnerLogic.write(compound);
        if (this.entityType != null )
            compound.putString("spawnerEntity", this.entityType.getRegistryName().toString());
    }

    /*public boolean processInteract(PlayerEntity player, Hand hand) {
        System.out.println(EntitySpawnerMob.this.entityType.getRegistryName().toString());
        return true;
    }*/

    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
                                            @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        EntitySpawnerMob.this.entityType = StelsConfig.instance.getEntityArrayList()
                    .get(rand.nextInt(StelsConfig.instance.getEntityArrayList().size()));
            mobSpawnerLogic.setEntityType(this.entityType);
            mobSpawnerLogic.setDelayToMin(1);
            return spawnDataIn;
    }
}
