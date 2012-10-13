package hybridcraft.FoodStuff.kitchen;

import hybridcraft.FoodStuff.HybridModFoodStuff;
import net.minecraft.src.*;

public class BlockStove extends Block {

	public BlockStove(int par1) {
		super(par1,Material.wood);
        this.blockIndexInTexture = 0;
        this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	// Display gui if next to counter
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if ((par1World.getBlockId(par2, par3, par4) != HybridModFoodStuff.stove.blockID ? false : par5EntityPlayer.getDistanceSq((double) par2 + 0.5D, (double) par3 + 0.5D, (double) par4 + 0.5D) <= 64.0D  && (par1World.getBlockId(par2 + 1, par3, par4) == HybridModFoodStuff.counter.blockID || par1World.getBlockId(par2 - 1, par3, par4) == HybridModFoodStuff.counter.blockID || par1World.getBlockId(par2, par3, par4 + 1) == HybridModFoodStuff.counter.blockID || par1World.getBlockId(par2, par3, par4 - 1) == HybridModFoodStuff.counter.blockID))) {
			par5EntityPlayer.openGui(hybridcraft.FoodStuff.HybridModFoodStuff.instance, 0, par1World, par2, par3, par4);
			return true;
		}
		return false;
	}
	
	@Override
	public int getBlockTextureFromSide(int par1) {
		switch (par1) {
		case 1:
			return 6;
		default:
			return 0;
		}
	}

    public String getTextureFile()  {
            return "/hc/kitchen.png";
    }
}
