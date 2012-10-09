package hybridcraft.IngotStuff;

import net.minecraft.src.*;

public class Ingot extends Item {
	public Ingot(int i) {
		super(i);
		maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	public String getTextureFile() {
		return "/hc/ingots.png";
	}
}