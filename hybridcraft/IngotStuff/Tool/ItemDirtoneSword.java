package hybridcraft.IngotStuff.Tool;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemSword;

public class ItemDirtoneSword extends ItemSword
{
 public ItemDirtoneSword(int itemID, EnumToolMaterial toolMaterial)
 {
  super(itemID, toolMaterial);
  this.setCreativeTab(CreativeTabs.tabCombat);
 }
 
 public String getTextureFile()
 {
         return "/hc/tools.png";
 }
}