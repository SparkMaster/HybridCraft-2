package hybridcraft.IngotStuff;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ArmorIrmendHelmet extends ItemArmor implements IArmorTextureProvider{

 public ArmorIrmendHelmet(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
 super(par1, par2EnumArmorMaterial, par3, par4);

 }

 public String getTextureFile(){
 return "/hc/armor.png";

 }

 public String getArmorTextureFile(ItemStack par1){
 if ( par1.itemID==HybridModIngotStuff.irmendHelmet.shiftedIndex|| par1.itemID==HybridModIngotStuff.irmendPlate.shiftedIndex||
 par1.itemID==HybridModIngotStuff.irmendBoots.shiftedIndex){
 return "/hc/armor/irmend_1.png";
 }if(par1.itemID==HybridModIngotStuff.irmendLegs.shiftedIndex){
 return "/hc/armor/irmend_2.png";
 }return "/hc/armor/irmend_2.png";
 }
 
}