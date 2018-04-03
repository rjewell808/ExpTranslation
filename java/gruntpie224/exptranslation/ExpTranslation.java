package gruntpie224.exptranslation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gruntpie224.exptranslation.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies="required-after:forge@[14.23.2.2611,)", useMetadata=true)

public class ExpTranslation
{
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;
    
    @Mod.Instance
    public static ExpTranslation instance;
    
    private static Logger logger = LogManager.getLogger(Reference.MOD_ID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger.info("Starting Pre-Init...");
    	proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	logger.info("Starting Init...");
    	proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	logger.info("Starting Post-Init...");
    	proxy.postInit(event);
    }
}
