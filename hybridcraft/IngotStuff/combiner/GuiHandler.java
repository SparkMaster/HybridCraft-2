package hybridcraft.IngotStuff.combiner;

import hybridcraft.IngotStuff.HybridModIngotStuff;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.src.*;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (world.getBlockId(x, y, z) == hybridcraft.IngotStuff.HybridModIngotStuff.blockCombiner.blockID) {
			return new ContainerCombiner(player.inventory, world, x, y, z);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (world.getBlockId(x, y, z) == hybridcraft.IngotStuff.HybridModIngotStuff.blockCombiner.blockID) {
			return new GUICombining(player.inventory, world, x, y, z);
		}
		return null;
	}
}