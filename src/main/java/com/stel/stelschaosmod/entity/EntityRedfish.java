package com.stel.stelschaosmod.entity;

import com.stel.stelschaosmod.common.blocks.ModBlocks;
import com.stel.stelschaosmod.entity.ai.GoalEatRedstone;
import com.stel.stelschaosmod.entity.ai.GoalRedstoneSignal;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.HandSide;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityRedfish extends CreatureEntity {
    //private tick

    public EntityRedfish(World world)
    {
        this(, world);
    }


    public EntityRedfish(EntityType<Entity> entityType, World world) {
        super(entityType, world);
        final BlockState blockStateForRedstone = ModBlocks.RedstoneBlock.getDefaultState();
        //this.goalSelector.addGoal(1, new Goal(this, .25D));
        this.goalSelector.addGoal(3, new GoalRedstoneSignal(this, blockStateForRedstone));
        this.goalSelector.addGoal(2, new GoalEatRedstone(this, world));
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
        //this.setSize(.65f,.25f);
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

    @Override
    public Iterable<ItemStack> getArmorInventoryList() {
        return null;
    }

    @Deprecated
    public boolean canProvidePower(BlockState state) {
        return true;
    }

    @Override
    public ItemStack getItemStackFromSlot(EquipmentSlotType slotIn) {
        return null;
    }

    @Override
    public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack) {

    }

    @Override
    public HandSide getPrimaryHand() {
        return null;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        //this.playSound(SoundEvents.ENTITY_SILVERFISH_STEP, 0.15F, 1.0F);
    }

    //@Override
    public boolean getCanSpawnHere()
    {
        return  this.world.getBlockState(new BlockPos(this.posX, this.posY, this.posZ)).getBlock() == Blocks.REDSTONE_WIRE;
    }

}
