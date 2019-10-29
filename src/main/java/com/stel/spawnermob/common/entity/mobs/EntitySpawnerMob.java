package com.stel.spawnermob.common.entity.mobs;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntitySpawnerMob extends EntityCreature {
    private boolean canDespawn = true;
    private Random rand = new Random(java.lang.System.currentTimeMillis());
    private final List<ResourceLocation> entities = new ArrayList<ResourceLocation>(EntityList.ENTITY_EGGS.keySet());
    private World worldIn;
    ResourceLocation res;
    BlockPos blockPos;
    EntityTracker entityTracker;
    private MobSpawnerBaseLogic mobSpawnerBaseLogic = new MobSpawnerBaseLogic() {
        public void broadcastEvent(int id) {
            EntitySpawnerMob.this.world.setEntityState(EntitySpawnerMob.this, (byte)id); }
            @Override
        public World getSpawnerWorld() {
            worldIn = EntitySpawnerMob.this.getEntityWorld();
            return worldIn;
        }
        @Override
        public BlockPos getSpawnerPosition() {
            blockPos = EntitySpawnerMob.this.getPosition();
            return blockPos;
        }
        public net.minecraft.entity.Entity getSpawnerEntity() {
            return EntitySpawnerMob.this;
        }
    };

    public EntitySpawnerMob(World worldIn) {
        super(worldIn);
        this.worldIn = worldIn;
        this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(1, new EntityAISwimming(this));
    }


    public EntitySpawnerMob(World worldIn, boolean canDespawn) {
        super(worldIn);
        this.worldIn = worldIn;
        this.canDespawn = canDespawn;
        this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(1, new EntityAISwimming(this));
    }



    @Override
    protected boolean canDespawn() {
        return canDespawn;
    }
    protected void initEntityAI()
    {
        this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(1, new EntityAISwimming(this));
    }
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }

    /**
     *  if a user right clicks an entity
     * @param player
     * @param hand
     * @return
     */
    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand) {
        if(!player.isSneaking()) {
            if(res != null)
                System.out.println(res.toString());
            return true;
        }
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        this.mobSpawnerBaseLogic.setDelayToMin(id);
    }

    /**
     * Updates the entity position and logic
     */
    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
    }
    /**
     * updates the spawners logic
     */

    public void onUpdate()
    {
        super.onUpdate();
        this.mobSpawnerBaseLogic.updateSpawner();
    }

    /**
     * Retrieves the ResourceLocation in the nbt tags from when user opened game/server
     * @param compound
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.mobSpawnerBaseLogic.readFromNBT(compound);
        if(compound.hasKey("spawnerEntity"))
        {
            String string = compound.getString("spawnerEntity");
            res = new ResourceLocation(string);
            this.mobSpawnerBaseLogic.setEntityId(res);
        }
    }

    /**
     * Stored the ResourceLocation in the nbt tags for when user closes game/server
     * @param compound
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        this.mobSpawnerBaseLogic.writeToNBT(compound);
        if (res != null)
        compound.setString("spawnerEntity", res.toString());
    }

    /**
     * on the initial spawn of the entity the entity will get a random entity from a list of entities and will
     * set it as the entity to spawn
     * @param difficultyInstance
     * @param entityLivingData
     * @return
     */
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficultyInstance, IEntityLivingData entityLivingData)
    {
        super.onInitialSpawn(difficultyInstance, entityLivingData);
        blockPos = EntitySpawnerMob.this.getPosition();
        res = entities.get(rand.nextInt(entities.size()));
        this.mobSpawnerBaseLogic.setEntityId(res);
        mobSpawnerBaseLogic.setDelayToMin(1);

        return entityLivingData;
    }


}
