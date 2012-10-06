package hybridcraft.IngotStuff;

import net.minecraft.src.Block;
import net.minecraft.src.BlockSand;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class WorldBlockFall extends BlockSand
{
	public static boolean fallInstantly = false;
	
    protected WorldBlockFall(int par1, int par2)
    {
        super(par1, par2);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    public String getTextureFile()
    {
            return "/hc/worldblocks.png";
    }
}
