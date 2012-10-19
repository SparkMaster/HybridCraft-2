package hybridcraft.FoodStuff.kitchen;

import net.minecraft.src.*;

public class ChickenSB extends ItemFood {

	public ChickenSB(int par1, int healAmount, float par3, boolean par4) {
		super(par1, healAmount, par3, false);
	}

	public String getTextureFile() {
		return "/hc/sandwich.png";
	}

	public ChickenSB(int itemID, int healAmount) {
		this(itemID, healAmount, 0.6F, false);
	}
}