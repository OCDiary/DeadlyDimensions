package ocdiary.deadlydimensions.util;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ocdiary.deadlydimensions.DeadlyDimensions;

@Mod.EventBusSubscriber
public class DEConfig {

    @SubscribeEvent
    public static void confChange(ConfigChangedEvent.OnConfigChangedEvent e){
        if(e.getModID().equals(DeadlyDimensions.MODID)){
            DEConfig.config();
        }
    }
    /**
     * This is now going to the config options and setup
     * This used to be a seperate class, but when re-writing
     * the mod it seemed more appropriate to condense it!
     * **/
    public static boolean useOverworld = true;
    public static String potionEffectOverworld;
    public static int potionStrengthOverworld;
    public static int potionDurationOverworld;
    public static boolean rainEffect = true;
    public static boolean overworldParticles = false;
    public static boolean overworldNightCycle = false;

    public static boolean useNether = true;
    public static String potionEffectNether;
    public static int potionStrengthNether;
    public static int potionDurationNether;
    public static boolean netherParticles = false;

    public static boolean useEnd = true;
    public static String potionEffectTheEnd;
    public static int potionStrengthTheEnd;
    public static int potionDurationTheEnd;
    public static boolean theEndParticles = false;

    public static boolean useCustom = true;
    public static int dimID;
    public static String potionEffectCustom;
    public static int potionStrengthCustom;
    public static int potionDurationCustom;
    public static boolean customParticles = false;

    public static String effectList;
    public static boolean makeItRain;
    public static int rainTime;


    public static void config() {

        MinecraftForge.EVENT_BUS.register(DeadlyDimensions.instance);

        final String POTIONIDS = DeadlyDimensions.config.CATEGORY_GENERAL + DeadlyDimensions.config.CATEGORY_SPLITTER + "Potion ID List";
        DeadlyDimensions.config.addCustomCategoryComment(POTIONIDS, "This is just a list of all the potion ID's available.");
        effectList = DeadlyDimensions.config.get(POTIONIDS, "See the id's of potion effects here:", "http://minecraft.gamepedia.com/Status_effect").getString();

        final String POTIONON = DeadlyDimensions.config.CATEGORY_GENERAL + DeadlyDimensions.config.CATEGORY_SPLITTER + "Potion Activations";
        DeadlyDimensions.config.addCustomCategoryComment(POTIONON, "Turn on or off the potion in the dimensions.");
        useOverworld = DeadlyDimensions.config.get(POTIONON, "1. Should potion effects be used in the Overworld?:", true).getBoolean();
        useNether = DeadlyDimensions.config.get(POTIONON, "2. Should potion effects be used in the Nether?:", true).getBoolean();
        useEnd = DeadlyDimensions.config.get(POTIONON, "3. Should potion effects be used in the End?:", true).getBoolean();
        makeItRain = DeadlyDimensions.config.get(POTIONON, "5. Should it rain on new player spawns?:", true).getBoolean();
        rainTime = DeadlyDimensions.config.get(POTIONON, "6. How long in mins should the initial rain last:", 3).getInt();

        final String OVERWORLD = DeadlyDimensions.config.CATEGORY_GENERAL + DeadlyDimensions.config.CATEGORY_SPLITTER + "Overworld Effects";
        DeadlyDimensions.config.addCustomCategoryComment(OVERWORLD, "All Overworld settings are here.");
        rainEffect = DeadlyDimensions.config.get(OVERWORLD, "Should rain stop the potion effects in the Overworld?:", true).getBoolean();
        overworldNightCycle = DeadlyDimensions.config.get(OVERWORLD, "Should the effects stop at night in the Overworld?:", false).getBoolean();
        overworldParticles = DeadlyDimensions.config.get(OVERWORLD, "Should player see particle effects for potion?:", false).getBoolean();
        potionEffectOverworld = DeadlyDimensions.config.get(OVERWORLD, "Overworld potion effect:", "minecraft:speed").getString();
        potionStrengthOverworld = DeadlyDimensions.config.get(OVERWORLD, "Overworld potion effect strength:", 1).getInt();
        potionDurationOverworld = DeadlyDimensions.config.get(OVERWORLD, "Overworld potion effect duration in seconds (min 3 recommended):", 5).getInt();

        final String NETHER = DeadlyDimensions.config.CATEGORY_GENERAL + DeadlyDimensions.config.CATEGORY_SPLITTER + "Nether Effects";
        DeadlyDimensions.config.addCustomCategoryComment(NETHER, "All Nether settings are here.");
        potionEffectNether = DeadlyDimensions.config.get(NETHER, "Nether potion effect ID:", "minecraft:fire_resistance").getString();
        potionStrengthNether = DeadlyDimensions.config.get(NETHER, "Nether potion effect strength:", 1).getInt();
        potionDurationNether = DeadlyDimensions.config.get(NETHER, "Nether potion effect duration in seconds (min 3 recommended):", 5).getInt();
        netherParticles = DeadlyDimensions.config.get(NETHER, "Should player see particle effects for potion?:", false).getBoolean();

        final String END = DeadlyDimensions.config.CATEGORY_GENERAL + DeadlyDimensions.config.CATEGORY_SPLITTER + "End Effects";
        DeadlyDimensions.config.addCustomCategoryComment(END, "All End settings are here.");
        potionEffectTheEnd = DeadlyDimensions.config.get(END, "End potion effect ID:", "minecraft:wither").getString();
        potionStrengthTheEnd = DeadlyDimensions.config.get(END, "End potion effect strength:", 1).getInt();
        potionDurationTheEnd = DeadlyDimensions.config.get(END, "End potion effect duration in seconds (min 3 recommended):", 5).getInt();
        theEndParticles = DeadlyDimensions.config.get(END, "Should player see particle effects for potion?:", false).getBoolean();

        final String CUSTOM = DeadlyDimensions.config.CATEGORY_GENERAL + DeadlyDimensions.config.CATEGORY_SPLITTER + "Custom Dimension Effects";
        DeadlyDimensions.config.addCustomCategoryComment(CUSTOM, "All custom dimension settings are here.");
        useCustom = DeadlyDimensions.config.get(CUSTOM, "1. Do you want to use a custom dimension?:", false).getBoolean();
        dimID = DeadlyDimensions.config.get(CUSTOM, "2. Please put a custom Dimension ID here (please note: -1, 0, and 1 will not work.):", "404").getInt();
        potionEffectCustom = DeadlyDimensions.config.get(CUSTOM, "3. Custom dimension potion effect ID:", "minecraft:jump_boost").getString();
        potionStrengthCustom = DeadlyDimensions.config.get(CUSTOM, "4. Custom dimension potion effect strength:", 1).getInt();
        potionDurationCustom = DeadlyDimensions.config.get(CUSTOM, "5. Custom dimension potion effect duration in seconds (min 3 recommended):", 5).getInt();
        customParticles = DeadlyDimensions.config.get(CUSTOM, "6. Should player see particle effects for potion?:", false).getBoolean();


        if(DeadlyDimensions.config.hasChanged()){
            DeadlyDimensions.config.save();
        }
    }
}
