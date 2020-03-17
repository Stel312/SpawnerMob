package com.stel.stelschaosmod.events;


import com.stel.stelschaosmod.entity.EntityRedfish;
import com.stel.stelschaosmod.entity.EntitySpawnerMob;
import com.stel.stelschaosmod.entitytypes.TypeEntities;
import com.stel.stelschaosmod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventHandler {
    private static Random rand = new Random(java.lang.System.currentTimeMillis());
    private static final ArrayList<Block> redstoneBlocks = new ArrayList<>(Arrays.asList(Blocks.REDSTONE_WIRE,
            Blocks.REDSTONE_BLOCK, Blocks.REDSTONE_TORCH, Blocks.REDSTONE_LAMP, Blocks.REPEATER, Blocks.COMPARATOR,
            Blocks.REDSTONE_ORE));

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        World world = (World) event.getWorld();
        if (redstoneBlocks.contains(event.getState().getBlock()) && rand.nextInt(99) ==  0) {
            Entity entity = TypeEntities.redfishEntityType.create(world);
            entity.setPosition(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
            world.addEntity(entity);
        }
    }

    @SubscribeEvent
    public static void onEntitySpawnEvent(LivingSpawnEvent.CheckSpawn event) {
         if (event.getEntity() instanceof EntitySpawnerMob) {
            if (event.getWorld().getBlockState(new BlockPos(event.getX(), event.getY(), event.getZ()))
                    .getBlock() != Blocks.WATER)
                event.setResult(Event.Result.ALLOW);
            else
                event.setResult(Event.Result.DENY);
        }
    }
}
