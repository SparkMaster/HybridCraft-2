package hybridcraft.IngotStuff.tool.cobble;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemTool;
import net.minecraft.src.Material;

public class Axe extends ItemTool
{
    /** an array of the blocks this axe is effective against */
    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern};

    public Axe(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, 3, par2EnumToolMaterial, blocksEffectiveAgainst);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && par2Block.blockMaterial == Material.wood ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
    }
    public String getTextureFile()
    {
            return "/hc/tools.png";
    }
   }
