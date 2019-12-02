package com.stel.stelschaosmod.proxies;

import com.google.common.eventbus.Subscribe;
import com.stel.stelschaosmod.entity.EntityRedfish;
import com.stel.stelschaosmod.entity.EntitySpawnerMob;
import com.stel.stelschaosmod.lib.Strings;
import com.stel.stelschaosmod.model.mob.ModelRedfish;
import com.stel.stelschaosmod.model.mob.ModelSpawnerMob;
import com.stel.stelschaosmod.render.RenderMob;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;


public class ClientProxy extends CommonProxy {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        //registerModel(Item.getItemFromBlock(ImprovedWitherSkull));
    }

    public static void registerModel(Item item) {
        //ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName() + "", "inventory"));
    }


}
