package com.Stel.SpawnerMob.common.core.helper;

import com.Stel.SpawnerMob.SpawnerMob;
import com.Stel.SpawnerMob.common.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityHelper {
    private static int entityID = 0;
    public static void registerEntity(String name, Class<? extends Entity> entity, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, name), entity, name, entityID++, SpawnerMob.instance, 64, 3, true, color1, color2);
    }
}
