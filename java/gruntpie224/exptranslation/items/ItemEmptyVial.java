package gruntpie224.exptranslation.items;

import gruntpie224.exptranslation.init.ExpTranBlocks;
import gruntpie224.exptranslation.init.ExpTranItems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemEmptyVial extends Item{
	
	public ItemEmptyVial(String name)
	{
		boolean isFilled = false;
		
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.MISC);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {      
		
		if (player.canPlayerEdit(pos, facing, player.getActiveItemStack()))
	    {
	    	double d0 = (double)pos.getX() + 0.5D;
	        double d1 = (double)pos.getY() + 0.9D;
	        double d2 = (double)pos.getZ() + 0.6D;

	        Block i1 = worldIn.getBlockState(pos).getBlock();
	        Block enchanter = ExpTranBlocks.exp_translator;
	       
        	if (i1 == enchanter && player.experienceTotal > 0)
            {
        		//par3World.playSoundAtEntity(par2EntityPlayer, "mob.chicken.plop", 0.5F, 0.1F / (itemRand.nextFloat() * 0.4F + 0.8F));
        		if(!worldIn.isRemote)
        		{
	        		player.getHeldItemMainhand().shrink(1);
	        		
	        		ItemStack item = new ItemStack((ExpTranItems.exp_vial));
	        		
	        		item.setTagCompound(new NBTTagCompound());
	        		item.getTagCompound().setInteger("expAmount", player.experienceTotal);
	        		
	        		EntityItem item_entity = new EntityItem(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), item);
	    			worldIn.spawnEntity(item_entity);
	    			
	    			player.addExperienceLevel(-(player.experienceLevel + 1));
	    			worldIn.playSound(null, pos, SoundEvents.ENTITY_CHICKEN_EGG, SoundCategory.BLOCKS, 1F, 1F);
        		}
        		else
        		{
        			worldIn.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, d0, d1, d2, 0.0D, 0.35D, 0.0D);
        		}
			
        		/*
        		//par3World.playSoundAtEntity(par2EntityPlayer, "mob.chicken.plop", 0.5F, 0.1F / (itemRand.nextFloat() * 0.3F + 0.8F));
        		player.getActiveItemStack().shrink(1);
                par2EntityPlayer.addExperienceLevel(this.explvl * 1);
                //par2EntityPlayer.addStat(VanillaAchievements.emptyVialACH, 1);
                par3World.spawnParticle(EnumParticleTypes.CRIT_MAGIC, d0+0.725D, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
                par3World.spawnParticle(EnumParticleTypes.CRIT_MAGIC, d0+0.725D, d1 + d3-0.1D, d2 + d4, 0.0D, 0.0D, 0.0D);
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
