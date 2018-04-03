package gruntpie224.exptranslation.init;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ExpTranBlocks {
	
	@GameRegistry.ObjectHolder("et:exp_translator")
	public static Block exp_translator;
	
	public static void initBlocks()
	{
		
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel(Block block) {
		
		Item item = Item.getItemFromBlock(block);
		
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
