package com.stel.stelschaosmod.common.entity.mobs.ai;

import com.stel.stelschaosmod.common.entity.mobs.EntityRedfish;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class EntityAIRedstoneSignal extends EntityAIBase {

    private EntityRedfish redfish;
    private final int update = 4;
    private final IBlockState blockState;

    public EntityAIRedstoneSignal(final EntityRedfish redfishIn, IBlockState blockStateIn)
    {
        this.blockState = blockStateIn;
        this.redfish = redfishIn;
    }
    @Override
    public boolean shouldExecute() {
        return true;
    }

    @Override
    public void updateTask() {

        long tick = redfish.ticksExisted % update;
        if (tick == (long) 0 )
        {
            int x = (int)redfish.posX;
            int y = (int)redfish.posY;
            int z = (int)redfish.posZ;
            BlockPos blockPos = new BlockPos(x,y,z);
                final IBlockState cur = redfish.getEntityWorld().getBlockState(blockPos);
                if(!cur.getBlock().isReplaceable(redfish.getEntityWorld(), blockPos))
                    return;
                redfish.getEntityWorld().setBlockState(blockPos, blockState );
        }
    }
}
