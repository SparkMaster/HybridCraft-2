package hybridcraft.IngotStuff;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ArmorDironHelmet extends ItemArmor implements IArmorTextureProvider{

 public ArmorDironHelmet(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
 super(par1, par2EnumArmorMaterial, par3, par4);

 }

 public String getTextureFile(){
 return "/hc/armor.png";

 }

 public String getArmorTextureFile(ItemStack par1){
 if ( par1.itemID==HybridModIngotStuff.dironHelmet.shiftedIndex|| par1.itemID==HybridModIngotStuff.dironPlate.shiftedIndex||
 par1.itemID==HybridModIngotStuff.dironBoots.shiftedIndex){
 return "/hc/armor/diron_1.png";
 }if(par1.itemID==HybridModIngotStuff.dironLegs.shiftedIndex){
 return "/hc/armor/diron_2.png";
 }return "/hc/armor/diron_2.png";
 }

}