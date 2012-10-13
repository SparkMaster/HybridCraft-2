package hybridcraft.IngotStuff.armor;

import hybridcraft.IngotStuff.HybridModIngotStuff;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class Dirt extends ItemArmor implements IArmorTextureProvider{

 public Dirt(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
 super(par1, par2EnumArmorMaterial, par3, par4);

 }

 public String getTextureFile(){
 return "/hc/armor.png";

 }

 public String getArmorTextureFile(ItemStack par1){
 if ( par1.itemID==HybridModIngotStuff.dirtHelmet.shiftedIndex|| par1.itemID==HybridModIngotStuff.dirtPlate.shiftedIndex||
 par1.itemID==HybridModIngotStuff.dirtBoots.shiftedIndex){
 return "/hc/armor/dirt_1.png";
 }if(par1.itemID==HybridModIngotStuff.dirtLegs.shiftedIndex){
 return "/hc/armor/dirt_2.png";
 }return "/hc/armor/dirt_2.png";
 }
}