package com.stel.stelschaosmod.main;

import com.stel.stelschaosmod.lib.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;


@Mod(Reference.MODID)
@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class stelschaosmod {
    public static stelschaosmod instance;

    public static final String MODID = Reference.MODID;
    public static final String NAME = Reference.MODNAME;
    public static final String VERSION = Reference.MODVER;


    private void setup(final FMLCommonSetupEvent event) {

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }


}
