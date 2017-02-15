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
public class EndEvents {
    public static boolean EndEffects = DEConfig.useEnd;
    public static int potionID = DEConfig.potionEffectTheEnd;
    public static int potionDuration = DEConfig.potionDurationTheEnd * 24;
    public static int potionStrength = DEConfig.potionStrengthTheEnd;
    public static boolean endParticles = DEConfig.theEndParticles;

    @SubscribeEvent
    public void EndEffects(LivingEvent.LivingUpdateEvent e){
        if(e.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntity();

            if (potionID != 0 && EndEffects) {
                if (player.dimension == 1 && player.getActivePotionEffect(Potion.getPotionById(potionID)) == null) {
                    player.addPotionEffect(new PotionEffect(Potion.getPotionById(potionID), potionDuration, potionStrength, false, endParticles));
                }
            }
        }
    }
}
