package com.stel.stelschaosmod.generator;

import com.stel.stelschaosmod.lib.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;

public class ItemModels extends ItemModelProvider {

    public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Reference.MODID, existingFileHelper);
    }


    @Override
    protected void registerModels() {

    }



    @Override
    public String getName() {
        return "Item Models";
    }
}
