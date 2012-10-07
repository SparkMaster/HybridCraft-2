package hybridcraft.IngotStuff.armor;

import hybridcraft.IngotStuff.mod_HybridModIngotStuff;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class Stold extends ItemArmor implements IArmorTextureProvider{

 public Stold(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
 super(par1, par2EnumArmorMaterial, par3, par4);

 }

 public String getTextureFile(){
 return "/hc/armor.png";

 }

 public String getArmorTextureFile(ItemStack par1){
 if ( par1.itemID==mod_HybridModIngotStuff.stoldHelmet.shiftedIndex|| par1.itemID==mod_HybridModIngotStuff.stoldPlate.shiftedIndex||
 par1.itemID==mod_HybridModIngotStuff.stoldBoots.shiftedIndex){
 return "/hc/armor/stold_1.png";
 }if(par1.itemID==mod_HybridModIngotStuff.stoldLegs.shiftedIndex){
 return "/hc/armor/stold_2.png";
 }return "/hc/armor/stold_2.png";
 }

}