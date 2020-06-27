package com.stel.stelschaosmod.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.stel.stelschaosmod.lib.Reference;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece;
import net.minecraft.world.gen.feature.template.*;


public class GnomeVillagePools {

    public static void init() {
        ImmutableList<StructureProcessor> immutablelist1 =
                ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.1F),
                        AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()))));

        ImmutableList<StructureProcessor> grassList =
                ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GRASS_BLOCK, 0.35F),
                        AlwaysTrueRuleTest.INSTANCE, Blocks.PODZOL.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GRASS_BLOCK, 0.40F),
                        AlwaysTrueRuleTest.INSTANCE, Blocks.COARSE_DIRT.getDefaultState()))));

        //houses
        JigsawManager.REGISTRY.register(
                new JigsawPattern(new ResourceLocation(Reference.MODID + ":village/gnome/houses"),
                        new ResourceLocation(Reference.MODID + ":village/gnome/terminators"),
                        ImmutableList.of(
                                new Pair<>(new SingleJigsawPiece(Reference.MODID + ":village/gnome/houses/big_house_01", immutablelist1), 1),
                                new Pair<>(new SingleJigsawPiece(Reference.MODID + ":village/gnome/houses/small_house_01", immutablelist1), 3),
                                new Pair<>(new SingleJigsawPiece(Reference.MODID + ":village/gnome/houses/farm_01", immutablelist1), 1),
                                new Pair<>(new SingleJigsawPiece(Reference.MODID + ":village/gnome/houses/bee_house", immutablelist1), 1),
                                new Pair<>(new SingleJigsawPiece(Reference.MODID + ":village/gnome/houses/bakery_house", immutablelist1), 1),
                                new Pair<>(new SingleJigsawPiece(Reference.MODID + ":village/gnome/houses/smith_house", immutablelist1), 1),
                                new Pair<>(new SingleJigsawPiece(Reference.MODID + ":village/gnome/houses/fishing_house", immutablelist1), 1),
                                new Pair<>(new SingleJigsawPiece(Reference.MODID + ":village/gnome/houses/cartographer_01", immutablelist1), 1)
                        ), JigsawPattern.PlacementBehaviour.RIGID));
        
        //roads
        JigsawManager.REGISTRY.register(new JigsawPattern(
                new ResourceLocation(Reference.MODID + ":village/gnome/streets"),
                new ResourceLocation(Reference.MODID + ":village/gnome/terminators"),
                ImmutableList.of(
                        new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/streets/corner_01", immutablelist1), 2),
                        new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/streets/straight_01", immutablelist1), 3),
                        //new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/streets/straight_02", immutablelist1), 2),
                        new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/streets/straight_03", grassList), 2),
                        new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/streets/cross_01", immutablelist1), 1)),
                JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));

        //decor
        JigsawManager.REGISTRY.register(new JigsawPattern(
                new ResourceLocation(Reference.MODID + ":village/gnome/decor"),
                new ResourceLocation(Reference.MODID + ":empty"), ImmutableList.of(
                        new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/decor/lamp_01"), 2)),
                JigsawPattern.PlacementBehaviour.RIGID));

        //towncenters
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Reference.MODID + ":village/gnome/town_center"),
                new ResourceLocation(Reference.MODID + ":empty"), ImmutableList.of(new Pair(
                        new SingleJigsawPiece(Reference.MODID + ":village/gnome/town_center/meeting_01"), 2)),
                JigsawPattern.PlacementBehaviour.RIGID));



        //terminators
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Reference.MODID + ":village/gnome/terminators"), new ResourceLocation("empty"),
                ImmutableList.of(new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/terminators/terminator_01", immutablelist1), 1)),
                JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));

    }
}
