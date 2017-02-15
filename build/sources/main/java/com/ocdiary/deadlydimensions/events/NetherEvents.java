package com.ocdiary.deadlydimensions.events;

import com.ocdiary.deadlydimensions.config.DEConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NetherEvents {

    private static boolean NetherEffects = DEConfig.useNether;
    private static int potionID = DEConfig.potionEffectNether;
    private static int potionDuration = DEConfig.potionDurationNether * 24;
    private static int potionStrength = DEConfig.potionStrengthNether;
    private static boolean particles = DEConfig.netherParticles;

    @SubscribeEvent
    public void NetherEffects(LivingEvent.LivingUpdateEvent e){
        if(e.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntity();

            if (potionID != 0 && NetherEffects) {
                if (player.dimension == -1 && player.getActivePotionEffect(Potion.getPotionById(potionID)) == null) {
                    player.addPotionEffect(new PotionEffect(Potion.getPotionById(potionID), potionDuration, potionStrength, false, particles));
                }
            }
        }
    }
}
