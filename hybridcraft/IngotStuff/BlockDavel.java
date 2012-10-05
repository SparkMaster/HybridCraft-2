package hybridcraft.IngotStuff;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.BlockSand;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.Material;

public class BlockDavel extends BlockSand
{
	public static boolean fallInstantly = true;
	
    public BlockDavel(int par1, int par2)
    {
    	super(par1, par2);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return par2Random.nextInt(10 - par3 * 3) == 0 ? Item.flint.shiftedIndex : this.blockID;
    }
    
    public String getTextureFile()
    {
            return "/hc/worldblocks.png";
    }
}
