package com.stel.stelschaosmod.common.blocks;


import com.stel.stelschaosmod.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {
    @ObjectHolder( Strings.BlockSourceBlock)
    public static Block RedstoneBlock;
    @ObjectHolder(Strings.BlockImprovedWitherSkull)
    public static Block ImprovedWitherSkull;


}

