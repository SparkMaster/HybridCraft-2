package hybridcraft.FoodStuff.kitchen;

import net.minecraft.src.*;
import hybridcraft.AbstractCraftingManager;
import hybridcraft.FoodStuff.*;
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
	
	private StoveManager() {

		// Classify Items
		BaB = new FoodBread(662, 8, false).setIconIndex(0).setItemName("bab");
		PaB = new FoodBread(664, 10, false).setIconIndex(1).setItemName("pab");
		CaB = new FoodBread(665, 10, false).setIconIndex(2).setItemName("cab");
		DogBread = new FoodBread(677, 10, true).setIconIndex(3).setItemName("db");
		
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
