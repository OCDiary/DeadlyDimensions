package com.ocdiary.deadlydimensions.events;

import com.ocdiary.deadlydimensions.config.DEConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by OCDiary on 02/01/2017.
 */
public class OverworldEvents {

    public static boolean rainE = DEConfig.rainEffect;
    public static boolean OverworldEffects = DEConfig.useOverworld;
    public static int potionID = DEConfig.potionEffectOverworld;
    public static int potionDuration = DEConfig.potionDurationOverworld * 24;
    public static int potionStrength = DEConfig.potionStrengthOverworld;
    public static boolean particles = DEConfig.overworldParticles;

    @SubscribeEvent
    public void OverworldEffects(LivingEvent.LivingUpdateEvent e){
        if(e.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntity();

            if (potionID != 0 && OverworldEffects) {
                if (rainE) {
                    if (!player.worldObj.isRaining() && player.dimension == 0 && player.getActivePotionEffect(Potion.getPotionById(potionID)) == null) {
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

    //Testing the idea of using effect at certain times.
    /*@SubscribeEvent
    public void checkTime(LivingEvent.LivingUpdateEvent e){
        if(e.getEntity() instanceof EntityPlayer) {
            EntityPlayer p = (EntityPlayer) e.getEntity();
            if (p.worldObj.getWorldTime() > 600 && p.worldObj.getWorldTime() < 900) {
                p.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 600, 10, false, false));
            }
        }

    }*/
}
