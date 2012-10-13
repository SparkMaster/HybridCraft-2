package hybridcraft.FoodStuff.kitchen;

import net.minecraft.src.*;
import hybridcraft.AbstractCraftingManager;
import hybridcraft.FoodStuff.*;
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
	
	private CookingPotManager() {

		// Classify Items
		bowlChicken = new Sandwich(hybridcraft.Config.bowlChickenID, 9).setIconIndex(12).setItemName("Chicken Soup");
		bowlBeef = new Sandwich(hybridcraft.Config.bowlBeefID, 8).setIconIndex(13).setItemName("Beef Stew");
		bowlMeat = new Sandwich(hybridcraft.Config.bowlMeatID, 10).setIconIndex(14).setItemName("Broth");
		
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