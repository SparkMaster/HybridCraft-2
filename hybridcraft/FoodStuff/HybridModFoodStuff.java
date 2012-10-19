package hybridcraft.FoodStuff;

import hybridcraft.CommonProxyHybrid;
import hybridcraft.FoodStuff.kitchen.*;
import hybridcraft.IngotStuff.*;
import net.minecraft.src.*;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "HybridCraft 2 Food", name = "HybridCraft 2 Food", version = "2.2 Stable")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class HybridModFoodStuff {

	@Instance("HybridCraft 2 Food")
	public static HybridModFoodStuff instance = new HybridModFoodStuff();

	@SidedProxy(clientSide = "hybrid.client.ClientProxyHybrid", serverSide = "hybridcraft.CommonProxyHybrid")
	public static CommonProxyHybrid proxy;

	// Declare Blocks
	public static Block stove;
	public static Block counter;
	public static Block cookingPot;
	
	// Counter/Stove GUIs
	private GuiHandler guiHandler = new GuiHandler();
	
	// Config
	public static final String CATEGORY_KITCHEN = "kitchen";
	public static final String CATEGORY_FOOD = "food";
	
	public static int  breadSliceID;
	public static int  chickenStripsID;
	public static int  beefSlicesID;
	public static int  baconID;
	public static int  chickenSandwichID;
	public static int  chickenSandwichBaconID;
	public static int  beefSandwichID;
	public static int  beefSandwichBaconID;
	public static int  meatSandwichID;
	public static int  applePieID;
	public static int  fruitSaladID;
	public static int  appleSliceID;
	public static int  counterID;
	public static int  stoveID;
	public static int  potID;
	public static int  bowlChickenID;
	public static int  bowlBeefID;
	public static int  bowlMeatID;
	public static int BaBID;
	public static int PaBID;
	public static int CaBID;
	public static int DogBreadID;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		counterID = config.get(CATEGORY_KITCHEN, "Counter", 665).getInt();
		stoveID = config.get(CATEGORY_KITCHEN, "Stove", 666).getInt();
		potID = config.get(CATEGORY_KITCHEN, "Cooking Pot", 667).getInt();
		breadSliceID = config.get(CATEGORY_FOOD, "Slice of Bread", 1000).getInt();
		chickenStripsID = config.get(CATEGORY_FOOD, "Chicken Tender", 1001).getInt();
		beefSlicesID = config.get(CATEGORY_FOOD, "Beef Slice", 1002).getInt();
		baconID = config.get(CATEGORY_FOOD, "Bacon", 1003).getInt();
		chickenSandwichID = config.get(CATEGORY_FOOD, "Chicken Sandwich", 1004).getInt();
		chickenSandwichBaconID = config.get(CATEGORY_FOOD, "Chicken Sandwich with Bacon", 1005).getInt();
		beefSandwichID = config.get(CATEGORY_FOOD, "Beef Sandwich", 1006).getInt();
		beefSandwichBaconID = config.get(CATEGORY_FOOD, "Beef Sandwich with Bacon", 1007).getInt();
		meatSandwichID = config.get(CATEGORY_FOOD, "Meat Sandwich", 1008).getInt();
		applePieID = config.get(CATEGORY_FOOD, "Apple Pie", 1009).getInt();
		fruitSaladID = config.get(CATEGORY_FOOD, "Fruit Salad", 1010).getInt();
		appleSliceID = config.get(CATEGORY_FOOD, "Apple Slice", 1011).getInt();
		bowlChickenID = config.get(CATEGORY_FOOD, "Bowl of Chicken", 1016).getInt();
		bowlBeefID = config.get(CATEGORY_FOOD, "Bowl of Beef", 1017).getInt();
		bowlMeatID = config.get(CATEGORY_FOOD, "Bowl of Meat", 1018).getInt();
		BaBID = config.get(CATEGORY_FOOD, "Beef Bread", 1012).getInt();
		PaBID = config.get(CATEGORY_FOOD, "Pork Bread", 1013).getInt();
		CaBID = config.get(CATEGORY_FOOD, "Chicken Bread", 1014).getInt();
		DogBreadID = config.get(CATEGORY_FOOD, "Dog Treat", 1015).getInt();
		
		
	}
	
	
	@Init
	public void load(FMLInitializationEvent event) {
		
		// Initialize managers on startup
		CounterManager.getInstance();
		StoveManager.getInstance();
		CookingPotManager.getInstance();
		
		// Register GUIs
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);

		// Classify Blocks
		counter = new BlockCounter(counterID).setBlockName("Counter");
		stove = new BlockStove(stoveID).setBlockName("Stove");
		cookingPot = new BlockCookingPot(potID).setBlockName("Cooking Pot");

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