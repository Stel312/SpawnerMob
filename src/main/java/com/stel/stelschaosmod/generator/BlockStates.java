package com.stel.stelschaosmod.generator;

import com.stel.stelschaosmod.lib.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Reference.MODID,  exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {


    }
}
