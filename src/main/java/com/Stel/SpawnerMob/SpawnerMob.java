package com.Stel.SpawnerMob;

import com.Stel.SpawnerMob.common.Items.SpawnerMobTab;
import com.Stel.SpawnerMob.common.core.proxy.CommonProxy;
import com.Stel.SpawnerMob.common.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.sql.Ref;

@Mod(modid = SpawnerMob.MODID, name = SpawnerMob.NAME, version = SpawnerMob.VERSION)
public class SpawnerMob
{
    public static final String MODID = Reference.MODID;
    public static final String NAME = Reference.MODNAME;
    public static final String VERSION = Reference.MODVER;

    private static Logger logger;
    @SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide =
            Reference.COMMONPROXY, modId = "")
    public static CommonProxy proxy;

    @Mod.Instance
    public static SpawnerMob instance;

    public static SpawnerMobTab spawnerMobTab;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
        spawnerMobTab = new SpawnerMobTab(CreativeTabs.getNextID(), "Spawner Mob");

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
