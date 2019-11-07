package com.stel.spawnermob.common.entity.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityImprovedWitherLvl1 extends EntityImprovedWitherBase {
    private final BossInfoServer bossInfo =
            (BossInfoServer) (new BossInfoServer(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS))
                    .setDarkenSky(true);
    private static boolean isImmuneToFire, canBreakBlocks;
    private int spawnTime, DEFAULT_SPAWN_TIME = 1000;
    private List<Entity> witherEntities = new ArrayList<>();
    private Random rand = new Random(java.lang.System.currentTimeMillis());
    private World worldin;

    public EntityImprovedWitherLvl1(World worldIn) {
        super(worldIn);
        this.worldin = worldIn;
        this.setHealth(1);
        this.setSize(0.9F, 3.5F);
        isImmuneToFire = false;
        canBreakBlocks = false;
        this.experienceValue = 50;
        this.spawnTime = DEFAULT_SPAWN_TIME;
        addWitherEntitiesToListLvl1();
    }

    private void addWitherEntitiesToListLvl1()
    {
        witherEntities.add(new EntityWitherSkeleton(worldin));
    }
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("Invul", this.getInvulTime());
        compound.setInteger("SpawnTime", spawnTime);

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        if(compound.hasKey("Invul"))
            this.setInvulTime(compound.getInteger("Invul"));
        if(compound.hasKey("SpawnTime"))
            this.spawnTime = compound.getInteger("SpawnTime");
        addWitherEntitiesToListLvl1();

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
