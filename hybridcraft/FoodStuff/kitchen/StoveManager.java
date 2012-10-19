package hybridcraft.FoodStuff.kitchen;

import net.minecraft.src.*;
import net.minecraftforge.common.Configuration;
import hybridcraft.AbstractCraftingManager;
import hybridcraft.FoodStuff.*;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.*;

public class StoveManager extends AbstractCraftingManager {

	private static final StoveManager instance = new StoveManager();

	public static final StoveManager getInstance() {
		return instance;
	}

	// Declare Items
	public static Item BaB;
	public static Item PaB;
	public static Item CaB;
	public static Item DogBread;
	
	// Config
	public static final String CATEGORY_KITCHEN = "kitchen";
	public static final String CATEGORY_FOOD = "food";
	public static int BaBID;
	public static int PaBID;
	public static int CaBID;
	public static int DogBreadID;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	
		BaBID = config.get(CATEGORY_FOOD, "Beef Bread", 1012).getInt();
		PaBID = config.get(CATEGORY_FOOD, "Pork Bread", 1013).getInt();
		CaBID = config.get(CATEGORY_FOOD, "Chicken Bread", 1014).getInt();
		DogBreadID = config.get(CATEGORY_FOOD, "Dog Treat", 1015).getInt();
		
	}
		
	
	private StoveManager() {

		// Classify Items
		BaB = new BeefB(BaBID, 8, false).setIconIndex(0).setItemName("bab");
		PaB = new PorkB(PaBID, 10, false).setIconIndex(1).setItemName("pab");
		CaB = new ChickenB(CaBID, 10, false).setIconIndex(2).setItemName("cab");
		DogBread = new DogB(DogBreadID, 10, true).setIconIndex(3).setItemName("db");
		
		// Register Items
		LanguageRegistry.addName(BaB, "Beef and Bread");
		LanguageRegistry.addName(PaB, "Pork and Bread");
		LanguageRegistry.addName(CaB, "Chicken and Bread");
		LanguageRegistry.addName(DogBread, "Dog Treat");
		
		// Shaped Item Recipes
		this.addRecipe(new ItemStack(CaB, 2), new Object[] { "BB ", " B ", " BB", 'B', Item.bread });

		// Shapeless Item Recipes
		this.addShapelessRecipe(new ItemStack(BaB, 2), new Object[] { new ItemStack(Item.beefRaw), new ItemStack(Item.bread) });
		this.addShapelessRecipe(new ItemStack(PaB, 2), new Object[] { new ItemStack(Item.porkRaw), new ItemStack(Item.bread) });
		this.addShapelessRecipe(new ItemStack(CaB, 2), new Object[] { new ItemStack(Item.chickenRaw), new ItemStack(Item.bread) });
		System.out.println(this.recipes.size() + " recipes");
	}
}
