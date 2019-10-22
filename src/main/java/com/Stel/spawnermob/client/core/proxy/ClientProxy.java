package com.Stel.spawnermob.client.core.proxy;

import com.Stel.spawnermob.client.Model.Mob.ModelSpawnerMob;
import com.Stel.spawnermob.client.render.RenderMob;
import com.Stel.spawnermob.common.core.proxy.CommonProxy;
import com.Stel.spawnermob.common.entity.Mobs.EntitySpawnerMob;
import com.Stel.spawnermob.common.lib.Strings;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event) {

        RenderingRegistry.registerEntityRenderingHandler(EntitySpawnerMob.class, (IRenderFactory) new RenderMob
                (Minecraft.getMinecraft().getRenderManager(), new ModelSpawnerMob(), 1, Strings.SpawnerMob));

    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLInitializationEvent event) {

    }
}
