package com.stel.stelschaosmod.common.entity.mobs;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityRedfish extends EntityCreature {
    private int eatRedstoneTimer = 250;
    public EntityRedfish(World worldIn) {
        super(worldIn);
        this.tasks.addTask(1, new EntityAIWander(this, 1.0D));

    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */

    public void onUpdate() {
        super.onUpdate();
        if (eatRedstoneTimer <= 0 && this.world.getBlockState(EntityRedfish.this.getPosition())
                .getBlock().equals(Block.getBlockFromName("minecraft:redstone_wire")))
        {
            this.world.getBlockState(EntityRedfish.this.getPosition())
        }
        if (eatRedstoneTimer <= 0 && this.world.getBlockState(EntityRedfish.this.getPosition())
                .getBlock().equals(Block.getBlockFromName("minecraft:redstone_wire")))
        {

            world.setBlockToAir(EntityRedfish.this.getPosition());
            eatRedstoneTimer = 250;
        }
        else
            eatRedstoneTimer--;
        System.out.println(eatRedstoneTimer);
    }

    @Override
    public boolean canDespawn()
    {
        return true;
    }

    protected boolean canTriggerWalking()
    {
        return false;
    }

    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_SILVERFISH_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_SILVERFISH_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_SILVERFISH_DEATH;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_SILVERFISH_STEP, 0.15F, 1.0F);
    }

    @Override
    public boolean getCanSpawnHere()
    {
        Block block = this.world.getBlockState(EntityRedfish.this.getPosition()).getBlock();
        if(block.equals(Block.getBlockFromName("minecraft:redstone_wire")))
            return true;
        return false;
    }

}
