package com.stel.stelschaosmod.common.entity.mobs;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityImprovedWitherLvl3 extends EntityWither {
    private final BossInfoServer bossInfo =
            (BossInfoServer) (new BossInfoServer(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS))
                    .setDarkenSky(true);
    private static boolean isImmuneToFire, canBreakBlocks;
    private int spawnTime, DEFAULT_SPAWN_TIME = 250;
    private List<String> witherEntities = new ArrayList<>();
    private Random rand = new Random(java.lang.System.currentTimeMillis());
    private World worldin;


    public EntityImprovedWitherLvl3(World worldIn) {
        super(worldIn);
        this.worldin = worldIn;
            this.setHealth(100);
            isImmuneToFire = true;
            canBreakBlocks = true;
            this.experienceValue = 150;
            spawnTime = DEFAULT_SPAWN_TIME;
            addWitherEntitiesToListLvl3();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
    }

    private void addWitherEntitiesToListLvl3()
    {
        witherEntities.add("minecraft:wither_skeleton");
    }


    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAILookIdle(this));
        this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
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



    @Override
    protected void updateAITasks()
    {


    }


    public static boolean canDestroyBlock(Block blockIn)
    {

        return canBreakBlocks &&  blockIn != Blocks.BEDROCK && blockIn != Blocks.END_PORTAL && blockIn != Blocks.END_PORTAL_FRAME
                && blockIn != Blocks.COMMAND_BLOCK && blockIn != Blocks.REPEATING_COMMAND_BLOCK
                && blockIn != Blocks.CHAIN_COMMAND_BLOCK && blockIn != Blocks.BARRIER
                && blockIn != Blocks.STRUCTURE_BLOCK && blockIn != Blocks.STRUCTURE_VOID
                && blockIn != Blocks.PISTON_EXTENSION && blockIn != Blocks.END_GATEWAY;
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
                addWitherEntitiesToListLvl3();

        if (this.hasCustomName())
        {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    /**
     * Sets the custom name tag for this entity
     */
    public void setCustomNameTag(String name)
    {
        super.setCustomNameTag(name);
        this.bossInfo.setName(this.getDisplayName());
    }

}
