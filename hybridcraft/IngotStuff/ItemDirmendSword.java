package hybridcraft.IngotStuff;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemSword;

public class ItemDirmendSword extends ItemSword {
	public ItemDirmendSword(int itemID, EnumToolMaterial toolMaterial) {
		super(itemID, toolMaterial);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}

	public String getTextureFile() {
		return "/hc/tools.png";
	}
}