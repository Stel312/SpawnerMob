package com.Stel.SpawnerMob.common.Entity.Mobs;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntitySpawnerMob extends EntityCreature {
    private boolean canDespawn;
    private MobSpawnerBaseLogic mobSpawnerBaseLogic;
    private World worldIn;
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
        return false;
    }

    @SubscribeEvent
    public void onEntitySpawn (LivingSpawnEvent event)
    {
        Random rand = new Random();
        List<ResourceLocation> entities = new ArrayList<ResourceLocation>(EntityList.ENTITY_EGGS.keySet());
        ResourceLocation res = entities.get(rand.nextInt(entities.size()));
        mobSpawnerBaseLogic = new MobSpawnerBaseLogic() {
            @Override
            public void broadcastEvent(int id) {

            }

            @Override
            public World getSpawnerWorld() {
                return worldIn;
            }

            @Override
            public BlockPos getSpawnerPosition() {
                return null;
            }
        };
        mobSpawnerBaseLogic.setEntityId(res);
        mobSpawnerBaseLogic.updateSpawner();


    }


}
