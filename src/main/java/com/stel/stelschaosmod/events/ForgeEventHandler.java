package com.stel.stelschaosmod.events;


import com.stel.stelschaosmod.entity.EntityRedfish;
import com.stel.stelschaosmod.entity.EntitySpawnerMob;
import com.stel.stelschaosmod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Arrays;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventHandler {

    private static final ArrayList<Block> redstoneBlocks = new ArrayList<>(Arrays.asList(Blocks.REDSTONE_WIRE,
            Blocks.REDSTONE_BLOCK, Blocks.REDSTONE_TORCH, Blocks.REDSTONE_LAMP));
    @SubscribeEvent
    public static void onEntitySpawnEvent(LivingSpawnEvent.CheckSpawn event) {
        Block block = event.getWorld().getBlockState(new BlockPos(event.getX(), event.getY(),
                event.getZ())).getBlock();
        if (event.getEntity() instanceof EntityRedfish)
        {
                if (redstoneBlocks.contains(block))
                event.setResult(Event.Result.ALLOW);
            else
                event.setResult(Event.Result.DENY);
        }
        else if (event.getEntity() instanceof EntitySpawnerMob)
        {
            if (event.getWorld().getBlockState(new BlockPos(event.getX(), event.getY(), event.getZ()))
                    .getBlock() != Blocks.WATER)
                event.setResult(Event.Result.ALLOW);
            else
                event.setResult(Event.Result.DENY);
        }
    }
}
