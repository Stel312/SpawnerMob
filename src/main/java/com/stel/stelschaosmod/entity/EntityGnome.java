package com.stel.stelschaosmod.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.INPC;
import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import org.lwjgl.opengl.ARBTextureGather;

import javax.annotation.Nullable;

public class EntityGnome extends AgeableEntity implements INPC, IMerchant {
    public EntityGnome(EntityType<? extends AgeableEntity> p_i48581_1_, World p_i48581_2_) {
        super(p_i48581_1_, p_i48581_2_);
    }

    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageableEntity) {
        return EntityType.COW.create(this.world);
    }

    @Override
    public void setCustomer(@Nullable PlayerEntity playerEntity) {

    }

    @Nullable
    @Override
    public PlayerEntity getCustomer() {
        return null;
    }

    @Override
    public MerchantOffers getOffers() {
        return null;
    }

    @Override
    public void setClientSideOffers(@Nullable MerchantOffers merchantOffers) {

    }

    @Override
    public void onTrade(MerchantOffer merchantOffer) {

    }

    @Override
    public void verifySellingItem(ItemStack itemStack) {

    }

    @Override
    public World getWorld() {
        return null;
    }

    @Override
    public int getXp() {
        return 0;
    }

    @Override
    public void setXP(int i) {

    }

    @Override
    public boolean func_213705_dZ() {
        return false;
    }

    @Override
    public SoundEvent getYesSound() {
        return null;
    }
}
