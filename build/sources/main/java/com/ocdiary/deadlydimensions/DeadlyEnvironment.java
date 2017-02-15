package com.ocdiary.deadlydimensions;

import com.ocdiary.deadlydimensions.config.DEConfig;
import com.ocdiary.deadlydimensions.lib.refs;
import com.ocdiary.deadlydimensions.events.EndEvents;
import com.ocdiary.deadlydimensions.events.NetherEvents;
import com.ocdiary.deadlydimensions.events.OverworldEvents;
import com.ocdiary.deadlydimensions.proxies.common;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.common.config.Configuration;


@Mod(modid = refs.MODID, name = refs.NAME, version = refs.VERSION, acceptedMinecraftVersions = refs.AVERSION)
public class DeadlyEnvironment {

    @Instance
    public static DeadlyEnvironment instance;

    @SidedProxy(clientSide = refs.CPROX, serverSide = refs.SPROX)
    public static common proxy;

    public static Configuration config;

    public static Logger log = FMLLog.getLogger();


    @EventHandler
    public void preInit(FMLPreInitializationEvent e){
        log.info("Deadly Environment Pre-Init");

        config = new Configuration(e.getSuggestedConfigurationFile());
        DEConfig.config();


    }


    @EventHandler
    public void init(FMLInitializationEvent e){
        log.info("Deadly Environment Init");


    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e){
        log.info("Deadly Environment Post-Init");

        MinecraftForge.EVENT_BUS.register(new OverworldEvents());
        MinecraftForge.EVENT_BUS.register(new NetherEvents());
        MinecraftForge.EVENT_BUS.register(new EndEvents());
    }


    @SubscribeEvent
    public void confChange(ConfigChangedEvent.OnConfigChangedEvent e){
        if(e.getModID().equals(refs.MODID)){
            DEConfig.config();
        }
    }


}
