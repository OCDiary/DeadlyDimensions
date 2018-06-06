package ocdiary.deadlydimensions;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ocdiary.deadlydimensions.proxy.CommonProxy;
import ocdiary.deadlydimensions.util.DEConfig;
import org.apache.logging.log4j.Logger;


@Mod(modid = DeadlyDimensions.MODID, name = DeadlyDimensions.NAME, version = DeadlyDimensions.VERSION, acceptedMinecraftVersions = DeadlyDimensions.AVERSION)
public class DeadlyDimensions {

    public static final String MODID = "deadlydimensions";
    public static final String NAME = "Deadly Dimensions";
    public static final String VERSION = "@VERSION@"; //This is replaced in the build.gradle;
    public static final String AVERSION = "[1.12, 1.12.2]";


    public static final String CPROX = "ocdiary.deadlydimensions.proxy.ClientProxy";
    public static final String SPROX = "ocdiary.deadlydimensions.proxy.CommonProxy";

    @Instance
    public static DeadlyDimensions instance;

    @SidedProxy(clientSide = DeadlyDimensions.CPROX, serverSide = DeadlyDimensions.SPROX)
    public static CommonProxy proxy;

    public static Configuration config;

    public static Logger log = FMLLog.getLogger();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e){
        log.info("Deadly Environment Pre-Init");
        proxy.preInit(e);

        config = new Configuration(e.getSuggestedConfigurationFile());
        DEConfig.config();
    }
    @EventHandler
    public void init(FMLInitializationEvent e){
        log.info("Deadly Environment Init");
        proxy.init(e);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent e){
        log.info("Deadly Environment Post-Init");
        proxy.postInit(e);
    }
}
