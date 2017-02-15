package com.ocdiary.deadlydimensions.config;

import com.ocdiary.deadlydimensions.DeadlyEnvironment;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by OCDiary on 02/01/2017.
 */
public class DEConfig {
    public static boolean useOverworld = true;
    public static int potionEffectOverworld;
    public static int potionStrengthOverworld;
    public static int potionDurationOverworld;
    public static boolean rainEffect = true;
    public static boolean overworldParticles = false;

    public static boolean useNether = true;
    public static int potionEffectNether;
    public static int potionStrengthNether;
    public static int potionDurationNether;
    public static boolean netherParticles = false;

    public static boolean useEnd = true;
    public static int potionEffectTheEnd;
    public static int potionStrengthTheEnd;
    public static int potionDurationTheEnd;
    public static boolean theEndParticles = false;

    public static String effectList;


    public static void config() {

        MinecraftForge.EVENT_BUS.register(DeadlyEnvironment.instance);

        final String POTIONIDS = DeadlyEnvironment.config.CATEGORY_GENERAL + DeadlyEnvironment.config.CATEGORY_SPLITTER + "Potion ID List";
        DeadlyEnvironment.config.addCustomCategoryComment(POTIONIDS, "This is just a list of all the potion ID's available.");
        effectList = DeadlyEnvironment.config.get(POTIONIDS, "See the id's of potion effects here:", "http://minecraft.gamepedia.com/Status_effect").getString();

        final String POTIONON = DeadlyEnvironment.config.CATEGORY_GENERAL + DeadlyEnvironment.config.CATEGORY_SPLITTER + "Potion Activations";
        DeadlyEnvironment.config.addCustomCategoryComment(POTIONON, "Turn on or off the potion in the dimensions.");
        useOverworld = DeadlyEnvironment.config.get(POTIONON, "1. Should potion effects be used in the Overworld?:", true).getBoolean();
        useNether = DeadlyEnvironment.config.get(POTIONON, "2. Should potion effects be used in the Nether?:", true).getBoolean();
        useEnd = DeadlyEnvironment.config.get(POTIONON, "3. Should potion effects be used in the End?:", true).getBoolean();


        final String OVERWORLD = DeadlyEnvironment.config.CATEGORY_GENERAL + DeadlyEnvironment.config.CATEGORY_SPLITTER + "Overworld Effects";
        DeadlyEnvironment.config.addCustomCategoryComment(OVERWORLD, "All Overworld settings are here.");
        rainEffect = DeadlyEnvironment.config.get(OVERWORLD, "Should rain stop the potion effects in the Overworld?:", true).getBoolean();
        overworldParticles = DeadlyEnvironment.config.get(OVERWORLD, "Should player see particle effects for potion?:", false).getBoolean();
        potionEffectOverworld = DeadlyEnvironment.config.get(OVERWORLD, "Overworld potion effect ID:", 1).getInt();
        potionStrengthOverworld = DeadlyEnvironment.config.get(OVERWORLD, "Overworld potion effect strength:", 1).getInt();
        potionDurationOverworld = DeadlyEnvironment.config.get(OVERWORLD, "Overworld potion effect duration in seconds (min 3 recommended):", 5).getInt();

        final String NETHER = DeadlyEnvironment.config.CATEGORY_GENERAL + DeadlyEnvironment.config.CATEGORY_SPLITTER + "Nether Effects";
        DeadlyEnvironment.config.addCustomCategoryComment(NETHER, "All Nether settings are here.");
        potionEffectNether = DeadlyEnvironment.config.get(NETHER, "Nether potion effect ID:", 12).getInt();
        potionStrengthNether = DeadlyEnvironment.config.get(NETHER, "Nether potion effect strength:", 1).getInt();
        potionDurationNether = DeadlyEnvironment.config.get(NETHER, "Nether potion effect duration in seconds (min 3 recommended):", 5).getInt();
        netherParticles = DeadlyEnvironment.config.get(NETHER, "Should player see particle effects for potion?:", false).getBoolean();

        final String END = DeadlyEnvironment.config.CATEGORY_GENERAL + DeadlyEnvironment.config.CATEGORY_SPLITTER + "End Effects";
        DeadlyEnvironment.config.addCustomCategoryComment(END, "All Nether settings are here.");
        potionEffectTheEnd = DeadlyEnvironment.config.get(END, "Nether potion effect ID:", 10).getInt();
        potionStrengthTheEnd = DeadlyEnvironment.config.get(END, "Nether potion effect strength:", 1).getInt();
        potionDurationTheEnd = DeadlyEnvironment.config.get(END, "Nether potion effect duration in seconds (min 3 recommended):", 5).getInt();
        theEndParticles = DeadlyEnvironment.config.get(END, "Should player see particle effects for potion?:", false).getBoolean();



        if(DeadlyEnvironment.config.hasChanged()){
            DeadlyEnvironment.config.save();
        }
    }
}
