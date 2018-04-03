package gruntpie224.exptranslation.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockExpTranslator extends Block{
	
	protected static final AxisAlignedBB TABLE_AABB = new AxisAlignedBB(0F, 0F, 0F, 1F, 0.55F, 1F);
	
	public BlockExpTranslator(String name, Material material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setSoundType(SoundType.WOOD);
		this.setLightLevel(0.8F);
		this.setHardness(1.3f);
	}

	 /**
	 * Sets the block's bounds for rendering it as an item
	 */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return TABLE_AABB;
    }
	
	@Override
    public boolean isBlockNormalCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }
    
    @Override
    public boolean isFullCube(IBlockState blockState){
    	return false;
    }
	

    @Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		double d0 = (double)pos.getX() + 0.125D;
        double d1 = (double)pos.getY() + 0.5D;
        double d2 = (double)pos.getZ() + 0.6D;
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;
	        
        super.randomDisplayTick(stateIn, worldIn, pos, rand);

        for (int l = pos.getX() - 2; l <= pos.getX() + 2; ++l)
        {
            for (int i1 = pos.getZ() - 2; i1 <= pos.getZ() + 2; ++i1)
            {
                if (l > pos.getX() - 2 && l < pos.getX() + 2 && i1 == pos.getZ() - 1)
                {
                    i1 = pos.getZ() + 2;
                }

                if (rand.nextInt(25) == 0)
                {
                    for (int j1 = pos.getY(); j1 <= pos.getY() + 1; ++j1)
                    {
                    	worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
                    	worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1 + d3, d2 + d4-0.725D, 0.0D, 0.0D, 0.0D);
                		worldIn.spawnParticle(EnumParticleTypes.FLAME, d0+0.725D, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
                		worldIn.spawnParticle(EnumParticleTypes.FLAME, d0+0.725D, d1 + d3, d2 + d4-0.725D, 0.0D, 0.0D, 0.0D);
                        //par1World.spawnParticle("happyVillager", (double)par2 + 0.625D, (double)par3 + 1.5D, (double)par4 + 0.625D, (double)((float)(l - par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(j1 - par3) - par5Random.nextFloat() - 1.0F), (double)((float)(i1 - par4) + par5Random.nextFloat()) - 0.5D);
                        }
                    }
                }
            }
        }
}
