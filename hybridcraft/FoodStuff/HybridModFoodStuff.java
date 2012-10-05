package hybridcraft.FoodStuff;

import hybridcraft.IngotStuff.CommonProxyHybrid;
import net.minecraft.src.Block;
import net.minecraft.src.BlockWorkbench;
import net.minecraft.src.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "HybridCraft 2 Food", name = "HybridCraft 2 Food", version = "2.2 beta 1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class HybridModFoodStuff {

	@SidedProxy(clientSide = "hybrid.client.ClientProxyHybrid", serverSide = "hybridcraft.IngotStuff.CommonProxyHybrid")
	public static CommonProxyHybrid proxy;
	
	public static Item BaB;
	public static Item PaB;
	public static Item CaB;
	// public static Block foodwb;

	
	@Init
	public void load(FMLInitializationEvent event) {

		// Classifications
		BaB = new ItemBaBFood(662, 8, false).setIconIndex(0).setItemName("bab");
		// foodwb = new FoodWorkbench(663).setHardness(2.5F).setStepSound(Block.soundWoodFootstep).setBlockName("foodwb");
		PaB = new ItemPaBFood(664, 10, false).setIconIndex(1).setItemName("pab");
		CaB = new ItemCaBFood(665, 10, false).setIconIndex(2).setItemName("cab");
		
		// Registry
		LanguageRegistry.addName(BaB, "Beef and Bread");
		LanguageRegistry.addName(PaB, "Pork and Bread");
		LanguageRegistry.addName(CaB, "Chicken and Bread");
		// LanguageRegistry.addName(foodwb, "Food Workbench [WIP]");
	}

}
