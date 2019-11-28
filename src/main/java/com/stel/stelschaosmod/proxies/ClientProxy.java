package com.stel.stelschaosmod.proxies;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class ClientProxy extends CommonProxy {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        //registerModel(Item.getItemFromBlock(ImprovedWitherSkull));
    }

    public static void registerModel(Item item) {
        //ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName() + "", "inventory"));
    }


    public void registerEntityRenders() {
        /*RenderingRegistry.registerEntityRenderingHandler(EntityRedfish.class, (IRenderFactory) new RenderMob
                (Minecraft.getMinecraft().getRenderManager(), new ModelRedfish(), 1, Strings.Redfish));

        RenderingRegistry.registerEntityRenderingHandler(EntitySpawnerMob.class, (IRenderFactory) new RenderMob
                (Minecraft.getMinecraft().getRenderManager(), new ModelSpawnerMob(), 1, Strings.SpawnerMob));

        RenderingRegistry.registerEntityRenderingHandler(EntityImprovedWitherLvl3.class, (IRenderFactory) new RenderMob
                (Minecraft.getMinecraft().getRenderManager(), new ModelSpawnerMob(), 1, Strings.ImprovedWitherLvl3));

        RenderingRegistry.registerEntityRenderingHandler(EntityImprovedWitherLvl2.class, (IRenderFactory) new RenderMob
                (Minecraft.getMinecraft().getRenderManager(), new ModelSpawnerMob(), 1, Strings.ImprovedWitherLvl2));

        RenderingRegistry.registerEntityRenderingHanzdler(EntityImprovedWitherLvl1.class, (IRenderFactory) new RenderMob
                (Minecraft.getMinecraft().getRenderManager(), new ModelSpawnerMob(), 1, Strings.ImprovedWitherLvl1));*/


    }

}
