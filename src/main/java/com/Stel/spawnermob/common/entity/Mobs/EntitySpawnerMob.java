package com.Stel.spawnermob.common.Entity.Mobs;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
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
        public BlockPos getSpawnerPosition() { return blockPos; }
        public net.minecraft.entity.Entity getSpawnerEntity() {
            return EntitySpawnerMob.this;
        }
    };

    public EntitySpawnerMob(World worldIn) {
        super(worldIn);
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

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand) {
        if(!player.isSneaking()) {
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
     * Called to update the entity's position/logic.
     */
    public void onEntityUpdate()
    {
        super.onEntityUpdate();
        if(this.mobSpawnerBaseLogic != null && blockPos !=null )
                this.mobSpawnerBaseLogic.updateSpawner();
        this.mobSpawnerBaseLogic.setEntityId(res);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.mobSpawnerBaseLogic.readFromNBT(compound);

    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        this.mobSpawnerBaseLogic.writeToNBT(compound);
    }


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
