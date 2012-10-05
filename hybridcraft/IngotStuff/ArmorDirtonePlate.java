package hybridcraft.IngotStuff;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ArmorDirtonePlate extends ItemArmor implements IArmorTextureProvider{

 public ArmorDirtonePlate(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
 super(par1, par2EnumArmorMaterial, par3, par4);

 }

 public String getTextureFile(){
 return "/hc/armor.png";

 }

 public String getArmorTextureFile(ItemStack par1){
 if ( par1.itemID==HybridModIngotStuff.dirtoneHelmet.shiftedIndex|| par1.itemID==HybridModIngotStuff.dirtonePlate.shiftedIndex||
 par1.itemID==HybridModIngotStuff.dirtoneBoots.shiftedIndex){
 return "/hc/armor/dirtone_1.png";
 }if(par1.itemID==HybridModIngotStuff.dirtoneLegs.shiftedIndex){
 return "/hc/armor/dirtone_2.png";
 }return "/hc/armor/dirtone_2.png";
 }

}