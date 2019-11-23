package com.stel.stelschaosmod.common.entity.mobs;

import com.stel.stelschaosmod.common.blocks.ModBlocks;
import com.stel.stelschaosmod.common.blocks.SourceBlock;
import com.stel.stelschaosmod.common.entity.mobs.ai.EntityAIEatRedstone;
import com.stel.stelschaosmod.common.entity.mobs.ai.EntityAIRedstoneSignal;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityRedfish extends EntityCreature {
    //private tick

  public EntityRedfish(World worldIn) {
        super(worldIn);
        //final IBlockState blockStateForRedstone = ModBlocks.RedstoneBlock.getDefaultState().withProperty(SourceBlock.redstoneSignal, 15);
        this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
        //this.tasks.addTask(9, new EntityAIRedstoneSignal(this, blockStateForRedstone));
        this.tasks.addTask(2, new EntityAIEatRedstone(this, worldIn));
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */

    public void onUpdate() {
        super.onUpdate();
    }

    public boolean isProvidingPower() {

        return true;

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
        if(block == Blocks.REDSTONE_WIRE)
            return true;
        return false;
    }

}
