package com.stel.stelschaosmod.main;

import com.google.common.collect.Lists;
import com.stel.stelschaosmod.lib.Reference;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class StelsConfig {

    public static StelsConfig instance;
    private static ForgeConfigSpec configSpec;
    private static Set<ResourceLocation> spawnerWhitelist;
    private static BooleanValue isPower, eatRedstone, whitelistEnabled;
    private static boolean canPowerRedstone, canEatRedstone, isWhitelistEnabled;

    private final ForgeConfigSpec.ConfigValue<List<? extends String>> spawnerWhitelistConfigValue;
    private static Collection<EntityType<?>> entityTypes = ForgeRegistries.ENTITIES.getValues();
    private static ArrayList<EntityType> entityArrayList;

    public static void init() {
        Pair<StelsConfig, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(StelsConfig::new);
        configSpec = pair.getRight();
        StelsConfig.instance = pair.getLeft();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, configSpec);
    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        if (configEvent.getConfig().getSpec() == StelsConfig.configSpec)
            bake();
    }

    private static void bake() {
        spawnerWhitelist = instance.spawnerWhitelistConfigValue.get().stream()
                .map(ResourceLocation::new).collect(Collectors.toSet());
        canPowerRedstone = isPower.get();
        canEatRedstone = eatRedstone.get();
        //isWhitelistEnabled = whitelistEnabled.get();
        entityArrayList = filterEntities();
    }

    private StelsConfig(ForgeConfigSpec.Builder builder) {
        Predicate<Object> whitelistMobsTest = t -> t instanceof String;
        builder.push("General");
        spawnerWhitelistConfigValue = builder.comment("List with mob registry names of the entities that you want to be added to the spawner mob")
                .defineList("Mobs", this::defaultMobs,whitelistMobsTest);
        //whitelistEnabled = builder.comment("If the chaos spawn can use a custom list or not default is false")
        //        .define("whitelist enabled", true);
        isPower = builder.comment("Determines whether or not the redfish can power redstone.")
                .define("Power", true);
        eatRedstone = builder.comment("Determines whether or not the redfish can eat redstone.")
                .define("Eats Redstone", true);
        builder.pop();
    }

    public  List<ResourceLocation> getSpawn() { return new ArrayList<>(spawnerWhitelist);  }
    private Set<ResourceLocation> getSpawnerWhitelist() { return spawnerWhitelist;}

    //public boolean isWhitelistEnabled() { return  isWhitelistEnabled; }

    public boolean canpower() { return canPowerRedstone;    }

    public boolean canEatRedstone() { return canEatRedstone;    }

    public ArrayList<EntityType> getEntityArrayList() { return entityArrayList; }

    private List<String> defaultMobs()
    {
        return Lists.newArrayList("minecraft:bat","minecraft:cat","minecraft:cow" ,"minecraft:cod",
                "minecraft:dolphin", "minecraft:drowned", "minecraft:blaze", "minecraft:villager", "minecraft:sheep",
                "minecraft:chicken", "minecraft:witch", "minecraft:cave_spider", "minecraft:silverfish",
                "minecraft:skeleton", "minecraft:salmon", "minecraft:phantom", "minecraft:horse","minecraft:donkey",
                "minecraft:ocelot", "minecraft:creeper", "minecraft:elder_guardian","minecraft:enderman",
                "minecraft:endermite", "minecraft:evoker", "minecraft:fox", "minecraft:ghast", "minecraft:giant",
                "minecraft:guardian", "minecraft:husk", "minecraft:iron_golem", "minecraft:magma_cube",
                "minecraft:mooshroom", "minecraft:mule", "minecraft:llama", "minecraft:spider",
                "minecraft:wither_skeleton", "minecraft:vindiicator", "minecraft:turtle", "minecraft:wolf",
                "minecraft:stray", "minecraft:squid", "minecraft:slime", "minecraft:shulker", "minecraft:ravager",
                "minecraft:rabbit", "minecraft:mule", "minecraft:panda", "minecraft:parrot", "minecraft:pig",
                "minecraft:pillager", "minecraft:polar_bear", "minecraft:puffer_fish", "minecraft:skeleton_horse",
                "minecraft:tropical_fish", "minecraft:vex", "minecraft:trader_llama", "minecraft:wandering_trader",
                "minecraft:zombie_pigman", "minecraft:zombie", "minecraft:zombie_villager", "stelschaosmod:spawnermob",
                "stelschaosmod:redfish");
    }

    private static ArrayList<EntityType> filterEntities()
    {
        //if (isWhitelistEnabled)
        //{
            Set<ResourceLocation> whitelist = spawnerWhitelist;
            entityTypes = entityTypes.stream().filter(e -> whitelist.toString().contains(e.getRegistryName().
                    toString())).collect(Collectors.toList());
        //}
        return new ArrayList<>(entityTypes);
    }
}