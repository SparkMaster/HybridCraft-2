package hybridcraft.FoodStuff.kitchen;

import net.minecraft.src.*;

public class ApplePie extends ItemFood {

	public ApplePie(int par1, int healAmount, float par3, boolean par4) {
		super(par1, healAmount, par3, false);
	}

	public String getTextureFile() {
		return "/hc/sandwich.png";
	}

	public ApplePie(int itemID, int healAmount) {
		this(itemID, healAmount, 0.6F, false);
	}
}