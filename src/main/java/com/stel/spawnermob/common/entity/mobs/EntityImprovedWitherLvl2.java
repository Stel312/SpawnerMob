package com.stel.spawnermob.common.entity.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityImprovedWitherLvl2 extends EntityImprovedWitherBase
{
    private final BossInfoServer bossInfo =
            (BossInfoServer) (new BossInfoServer(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS))
                    .setDarkenSky(true);
    private static boolean isImmuneToFire, canBreakBlocks;
    private int spawnTime, DEFAULT_SPAWN_TIME = 500;
    private List<Entity> witherEntities = new ArrayList<>();
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
        witherEntities.add(new EntityWitherSkeleton(worldin));
    }


    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("Invul", this.getInvulTime());
        compound.setInteger("SpawnTime", spawnTime);

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
        if(spawnTime == 0 && witherEntities.size() > 0)
        {
            Entity entityToSpawn = witherEntities.get(rand.nextInt(witherEntities.size()));
            entityToSpawn.setPosition(this.posX, this.posY, this.posZ);
            worldin.spawnEntity(entityToSpawn);
            spawnTime = DEFAULT_SPAWN_TIME;
        }
        else
            spawnTime--;
        System.out.println(spawnTime);
    }
}
