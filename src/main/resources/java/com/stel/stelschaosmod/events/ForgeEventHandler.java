package com.stel.stelschaosmod.events;

import com.stel.stelschaosmod.entitytypes.TypeEntities;
import com.stel.stelschaosmod.lib.Reference;
import com.stel.stelschaosmod.lib.Strings;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ForgeEventHandler {
    @SubscribeEvent
    public static void registerSpawnEggs(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new SpawnEggItem(TypeEntities.redfishEntityType, 0, 0, new Item.Properties().group(ItemGroup.MISC)),
                new SpawnEggItem(TypeEntities.spawnerMobEntityType, 0, 0, new Item.Properties().group(ItemGroup.MISC)));
    }
    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(TypeEntities.redfishEntityType.setRegistryName(Reference.MODID, Strings.Redfish),
                TypeEntities.spawnerMobEntityType.setRegistryName(Reference.MODID, Strings.SpawnerMob));
    }
}
