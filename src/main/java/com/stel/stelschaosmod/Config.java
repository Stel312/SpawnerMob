package com.stel.stelschaosmod;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;




public class Config {


    public static Config instance;

    private List<String> spawnerBlacklist;




    public static void init() {

        Pair<Config, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(Config::new);
        ForgeConfigSpec configSpec = pair.getRight();
        Config.instance = pair.getLeft();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, configSpec);
    }


    public Config(ForgeConfigSpec.Builder builder) {
        this.spawnerBlacklist = new ArrayList<>();
        builder.push("Spawner Blacklist");
        {
            Predicate<Object> bannedMobsTest = t -> {
                if (!(t instanceof String))
                    return false;
                String str = (String) t;
                return true;
            };
            this.spawnerBlacklist.add("minecraft:cow");
            this.spawnerBlacklist.add("minecraft:blaze");
            this.spawnerBlacklist.add("minecraft:cat");
            this.spawnerBlacklist.add("minecraft:villager");
            this.spawnerBlacklist.add("minecraft:sheep");
            this.spawnerBlacklist.add("minecraft:chicken");
            this.spawnerBlacklist.add("minecraft:bat");
            this.spawnerBlacklist.add("minecraft:witch");
            this.spawnerBlacklist.add("minecraft:cave_spider");
            this.spawnerBlacklist.add("minecraft:zombie");
            this.spawnerBlacklist.add("minecraft:zombe_villager");
            this.spawnerBlacklist.add("minecraft:silverfish");
            this.spawnerBlacklist.add("minecraft:skeleton");
            this.spawnerBlacklist.add("minecraft:cod");
            this.spawnerBlacklist.add("minecraft:salmon");
            this.spawnerBlacklist.add("minecraft:phantom");
            this.spawnerBlacklist.add("minecraft:horse");
            this.spawnerBlacklist.add("minecraft:donkey");
            this.spawnerBlacklist.add("minecraft:ocelot");
            this.spawnerBlacklist.add("minecraft:creeper");
            this.spawnerBlacklist.add("minecraft:dolphin");
            this.spawnerBlacklist.add("minecraft:drowned");
            this.spawnerBlacklist.add("minecraft:elder_guardian");
            this.spawnerBlacklist.add("minecraft:enderman");
            this.spawnerBlacklist.add("minecraft:endermite");
            this.spawnerBlacklist.add("minecraft:evoker");
            this.spawnerBlacklist.add("minecraft:fox");
            this.spawnerBlacklist.add("minecraft:ghast");
            this.spawnerBlacklist.add("minecraft:giant");
            this.spawnerBlacklist.add("minecraft:guardian");
            this.spawnerBlacklist.add("minecraft:husk");
            this.spawnerBlacklist.add("minecraft:iron_golem");
            this.spawnerBlacklist.add("minecraft:magma_cube");
            this.spawnerBlacklist.add("minecraft:mooshroom");
            this.spawnerBlacklist.add("minecraft:mule");
            this.spawnerBlacklist.add("minecraft:llama");
            this.spawnerBlacklist.add("minecraft:spider");
            this.spawnerBlacklist.add("minecraft:wither_skeleton");
            this.spawnerBlacklist.add("minecraft:vindiicator");
            this.spawnerBlacklist.add("minecraft:turtle");
            this.spawnerBlacklist.add("minecraft:wolf");
            this.spawnerBlacklist.add("minecraft:stray");
            this.spawnerBlacklist.add("minecraft:squid");
            this.spawnerBlacklist.add("minecraft:slime");
            this.spawnerBlacklist.add("minecraft:shulker");
            this.spawnerBlacklist.add("minecraft:ravager");
            this.spawnerBlacklist.add("minecraft:rabbit");
            this.spawnerBlacklist.add("minecraft:mule");
            this.spawnerBlacklist.add("minecraft:panda");
            this.spawnerBlacklist.add("minecraft:parrot");
            this.spawnerBlacklist.add("minecraft:pig");
            this.spawnerBlacklist.add("minecraft:pillager");
            this.spawnerBlacklist.add("minecraft:polar_bear");
            this.spawnerBlacklist.add("minecraft:puffer_fish");
            this.spawnerBlacklist.add("minecraft:skeleton_horse");
            this.spawnerBlacklist.add("minecraft:tropical_fish");
            this.spawnerBlacklist.add("minecraft:vex");
            this.spawnerBlacklist.add("minecraft:trader_llama");
            this.spawnerBlacklist.add("minecraft:wandering_trader");
            this.spawnerBlacklist.add("minecraft:zombie_pigman");
            this.spawnerBlacklist.add("stelschaosmod:spawnermob");
            this.spawnerBlacklist.add("stelschaosmod:redfish");
            builder.comment("List with mob registry names of the entities that you want to be added to the spawner mob")
                    .defineList("Mobs", this.spawnerBlacklist, bannedMobsTest);
        }

        builder.pop();

    }



    public String[] getSpawnerBlacklist() {

        return Arrays.copyOf(this.spawnerBlacklist.toArray(), this.spawnerBlacklist.toArray().length, String[].class);

    }

}