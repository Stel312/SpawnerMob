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


}
