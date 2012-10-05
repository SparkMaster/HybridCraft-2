package hybridcraft.IngotStuff;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ArmorIroldLegs extends ItemArmor implements IArmorTextureProvider{

 public ArmorIroldLegs(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
 super(par1, par2EnumArmorMaterial, par3, par4);

 }

 public String getTextureFile(){
 return "/hc/armor.png";

 }

 public String getArmorTextureFile(ItemStack par1){
 if ( par1.itemID==HybridModIngotStuff.iroldHelmet.shiftedIndex|| par1.itemID==HybridModIngotStuff.iroldPlate.shiftedIndex||
 par1.itemID==HybridModIngotStuff.iroldBoots.shiftedIndex){
 return "/hc/armor/irold_1.png";
 }if(par1.itemID==HybridModIngotStuff.iroldLegs.shiftedIndex){
 return "/hc/armor/irold_2.png";
 }return "/hc/armor/irold_2.png";
 }

}