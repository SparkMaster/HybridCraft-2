package hybridcraft.IngotStuff;

import net.minecraft.src.BlockFlower;

public class FlowerDiamond extends BlockFlower{

	public FlowerDiamond(int id, int iconindex) {
		super(id, iconindex);
	}

	public String getTextureFile(){
		return "/hc/flowers.png";
	}

}
