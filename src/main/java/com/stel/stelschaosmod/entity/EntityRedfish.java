package com.stel.stelschaosmod.entity;

import com.stel.stelschaosmod.blocks.ModBlocks;
import com.stel.stelschaosmod.entity.ai.GoalEatRedstone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.HandSide;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityRedfish extends CreatureEntity {


    public EntityRedfish(EntityType<CreatureEntity> entityType, World world) {
        super(entityType, world);
        final BlockState blockStateForRedstone = ModBlocks.RedstoneBlock.getDefaultState();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        //this.goalSelector.addGoal(3, new GoalRedstoneSignal(this, blockStateForRedstone));
        this.goalSelector.addGoal(2, new GoalEatRedstone(this, world));
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(.5D);
    }


    @Override
    public void tick()
    {

    }


    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
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



    @Deprecated
    public boolean canProvidePower(BlockState state) {
        return true;
    }




    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_SILVERFISH_STEP, 0.15F, 1.0F);
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn)
    {
        return  this.world.getBlockState(new BlockPos(this.posX, this.posY, this.posZ)).getBlock() == Blocks.REDSTONE_WIRE;
    }

}
