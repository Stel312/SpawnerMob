package com.stel.stelschaosmod.common.blocks;

import com.google.common.base.Predicate;
import com.stel.stelschaosmod.common.entity.mobs.EntityImprovedWitherLvl1;
import com.stel.stelschaosmod.common.entity.mobs.EntityImprovedWitherLvl2;
import com.stel.stelschaosmod.common.entity.mobs.EntityImprovedWitherLvl3;
import com.stel.stelschaosmod.common.items.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMaterialMatcher;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockImprovedWitherSkull extends BlockSkull {
    private BlockPattern witherPattern;
    private int witherLvl;
    EntityWither entityImprovedWither;
    BlockImprovedWitherSkull(String toolClass, int level, float hardness, float resistance, String name)
    {
        this.setHarvestLevel(toolClass, level);
        setHardness(hardness);
        setResistance(resistance);
        setCreativeTab(ModItems.spawnerMobTab);
        setRegistryName(name);
    }

    private static final Predicate<BlockWorldState> IS_WITHER_SKELETON = new Predicate<BlockWorldState>() {
        public boolean apply(@Nullable BlockWorldState p_apply_1_) {
            assert p_apply_1_ != null;
            p_apply_1_.getBlockState();
            return p_apply_1_.getBlockState().getBlock() == Blocks.SKULL && p_apply_1_.getTileEntity() instanceof TileEntitySkull && ((TileEntitySkull) p_apply_1_.getTileEntity()).getSkullType() == 1;
        }
    };


    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        checkWitherSpawn(worldIn, pos);
    }

    private BlockPattern getWitherPatternLvl1()
    {

            this.witherPattern = FactoryBlockPattern.start().aisle("^+^", "###", "~#~")
                    .where('#', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.SOUL_SAND)))
                    .where('^', IS_WITHER_SKELETON)
                    .where('~', BlockWorldState.hasState(BlockMaterialMatcher.forMaterial(Material.AIR)))
                    .where('+', BlockWorldState.hasState(BlockStateMatcher.forBlock(ModBlocks.ImprovedWitherSkull))).build();

        return this.witherPattern;
    }

    private BlockPattern getWitherPatternLvl2()
    {

            this.witherPattern = FactoryBlockPattern.start().aisle("+^+", "###", "~#~")
                    .where('#', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.SOUL_SAND)))
                    .where('^', IS_WITHER_SKELETON)
                    .where('~', BlockWorldState.hasState(BlockMaterialMatcher.forMaterial(Material.AIR)))
                    .where('+', BlockWorldState
                            .hasState(BlockStateMatcher.forBlock(ModBlocks.ImprovedWitherSkull))).build();

        return this.witherPattern;
    }

    private BlockPattern getWitherPatternLvl3()
    {
            this.witherPattern = FactoryBlockPattern.start().aisle("+++", "###", "~#~")
                    .where('#', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.SOUL_SAND)))
                    .where('~', BlockWorldState.hasState(BlockMaterialMatcher.forMaterial(Material.AIR)))
                    .where('+', BlockWorldState
                            .hasState(BlockStateMatcher.forBlock(ModBlocks.ImprovedWitherSkull))).build();

        return this.witherPattern;
    }


    /**
     * will spawn the new wither entity that will be added
     * @param worldIn the world where the game checks
     * @param pos the position of the block
     */
    private void checkWitherSpawn(World worldIn, BlockPos pos) {
        if (pos.getY() >= 2 && worldIn.getDifficulty() != EnumDifficulty.PEACEFUL && !worldIn.isRemote) {
            BlockPattern blockpattern = this.getWitherPatternLvl1();
            BlockPattern.PatternHelper blockpattern$patternhelper = blockpattern.match(worldIn, pos);
            if (blockpattern$patternhelper != null)
                witherLvl = 1;
            if(blockpattern$patternhelper == null)
            {
                blockpattern = this.getWitherPatternLvl2();
                blockpattern$patternhelper = blockpattern.match(worldIn, pos);
                if (blockpattern$patternhelper != null)
                    witherLvl = 2;
            }

            if(blockpattern$patternhelper == null)
            {
                blockpattern = this.getWitherPatternLvl3();
                blockpattern$patternhelper = blockpattern.match(worldIn, pos);
                if (blockpattern$patternhelper != null)
                    witherLvl = 3;
            }


            if (blockpattern$patternhelper != null) {
                for (int i = 0; i < 3; ++i) {
                    BlockWorldState blockworldstate = blockpattern$patternhelper.translateOffset(i, 0, 0);
                    worldIn.setBlockState(blockworldstate.getPos(), blockworldstate.getBlockState().withProperty(NODROP, Boolean.TRUE), 2);
                }

                for (int j = 0; j < blockpattern.getPalmLength(); ++j) {
                    for (int k = 0; k < blockpattern.getThumbLength(); ++k) {
                        BlockWorldState blockworldstate1 = blockpattern$patternhelper.translateOffset(j, k, 0);
                        worldIn.setBlockState(blockworldstate1.getPos(), Blocks.AIR.getDefaultState(), 2);
                    }
                }

                if(witherLvl == 1)
                    entityImprovedWither = new EntityImprovedWitherLvl1(worldIn);
                else if (witherLvl == 2)
                    entityImprovedWither = new EntityImprovedWitherLvl2(worldIn);
                else if (witherLvl == 3)
                    entityImprovedWither = new EntityImprovedWitherLvl3(worldIn);


                BlockPos blockpos1 = blockpattern$patternhelper.translateOffset(1, 2, 0).getPos();
                entityImprovedWither.setLocationAndAngles((double) blockpos1.getX() + 0.5D, (double) blockpos1.getY() + 0.55D, (double) blockpos1.getZ() + 0.5D, blockpattern$patternhelper.getForwards().getAxis() == EnumFacing.Axis.X ? 0.0F : 90.0F, 0.0F);
                entityImprovedWither.renderYawOffset = blockpattern$patternhelper.getForwards().getAxis() == EnumFacing.Axis.X ? 0.0F : 90.0F;
                if(witherLvl < 2)
                    entityImprovedWither.ignite();

                for (EntityPlayerMP entityplayermp : worldIn.getEntitiesWithinAABB(EntityPlayerMP.class, entityImprovedWither.getEntityBoundingBox().grow(50.0D))) {
                    CriteriaTriggers.SUMMONED_ENTITY.trigger(entityplayermp, entityImprovedWither);
                }

                worldIn.spawnEntity(entityImprovedWither);

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
