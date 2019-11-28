package com.stel.stelschaosmod.common.entity.mobs.ai;

import com.stel.stelschaosmod.common.entity.mobs.EntityRedfish;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class EntityAIEatRedstone extends EntityAIBase {
    private EntityRedfish redfish;
    private World world;
    private final int update = 200;

    public EntityAIEatRedstone(final EntityRedfish redfishIn, World world) {
        this.redfish = redfishIn;
        this.world = world;
    }

    @Override
    public boolean shouldExecute() {
        return true;
    }

    @Override
    public void updateTask() {

        long tick = this.redfish.ticksExisted % update;
        if (tick == (long) 0 && this.world.getBlockState(redfish.getPosition())
                .getBlock() == Blocks.REDSTONE_WIRE) {
            world.setBlockToAir(redfish.getPosition());
        }
    }
}
