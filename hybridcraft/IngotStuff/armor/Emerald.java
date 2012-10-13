package hybridcraft.IngotStuff.Armor;

import hybridcraft.IngotStuff.HybridModIngotStuff;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class Emerald extends ItemArmor implements IArmorTextureProvider{

 public Emerald(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
 super(par1, par2EnumArmorMaterial, par3, par4);

 }

 public String getTextureFile(){
 return "/hc/armor.png";

 }

 public String getArmorTextureFile(ItemStack par1){
 if ( par1.itemID==HybridModIngotStuff.emeraldHelmet.shiftedIndex|| par1.itemID==HybridModIngotStuff.emeraldPlate.shiftedIndex||
 par1.itemID==HybridModIngotStuff.emeraldBoots.shiftedIndex){
 return "/hc/armor/emerald_1.png";
 }if(par1.itemID==HybridModIngotStuff.emeraldLegs.shiftedIndex){
 return "/hc/armor/emerald_2.png";
 }return "/hc/armor/emerald_2.png";
 }

}