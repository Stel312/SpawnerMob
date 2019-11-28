package com.stel.stelschaosmod.entity.ai;

import com.stel.stelschaosmod.entity.EntityRedfish;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.world.World;

public class GoalEatRedstone extends Goal {
    private EntityRedfish redfish;
    private World world;
    private final int update = 200;

    public GoalEatRedstone(final EntityRedfish redfishIn, World world) {
        this.redfish = redfishIn;
        this.world = world;
    }

    @Override
    public boolean shouldExecute() {
        return true;
    }

    @Override
    public void tick() {

        long tick = this.redfish.ticksExisted % update;
        if (tick == (long) 0 && this.world.getBlockState(redfish.getPosition())
                .getBlock() == Blocks.REDSTONE_WIRE) {
            world.setBlockState(redfish.getPosition(), Blocks.AIR.getDefaultState());
        }
    }
}
