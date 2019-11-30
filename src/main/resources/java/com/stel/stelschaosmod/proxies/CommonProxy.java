package com.stel.stelschaosmod.proxies;

import com.stel.stelschaosmod.blocks.SourceBlock;
import com.stel.stelschaosmod.lib.Reference;
import com.stel.stelschaosmod.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CommonProxy
{

        @SubscribeEvent
        public static void registerBlock(RegistryEvent.Register<Block> event) {
            //event.getRegistry().register(new BlockImprovedWitherSkull( "pickaxe", 0, 1f, 10f, Strings.BlockImprovedWitherSkull));
            event.getRegistry().register(new SourceBlock().setRegistryName(Reference.MODID, Strings.BlockSourceBlock));
        }

        @SubscribeEvent
        public static void registerItem(RegistryEvent.Register<Item> event) {
            //event.getRegistry().register(new ItemBlock(ImprovedWitherSkull).setRegistryName(Objects.requireNonNull(ImprovedWitherSkull.getRegistryName())));
        }

}
