package com.stel.stelschaosmod.main;


import com.stel.stelschaosmod.Config;
import com.stel.stelschaosmod.entity.EntityRedfish;
import com.stel.stelschaosmod.entity.EntitySpawnerMob;
import com.stel.stelschaosmod.lib.Strings;
import com.stel.stelschaosmod.model.mob.ModelRedfish;
import com.stel.stelschaosmod.model.mob.ModelSpawnerMob;
import com.stel.stelschaosmod.render.RenderMob;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;



@Mod("stelschaosmod")
public class stelschaosmod {
    public static stelschaosmod instance;
    public stelschaosmod()
    {
        Config.init();
        registerEntities();
    }



    private void setup(final FMLCommonSetupEvent event) { }

    private void enqueueIMC(final InterModEnqueueEvent event) { }

    public static void registerEntities() {
        RenderingRegistry.registerEntityRenderingHandler(EntityRedfish.class, EntityRendererManager -> new RenderMob
                (Minecraft.getInstance().getRenderManager(), new ModelRedfish(), .25f, Strings.Redfish));
        RenderingRegistry.registerEntityRenderingHandler(EntitySpawnerMob.class, EntityRendererManager -> new RenderMob
                (Minecraft.getInstance().getRenderManager(), new ModelSpawnerMob(), .75F, Strings.SpawnerMob));
    }
}
