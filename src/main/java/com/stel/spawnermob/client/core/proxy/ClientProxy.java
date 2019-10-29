package com.stel.spawnermob.client.core.proxy;

import com.stel.spawnermob.client.model.mob.ModelSpawnerMob;
import com.stel.spawnermob.client.render.RenderMob;
import com.stel.spawnermob.common.blocks.BlockImprovedWitherSkull;
import com.stel.spawnermob.common.core.proxy.CommonProxy;
import com.stel.spawnermob.common.entity.mobs.EntitySpawnerMob;
import com.stel.spawnermob.common.lib.Strings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.stel.spawnermob.common.blocks.ModBlocks.ImprovedWitherSkull;


public class ClientProxy extends CommonProxy {
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        registerModel(Item.getItemFromBlock(ImprovedWitherSkull));
    }

    public static void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName() + "", "inventory"));
    }

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
