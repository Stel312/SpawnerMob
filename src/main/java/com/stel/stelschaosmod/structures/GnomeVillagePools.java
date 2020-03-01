package com.stel.stelschaosmod.structures;
        ;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.stel.stelschaosmod.lib.Reference;
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
        ImmutableList<StructureProcessor> immutablelist1 =
                ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.1F),
                        AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()))));

        JigsawManager.REGISTRY.register(new JigsawPattern(
                new ResourceLocation(Reference.MODID + ":village/gnome/streets"),
                new ResourceLocation(Reference.MODID + ":village/gnome/terminators"),
                ImmutableList.of(
                        new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/streets/corner_01", immutablelist1), 1),
                        new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/streets/straight_01", immutablelist1), 1),
                        new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/streets/cross_01", immutablelist1), 1)                        ),
                JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));

        JigsawManager.REGISTRY.register(
                new JigsawPattern(new ResourceLocation(Reference.MODID + ":village/gnome/houses"),
                        new ResourceLocation(Reference.MODID + ":village/gnome/terminators"),
                        ImmutableList.of(new Pair<>(new SingleJigsawPiece(Reference.MODID + ":village/gnome/houses/big_house_01", immutablelist1), 1)),

                        JigsawPattern.PlacementBehaviour.RIGID));
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Reference.MODID + ":village/gnome/terminators"), new ResourceLocation("empty"),
                ImmutableList.of(new Pair(new SingleJigsawPiece(Reference.MODID + ":village/gnome/terminators/terminator_01", immutablelist1), 1)),
                JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));

        //JigsawManager.field_214891_a.register(new JigsawPattern(new ResourceLocation("village/plains/zombie/houses"), new ResourceLocation("village/plains/terminators"), ImmutableList.of(new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_small_house_1", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_small_house_2", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_small_house_3", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_small_house_4", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_small_house_5", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_small_house_6", lvt_0_1_), 1), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_small_house_7", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_small_house_8", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_medium_house_1", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_medium_house_2", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_big_house_1", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/houses/plains_butcher_shop_1", lvt_0_1_), 2), new Pair[]{new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_butcher_shop_2", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/houses/plains_tool_smith_1", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_fletcher_house_1", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_shepherds_house_1", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/houses/plains_armorer_house_1", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/houses/plains_fisher_cottage_1", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/houses/plains_tannery_1", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/houses/plains_cartographer_1", lvt_0_1_), 1), new Pair(new SingleJigsawPiece("village/plains/houses/plains_library_1", lvt_0_1_), 3), new Pair(new SingleJigsawPiece("village/plains/houses/plains_library_2", lvt_0_1_), 1), new Pair(new SingleJigsawPiece("village/plains/houses/plains_masons_house_1", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/houses/plains_weaponsmith_1", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/houses/plains_temple_3", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/houses/plains_temple_4", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_stable_1", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/houses/plains_stable_2", lvt_0_1_), 2), new Pair(new SingleJigsawPiece("village/plains/houses/plains_large_farm_1", lvt_0_1_), 4), new Pair(new SingleJigsawPiece("village/plains/houses/plains_small_farm_1", lvt_0_1_), 4), new Pair(new SingleJigsawPiece("village/plains/houses/plains_animal_pen_1", lvt_0_1_), 1), new Pair(new SingleJigsawPiece("village/plains/houses/plains_animal_pen_2", lvt_0_1_), 1), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_animal_pen_3", lvt_0_1_), 5), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_meeting_point_4", lvt_0_1_), 3), new Pair(new SingleJigsawPiece("village/plains/zombie/houses/plains_meeting_point_5", lvt_0_1_), 1), Pair.of(EmptyJigsawPiece.INSTANCE, 10)}), JigsawPattern.PlacementBehaviour.RIGID));

    }
    static {

    }
}
