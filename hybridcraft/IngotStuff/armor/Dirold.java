package hybridcraft.IngotStuff.armor;

import hybridcraft.IngotStuff.HybridModIngotStuff;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class Dirold extends ItemArmor implements IArmorTextureProvider{

 public Dirold(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
 super(par1, par2EnumArmorMaterial, par3, par4);

 }

 public String getTextureFile(){
 return "/hc/armor.png";

 }

 public String getArmorTextureFile(ItemStack par1){
 if ( par1.itemID==HybridModIngotStuff.diroldHelmet.shiftedIndex|| par1.itemID==HybridModIngotStuff.diroldPlate.shiftedIndex||
 par1.itemID==HybridModIngotStuff.diroldBoots.shiftedIndex){
 return "/hc/armor/dirold_1.png";
 }if(par1.itemID==HybridModIngotStuff.diroldLegs.shiftedIndex){
 return "/hc/armor/dirold_2.png";
 }return "/hc/armor/dirold_2.png";
 }

}