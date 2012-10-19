package hybridcraft.FoodStuff.kitchen;

import net.minecraft.src.*;
import net.minecraftforge.common.Configuration;
import hybridcraft.AbstractCraftingManager;
import hybridcraft.FoodStuff.*;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.*;

public class CookingPotManager extends AbstractCraftingManager {

	private static final CookingPotManager instance = new CookingPotManager();

	public static final CookingPotManager getInstance() {
		return instance;
	}

	// Declare Items
	public static Item bowlChicken;
	public static Item bowlBeef;
	public static Item bowlMeat;
	
	// Config
	public static final String CATEGORY_KITCHEN = "kitchen";
	public static final String CATEGORY_FOOD = "food";
	
	public static int  bowlChickenID;
	public static int  bowlBeefID;
	public static int  bowlMeatID;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		bowlChickenID = config.get(CATEGORY_FOOD, "Bowl of Chicken", 1016).getInt();
		bowlBeefID = config.get(CATEGORY_FOOD, "Bowl of Beef", 1017).getInt();
		bowlMeatID = config.get(CATEGORY_FOOD, "Bowl of Meat", 1018).getInt();
		

	}
	
	private CookingPotManager() {

		// Classify Items
		bowlChicken = new BC(bowlChickenID, 9).setIconIndex(12).setItemName("Chicken Soup");
		bowlBeef = new BB(bowlBeefID, 8).setIconIndex(13).setItemName("Beef Stew");
		bowlMeat = new BM(bowlMeatID, 10).setIconIndex(14).setItemName("Broth");
		
		// Register Items
		LanguageRegistry.addName(bowlChicken, "Chicken Soup");
		LanguageRegistry.addName(bowlBeef, "Beef Stew");
		LanguageRegistry.addName(bowlMeat, "Broth");
		
		// Recipes
		this.addShapelessRecipe(new ItemStack(bowlChicken, 1), Item.bowlEmpty, CounterManager.chickenStrips, CounterManager.chickenStrips, CounterManager.chickenStrips );
		this.addShapelessRecipe(new ItemStack(bowlBeef, 1), Item.bowlEmpty, CounterManager.beefSlices, CounterManager.beefSlices);
		this.addShapelessRecipe(new ItemStack(bowlMeat, 1), Item.bowlEmpty, CounterManager.chickenStrips, CounterManager.chickenStrips, CounterManager.beefSlices );
		System.out.println(this.recipes.size() + " recipes");
	}
}