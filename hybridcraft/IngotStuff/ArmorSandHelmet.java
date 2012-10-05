package hybridcraft.IngotStuff;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ArmorSandHelmet extends ItemArmor implements IArmorTextureProvider{

 public ArmorSandHelmet(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
 super(par1, par2EnumArmorMaterial, par3, par4);

 }

 public String getTextureFile(){
 return "/hc/armor.png";

 }

 public String getArmorTextureFile(ItemStack par1){
 if ( par1.itemID==HybridModIngotStuff.sandHelmet.shiftedIndex|| par1.itemID==HybridModIngotStuff.sandPlate.shiftedIndex||
 par1.itemID==HybridModIngotStuff.sandBoots.shiftedIndex){
 return "/hc/armor/sand_1.png";
 }if(par1.itemID==HybridModIngotStuff.sandLegs.shiftedIndex){
 return "/hc/armor/sand_2.png";
 }return "/hc/armor/sand_2.png";
 }

}