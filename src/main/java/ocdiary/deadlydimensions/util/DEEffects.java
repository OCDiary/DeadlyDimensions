package ocdiary.deadlydimensions.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber
public class DEEffects {

    /**
     * OVERWORLD
     * */
    private static boolean rainE = DEConfig.rainEffect;
    private static boolean OverworldEffects = DEConfig.useOverworld;
    private static String potionID = DEConfig.potionEffectOverworld;
    private static int potionDuration = DEConfig.potionDurationOverworld * 24;
    private static int potionStrength = DEConfig.potionStrengthOverworld;
    private static boolean particles = DEConfig.overworldParticles;
    private static Potion potionEffectOverworld = Potion.getPotionFromResourceLocation(potionID);
    private static boolean nightCycle = DEConfig.overworldNightCycle;


    //This is handling the adding the effect to the player in the overworld.
    @SubscribeEvent
    public static void OverworldEffec(TickEvent.PlayerTickEvent e){
        EntityPlayer player = e.player;
        if(!player.world.isRemote){
            if(potionEffectOverworld != null && OverworldEffects){
                if(rainE){
                    if(nightCycle){
                        if(!player.world.isRaining() && player.dimension == 0 && player.getActivePotionEffect(potionEffectOverworld)== null && player.world.isDaytime()) {
                            player.addPotionEffect(new PotionEffect(potionEffectOverworld, potionDuration, potionStrength, false, particles));
                            }
                    }else{
                        if(!player.world.isRaining() && player.dimension == 0 && player.getActivePotionEffect(potionEffectOverworld)== null) {
                            player.addPotionEffect(new PotionEffect(potionEffectOverworld, potionDuration, potionStrength, false, particles));
                        }
                    }
                }

                if(!rainE){
                    if(nightCycle) {
                        if (player.dimension == 0 && player.getActivePotionEffect(potionEffectOverworld) == null && player.world.isDaytime()) {
                            player.addPotionEffect(new PotionEffect(potionEffectOverworld, potionDuration, potionStrength, false, particles));
                        }
                    }else {
                        if (player.dimension == 0 && player.getActivePotionEffect(potionEffectOverworld) == null) {
                            player.addPotionEffect(new PotionEffect(potionEffectOverworld, potionDuration, potionStrength, false, particles));
                        }
                    }
                }
            }
        }
    }


    /**
     * NETHER
     * */
    private static boolean NetherEffects = DEConfig.useNether;
    private static String potionIDN = DEConfig.potionEffectNether;
    private static int potionDurationN = DEConfig.potionDurationNether * 24;
    private static int potionStrengthN = DEConfig.potionStrengthNether;
    private static boolean particlesN = DEConfig.netherParticles;
    private static Potion potionEffectNether = Potion.getPotionFromResourceLocation(potionIDN);

    //This is handling the adding the effect to the player in the nether.
    @SubscribeEvent
    public static void NetherEffects(TickEvent.PlayerTickEvent e) {
        EntityPlayer player = e.player;
        if (!player.world.isRemote) {
                if (potionEffectNether != null && NetherEffects) {
                    if (player.dimension == -1 && player.getActivePotionEffect(potionEffectNether) == null) {
                        player.addPotionEffect(new PotionEffect(potionEffectNether, potionDurationN, potionStrengthN, false, particlesN));
                    }
                }
            }
    }

    /**
     * THE END
     * */
    private static boolean EndEffects = DEConfig.useEnd;
    private static String potionIDE = DEConfig.potionEffectTheEnd;
    private static int potionDurationE = DEConfig.potionDurationTheEnd * 24;
    private static int potionStrengthE = DEConfig.potionStrengthTheEnd;
    private static boolean endParticles = DEConfig.theEndParticles;
    private static Potion potionEffectEnd = Potion.getPotionFromResourceLocation(potionIDE);

    //This is handling the adding the effect to the player in the end.
    @SubscribeEvent
    public static void EndEffects(TickEvent.PlayerTickEvent e){
        EntityPlayer player = e.player;
        if (!player.world.isRemote) {
                if (potionEffectEnd != null && EndEffects) {
                    if (player.dimension == 1 && player.getActivePotionEffect(potionEffectEnd) == null && player.world.isDaytime()) {
                        player.addPotionEffect(new PotionEffect(potionEffectEnd, potionDurationE, potionStrengthE, false, endParticles));
                    }
                }
            }
    }


    /**
     * Custom Dim
     * */
    private static boolean CustomEffects = DEConfig.useCustom;
    private static String potionIDC = DEConfig.potionEffectCustom;
    private static int cDimID = DEConfig.dimID;
    private static int potionDurationC = DEConfig.potionDurationCustom * 24;
    private static int potionStrengthC = DEConfig.potionStrengthCustom;
    private static boolean customParticles = DEConfig.customParticles;
    private static Potion potionEffectCustom = Potion.getPotionFromResourceLocation(potionIDC);

    //This is handling the adding the effect to the player in the custom dimension.
    @SubscribeEvent
    public static void CustomEffects(TickEvent.PlayerTickEvent e){
        EntityPlayer player = e.player;
        if (!player.world.isRemote) {
                if (potionEffectCustom != null && CustomEffects) {
                    if (cDimID != -1 && cDimID != 0 && cDimID != 1) {
                        if (player.dimension == cDimID && player.getActivePotionEffect(potionEffectCustom) == null && player.world.isDaytime()) {
                            player.addPotionEffect(new PotionEffect(potionEffectCustom, potionDurationC, potionStrengthC, false, customParticles));
                        }
                    }
                }
            }
    }


    /**
     * WORLD JOIN EVENT
     */

    private static final String PLAYER_NEW = ("make_rain");
    private static int timer;

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent e) {
        if(DEConfig.makeItRain) {
            NBTTagCompound player = e.player.getEntityData();
            NBTTagCompound data = getTag(player, EntityPlayer.PERSISTED_NBT_TAG);

            if(!data.getBoolean(PLAYER_NEW)) {
                timer = (DEConfig.rainTime * 60) * 20;
                //e.player.world.getWorldInfo().setRaining(true);
                e.player.sendMessage(new TextComponentString("Starting initial rain, it will last: " + ((timer / 20) / 60) + "mins"));
                data.setBoolean(PLAYER_NEW, true);
                player.setTag(EntityPlayer.PERSISTED_NBT_TAG, data);
            }
        }
    }


    private static NBTTagCompound getTag(NBTTagCompound tag, String key) {
        if(tag == null || !tag.hasKey(key)) {
            return new NBTTagCompound();
        }

        return tag.getCompoundTag(key);
    }


    @SubscribeEvent
    public static void rainControl(TickEvent.PlayerTickEvent e){
        if(!e.player.world.isRemote){
            if(timer > 0){
                e.player.world.getWorldInfo().setRaining(true);
                timer--;
            }else if(timer == 0){
                e.player.world.getWorldInfo().setRaining(false);
                timer--;
            }
            sendMessage(e.player);
        }
    }

    private static void sendMessage(EntityPlayer player){
        if(timer == 600)
            player.sendMessage(new TextComponentString("Quick, only 30 seconds of rain left!"));
        if(timer == 0)
            player.sendMessage(new TextComponentString("The rain is now stopping, good luck!"));
    }
}
