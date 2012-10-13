package hybridcraft.FoodStuff.kitchen;

import java.util.List;
import java.util.Random;

import javax.jws.Oneway;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import hybridcraft.FoodStuff.HybridModFoodStuff;
import net.minecraft.src.*;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockCookingPot extends Block {
	
	
	public BlockCookingPot(int par1) {
		super(par1, Material.iron);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F);
	}

    
	// Display gui
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (par1World.getBlockId(par2, par3, par4) != HybridModFoodStuff.cookingPot.blockID ? false : par5EntityPlayer.getDistanceSq((double) par2 + 0.5D, (double) par3 + 0.5D, (double) par4 + 0.5D) <= 64.0D){
			par5EntityPlayer.openGui(hybridcraft.FoodStuff.HybridModFoodStuff.instance, 2, par1World, par2, par3, par4);
			return true;
		} 
		return false;
	}
	
	@Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        return canBlockStay(par1World, par2, par3, par4);
    }
	
	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
		return par1World.getBlockId(par2, par3-1, par4) == HybridModFoodStuff.stove.blockID;
	}
    
	@Override
    public int getBlockTextureFromSide(int par1) {
		switch (par1) {
		case 1:
			return 3;
		default:
			return 2;
		}
    }
		
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
    	
        if (par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 0)
        {
            this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
        }
        else if (par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 1)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.5F, 0.5F, 0.5F, 1.0F);
        }
        else if (par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 2)
        {
            this.setBlockBounds(0.5F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
        }
        else if (par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 3)
        {
        	this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F);
        }
        else {
            this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
        
        }
    }
    
	@Override
    public void addCollidingBlockToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
    {
        int var8 = par1World.getBlockMetadata(par2, par3, par4);
        int var9 = var8 & 3;

        if (var9 == 0)
        {
            this.setBlockBounds(0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F);
            super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }
        else if (var9 == 1)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.5F, 0.5F, 0.5F, 1.0F);
            super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }
        else if (var9 == 2)
        {
            this.setBlockBounds(0.5F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
            super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }
        else if (var9 == 3)
        {
        	this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F);
            super.addCollidingBlockToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F);
    }
	
    /**
     * Called when the block is placed in the world.
     */
    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int var7 = par1World.getBlockMetadata(par2, par3, par4) & 4;

        if (var6 == 0) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2 | var7);
        }
        if (var6 == 1) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1 | var7);
        }
        if (var6 == 2) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3 | var7);
        }
        if (var6 == 3) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0 | var7);
        }
    }
    
    /**
     * called before onBlockPlacedBy by ItemBlock and ItemReed
     */
    @Override
    public void updateBlockMetadata(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8)
    {
        if (par5 == 0 || par5 != 1 && (double)par7 > 0.5D)
        {
            int var9 = par1World.getBlockMetadata(par2, par3, par4);
            par1World.setBlockMetadataWithNotify(par2, par3, par4, var9 | 4);
        }
    }
    
	// Smoke particles
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int var6 = par1World.getBlockMetadata(par2, par3, par4);
        
        float var7 = (float)par2 + ((var6 + 1) % 2)* 0.5F + par5Random.nextFloat() * 0.5F;
        float var9 = (float)par4 + ((var6 % 3) < 1 ? 0 : 0.5F) + par5Random.nextFloat() * 0.5F;
        float var8 = (float)par3 + 0.5F  ;
        par1World.spawnParticle("smoke", (double)(var7), (double)var8, (double)(var9), 0.0D, 0.0D, 0.0D);
    }
 
    
	@Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
        if (!this.canBlockStay(par1World, par2, par3, par4)) {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
        }
    }
	
    public String getTextureFile() {
            return "/hc/kitchen.png";
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return true;
    }

}
    

