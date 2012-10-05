package hybridcraft.IngotStuff;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class IngotGomendBlock extends Block
{
    public IngotGomendBlock(int par1, int par2)
    {
        super(par1, par2, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    public String getTextureFile()
    {
            return "/hc/blocks.png";
    }
}