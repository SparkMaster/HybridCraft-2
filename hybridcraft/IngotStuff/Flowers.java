package hybridcraft.IngotStuff;

import net.minecraft.src.BlockFlower;

public class Flowers extends BlockFlower{

	public Flowers(int id, int iconindex) {
		super(id, iconindex);
	}
	
	public String getTextureFile(){
		return "/hc/flowers.png";
	}

}
