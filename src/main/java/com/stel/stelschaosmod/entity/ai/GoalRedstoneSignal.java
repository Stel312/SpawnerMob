package com.stel.stelschaosmod.entity.ai;

import com.stel.stelschaosmod.entity.EntityRedfish;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;

public class GoalRedstoneSignal extends Goal {

    private EntityRedfish redfish;
    private final int update = 4;
    private final BlockState blockState;

    public GoalRedstoneSignal(final EntityRedfish redfishIn, BlockState blockStateIn)
    {
        this.blockState = blockStateIn;
        this.redfish = redfishIn;
    }
    @Override
    public boolean shouldExecute() {
        return true;
    }

    @Override
    public void tick() {
        if (redfish.ticksExisted % update ==  0L)
        {
            final BlockState cur = redfish.getEntityWorld().getBlockState(redfish.getPosition());
            if(cur.getBlock().isAir(cur))
                redfish.getEntityWorld().setBlockState(redfish.getPosition(), blockState );
        }
    }
}
