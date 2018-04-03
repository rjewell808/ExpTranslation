package gruntpie224.exptranslation.init;

import gruntpie224.exptranslation.items.ItemEmptyVial;
import gruntpie224.exptranslation.items.ItemVial;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ExpTranItems {
	
	@GameRegistry.ObjectHolder("et:vial_empty")
	public static Item empty_vial;
	
	@GameRegistry.ObjectHolder("et:vial_exp")
	public static Item exp_vial;
	
	public static void initItems()
	{
		empty_vial = new ItemEmptyVial("vial_empty");
		exp_vial = new ItemVial("vial_exp");
	}
	
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(empty_vial);
		event.getRegistry().register(exp_vial);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		initModel(empty_vial);
		initModel(exp_vial);
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModel(Item item) {
		
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
