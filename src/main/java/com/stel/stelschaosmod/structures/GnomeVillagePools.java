package com.stel.stelschaosmod.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.jigsaw.EmptyJigsawPiece;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece;
import net.minecraft.world.gen.feature.template.*;

public class GnomeVillagePools {
    public static void init() {


            ImmutableList<StructureProcessor> immutablelist = ImmutableList.of(new RuleStructureProcessor(
                    ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.8F),
                                    AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()),
                            new RuleEntry(new TagMatchRuleTest(BlockTags.DOORS), AlwaysTrueRuleTest.INSTANCE,
                                    Blocks.AIR.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.TORCH),
                                    AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()),
                            new RuleEntry(new BlockMatchRuleTest(Blocks.WALL_TORCH), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()),
                            new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.07F),
                                    AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
                            new RuleEntry(new RandomBlockMatchRuleTest(Blocks.MOSSY_COBBLESTONE, 0.07F), AlwaysTrueRuleTest.INSTANCE,
                                    Blocks.COBWEB.getDefaultState()),
                            new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHITE_TERRACOTTA, 0.07F),
                                    AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
                            new RuleEntry(new RandomBlockMatchRuleTest(Blocks.OAK_LOG, 0.05F),
                                    AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
                            new RuleEntry(new RandomBlockMatchRuleTest(Blocks.OAK_PLANKS, 0.1F),
                                    AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
                            new RuleEntry(new RandomBlockMatchRuleTest(Blocks.OAK_STAIRS, 0.1F),
                                    AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
                            new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STRIPPED_OAK_LOG, 0.02F),
                                    AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
                            new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GLASS_PANE, 0.5F),
                                    AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
                            new RuleEntry(new BlockStateMatchRuleTest(Blocks.GLASS_PANE.getDefaultState().with(PaneBlock.NORTH,
                                    Boolean.TRUE).with(PaneBlock.SOUTH, Boolean.TRUE)),
                                    AlwaysTrueRuleTest.INSTANCE, Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState().with(PaneBlock.NORTH,
                                    Boolean.TRUE).with(PaneBlock.SOUTH, Boolean.TRUE)),
                            new RuleEntry(new BlockStateMatchRuleTest(Blocks.GLASS_PANE.getDefaultState().with(PaneBlock.EAST,
                                    Boolean.TRUE).with(PaneBlock.WEST, Boolean.TRUE)), AlwaysTrueRuleTest.INSTANCE,
                                    Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState().with(PaneBlock.EAST, Boolean.TRUE).with(PaneBlock.WEST,
                                            Boolean.TRUE)))));
            ImmutableList<StructureProcessor> immutablelist1 = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()))));
            JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation("village/gnome/houses"),
                    new ResourceLocation("village/﻿gnome/terminators"),
                    ImmutableList.of(new Pair<>(new SingleJigsawPiece("village/gnome/gnomehouse1", immutablelist1), 8)),
                    JigsawPattern.PlacementBehaviour.RIGID));


    }
}
