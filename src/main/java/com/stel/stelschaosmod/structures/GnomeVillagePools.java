package com.stel.stelschaosmod.structures;
        ;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.stel.stelschaosmod.lib.Reference;
import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
        import net.minecraft.world.biome.DefaultBiomeFeatures;
        import net.minecraft.world.gen.feature.Feature;
        import net.minecraft.world.gen.feature.jigsaw.*;
        import net.minecraft.world.gen.feature.template.*;

public class GnomeVillagePools {
    public static void init() {
        ImmutableList<StructureProcessor> immutablelist1 =
                ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.1F),
                        AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()))));

        //roads
        JigsawManager.REGISTRY.register(new JigsawPattern(
                new ResourceLocation(Reference.MODID + ":village/gnome/streets"),
                new ResourceLocation(Reference.MODID + ":village/gnome/terminators"),
                ImmutableList.of(
                        new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/streets/corner_01", immutablelist1), 2),
                        new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/streets/straight_01", immutablelist1), 2),
                        new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/streets/straight_02", immutablelist1), 2),
                        new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/streets/cross_01", immutablelist1), 1)                        ),
                JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));

        //decor
        JigsawManager.REGISTRY.register(new JigsawPattern(
                new ResourceLocation(Reference.MODID + ":village/gnome/decor"),
                new ResourceLocation("empty"), ImmutableList.of(
                        new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/decor/lamp_01"), 2)),
                JigsawPattern.PlacementBehaviour.RIGID));

        //towncenters
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Reference.MODID + ":village/gnome/town_center"),
                new ResourceLocation("empty"), ImmutableList.of(new Pair(
                        new SingleJigsawPiece(Reference.MODID + ":village/gnome/town_center/meeting_01"), 2)),
                JigsawPattern.PlacementBehaviour.RIGID));

        //houses
        JigsawManager.REGISTRY.register(
                new JigsawPattern(new ResourceLocation(Reference.MODID + ":village/gnome/houses"),
                        new ResourceLocation(Reference.MODID + ":village/gnome/terminators"),
                        ImmutableList.of(
                                new Pair<>(new SingleJigsawPiece(Reference.MODID + ":village/gnome/houses/big_house_01", immutablelist1), 1),
                                new Pair<>(new SingleJigsawPiece(Reference.MODID + ":village/gnome/houses/small_house_01", immutablelist1), 1)
                        ), JigsawPattern.PlacementBehaviour.RIGID));

        //terminators
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Reference.MODID + ":village/gnome/terminators"), new ResourceLocation("empty"),
                ImmutableList.of(new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/terminators/terminator_01", immutablelist1), 1)),
                JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));

    }
}
