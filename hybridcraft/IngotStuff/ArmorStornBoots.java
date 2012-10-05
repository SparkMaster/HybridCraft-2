package hybridcraft.IngotStuff;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ArmorStornBoots extends ItemArmor implements IArmorTextureProvider{

 public ArmorStornBoots(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
 super(par1, par2EnumArmorMaterial, par3, par4);

 }

 public String getTextureFile(){
 return "/hc/armor.png";

 }

 public String getArmorTextureFile(ItemStack par1){
 if ( par1.itemID==HybridModIngotStuff.stornHelmet.shiftedIndex|| par1.itemID==HybridModIngotStuff.stornPlate.shiftedIndex||
 par1.itemID==HybridModIngotStuff.stornBoots.shiftedIndex){
 return "/hc/armor/storn_1.png";
 }if(par1.itemID==HybridModIngotStuff.stornLegs.shiftedIndex){
 return "/hc/armor/storn_2.png";
 }return "/hc/armor/storn_2.png";
 }

}