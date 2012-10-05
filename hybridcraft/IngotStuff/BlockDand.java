package hybridcraft.IngotStuff;

import net.minecraft.src.Block;
import net.minecraft.src.BlockSand;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockDand extends BlockSand
{
	public static boolean fallInstantly = false;
	
    protected BlockDand(int par1, int par2)
    {
        super(par1, par2);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    public String getTextureFile()
    {
            return "/hc/worldblocks.png";
    }
}
