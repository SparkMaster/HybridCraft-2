package hybridcraft.IngotStuff;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ArmorDirmendLegs extends ItemArmor implements IArmorTextureProvider{

 public ArmorDirmendLegs(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
 super(par1, par2EnumArmorMaterial, par3, par4);

 }

 public String getTextureFile(){
 return "/hc/armor.png";

 }

 public String getArmorTextureFile(ItemStack par1){
 if ( par1.itemID==HybridModIngotStuff.dirmendHelmet.shiftedIndex|| par1.itemID==HybridModIngotStuff.dirmendPlate.shiftedIndex||
 par1.itemID==HybridModIngotStuff.dirmendBoots.shiftedIndex){
 return "/hc/armor/dirmend_1.png";
 }if(par1.itemID==HybridModIngotStuff.dirmendLegs.shiftedIndex){
 return "/hc/armor/dirmend_2.png";
 }return "/hc/armor/dirmend_2.png";
 }

}