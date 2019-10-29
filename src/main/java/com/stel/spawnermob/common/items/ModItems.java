package com.stel.spawnermob.common.items;

import com.stel.spawnermob.common.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModItems
{
    public static final Item SKULL = new Item();
    public static CreativeTabs spawnerMobTab = new SpawnerMobTab(CreativeTabs.getNextID(), Strings.SpawnerMobTab);
    public static void preinit()
    {



    }
    @SubscribeEvent
    public static void regiterItems(RegistryEvent.Register<Item> event)
    {

    }

}
