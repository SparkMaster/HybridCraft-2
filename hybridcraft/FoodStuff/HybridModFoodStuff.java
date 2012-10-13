package hybridcraft.FoodStuff;

import hybridcraft.FoodStuff.kitchen.*;
import hybridcraft.IngotStuff.*;
import net.minecraft.src.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "HybridCraft 2 Food", name = "HybridCraft 2 Food", version = "2.2 Stable")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class HybridModFoodStuff {

	@Instance("HybridCraft 2 Food")
	public static HybridModFoodStuff instance = new HybridModFoodStuff();

	@SidedProxy(clientSide = "hybrid.client.ClientProxyHybrid", serverSide = "hybridcraft.IngotStuff.CommonProxyHybrid")
	public static CommonProxyHybrid proxy;

	// Declare Blocks
	public static Block stove;
	public static Block counter;
	public static Block cookingPot;
	
	// Counter/Stove GUIs
	private GuiHandler guiHandler = new GuiHandler();

	@Init
	public void load(FMLInitializationEvent event) {
		
		// Initialize managers on startup
		CounterManager.getInstance();
		StoveManager.getInstance();
		CookingPotManager.getInstance();
		
		// Register GUIs
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);

		// Classify Blocks
		counter = new BlockCounter(hybridcraft.Config.counterID).setBlockName("Counter");
		stove = new BlockStove(hybridcraft.Config.stoveID).setBlockName("Stove");
		cookingPot = new BlockCookingPot(hybridcraft.Config.potID).setBlockName("Cooking Pot");

		// Register Blocks
		GameRegistry.registerBlock(stove);
		GameRegistry.registerBlock(counter);
		GameRegistry.registerBlock(cookingPot);
		
		LanguageRegistry.addName(stove, "Stove");
		LanguageRegistry.addName(counter, "Counter");
		LanguageRegistry.addName(cookingPot, "Cooking Pot");

		// Shaped Block Recipes
		GameRegistry.addRecipe(new ItemStack(stove, 1), new Object[] { "XXX", "XCX", "XXX", 'X', Item.ingotIron, 'C', Item.coal });
		GameRegistry.addRecipe(new ItemStack(counter, 1), new Object[] { "SSS", "XXX", "XXX", 'X', Block.wood, 'S', Block.stone });
		GameRegistry.addRecipe(new ItemStack(cookingPot, 1), new Object[] { "X X", "X X", "XWX", 'X', Item.ingotIron, 'W', Item.bucketWater });

	}
}