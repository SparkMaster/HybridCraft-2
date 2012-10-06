package hybridcraft.IngotStuff.tool.dirold;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemSword;

public class Sword extends ItemSword
{
 public Sword(int itemID, EnumToolMaterial toolMaterial)
 {
  super(itemID, toolMaterial);
  this.setCreativeTab(CreativeTabs.tabCombat);
 }
 
 public String getTextureFile()
 {
         return "/hc/tools.png";
 }
}