package hybridcraft.IngotStuff;

import net.minecraft.src.BlockFlower;

public class FlowerStone extends BlockFlower{

	public FlowerStone(int id, int iconindex) {
		super(id, iconindex);
	}

	public String getTextureFile(){
		return "/hc/flowers.png";
	}

}
