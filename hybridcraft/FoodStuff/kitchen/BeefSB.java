package hybridcraft.FoodStuff.kitchen;

import net.minecraft.src.*;

public class BeefSB extends ItemFood {

	public BeefSB(int par1, int healAmount, float par3, boolean par4) {
		super(par1, healAmount, par3, false);
	}

	public String getTextureFile() {
		return "/hc/sandwich.png";
	}

	public BeefSB(int itemID, int healAmount) {
		this(itemID, healAmount, 0.6F, false);
	}
}