package gruntpie224.exptranslation.proxy;

import gruntpie224.exptranslation.init.ExpTranBlocks;
import gruntpie224.exptranslation.init.ExpTranItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {}
	public void init(FMLInitializationEvent event) {}
	public void postInit(FMLPostInitializationEvent event) {}
	public void serverStarting(FMLServerStartingEvent event) {}
	public void serverStopping(FMLServerStoppingEvent event) {}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		ExpTranBlocks.initBlocks();
		ExpTranBlocks.registerBlocks(event);
	}
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event)
	{
		ExpTranItems.initItems();
		ExpTranBlocks.registerBlockItems(event);
		ExpTranItems.registerItems(event);
	}
}
