package hybridcraft.IngotStuff;

import net.minecraft.src.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CombiningManager {
	
	/** The static instance of this class */
	private static final CombiningManager instance = new CombiningManager();

	/** A list of all the recipes added */
	private List recipes = new ArrayList();

	/**
	 * Returns the static instance of this class
	 */
	public static final CombiningManager getInstance() {
		return instance;
	}

	static Item dirtoneIngot;
	static Item dironIngot;
	static Item diroldIngot;
	static Item dirmendIngot;
	static Item stoneIngot;
	static Item stornIngot;
	static Item stoldIngot;
	static Item stomendIngot;
	static Item iroldIngot;
	static Item irmendIngot;
	static Item gomendIngot;

	private CombiningManager() {

		// Ingots

		final int dirtoneIngotID;
		final int dironIngotID;
		final int diroldIngotID;
		final int dirmendIngotID;
		final int stoneIngotID;
		final int stornIngotID;
		final int stoldIngotID;
		final int stomendIngotID;
		final int iroldIngotID;
		final int irmendIngotID;
		final int gomendIngotID;

		dirtoneIngotID = 561;
		dironIngotID = 562;
		diroldIngotID = 563;
		dirmendIngotID = 564;
		stoneIngotID = 565;
		stornIngotID = 566;
		stoldIngotID = 567;
		stomendIngotID = 568;
		iroldIngotID = 569;
		irmendIngotID = 570;
		gomendIngotID = 571;

		// Ingot
		dirtoneIngot = new Ingot(dirtoneIngotID).setIconIndex(1).setItemName("dirtoneIngot");
		dironIngot = new Ingot(dironIngotID).setIconIndex(2).setItemName("dironIngot");
		diroldIngot = new Ingot(diroldIngotID).setIconIndex(3).setItemName("diroldIngot");
		dirmendIngot = new Ingot(dirmendIngotID).setIconIndex(4).setItemName("dirmendIngot");
		stoneIngot = new Ingot(stoneIngotID).setIconIndex(5).setItemName("stoneIngot");
		stornIngot = new Ingot(stornIngotID).setIconIndex(6).setItemName("stornIngot");
		stoldIngot = new Ingot(stoldIngotID).setIconIndex(7).setItemName("stoldIngot");
		stomendIngot = new Ingot(stomendIngotID).setIconIndex(8).setItemName("stormendIngot");
		iroldIngot = new Ingot(iroldIngotID).setIconIndex(9).setItemName("iroldIngot");
		irmendIngot = new Ingot(irmendIngotID).setIconIndex(10).setItemName("irmendIngot");
		gomendIngot = new Ingot(gomendIngotID).setIconIndex(11).setItemName("gomendIngot");

		// Ingot Registry
		LanguageRegistry.addName(dirtoneIngot, "Dirtone Ingot");
		LanguageRegistry.addName(dironIngot, "Diron Ingot");
		LanguageRegistry.addName(diroldIngot, "Dirold Ingot");
		LanguageRegistry.addName(dirmendIngot, "Dirmend Ingot");
		LanguageRegistry.addName(stoneIngot, "Stone Ingot");
		LanguageRegistry.addName(stornIngot, "Storn Ingot");
		LanguageRegistry.addName(stoldIngot, "Stold Ingot");
		LanguageRegistry.addName(stomendIngot, "Stomend Ingot");
		LanguageRegistry.addName(iroldIngot, "Irold Ingot");
		LanguageRegistry.addName(irmendIngot, "Irmend Ingot");
		LanguageRegistry.addName(gomendIngot, "Gomend Ingot");

		// Ingot Recipes
		this.addRecipe(new ItemStack(dirtoneIngot), new Object[] { "XXX", "SSS", "XXX", 'X', Block.dirt, 'S', Block.stone, });
		this.addRecipe(new ItemStack(dironIngot), new Object[] { "XXX", "XIX", "XXX", 'X', Block.dirt, 'I', Item.ingotIron, });
		this.addRecipe(new ItemStack(diroldIngot), new Object[] { "XXX", "XGX", "XXX", 'X', Block.dirt, 'G', Item.ingotGold, });
		this.addRecipe(new ItemStack(dirmendIngot), new Object[] { "XXX", "XDX", "XXX", 'X', Block.dirt, 'D', Item.diamond, });
		this.addRecipe(new ItemStack(stoneIngot), new Object[] { "XXX", "XXX", "XXX", 'X', Block.stone, });
		this.addRecipe(new ItemStack(stornIngot), new Object[] { "XXX", "XIX", "XXX", 'X', Block.stone, 'I', Item.ingotIron, });
		this.addRecipe(new ItemStack(stoldIngot), new Object[] { "XXX", "XGX", "XXX", 'X', Block.stone, 'G', Item.ingotGold, });
		this.addRecipe(new ItemStack(stomendIngot), new Object[] { "XXX", "XDX", "XXX", 'X', Block.stone, 'D', Item.diamond, });
		this.addRecipe(new ItemStack(iroldIngot), new Object[] { "GXG", "XGX", "GXG", 'X', Item.ingotIron, 'G', Item.ingotGold, });
		this.addRecipe(new ItemStack(irmendIngot), new Object[] { "XXX", "XDX", "XXX", 'X', Item.ingotIron, 'D', Item.diamond, });
		this.addRecipe(new ItemStack(gomendIngot), new Object[] { "GGG", "GDG", "GGG", 'D', Item.diamond, 'G', Item.ingotGold, });
		System.out.println(this.recipes.size() + " recipes");
	}

	/**
	 * Adds a recipe. See spreadsheet on first page for details.
	 */
	public void addRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
		String var3 = "";
		int var4 = 0;
		int var5 = 0;
		int var6 = 0;
		int var9;

		if (par2ArrayOfObj[var4] instanceof String[]) {
			String[] var7 = (String[]) ((String[]) par2ArrayOfObj[var4++]);
			String[] var8 = var7;
			var9 = var7.length;

			for (int var10 = 0; var10 < var9; ++var10) {
				String var11 = var8[var10];
				++var6;
				var5 = var11.length();
				var3 = var3 + var11;
			}
		} else {
			while (par2ArrayOfObj[var4] instanceof String) {
				String var13 = (String) par2ArrayOfObj[var4++];
				++var6;
				var5 = var13.length();
				var3 = var3 + var13;
			}
		}

		HashMap var14;

		for (var14 = new HashMap(); var4 < par2ArrayOfObj.length; var4 += 2) {
			Character var16 = (Character) par2ArrayOfObj[var4];
			ItemStack var17 = null;

			if (par2ArrayOfObj[var4 + 1] instanceof Item) {
				var17 = new ItemStack((Item) par2ArrayOfObj[var4 + 1]);
			} else if (par2ArrayOfObj[var4 + 1] instanceof Block) {
				var17 = new ItemStack((Block) par2ArrayOfObj[var4 + 1], 1, -1);
			} else if (par2ArrayOfObj[var4 + 1] instanceof ItemStack) {
				var17 = (ItemStack) par2ArrayOfObj[var4 + 1];
			}

			var14.put(var16, var17);
		}

		ItemStack[] var15 = new ItemStack[var5 * var6];

		for (var9 = 0; var9 < var5 * var6; ++var9) {
			char var18 = var3.charAt(var9);

			if (var14.containsKey(Character.valueOf(var18))) {
				var15[var9] = ((ItemStack) var14.get(Character.valueOf(var18))).copy();
			} else {
				var15[var9] = null;
			}
		}

		this.recipes.add(new ShapedRecipes(var5, var6, var15, par1ItemStack));
	}

	public void addShapelessRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
		ArrayList var3 = new ArrayList();
		Object[] var4 = par2ArrayOfObj;
		int var5 = par2ArrayOfObj.length;

		for (int var6 = 0; var6 < var5; ++var6) {
			Object var7 = var4[var6];

			if (var7 instanceof ItemStack) {
				var3.add(((ItemStack) var7).copy());
			} else if (var7 instanceof Item) {
				var3.add(new ItemStack((Item) var7));
			} else {
				if (!(var7 instanceof Block)) {
					throw new RuntimeException("Invalid shapeless recipy!");
				}

				var3.add(new ItemStack((Block) var7));
			}
		}

		this.recipes.add(new ShapelessRecipes(par1ItemStack, var3));
	}

	public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting) {
		int var2 = 0;
		ItemStack var3 = null;
		ItemStack var4 = null;

		for (int var5 = 0; var5 < par1InventoryCrafting.getSizeInventory(); ++var5) {
			ItemStack var6 = par1InventoryCrafting.getStackInSlot(var5);

			if (var6 != null) {
				if (var2 == 0) {
					var3 = var6;
				}

				if (var2 == 1) {
					var4 = var6;
				}

				++var2;
			}
		}

		if (var2 == 2 && var3.itemID == var4.itemID && var3.stackSize == 1 && var4.stackSize == 1 && Item.itemsList[var3.itemID].isRepairable()) {
			Item var10 = Item.itemsList[var3.itemID];
			int var12 = var10.getMaxDamage() - var3.getItemDamageForDisplay();
			int var7 = var10.getMaxDamage() - var4.getItemDamageForDisplay();
			int var8 = var12 + var7 + var10.getMaxDamage() * 10 / 100;
			int var9 = var10.getMaxDamage() - var8;

			if (var9 < 0) {
				var9 = 0;
			}

			return new ItemStack(var3.itemID, 1, var9);
		} else {
			Iterator var11 = this.recipes.iterator();
			IRecipe var13;

			do {
				if (!var11.hasNext()) {
					return null;
				}

				var13 = (IRecipe) var11.next();
			} while (!var13.matches(par1InventoryCrafting));

			return var13.getCraftingResult(par1InventoryCrafting);
		}
	}

	/**
	 * returns the List<> of all recipes
	 */
	public List getRecipeList() {
		return this.recipes;
	}
}
