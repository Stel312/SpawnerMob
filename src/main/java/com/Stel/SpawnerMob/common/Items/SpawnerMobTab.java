package com.Stel.SpawnerMob.common.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class SpawnerMobTab extends CreativeTabs {
    public SpawnerMobTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.BANNER);
    }
}