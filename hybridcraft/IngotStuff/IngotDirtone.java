package hybridcraft.IngotStuff;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class IngotDirtone extends Item
{
    public IngotDirtone(int i)
    {
        super(i);
        maxStackSize = 64;
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
    public String getTextureFile()
    {
            return "/hc/ingots.png";
    }
}