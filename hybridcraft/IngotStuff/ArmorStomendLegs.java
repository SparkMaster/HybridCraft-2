package hybridcraft.IngotStuff;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ArmorStomendLegs extends ItemArmor implements IArmorTextureProvider{

 public ArmorStomendLegs(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
 super(par1, par2EnumArmorMaterial, par3, par4);

 }

 public String getTextureFile(){
 return "/hc/armor.png";

 }

 public String getArmorTextureFile(ItemStack par1){
 if ( par1.itemID==HybridModIngotStuff.stomendHelmet.shiftedIndex|| par1.itemID==HybridModIngotStuff.stomendPlate.shiftedIndex||
 par1.itemID==HybridModIngotStuff.stomendBoots.shiftedIndex){
 return "/hc/armor/stomend_1.png";
 }if(par1.itemID==HybridModIngotStuff.stomendLegs.shiftedIndex){
 return "/hc/armor/stomend_2.png";
 }return "/hc/armor/stomend_2.png";
 }

}