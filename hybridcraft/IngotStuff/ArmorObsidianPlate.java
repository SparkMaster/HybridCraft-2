package hybridcraft.IngotStuff;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ArmorObsidianPlate extends ItemArmor implements IArmorTextureProvider{

 public ArmorObsidianPlate(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
 super(par1, par2EnumArmorMaterial, par3, par4);

 }

 public String getTextureFile(){
 return "/hc/armor.png";

 }

 public String getArmorTextureFile(ItemStack par1){
 if ( par1.itemID==HybridModIngotStuff.obsidianHelmet.shiftedIndex|| par1.itemID==HybridModIngotStuff.obsidianPlate.shiftedIndex||
 par1.itemID==HybridModIngotStuff.obsidianBoots.shiftedIndex){
 return "/hc/armor/obsidian_1.png";
 }if(par1.itemID==HybridModIngotStuff.obsidianLegs.shiftedIndex){
 return "/hc/armor/obsidian_2.png";
 }return "/hc/armor/obsidian_2.png";
 }

}