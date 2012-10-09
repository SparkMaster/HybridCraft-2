package hybridcraft.FoodStuff.kitchen;

import net.minecraft.src.*;

public class BlockCounter extends BlockWorkbench {

	public BlockCounter(int par1) {
		super(par1);
        this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		} else {
			par5EntityPlayer.openGui(hybridcraft.FoodStuff.HybridModFoodStuff.instance, 1, par1World, par2, par3, par4);
			return true;
		}
	}

	@Override
    public int getBlockTextureFromSide(int par1)
    {
		return 1;
    }

    public String getTextureFile()
    {
            return "/hc/kitchen.png";
    }
	
}
