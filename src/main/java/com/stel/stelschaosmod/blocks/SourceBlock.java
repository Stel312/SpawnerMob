package com.stel.stelschaosmod.blocks;

import com.stel.stelschaosmod.entity.EntityRedfish;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class SourceBlock extends Block {
    public SourceBlock() {
        super(Properties.create(Material.GLASS).tickRandomly());

    }


    @Override
    public int tickRate(final IWorldReader worldIn) {
        return 2;
    }

    public boolean ticksRandomly(BlockState state) {
        return this.ticksRandomly;
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {

        worldIn.getPendingBlockTicks().scheduleTick(pos, this, tickRate(worldIn));
    }

    @Override
    public void tick(final BlockState state, final World worldIn, final BlockPos pos, final Random random)
    {
        AxisAlignedBB toCheck = new AxisAlignedBB(pos).grow(0.5D);
        List<EntityRedfish> list = worldIn.getEntitiesWithinAABB(EntityRedfish.class, toCheck);
        if (list.isEmpty()) {
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
        } else {
            worldIn.getPendingBlockTicks().scheduleTick(pos, this, tickRate(worldIn));
        }
    }

    @Override
    public VoxelShape getShape(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext cxt) {
        return VoxelShapes.empty();
    }

    @Override
    public VoxelShape getCollisionShape(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext cxt) {
        return VoxelShapes.empty();
    }

    @Override
    public VoxelShape getRaytraceShape(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
        return VoxelShapes.empty();
    }

    @Override
    public VoxelShape getRenderShape(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
        return VoxelShapes.empty();
    }

    @Override
    public boolean isNormalCube(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
        return false;
    }

    @Override
    public boolean isSolid(final BlockState state) {
        return false;
    }

    @Override
    public ItemStack getItem(final IBlockReader worldIn, final BlockPos pos, final BlockState state) {
        return ItemStack.EMPTY;
    }

//	@Override
//	public boolean isCollidable(BlockState state) {
//		return false;
//	}

    @Override
    public boolean isReplaceable(final BlockState state, final BlockItemUseContext useContext) {
        return true;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(final BlockItemUseContext context) {
        return getDefaultState();
    }

    @Override
    public BlockState getStateForPlacement(final BlockState state, final Direction facing, final BlockState state2,
                                           final IWorld world, final BlockPos pos1, final BlockPos pos2, final Hand hand) {
        return getDefaultState();
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public void onFallenUpon(final World worldIn, final BlockPos pos, final Entity entityIn, final float fallDistance) {
        // do nothing
    }

    @Override
    public void onEntityCollision(final BlockState state, final World worldIn, final BlockPos pos, final Entity entity) {
        // do nothing
    }

    @Override
    public void onLanded(final IBlockReader worldIn, final Entity entityIn) {
        // do nothing
    }

    @Override
    public boolean canSpawnInBlock() {
        return true;
    }
    @Override
    public int getWeakPower(final BlockState blockState, final IBlockReader blockAccess, final BlockPos pos, final Direction side) {
        return 15;
    }

    @Override
    public int getStrongPower(final BlockState blockState, final IBlockReader blockAccess, final BlockPos pos, final Direction side) {
        return 15;
    }
}
