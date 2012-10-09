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

@Mod(modid = "HybridCraft 2 Food", name = "HybridCraft 2 Food", version = "2.2 beta 1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class HybridModFoodStuff {

	@Instance("HybridCraft 2 Food")
	public static HybridModFoodStuff instance = new HybridModFoodStuff();

	@SidedProxy(clientSide = "hybrid.client.ClientProxyHybrid", serverSide = "hybridcraft.IngotStuff.CommonProxyHybrid")
	public static CommonProxyHybrid proxy;

	// Declare Blocks
	public static Block Stove;
	public static Block Counter;

	// Counter/Stove GUIs
	private GuiHandler guiHandler = new GuiHandler();

	@Init
	public void load(FMLInitializationEvent event) {

		// Register GUIs
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);

		// Classify Blocks
		Counter = new BlockCounter(679).setBlockName("Counter");
		Stove = new BlockStove(678).setBlockName("Stove");

		// Register Blocks
		GameRegistry.registerBlock(Stove);
		GameRegistry.registerBlock(Counter);
		LanguageRegistry.addName(Stove, "Stove");
		LanguageRegistry.addName(Counter, "Counter");

		// Shaped Block Recipes
		GameRegistry.addRecipe(new ItemStack(Stove, 1), new Object[] { "XXX", "XCX", "XXX", 'X', Item.ingotIron, 'C', Item.coal, });
		GameRegistry.addRecipe(new ItemStack(Counter, 3), new Object[] { "SSS", "XXX", "XXX", 'X', Block.wood, 'S', Block.stone, });

	}
}