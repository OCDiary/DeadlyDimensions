package com.ocdiary.deadlydimensions.events;

import com.ocdiary.deadlydimensions.DeadlyDimensions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber
public class DEEvents {


    /**
     * OVERWORLD
     * */
    public static boolean rainE = DeadlyDimensions.rainEffect;
    public static boolean OverworldEffects = DeadlyDimensions.useOverworld;
    public static int potionID = DeadlyDimensions.potionEffectOverworld;
    public static int potionDuration = DeadlyDimensions.potionDurationOverworld * 24;
    public static int potionStrength = DeadlyDimensions.potionStrengthOverworld;
    public static boolean particles = DeadlyDimensions.overworldParticles;

    @SubscribeEvent
    public static void OverworldEffects(LivingEvent.LivingUpdateEvent e){
        if(e.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntity();

            if (potionID != 0 && OverworldEffects) {
                if (rainE) {
                    if (!player.world.isRaining() && player.dimension == 0 && player.getActivePotionEffect(Potion.getPotionById(potionID)) == null) {
                        player.addPotionEffect(new PotionEffect(Potion.getPotionById(potionID), potionDuration, potionStrength, false, particles));
                    }
                }
                if (!rainE) {
                    if (player.dimension == 0 && player.getActivePotionEffect(Potion.getPotionById(potionID)) == null) {
                        player.addPotionEffect(new PotionEffect(Potion.getPotionById(potionID), potionDuration, potionStrength, false, particles));
                    }
                }
            }
        }
    }

    /**
     * NETHER
     * */

    private static boolean NetherEffects = DeadlyDimensions.useNether;
    private static int potionIDN = DeadlyDimensions.potionEffectNether;
    private static int potionDurationN = DeadlyDimensions.potionDurationNether * 24;
    private static int potionStrengthN = DeadlyDimensions.potionStrengthNether;
    private static boolean particlesN = DeadlyDimensions.netherParticles;

    @SubscribeEvent
    public static void NetherEffects(LivingEvent.LivingUpdateEvent e){
        if(e.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntity();

            if (potionIDN != 0 && NetherEffects) {
                if (player.dimension == -1 && player.getActivePotionEffect(Potion.getPotionById(potionIDN)) == null) {
                    player.addPotionEffect(new PotionEffect(Potion.getPotionById(potionIDN), potionDurationN, potionStrengthN, false, particlesN));
                }
            }
        }
    }

    /**
     * THE END
     * */
    public static boolean EndEffects = DeadlyDimensions.useEnd;
    public static int potionIDE = DeadlyDimensions.potionEffectTheEnd;
    public static int potionDurationE = DeadlyDimensions.potionDurationTheEnd * 24;
    public static int potionStrengthE = DeadlyDimensions.potionStrengthTheEnd;
    public static boolean endParticles = DeadlyDimensions.theEndParticles;

    @SubscribeEvent
    public static void EndEffects(LivingEvent.LivingUpdateEvent e){
        if(e.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntity();

            if (potionIDE != 0 && EndEffects) {
                if (player.dimension == 1 && player.getActivePotionEffect(Potion.getPotionById(potionIDE)) == null) {
                    player.addPotionEffect(new PotionEffect(Potion.getPotionById(potionIDE), potionDurationE, potionStrengthE, false, endParticles));
                }
            }
        }
    }


    public static boolean CustomEffects = DeadlyDimensions.useCustom;
    public static int potionIDC = DeadlyDimensions.potionEffectCustom;
    public static int cDimID = DeadlyDimensions.dimID;
    public static int potionDurationC = DeadlyDimensions.potionDurationCustom * 24;
    public static int potionStrengthC = DeadlyDimensions.potionStrengthCustom;
    public static boolean customParticles = DeadlyDimensions.customParticles;

    @SubscribeEvent
    public static void CustomEffects(LivingEvent.LivingUpdateEvent e){
        if(e.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntity();

            if (potionIDC != 0 && CustomEffects) {
                if (cDimID != -1 && cDimID != 0 && cDimID != 1) {
                    if (player.dimension == cDimID && player.getActivePotionEffect(Potion.getPotionById(potionIDC)) == null) {
                        player.addPotionEffect(new PotionEffect(Potion.getPotionById(potionIDC), potionDurationC, potionStrengthC, false, customParticles));
                    }
                }
            }
        }
    }
    /**
     * WORLD JOIN EVENT
     */

    public static final String PLAYER_NEW = ("make_rain");

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent e) {
        if(DeadlyDimensions.makeItRain) {
            NBTTagCompound player = e.player.getEntityData();
            NBTTagCompound data = getTag(player, EntityPlayer.PERSISTED_NBT_TAG);

            if(!data.getBoolean(PLAYER_NEW)) {
                e.player.world.getWorldInfo().setRaining(true);
                data.setBoolean(PLAYER_NEW, true);
                player.setTag(EntityPlayer.PERSISTED_NBT_TAG, data);
            }
        }
    }


    public static NBTTagCompound getTag(NBTTagCompound tag, String key) {
        if(tag == null || !tag.hasKey(key)) {
            return new NBTTagCompound();
        }

        return tag.getCompoundTag(key);
    }
}
