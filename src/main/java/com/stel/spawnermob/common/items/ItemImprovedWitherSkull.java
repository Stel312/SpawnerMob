package com.stel.spawnermob.common.items;

import net.minecraft.item.ItemSkull;

public class ItemImprovedWitherSkull extends ItemSkull {
    private static final String SKULL_TYPES = "ImprovedWitherSkull";
    public ItemImprovedWitherSkull()
    {
        this.setCreativeTab(ModItems.spawnerMobTab);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

}
