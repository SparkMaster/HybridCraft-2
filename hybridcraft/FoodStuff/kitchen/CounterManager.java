package hybridcraft.FoodStuff.kitchen;

import net.minecraft.src.*;
import hybridcraft.AbstractCraftingManager;
import hybridcraft.FoodStuff.*;
import cpw.mods.fml.common.registry.*;

public class CounterManager extends AbstractCraftingManager {

	private static final CounterManager instance = new CounterManager();

	public static CounterManager getInstance() {
		return instance;
	}

	public static Item breadSlice;
	public static Item chickenStrips;
	public static Item beefSlices;
	public static Item bacon;
	public static Item chickenSandwich;
	public static Item chickenSandwichBacon;
	public static Item beefSandwich;
	public static Item beefSandwichBacon;
	public static Item meatSandwich;

	private CounterManager() {

		// Classify Items
		breadSlice = new Sandwich(901, 1).setIconIndex(0).setItemName("Bread Slice");
		chickenStrips = new Sandwich(902, 3).setIconIndex(1).setItemName("Chicken Strips");
		beefSlices = new Sandwich(903, 4).setIconIndex(2).setItemName("Beef Slice");
		bacon = new Sandwich(904, 4).setIconIndex(3).setItemName("Bacon");
		chickenSandwich = new Sandwich(905, 8).setIconIndex(4).setItemName("Chicken Sandwich");
		chickenSandwichBacon = new Sandwich(906, 9).setIconIndex(5).setItemName("Chicken Sandwich");
		beefSandwich = new Sandwich(907, 10).setIconIndex(6).setItemName("Beef Sandwich");
		beefSandwichBacon = new Sandwich(908, 10).setIconIndex(7).setItemName("Pork Sandwich");
		meatSandwich = new Sandwich(909, 9).setIconIndex(8).setItemName("Meat Sandwich");

		// Register Items
		LanguageRegistry.addName(breadSlice, "Bread Slice");
		LanguageRegistry.addName(chickenStrips, "Chicken Strips");
		LanguageRegistry.addName(beefSlices, "Beef Slices");
		LanguageRegistry.addName(bacon, "Bacon");
		LanguageRegistry.addName(chickenSandwich, "Chicken Sandwich");
		LanguageRegistry.addName(chickenSandwichBacon, "Chicken Sandwich with Bacon");
		LanguageRegistry.addName(beefSandwich, "Beef Sandwich");
		LanguageRegistry.addName(beefSandwichBacon, "Beef Sandwich with Bacon");
		LanguageRegistry.addName(meatSandwich, "Meat Sandwich");

		// Shaped Item Recipes
		this.addRecipe(new ItemStack(chickenSandwich), new Object[] { " X ", "ZZ ", " X ", 'X', breadSlice, 'Z', chickenStrips });
		this.addRecipe(new ItemStack(chickenSandwichBacon), new Object[] { " X ", "YZ ", " X ", 'X', breadSlice, 'Z', chickenStrips, 'Y', bacon });
		this.addRecipe(new ItemStack(beefSandwich), new Object[] { " X ", "ZZ ", " X ", 'X', breadSlice, 'Z', beefSlices });
		this.addRecipe(new ItemStack(beefSandwichBacon), new Object[] { " X ", "YZ ", " X ", 'X', breadSlice, 'Z', beefSlices, 'Y', bacon });
		this.addRecipe(new ItemStack(meatSandwich), new Object[] { " X ", "YZ ", " X ", 'X', breadSlice, 'Z', chickenStrips, 'Y', beefSlices });
		this.addRecipe(new ItemStack(meatSandwich), new Object[] { " X ", "ZY ", " X ", 'X', breadSlice, 'Z', chickenStrips, 'Y', beefSlices });

		// Shapeless Item Recipes
		this.addShapelessRecipe(new ItemStack(breadSlice, 5), Item.bread);
		this.addShapelessRecipe(new ItemStack(chickenStrips, 2), Item.chickenCooked);
		this.addShapelessRecipe(new ItemStack(beefSlices, 2), Item.beefCooked);
		this.addShapelessRecipe(new ItemStack(bacon, 2), Item.porkCooked);
	}
}