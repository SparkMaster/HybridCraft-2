package hybridcraft.FoodStuff;

import hybridcraft.IngotStuff.CommonProxyHybrid;
import hybridcraft.IngotStuff.IngotBlock;
import net.minecraft.src.Block;
import net.minecraft.src.BlockWorkbench;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "HybridCraft 2 Food", name = "HybridCraft 2 Food", version = "2.2 beta 1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class HybridModFoodStuff {

	@SidedProxy(clientSide = "hybrid.client.ClientProxyHybrid", serverSide = "hybridcraft.IngotStuff.CommonProxyHybrid")
	public static CommonProxyHybrid proxy;
	
	//Declare Blocks
	public static Block Stove;
	public static Block Counter;
	// public static Block foodwb;
	
	//Declare Items
	public static Item BaB;
	public static Item PaB;
	public static Item CaB;
	public static Item DogBread;
	

	
	@Init
	public void load(FMLInitializationEvent event) {

		// Classify Blocks
		// foodwb = new FoodWorkbench(663).setHardness(2.5F).setStepSound(Block.soundWoodFootstep).setBlockName("foodwb");
		Stove = new Decor(678, 0).setStepSound(Block.soundMetalFootstep).setBlockName("Stove").setHardness(1F).setResistance(4F);
		Counter = new Decor(679, 1).setStepSound(Block.soundWoodFootstep).setBlockName("Counter").setHardness(1F).setResistance(4F);
		
		// Classify Items
		BaB = new FoodBread(662, 8, false).setIconIndex(0).setItemName("bab");
		PaB = new FoodBread(664, 10, false).setIconIndex(1).setItemName("pab");
		CaB = new FoodBread(665, 10, false).setIconIndex(2).setItemName("cab");
		DogBread = new FoodBread(677, 10, true).setIconIndex(3).setItemName("db");
		
		// Register Blocks
		GameRegistry.registerBlock(Stove);
		GameRegistry.registerBlock(Counter);
		//GameRegistry.registerBlock(foodwb);
		LanguageRegistry.addName(Stove, "Stove");
		LanguageRegistry.addName(Counter, "Counter");
		// LanguageRegistry.addName(foodwb, "Food Workbench [WIP]");
		
		// Register Items
		LanguageRegistry.addName(BaB, "Beef and Bread");
		LanguageRegistry.addName(PaB, "Pork and Bread");
		LanguageRegistry.addName(CaB, "Chicken and Bread");
		LanguageRegistry.addName(DogBread, "Dog Treat");
		
		// Shaped Block Recipes
		GameRegistry.addRecipe(new ItemStack(Stove, 1), new Object[]
				{
			"XXX", "XCX", "XXX", 'X', Item.ingotIron, 'C', Item.coal,
				});
		GameRegistry.addRecipe(new ItemStack(Counter, 3), new Object[]
				{
			"SSS", "XXX", "XXX", 'X', Block.wood, 'S', Block.stone,
				});
		
		// Shaped Item Recipes
		GameRegistry.addRecipe(new ItemStack(CaB, 2), new Object[]
				{
			"BB ", " B ", " BB", 'B', Item.bread
				});		
		
		// Shapeless Item Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(BaB, 2), new Object[]
				{
			new ItemStack(Item.beefRaw), new ItemStack(Item.bread)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(PaB, 2), new Object[]
				{
			new ItemStack(Item.porkRaw), new ItemStack(Item.bread)
				});
		GameRegistry.addShapelessRecipe(new ItemStack(CaB, 2), new Object[]
				{
			new ItemStack(Item.chickenRaw), new ItemStack(Item.bread)
				});
		
}
}