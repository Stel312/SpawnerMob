package com.stel.stelschaosmod.common.entity.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityImprovedWitherLvl2 extends EntityWither
{
    private final BossInfoServer bossInfo =
            (BossInfoServer) (new BossInfoServer(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS))
                    .setDarkenSky(true);
    private static boolean isImmuneToFire, canBreakBlocks;
    private int spawnTime, DEFAULT_SPAWN_TIME = 500;
    private List<String> witherEntities = new ArrayList<>();
    private Random rand = new Random(java.lang.System.currentTimeMillis());
    private World worldin;
    public EntityImprovedWitherLvl2(World worldIn) {
        super(worldIn);
        this.setHealth(10);
        this.worldin = worldIn;
        isImmuneToFire = true;
        canBreakBlocks = true;
        this.experienceValue = 100;
        spawnTime = DEFAULT_SPAWN_TIME;
        addWitherEntitiesToListLvl2();
    }

    private void addWitherEntitiesToListLvl2()
    {
        witherEntities.add("minecraft:zombie");
    }


    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("Invul", this.getInvulTime());
        compound.setInteger("SpawnTime", spawnTime);

    }
    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAILookIdle(this));
    }

    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        if(compound.hasKey("Invul"))
            this.setInvulTime(compound.getInteger("Invul"));
        if(compound.hasKey("SpawnTime"))
            this.spawnTime = compound.getInteger("SpawnTime");
        if (this.hasCustomName())
        {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        if(spawnTime == 0)
        {
            ResourceLocation resourceLocation =
                    new ResourceLocation(witherEntities.get(rand.nextInt(witherEntities.size())));
            Entity entityToSpawn = EntityList.createEntityByIDFromName(resourceLocation , worldin);
            entityToSpawn.setPosition(this.posX, this.posY, this.posZ);
            worldin.spawnEntity(entityToSpawn);
            spawnTime = DEFAULT_SPAWN_TIME;
        }
        else
            spawnTime--;
        System.out.println(spawnTime);
    }
}
