package com.stel.stelschaosmod.common.items;

import com.stel.stelschaosmod.common.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SpawnerMobTab extends CreativeTabs {
    public SpawnerMobTab(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlocks.ImprovedWitherSkull);
    }
}