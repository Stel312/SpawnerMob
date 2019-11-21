package com.stel.stelschaosmod.common.entity.mobs.ai;

import com.stel.stelschaosmod.common.entity.mobs.EntityRedfish;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityAIRedstoneSignal extends EntityAIBase {

    private EntityRedfish redfish;
    private World world;
    private final int update = 200;
    public final IBlockState blockState;

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

        long tick = this.redfish.ticksExisted % update;
        if (tick == (long) 0 )
        {
            int x = (int)redfish.posX;
            int y = (int)redfish.posY;
            int z = (int)redfish.posZ;
            BlockPos blockPos = new BlockPos(x,y,z);

        }
    }
}
