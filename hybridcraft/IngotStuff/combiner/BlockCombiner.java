package hybridcraft.IngotStuff.combiner;

import hybridcraft.IngotStuff.HybridModIngotStuff;
import net.minecraft.src.Block;
import net.minecraft.src.BlockWorkbench;
import net.minecraft.src.ContainerWorkbench;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.GuiCrafting;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.Packet100OpenWindow;
import net.minecraft.src.World;

public class BlockCombiner extends BlockWorkbench {

	public BlockCombiner(int par1) {
		super(par1);
		
        this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		} else {
			par5EntityPlayer.openGui(HybridModIngotStuff.instance, 0, par1World, par2, par3, par4);
			return true;
		}
	}

	@Override
    public int getBlockTextureFromSide(int par1)
    {
		return 13;
    }

    public String getTextureFile()
    {
            return "/hc/blocks.png";
    }
	
}
