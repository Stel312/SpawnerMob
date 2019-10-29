package com.stel.spawnermob.common.blocks;

import com.google.common.base.Predicate;
import com.stel.spawnermob.common.entity.mobs.EntityImprovedWither;
import com.stel.spawnermob.common.items.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.pattern.BlockMaterialMatcher;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockImprovedWitherSkull extends BlockSkull {
    private BlockPattern witherPattern;

    public BlockImprovedWitherSkull( String toolClass, int level, float hardness, float resistance, String name)
    {
        this.setHarvestLevel(toolClass, level);
        setHardness(hardness);
        setResistance(resistance);
        setCreativeTab(ModItems.spawnerMobTab);
        setRegistryName(name);
    }

    private static final Predicate<BlockWorldState> IS_WITHER_SKELETON = new Predicate<BlockWorldState>() {
        public boolean apply(@Nullable BlockWorldState p_apply_1_) {
            return p_apply_1_.getBlockState() != null && p_apply_1_.getBlockState().getBlock() == Blocks.SKULL && p_apply_1_.getTileEntity() instanceof TileEntitySkull && ((TileEntitySkull) p_apply_1_.getTileEntity()).getSkullType() == 1;
        }
    };

    @Override
    protected BlockPattern getWitherPattern()
    {

        if (this.witherPattern == null) {
            this.witherPattern = FactoryBlockPattern.start().aisle("^+^", "###", "~#~")
                    .where('#', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.SOUL_SAND)))
                    .where('^', IS_WITHER_SKELETON)
                    .where('~', BlockWorldState.hasState(BlockMaterialMatcher.forMaterial(Material.AIR)))
                    .where('+', BlockWorldState.hasState(BlockStateMatcher.forBlock(ModBlocks.ImprovedWitherSkull))).build();
        }

        return this.witherPattern;
    }

    @Override
    public void checkWitherSpawn(World worldIn, BlockPos pos, TileEntitySkull te) {
        if (te.getSkullType() == 1 && pos.getY() >= 2 && worldIn.getDifficulty() != EnumDifficulty.PEACEFUL && !worldIn.isRemote) {
            BlockPattern blockpattern = this.getWitherPattern();
            BlockPattern.PatternHelper blockpattern$patternhelper = blockpattern.match(worldIn, pos);

            if (blockpattern$patternhelper != null) {
                for (int i = 0; i < 3; ++i) {
                    BlockWorldState blockworldstate = blockpattern$patternhelper.translateOffset(i, 0, 0);
                    worldIn.setBlockState(blockworldstate.getPos(), blockworldstate.getBlockState().withProperty(NODROP, Boolean.valueOf(true)), 2);
                }

                for (int j = 0; j < blockpattern.getPalmLength(); ++j) {
                    for (int k = 0; k < blockpattern.getThumbLength(); ++k) {
                        BlockWorldState blockworldstate1 = blockpattern$patternhelper.translateOffset(j, k, 0);
                        worldIn.setBlockState(blockworldstate1.getPos(), Blocks.AIR.getDefaultState(), 2);
                    }
                }

                BlockPos blockpos = blockpattern$patternhelper.translateOffset(1, 0, 0).getPos();
                EntityImprovedWither entityImprovedWither = new EntityImprovedWither(worldIn);
                BlockPos blockpos1 = blockpattern$patternhelper.translateOffset(1, 2, 0).getPos();
                entityImprovedWither.setLocationAndAngles((double) blockpos1.getX() + 0.5D, (double) blockpos1.getY() + 0.55D, (double) blockpos1.getZ() + 0.5D, blockpattern$patternhelper.getForwards().getAxis() == EnumFacing.Axis.X ? 0.0F : 90.0F, 0.0F);
                entityImprovedWither.renderYawOffset = blockpattern$patternhelper.getForwards().getAxis() == EnumFacing.Axis.X ? 0.0F : 90.0F;
                entityImprovedWither.ignite();

                for (EntityPlayerMP entityplayermp : worldIn.getEntitiesWithinAABB(EntityPlayerMP.class, entityImprovedWither.getEntityBoundingBox().grow(50.0D))) {
                    CriteriaTriggers.SUMMONED_ENTITY.trigger(entityplayermp, entityImprovedWither);
                }

                worldIn.spawnEntity(entityImprovedWither);

                for (int l = 0; l < 120; ++l) {
                    worldIn.spawnParticle(EnumParticleTypes.SNOWBALL, (double) blockpos.getX() + worldIn.rand.nextDouble(), (double) (blockpos.getY() - 2) + worldIn.rand.nextDouble() * 3.9D, (double) blockpos.getZ() + worldIn.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
                }

                for (int i1 = 0; i1 < blockpattern.getPalmLength(); ++i1) {
                    for (int j1 = 0; j1 < blockpattern.getThumbLength(); ++j1) {
                        BlockWorldState blockworldstate2 = blockpattern$patternhelper.translateOffset(i1, j1, 0);
                        worldIn.notifyNeighborsRespectDebug(blockworldstate2.getPos(), Blocks.AIR, false);
                    }
                }
            }
        }
    }
}
