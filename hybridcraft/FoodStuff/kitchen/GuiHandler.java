package hybridcraft.FoodStuff.kitchen;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.src.*;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (world.getBlockId(x, y, z) == hybridcraft.FoodStuff.HybridModFoodStuff.Stove.blockID) {
			return new ContainerStove(player.inventory, world, x, y, z);
		} else if (world.getBlockId(x, y, z) == hybridcraft.FoodStuff.HybridModFoodStuff.Counter.blockID) {
			return new ContainerCounter(player.inventory, world, x, y, z);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (world.getBlockId(x, y, z) == hybridcraft.FoodStuff.HybridModFoodStuff.Stove.blockID) {
			return new GUIStove(player.inventory, world, x, y, z);
		} else if (world.getBlockId(x, y, z) == hybridcraft.FoodStuff.HybridModFoodStuff.Counter.blockID) {
				return new GUICounter(player.inventory, world, x, y, z);
			}
		return null;
	}
}