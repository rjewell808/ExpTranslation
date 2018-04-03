package gruntpie224.exptranslation.init;

import gruntpie224.exptranslation.blocks.BlockExpTranslator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ExpTranBlocks {
	
	@GameRegistry.ObjectHolder("et:exp_translator")
	public static Block exp_translator;
	
	public static void initBlocks()
	{
		exp_translator = new BlockExpTranslator("exp_translator", Material.WOOD);
	}
	
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(exp_translator);
	}
	
	public static void registerBlockItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new ItemBlock(exp_translator).setRegistryName(exp_translator.getRegistryName()));
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		initModel(exp_translator);
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModel(Block block) {
		
		Item item = Item.getItemFromBlock(block);
		
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
