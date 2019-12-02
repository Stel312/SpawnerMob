package com.stel.stelschaosmod.entity.ai;

import com.stel.stelschaosmod.entity.EntityRedfish;
import net.minecraft.block.BlockState;
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
        long tick = redfish.ticksExisted % update;
        if (tick == (long) 0 )
        {
            int x = (int)redfish.posX;
            int y = (int)redfish.posY;
            int z = (int)redfish.posZ;
            BlockPos blockPos = new BlockPos(x,y,z);
                final BlockState cur = redfish.getEntityWorld().getBlockState(blockPos);
                redfish.getEntityWorld().setBlockState(blockPos, blockState );
        }
    }
}
