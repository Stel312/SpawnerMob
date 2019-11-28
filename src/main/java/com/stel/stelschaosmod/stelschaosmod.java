package com.stel.stelschaosmod;

import com.stel.stelschaosmod.common.core.proxy.CommonProxy;
import com.stel.stelschaosmod.common.lib.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = stelschaosmod.MODID, name = stelschaosmod.NAME, version = stelschaosmod.VERSION)
public class stelschaosmod
{
    public static final String MODID = Reference.MODID;
    public static final String NAME = Reference.MODNAME;
    public static final String VERSION = Reference.MODVER;

    private static Logger logger;
    @SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide =
            Reference.COMMONPROXY, modId = "")
    public static CommonProxy proxy;

    @Mod.Instance
    public static stelschaosmod instance;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);


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
