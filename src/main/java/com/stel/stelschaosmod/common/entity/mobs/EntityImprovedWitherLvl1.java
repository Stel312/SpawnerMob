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

public class EntityImprovedWitherLvl1 extends EntityWither {
    private final BossInfoServer bossInfo =
            (BossInfoServer) (new BossInfoServer(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS))
                    .setDarkenSky(true);
    private static boolean isImmuneToFire, canBreakBlocks;
    private int spawnTime, DEFAULT_SPAWN_TIME = 1000;
    private List<String> witherEntities = new ArrayList<>();
    private Random rand = new Random(java.lang.System.currentTimeMillis());
    private World worldin;

    public EntityImprovedWitherLvl1(World worldIn) {
        super(worldIn);
        this.worldin = worldIn;
        this.setHealth(1);
        this.setSize(0.9F, 3.5F);
        isImmuneToFire = false;
        canBreakBlocks = true;
        this.experienceValue = 50;
        this.spawnTime = DEFAULT_SPAWN_TIME;
        addWitherEntitiesToListLvl1();
    }

    private void addWitherEntitiesToListLvl1()
    {
        witherEntities.add("minecraft:chicken");
    }
    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAILookIdle(this));
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
