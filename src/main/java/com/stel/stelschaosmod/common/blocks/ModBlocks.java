package com.stel.stelschaosmod.common.blocks;

import com.stel.stelschaosmod.common.lib.Reference;
import com.stel.stelschaosmod.common.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Objects;

public class ModBlocks {
    @GameRegistry.ObjectHolder(Reference.MODID + ":block_source")
    public static Block RedstoneBlock;
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BlockImprovedWitherSkull)
    public static Block ImprovedWitherSkull;

    @Mod.EventBusSubscriber(modid = Reference.MODID)
    public static class register {

        @SubscribeEvent
        public static void registerBlock(RegistryEvent.Register<Block> event) {
            //event.getRegistry().register(new BlockImprovedWitherSkull( "pickaxe", 0, 1f, 10f, Strings.BlockImprovedWitherSkull));
        }

        @SubscribeEvent
        public static void registerItem(RegistryEvent.Register<Item> event) {
            //event.getRegistry().register(new ItemBlock(ImprovedWitherSkull).setRegistryName(Objects.requireNonNull(ImprovedWitherSkull.getRegistryName())));
        }
    }
}

