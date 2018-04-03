package gruntpie224.exptranslation.items;

import java.util.List;

import javax.annotation.Nullable;

import gruntpie224.exptranslation.init.ExpTranBlocks;
import gruntpie224.exptranslation.init.ExpTranItems;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVial extends Item{
	
	public ItemVial(String name)
	{
		boolean isFilled = false;
		
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.MISC);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) 
	{
	    return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("expAmount"))
			tooltip.add("Contains \u00a76" + stack.getTagCompound().getInteger("expAmount") + "\u00a77 exp");
    }
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {      
		if(worldIn.isRemote)
			return EnumActionResult.PASS;
		
		if (player.canPlayerEdit(pos, facing, player.getActiveItemStack()))
	    {
	    	double d0 = (double)pos.getX() - 0.2D;
	        double d1 = (double)pos.getY() + 1.4D;
	        double d2 = (double)pos.getZ() + 0.325D;
	        double d3 = 0.2199999988079071D;
	        double d4 = 0.27000001072883606D;
	        Block i1 = worldIn.getBlockState(pos).getBlock();
	        Block enchanter = ExpTranBlocks.exp_translator;
	       
	        if (i1 == enchanter)
	        {
	            ItemStack stack = player.getHeldItemMainhand();

	            if(stack.hasTagCompound() && stack.getTagCompound().hasKey("expAmount"))
	            {
	            	player.addExperience(stack.getTagCompound().getInteger("expAmount"));
	            	player.getHeldItemMainhand().shrink(1);
	            }
	            
	            worldIn.spawnParticle(EnumParticleTypes.CRIT_MAGIC, d0+0.725D, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
	            worldIn.spawnParticle(EnumParticleTypes.CRIT_MAGIC, d0+0.725D, d1 + d3-0.1D, d2 + d4, 0.0D, 0.0D, 0.0D);
	            worldIn.spawnParticle(EnumParticleTypes.CRIT_MAGIC, d0+0.725D+0.1D, d1 + d3-0.2D, d2 + d4, 0.0D, 0.0D, 0.0D);
	            worldIn.spawnParticle(EnumParticleTypes.CRIT_MAGIC, d0+0.725D-0.2D, d1 + d3-0.3D, d2 + d4, 0.0D, 0.0D, 0.0D);
	            /*
	        	//par3World.playSoundAtEntity(par2EntityPlayer, "mob.chicken.plop", 0.5F, 1F);
	            par1ItemStack.stackSize -= 10;
	            par2EntityPlayer.addExperienceLevel(this.explvl * 10);
	            //par2EntityPlayer.addStat(VanillaAchievements.emptyVialACH, 1);
	            
	            */
	            return EnumActionResult.PASS;
	        }
	        
            return EnumActionResult.FAIL;
	    }
	    else
	    {
	        return EnumActionResult.FAIL;
	    }
    }
}
