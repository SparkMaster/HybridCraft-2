//Tools 601-700
//Ingots 701-800
//Armors 801-900
//Blocks 401-800
//Flowers 901-950

package hybridcraft.IngotStuff;

import java.util.Random;
import hybridcraft.*;
import hybridcraft.IngotStuff.armor.*;
import hybridcraft.IngotStuff.hybridizer.BlockHybridizer;
import hybridcraft.IngotStuff.hybridizer.GuiHandler;
import hybridcraft.IngotStuff.hybridizer.HybridizingManager;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Achievement;
import net.minecraft.src.AchievementList;

@Mod(modid = "HybridCraft 2 Materials", name = "HybridCraft 2 Materials", version = "2.2 Stable")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class HybridModIngotStuff implements ICraftingHandler {

	// Instance
	@Instance("HybridCraft 2 Materials")
	public static HybridModIngotStuff instance = new HybridModIngotStuff();

	// Proxy
	@SidedProxy(clientSide = "hybrid.client.ClientProxyHybrid", serverSide = "hybridcraft.CommonProxyHybrid")
	public static CommonProxyHybrid proxy;
	
	// Combiner GUI
	private GuiHandler guiHandler = new GuiHandler();

	// Tool Materials
	static EnumToolMaterial dirt = EnumHelper.addToolMaterial("dirt", 0, 30, 1.0F, 0, 15);
	static EnumToolMaterial dirtone = EnumHelper.addToolMaterial("dirtone", 1, 80, 2.0F, 1, 14);
	static EnumToolMaterial diron = EnumHelper.addToolMaterial("diron", 1, 140, 3.5F, 1, 14);
	static EnumToolMaterial dirold = EnumHelper.addToolMaterial("dirold", 0, 31, 6.5F, 0, 14);
	static EnumToolMaterial dirmend = EnumHelper.addToolMaterial("dirmend", 2, 795, 4.5F, 2, 14);
	static EnumToolMaterial storn = EnumHelper.addToolMaterial("storn", 2, 190, 5.0F, 2, 14);
	static EnumToolMaterial stold = EnumHelper.addToolMaterial("stold", 2, 81, 8.0F, 2, 14);
	static EnumToolMaterial stomend = EnumHelper.addToolMaterial("stomend", 2, 846, 6.0F, 2, 14);
	static EnumToolMaterial irold = EnumHelper.addToolMaterial("irold", 2, 141, 9.0F, 2, 14);
	static EnumToolMaterial irmend = EnumHelper.addToolMaterial("irmend", 2, 905, 7.0F, 2, 14);
	static EnumToolMaterial gomend = EnumHelper.addToolMaterial("gomend", 2, 796, 10.0F, 2, 14);
	static EnumToolMaterial obsidian = EnumHelper.addToolMaterial("obsidian", 3, 1233, 12.0F, 3, 14);
	static EnumToolMaterial sand = EnumHelper.addToolMaterial("sand", 0, 35, 2.0F, 0, 14);
	static EnumToolMaterial cobble = EnumHelper.addToolMaterial("cobble", 0, 75, 1.0F, 0, 14);
	static EnumToolMaterial emerald = EnumHelper.addToolMaterial("emerald", 4, 2000, 20.0F, 3, 27);

	// Armor Materials
	static EnumArmorMaterial dirta = EnumHelper.addArmorMaterial("dirt", 30, new int[] { 1, 1, 1, 1 }, 14);
	static EnumArmorMaterial dirtonea = EnumHelper.addArmorMaterial("dirtone", 40, new int[] { 1, 2, 1, 1 }, 14);
	static EnumArmorMaterial dirona = EnumHelper.addArmorMaterial("diron", 70, new int[] { 1, 2, 1, 2 }, 14);
	static EnumArmorMaterial dirolda = EnumHelper.addArmorMaterial("dirold", 31, new int[] { 1, 2, 2, 2 }, 14);
	static EnumArmorMaterial dirmenda = EnumHelper.addArmorMaterial("dirmend", 90, new int[] { 2, 2, 2, 2 }, 14);
	static EnumArmorMaterial storna = EnumHelper.addArmorMaterial("storn", 80, new int[] { 2, 3, 2, 3 }, 14);
	static EnumArmorMaterial stolda = EnumHelper.addArmorMaterial("stold", 37, new int[] { 2, 3, 3, 3 }, 14);
	static EnumArmorMaterial stomenda = EnumHelper.addArmorMaterial("stomend", 100, new int[] { 3, 3, 3, 3 }, 14);
	static EnumArmorMaterial irolda = EnumHelper.addArmorMaterial("irold", 44, new int[] { 3, 4, 3, 3 }, 14);
	static EnumArmorMaterial irmenda = EnumHelper.addArmorMaterial("irmend", 120, new int[] { 3, 4, 3, 4 }, 14);
	static EnumArmorMaterial gomenda = EnumHelper.addArmorMaterial("gomend", 150, new int[] { 4, 4, 4, 4 }, 14);
	static EnumArmorMaterial obsidiana = EnumHelper.addArmorMaterial("obsidian", 300, new int[] { 10, 10, 10, 10 }, 14);
	static EnumArmorMaterial stonea = EnumHelper.addArmorMaterial("stone", 50, new int[] { 2, 3, 2, 2 }, 14);
	static EnumArmorMaterial sanda = EnumHelper.addArmorMaterial("sand", 60, new int[] { 2, 1, 2, 2, }, 14);
	static EnumArmorMaterial emeralda = EnumHelper.addArmorMaterial("emerald", 500, new int[] { 12, 12, 12, 12 }, 27);

	
	
	// Tools
	public static Item dirtsword;
	public static Item dirtpick;
	public static Item dirtaxe;
	public static Item dirtshovel;
	public static Item dirthoe;
	public static Item dirtonesword;
	public static Item dirtonepick;
	public static Item dirtoneaxe;
	public static Item dirtoneshovel;
	public static Item dirtonehoe;
	public static Item dironsword;
	public static Item dironpick;
	public static Item dironaxe;
	public static Item dironshovel;
	public static Item dironhoe;
	public static Item diroldsword;
	public static Item diroldpick;
	public static Item diroldaxe;
	public static Item diroldshovel;
	public static Item diroldhoe;
	public static Item dirmendsword;
	public static Item dirmendpick;
	public static Item dirmendaxe;
	public static Item dirmendshovel;
	public static Item dirmendhoe;
	public static Item stornsword;
	public static Item stornpick;
	public static Item stornaxe;
	public static Item stornshovel;
	public static Item stornhoe;
	public static Item stoldsword;
	public static Item stoldpick;
	public static Item stoldaxe;
	public static Item stoldshovel;
	public static Item stoldhoe;
	public static Item stomendsword;
	public static Item stomendpick;
	public static Item stomendaxe;
	public static Item stomendshovel;
	public static Item stomendhoe;
	public static Item iroldsword;
	public static Item iroldpick;
	public static Item iroldaxe;
	public static Item iroldshovel;
	public static Item iroldhoe;
	public static Item irmendsword;
	public static Item irmendpick;
	public static Item irmendaxe;
	public static Item irmendshovel;
	public static Item irmendhoe;
	public static Item gomendsword;
	public static Item gomendpick;
	public static Item gomendaxe;
	public static Item gomendshovel;
	public static Item gomendhoe;
	public static Item obsidiansword;
	public static Item obsidianpick;
	public static Item obsidianaxe;
	public static Item obsidianshovel;
	public static Item obsidianhoe;
	public static Item sandsword;
	public static Item sandpick;
	public static Item sandaxe;
	public static Item sandshovel;
	public static Item sandhoe;
	public static Item cobblesword;
	public static Item cobblepick;
	public static Item cobbleaxe;
	public static Item cobbleshovel;
	public static Item cobblehoe;
	public static Item emeraldsword;
	public static Item emeraldpick;
	public static Item emeraldaxe;
	public static Item emeraldshovel;
	public static Item emeraldhoe;

	// Ingots
	public static Item dirtIngot;
	public static Item obsidianShard;
	public static Item obsidianIngot;
	public static Item sandIngot;
	public static Item stoneIngot;

	// Armors
	public static Item dirtHelmet;
	public static Item dirtPlate;
	public static Item dirtLegs;
	public static Item dirtBoots;
	public static Item dirtoneHelmet;
	public static Item dirtonePlate;
	public static Item dirtoneLegs;
	public static Item dirtoneBoots;
	public static Item dironHelmet;
	public static Item dironPlate;
	public static Item dironLegs;
	public static Item dironBoots;
	public static Item diroldHelmet;
	public static Item diroldPlate;
	public static Item diroldLegs;
	public static Item diroldBoots;
	public static Item dirmendHelmet;
	public static Item dirmendPlate;
	public static Item dirmendLegs;
	public static Item dirmendBoots;
	public static Item stornHelmet;
	public static Item stornPlate;
	public static Item stornLegs;
	public static Item stornBoots;
	public static Item stoldHelmet;
	public static Item stoldPlate;
	public static Item stoldLegs;
	public static Item stoldBoots;
	public static Item stomendHelmet;
	public static Item stomendPlate;
	public static Item stomendLegs;
	public static Item stomendBoots;
	public static Item iroldHelmet;
	public static Item iroldPlate;
	public static Item iroldLegs;
	public static Item iroldBoots;
	public static Item irmendHelmet;
	public static Item irmendPlate;
	public static Item irmendLegs;
	public static Item irmendBoots;
	public static Item gomendHelmet;
	public static Item gomendPlate;
	public static Item gomendLegs;
	public static Item gomendBoots;
	public static Item obsidianHelmet;
	public static Item obsidianPlate;
	public static Item obsidianLegs;
	public static Item obsidianBoots;
	public static Item stoneHelmet;
	public static Item stonePlate;
	public static Item stoneLegs;
	public static Item stoneBoots;
	public static Item sandHelmet;
	public static Item sandPlate;
	public static Item sandLegs;
	public static Item sandBoots;
	public static Item emeraldHelmet;
	public static Item emeraldPlate;
	public static Item emeraldLegs;
	public static Item emeraldBoots;

	// Ingot Blocks
	public static Block dirtBlock;
	public static Block dirtoneBlock;
	public static Block dironBlock;
	public static Block diroldBlock;
	public static Block dirmendBlock;
	public static Block stoneBlock;
	public static Block stornBlock;
	public static Block stoldBlock;
	public static Block stomendBlock;
	public static Block iroldBlock;
	public static Block irmendBlock;
	public static Block gomendBlock;
	public static Block sandBlock;

	// World Blocks
	public static Block dand;
	public static Block davel;
	public static Block done;

	// Flowers
	public static BlockFlower dirtFlower;
	public static BlockFlower stoneFlower;
	public static BlockFlower ironFlower;
	public static BlockFlower goldFlower;
	public static BlockFlower diamondFlower;
	public static BlockFlower obsidianFlower;
	public static BlockFlower emeraldFlower;
	
	// Achievement
	public static final Achievement DirtAchieve = new Achievement(2000, "DirtAchieve", 0, 0, Block.dirt, null).setIndependent().registerAchievement();
	
	public static AchievementPage HC1 = new AchievementPage("HybridCraft2", DirtAchieve);
	
	// Crafting
	public static BlockHybridizer blockHybridizer;
	
	// Config
	public static final String CATEGORY_TOOL = "tools";
	public static final String CATEGORY_INGOT = "ingots";
	public static final String CATEGORY_ARMOR = "armors";
	public static final String CATEGORY_FLOWER = "flowers";

	public static int  dirtswordID;
	public static int  dirtpickID;
	public static int  dirtaxeID;
	public static int  dirtshovelID;
	public static int  dirthoeID;
	public static int  dirtoneswordID;
	public static int  dirtonepickID;
	public static int  dirtoneaxeID;
	public static int  dirtoneshovelID;
	public static int  dirtonehoeID;
	public static int  dironswordID;
	public static int  dironpickID;
	public static int  dironaxeID;
	public static int  dironshovelID;
	public static int  dironhoeID;
	public static int  diroldswordID;
	public static int  diroldpickID;
	public static int  diroldaxeID;
	public static int  diroldshovelID;
	public static int  diroldhoeID;
	public static int  dirmendswordID;
	public static int  dirmendpickID;
	public static int  dirmendaxeID;
	public static int  dirmendshovelID;
	public static int  dirmendhoeID;
	public static int  stornswordID;
	public static int  stornpickID;
	public static int  stornaxeID;
	public static int  stornshovelID;
	public static int  stornhoeID;
	public static int  stoldswordID;
	public static int  stoldpickID;
	public static int  stoldaxeID;
	public static int  stoldshovelID;
	public static int  stoldhoeID;
	public static int  stomendswordID;
	public static int  stomendpickID;
	public static int  stomendaxeID;
	public static int  stomendshovelID;
	public static int  stomendhoeID;
	public static int  iroldswordID;
	public static int  iroldpickID;
	public static int  iroldaxeID;
	public static int  iroldshovelID;
	public static int  iroldhoeID;
	public static int  irmendswordID;
	public static int  irmendpickID;
	public static int  irmendaxeID;
	public static int  irmendshovelID;
	public static int  irmendhoeID;
	public static int  gomendswordID;
	public static int  gomendpickID;
	public static int  gomendaxeID;
	public static int  gomendshovelID;
	public static int  gomendhoeID;
	public static int  obsidianswordID;
	public static int  obsidianpickID;
	public static int  obsidianaxeID;
	public static int  obsidianshovelID;
	public static int  obsidianhoeID;
	public static int  dirtHelmetID;
	public static int  dirtPlateID;
	public static int  dirtLegsID;
	public static int  dirtBootsID;
	public static int  dirtoneHelmetID;
	public static int  dirtonePlateID;
	public static int  dirtoneLegsID;
	public static int  dirtoneBootsID;
	public static int  dironHelmetID;
	public static int  dironPlateID;
	public static int  dironLegsID;
	public static int  dironBootsID;
	public static int  diroldHelmetID;
	public static int  diroldPlateID;
	public static int  diroldLegsID;
	public static int  diroldBootsID;
	public static int  dirmendHelmetID;
	public static int  dirmendPlateID;
	public static int  dirmendLegsID;
	public static int  dirmendBootsID;
	public static int  stornHelmetID;
	public static int  stornPlateID;
	public static int  stornLegsID;
	public static int  stornBootsID;
	public static int  stoldHelmetID;
	public static int  stoldPlateID;
	public static int  stoldLegsID;
	public static int  stoldBootsID;
	public static int  stomendHelmetID;
	public static int  stomendPlateID;
	public static int  stomendLegsID;
	public static int  stomendBootsID;
	public static int  iroldHelmetID;
	public static int  iroldPlateID;
	public static int  iroldLegsID;
	public static int  iroldBootsID;
	public static int  irmendHelmetID;
	public static int  irmendPlateID;
	public static int  irmendLegsID;
	public static int  irmendBootsID;
	public static int  gomendHelmetID;
	public static int  gomendPlateID;
	public static int  gomendLegsID;
	public static int  gomendBootsID;
	public static int  obsidianHelmetID;
	public static int  obsidianPlateID;
	public static int  obsidianLegsID;
	public static int  obsidianBootsID;
	public static int  dirtBlockID;
	public static int  dirtoneBlockID;
	public static int  dironBlockID;
	public static int  diroldBlockID;
	public static int  dirmendBlockID;
	public static int  stoneBlockID;
	public static int  stornBlockID;
	public static int  stoldBlockID;
	public static int  stomendBlockID;
	public static int  iroldBlockID;
	public static int  irmendBlockID;
	public static int  gomendBlockID;
	public static int  dandID;
	public static int  davelID;
	public static int  doneID;
	public static int  dirtFlowerID;
	public static int  stoneFlowerID;
	public static int  ironFlowerID;
	public static int  goldFlowerID;
	public static int  diamondFlowerID;
	public static int  obsidianFlowerID;
	public static int  sandBlockID;
	public static int  stoneHelmetID;
	public static int  stonePlateID;
	public static int  stoneLegsID;
	public static int  stoneBootsID;
	public static int  sandHelmetID;
	public static int  sandPlateID;
	public static int  sandLegsID;
	public static int  sandBootsID;
	public static int  sandswordID;
	public static int  sandpickID;
	public static int  sandaxeID;
	public static int  sandshovelID;
	public static int  sandhoeID;
	public static int  cobbleswordID;
	public static int  cobblepickID;
	public static int  cobbleaxeID;
	public static int  cobbleshovelID;
	public static int  cobblehoeID;
	public static int  emeraldswordID;
	public static int  emeraldpickID;
	public static int  emeraldaxeID;
	public static int  emeraldshovelID;
	public static int  emeraldhoeID;
	public static int  emeraldflowerID;
	public static int  emeraldhelmetID;
	public static int  emeraldplateID;
	public static int  emeraldlegsID;
	public static int  emeraldbootsID;
	public static int  combinerID;
	public static int  obsidianShardID;
	public static int  obsidianIngotID;
	public static int  sandIngotID;
	public static int  dirtIngotID;
	public static int  stoneIngotID;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		obsidianShardID = config.get(CATEGORY_INGOT, "Obsidian Shard", 500).getInt();
		obsidianIngotID = config.get(CATEGORY_INGOT, "Obsidian Ingot", 501).getInt();
		sandIngotID = config.get(CATEGORY_INGOT, "Sand Ingot", 502).getInt();
		dirtIngotID = config.get(CATEGORY_INGOT, "Dirt Ingot", 503).getInt();
		dirtswordID = config.get(CATEGORY_TOOL, "Dirt Sword", 504).getInt();
		dirtpickID = config.get(CATEGORY_TOOL, "Dirt Pickaxe", 505).getInt();
		dirtaxeID = config.get(CATEGORY_TOOL, "Dirt Axe", 506).getInt();
		dirtshovelID = config.get(CATEGORY_TOOL, "Dirt Shovel", 507).getInt();
		dirthoeID = config.get(CATEGORY_TOOL, "Dirt Hoe", 508).getInt();
		dirtoneswordID = config.get(CATEGORY_TOOL, "Dirtone Sword", 509).getInt();
		dirtonepickID = config.get(CATEGORY_TOOL, "Dirtone Pickaxe", 510).getInt();
		dirtoneaxeID = config.get(CATEGORY_TOOL, "Dirtone Axe", 511).getInt();
		dirtoneshovelID = config.get(CATEGORY_TOOL, "Dirtone Shovel", 512).getInt();
		dirtonehoeID = config.get(CATEGORY_TOOL, "Dirtone Hoe", 513).getInt();
		dironswordID = config.get(CATEGORY_TOOL, "Diron Sword", 514).getInt();
		dironpickID = config.get(CATEGORY_TOOL, "Diron Pickaxe", 515).getInt();
		dironaxeID = config.get(CATEGORY_TOOL, "Diron Axe", 516).getInt();
		dironshovelID = config.get(CATEGORY_TOOL, "Diron Shovel", 517).getInt();
		dironhoeID = config.get(CATEGORY_TOOL, "Diron Hoe", 518).getInt();
		diroldswordID = config.get(CATEGORY_TOOL, "Dirold Sword", 519).getInt();
		diroldpickID = config.get(CATEGORY_TOOL, "Dirold Pickaxe", 520).getInt();
		diroldaxeID = config.get(CATEGORY_TOOL, "Dirold Axe", 521).getInt();
		diroldshovelID = config.get(CATEGORY_TOOL, "Dirold Shovel", 522).getInt();
		diroldhoeID = config.get(CATEGORY_TOOL, "Dirold Hoe", 523).getInt();
		dirmendswordID = config.get(CATEGORY_TOOL, "Dirmend Sword", 524).getInt();
		dirmendpickID = config.get(CATEGORY_TOOL, "Dirmend Pickaxe", 525).getInt();
		dirmendaxeID = config.get(CATEGORY_TOOL, "Dirmend Axe", 526).getInt();
		dirmendshovelID = config.get(CATEGORY_TOOL, "Dirmend Shovel", 527).getInt();
		dirmendhoeID = config.get(CATEGORY_TOOL, "Dirmend Hoe", 528).getInt();
		stornswordID = config.get(CATEGORY_TOOL, "Storn Sword", 529).getInt();
		stornpickID = config.get(CATEGORY_TOOL, "Storn Pick", 530).getInt();
		stornaxeID = config.get(CATEGORY_TOOL, "Storn Axe", 531).getInt();
		stornshovelID = config.get(CATEGORY_TOOL, "Storn Shovel", 532).getInt();
		stornhoeID = config.get(CATEGORY_TOOL, "Storn Hoe", 533).getInt();
		stoldswordID = config.get(CATEGORY_TOOL, "Stold Sword", 534).getInt();
		stoldpickID = config.get(CATEGORY_TOOL, "Stold Pickaxe", 535).getInt();
		stoldaxeID = config.get(CATEGORY_TOOL, "Stold Axe", 536).getInt();
		stoldshovelID = config.get(CATEGORY_TOOL, "Stold Shovel", 537).getInt();
		stoldhoeID = config.get(CATEGORY_TOOL, "Stold Hoe", 538).getInt();
		stomendswordID = config.get(CATEGORY_TOOL, "Stomend Sword", 539).getInt();
		stomendpickID = config.get(CATEGORY_TOOL, "Stomend Pickaxe", 540).getInt();
		stomendaxeID = config.get(CATEGORY_TOOL, "Stomend Axe", 541).getInt();
		stomendshovelID = config.get(CATEGORY_TOOL, "Stomend Shovel", 542).getInt();
		stomendhoeID = config.get(CATEGORY_TOOL, "Stomend Hoe", 543).getInt();
		iroldswordID = config.get(CATEGORY_TOOL, "Irold Sword", 544).getInt();
		iroldpickID = config.get(CATEGORY_TOOL, "Irold Pickaxe", 545).getInt();
		iroldaxeID = config.get(CATEGORY_TOOL, "Irold Axe", 546).getInt();
		iroldshovelID = config.get(CATEGORY_TOOL, "Irold Shovel", 547).getInt();
		iroldhoeID = config.get(CATEGORY_TOOL, "Irold Hoe", 548).getInt();
		irmendswordID = config.get(CATEGORY_TOOL, "Irmend Sword", 549).getInt();
		irmendpickID = config.get(CATEGORY_TOOL, "Irmend Pick", 550).getInt();
		irmendaxeID = config.get(CATEGORY_TOOL, "Irmend Axe", 551).getInt();
		irmendshovelID = config.get(CATEGORY_TOOL, "Irmend Shovel", 552).getInt();
		irmendhoeID = config.get(CATEGORY_TOOL, "Irmend Hoe", 553).getInt();
		gomendswordID = config.get(CATEGORY_TOOL, "Gomend Sword", 554).getInt();
		gomendpickID = config.get(CATEGORY_TOOL, "Gomend Pickaxe", 555).getInt();
		gomendaxeID = config.get(CATEGORY_TOOL, "Gomend Axe", 556).getInt();
		gomendshovelID = config.get(CATEGORY_TOOL, "Gomend Shovel", 557).getInt();
		gomendhoeID = config.get(CATEGORY_TOOL, "Gomend Hoe", 558).getInt();
		obsidianswordID = config.get(CATEGORY_TOOL, "Obsidian Sword", 559).getInt();
		obsidianpickID = config.get(CATEGORY_TOOL, "Obsidian Pickaxe", 560).getInt();
		obsidianaxeID = config.get(CATEGORY_TOOL, "Obsidian Axe", 561).getInt();
		obsidianshovelID = config.get(CATEGORY_TOOL, "Obsidian Shovel", 562).getInt();
		obsidianhoeID = config.get(CATEGORY_TOOL, "Obsidian Hoe", 563).getInt();
		dirtHelmetID = config.get(CATEGORY_ARMOR, "Dirt Helmet ", 564).getInt();
		dirtPlateID = config.get(CATEGORY_ARMOR, "Dirt Chestplate", 565).getInt();
		dirtLegsID = config.get(CATEGORY_ARMOR, "Dirt Leggings", 566).getInt();
		dirtBootsID = config.get(CATEGORY_ARMOR, "Dirt Boots", 567).getInt();
		dirtoneHelmetID = config.get(CATEGORY_ARMOR, "Dirtone Helmet", 568).getInt();
		dirtonePlateID = config.get(CATEGORY_ARMOR, "Dirtone Chestplate", 569).getInt();
		dirtoneLegsID = config.get(CATEGORY_ARMOR, "Dirtone Leggings", 570).getInt();
		dirtoneBootsID = config.get(CATEGORY_ARMOR, "Dirtone Boots", 571).getInt();
		dironHelmetID = config.get(CATEGORY_ARMOR, "Diron Helmet", 572).getInt();
		dironPlateID = config.get(CATEGORY_ARMOR, "Diron Chestplate", 573).getInt();
		dironLegsID = config.get(CATEGORY_ARMOR, "Diron Leggings", 574).getInt();
		dironBootsID = config.get(CATEGORY_ARMOR, "Diron Boots", 575).getInt();
		diroldHelmetID = config.get(CATEGORY_ARMOR, "Dirold Helmet", 576).getInt();
		diroldPlateID = config.get(CATEGORY_ARMOR, "Dirold Chestplate", 577).getInt();
		diroldLegsID = config.get(CATEGORY_ARMOR, "Dirold Leggings", 578).getInt();
		diroldBootsID = config.get(CATEGORY_ARMOR, "Dirold Boots", 579).getInt();
		dirmendHelmetID = config.get(CATEGORY_ARMOR, "Dirmend Helmet", 580).getInt();
		dirmendPlateID = config.get(CATEGORY_ARMOR, "Dirmend Chestplate", 581).getInt();
		dirmendLegsID = config.get(CATEGORY_ARMOR, "Dirmend Leggings", 582).getInt();
		dirmendBootsID = config.get(CATEGORY_ARMOR, "Dirmend Boots", 583).getInt();
		stornHelmetID = config.get(CATEGORY_ARMOR, "Storn Helmet", 584).getInt();
		stornPlateID = config.get(CATEGORY_ARMOR, "Storn Chestplate", 585).getInt();
		stornLegsID = config.get(CATEGORY_ARMOR, "Storn Leggings", 586).getInt();
		stornBootsID = config.get(CATEGORY_ARMOR, "Storn Boots", 587).getInt();
		stoldHelmetID = config.get(CATEGORY_ARMOR, "Stold Helmet", 588).getInt();
		stoldPlateID = config.get(CATEGORY_ARMOR, "Stold Chestplate", 589).getInt();
		stoldLegsID = config.get(CATEGORY_ARMOR, "Stold Leggings", 590).getInt();
		stoldBootsID = config.get(CATEGORY_ARMOR, "Stold Boots", 591).getInt();
		stomendHelmetID = config.get(CATEGORY_ARMOR, "Stomend Helmet", 592).getInt();
		stomendPlateID = config.get(CATEGORY_ARMOR, "Stomend Chestplate", 593).getInt();
		stomendLegsID = config.get(CATEGORY_ARMOR, "Stomend Leggings", 594).getInt();
		stomendBootsID = config.get(CATEGORY_ARMOR, "Stomend Boots", 595).getInt();
		iroldHelmetID = config.get(CATEGORY_ARMOR, "Irold Helmet", 596).getInt();
		iroldPlateID = config.get(CATEGORY_ARMOR, "Irold Chestplate", 597).getInt();
		iroldLegsID = config.get(CATEGORY_ARMOR, "Irold Leggings", 598).getInt();
		iroldBootsID = config.get(CATEGORY_ARMOR, "Irold Boots", 599).getInt();
		irmendHelmetID = config.get(CATEGORY_ARMOR, "Irmend Helmet", 600).getInt();
		irmendPlateID = config.get(CATEGORY_ARMOR, "Irmend Chestplate", 601).getInt();
		irmendLegsID = config.get(CATEGORY_ARMOR, "Irmend Leggings", 602).getInt();
		irmendBootsID = config.get(CATEGORY_ARMOR, "Irmend Boots", 603).getInt();
		gomendHelmetID = config.get(CATEGORY_ARMOR, "Gomend Helmet", 604).getInt();
		gomendPlateID = config.get(CATEGORY_ARMOR, "Gomend Chestplate", 605).getInt();
		gomendLegsID = config.get(CATEGORY_ARMOR, "Gomend Leggings", 606).getInt();
		gomendBootsID = config.get(CATEGORY_ARMOR, "Gomend Boots", 607).getInt();
		obsidianHelmetID = config.get(CATEGORY_ARMOR, "Obsidian Helmet", 608).getInt();
		obsidianPlateID = config.get(CATEGORY_ARMOR, "Obsidian Chestplate", 609).getInt();
		obsidianLegsID = config.get(CATEGORY_ARMOR, "Obsidian Leggings", 610).getInt();
		obsidianBootsID = config.get(CATEGORY_ARMOR, "Obsidian Boots", 611).getInt();
		dirtBlockID = config.get(Configuration.CATEGORY_BLOCK, "Dirt Ingot Block", 612).getInt();
		dirtoneBlockID = config.get(Configuration.CATEGORY_BLOCK, "Dirtone Ingot Block", 613).getInt();
		dironBlockID = config.get(Configuration.CATEGORY_BLOCK, "Diron Ingot Block", 614).getInt();
		diroldBlockID = config.get(Configuration.CATEGORY_BLOCK, "Dirold Ingot Block", 615).getInt();
		dirmendBlockID = config.get(Configuration.CATEGORY_BLOCK, "Dirmend Ingot Block", 616).getInt();
		stoneBlockID = config.get(Configuration.CATEGORY_BLOCK,	"Stone Ingot Block", 617).getInt();
		stornBlockID = config.get(Configuration.CATEGORY_BLOCK,	"Storn Ingot Block", 618).getInt();
		stoldBlockID = config.get(Configuration.CATEGORY_BLOCK,	"Stold Ingot Block", 619).getInt();
		stomendBlockID = config.get(Configuration.CATEGORY_BLOCK, "Stomend Ingot Block", 620).getInt();
		iroldBlockID = config.get(Configuration.CATEGORY_BLOCK,	"Irold Ingot Block", 621).getInt();
		irmendBlockID = config.get(Configuration.CATEGORY_BLOCK, "Irmend Ingot Block", 622).getInt();
		gomendBlockID = config.get(Configuration.CATEGORY_BLOCK, "Gomend Ingot Block", 623).getInt();
		dandID = config.get(Configuration.CATEGORY_BLOCK, "Dirt/Sand Block", 624).getInt();
		davelID = config.get(Configuration.CATEGORY_BLOCK, "Dirt/Gravel Block",	625).getInt();
		doneID = config.get(Configuration.CATEGORY_BLOCK, "Dirt/Stone Block", 626).getInt();
		dirtFlowerID = config.get(CATEGORY_FLOWER, "Dirt Flower", 627).getInt();
		stoneFlowerID = config.get(CATEGORY_FLOWER, "Stone Flower", 628).getInt();
		ironFlowerID = config.get(CATEGORY_FLOWER, "Iron Flower", 629).getInt();
		goldFlowerID = config.get(CATEGORY_FLOWER, "Gold Flower", 630).getInt();
		diamondFlowerID = config.get(CATEGORY_FLOWER, "Diamond Flower", 631).getInt();
		sandBlockID = config.get(Configuration.CATEGORY_BLOCK, "Sand Ingot Block", 633).getInt();
		stoneHelmetID = config.get(CATEGORY_ARMOR, "Stone Helmet", 634).getInt();
		stonePlateID = config.get(CATEGORY_ARMOR, "Stone Chestplate", 635).getInt();
		stoneLegsID = config.get(CATEGORY_ARMOR, "Stone Leggings", 636).getInt();
		stoneBootsID = config.get(CATEGORY_ARMOR, "Stone Boots", 637).getInt();
		sandHelmetID = config.get(CATEGORY_ARMOR, "Sand Helmet", 638).getInt();
		sandPlateID = config.get(CATEGORY_ARMOR, "Sand Chestplate", 639).getInt();
		sandLegsID = config.get(CATEGORY_ARMOR, "Sand Leggings", 640).getInt();
		sandBootsID = config.get(CATEGORY_ARMOR, "Sand Boots", 641).getInt();
		sandswordID = config.get(CATEGORY_TOOL, "Sand Sword", 642).getInt();
		sandpickID = config.get(CATEGORY_TOOL, "Sand Pickaxe", 643).getInt();
		sandaxeID = config.get(CATEGORY_TOOL, "Sand Axe", 644).getInt();
		sandshovelID = config.get(CATEGORY_TOOL, "Sand Shovel", 645).getInt();
		sandhoeID = config.get(CATEGORY_TOOL, "Sand Hoe", 646).getInt();
		cobbleswordID = config.get(CATEGORY_TOOL, "Cobble Sword", 647).getInt();
		cobblepickID = config.get(CATEGORY_TOOL, "Cobble Pickaxe", 648).getInt();
		cobbleaxeID = config.get(CATEGORY_TOOL, "Cobble Axe", 649).getInt();
		cobbleshovelID = config.get(CATEGORY_TOOL, "Cobble Shovel", 650).getInt();
		cobblehoeID = config.get(CATEGORY_TOOL, "Cobble Hoe", 651).getInt();
		obsidianFlowerID = config.get(CATEGORY_FLOWER, "Obsidian Flower", 652).getInt();
		emeraldswordID = config.get(CATEGORY_TOOL, "Emerald Sword", 653).getInt();
		emeraldpickID = config.get(CATEGORY_TOOL, "Emerald Pickaxe", 654).getInt();
		emeraldaxeID = config.get(CATEGORY_TOOL, "Emerald Axe", 655).getInt();
		emeraldshovelID = config.get(CATEGORY_TOOL, "Emerald Shovel", 656).getInt();
		emeraldhoeID = config.get(CATEGORY_TOOL, "Emerald Hoe", 657).getInt();
		emeraldflowerID = config.get(CATEGORY_FLOWER, "Emerald Flower", 658).getInt();
		emeraldhelmetID = config.get(CATEGORY_ARMOR, "Emerald Helmet", 659).getInt();
		emeraldplateID = config.get(CATEGORY_ARMOR, "Emerald Chestplate", 660).getInt();
		emeraldlegsID = config.get(CATEGORY_ARMOR, "Emerald Leggings", 661).getInt();
		emeraldbootsID = config.get(CATEGORY_ARMOR, "Emerald Boots", 662).getInt();
		combinerID = config.get(CATEGORY_ARMOR, "Combiner", 663).getInt();
		stoneIngotID = config.get(CATEGORY_INGOT, "Stone Ingot", 664).getInt();
	}
	
	@Init
	public void load(FMLInitializationEvent event) {	
		
		// Achievements
		ModLoader.addAchievementDesc(DirtAchieve, "Got Dirt?", "On Your Way to Mixing");
		
		AchievementPage.registerAchievementPage(HC1);
		
		// Tools
		dirtsword = new hybridcraft.IngotStuff.ItemHybridSword(dirtswordID, dirt).setIconIndex(0).setItemName("dirtsword");
		dirtpick = new hybridcraft.IngotStuff.ItemHybridPickaxe(dirtpickID, dirt).setIconIndex(1).setItemName("dirtpick");
		dirtaxe = new hybridcraft.IngotStuff.ItemHybridAxe(dirtaxeID, dirt).setIconIndex(2).setItemName("dirtaxe");
		dirtshovel = new hybridcraft.IngotStuff.ItemHybridSpade(dirtshovelID, dirt).setIconIndex(3).setItemName("dirtshovel");
		dirthoe = new hybridcraft.IngotStuff.ItemHybridHoe(dirthoeID, dirt).setIconIndex(4).setItemName("dirthoe");
		dirtonesword = new hybridcraft.IngotStuff.ItemHybridSword(dirtoneswordID, dirtone).setIconIndex(5).setItemName("dirtonesword");
		dirtonepick = new hybridcraft.IngotStuff.ItemHybridPickaxe(dirtonepickID, dirtone).setIconIndex(6).setItemName("dirtonepick");
		dirtoneaxe = new hybridcraft.IngotStuff.ItemHybridAxe(dirtoneaxeID, dirtone).setIconIndex(7).setItemName("dirtoneaxe");
		dirtoneshovel = new hybridcraft.IngotStuff.ItemHybridSpade(dirtoneshovelID, dirtone).setIconIndex(8).setItemName("dirtoneshovel");
		dirtonehoe = new hybridcraft.IngotStuff.ItemHybridHoe(dirtonehoeID, dirtone).setIconIndex(9).setItemName("dirtonehoe");
		dironsword = new hybridcraft.IngotStuff.ItemHybridSword(dironswordID, dirtone).setIconIndex(10).setItemName("dironsword");
		dironpick = new hybridcraft.IngotStuff.ItemHybridPickaxe(dironpickID, diron).setIconIndex(11).setItemName("dironpick");
		dironaxe = new hybridcraft.IngotStuff.ItemHybridAxe(dironaxeID, diron).setIconIndex(12).setItemName("dironaxe");
		dironshovel = new hybridcraft.IngotStuff.ItemHybridSpade(dironshovelID, diron).setIconIndex(13).setItemName("dironshovel");
		dironhoe = new hybridcraft.IngotStuff.ItemHybridHoe(dironhoeID, diron).setIconIndex(14).setItemName("dironhoe");
		diroldsword = new hybridcraft.IngotStuff.ItemHybridSword(diroldswordID, dirold).setIconIndex(15).setItemName("diroldsword");
		diroldpick = new hybridcraft.IngotStuff.ItemHybridPickaxe(diroldpickID, dirold).setIconIndex(16).setItemName("diroldpick");
		diroldaxe = new hybridcraft.IngotStuff.ItemHybridAxe(diroldaxeID, dirold).setIconIndex(17).setItemName("diroldaxe");
		diroldshovel = new hybridcraft.IngotStuff.ItemHybridSpade(diroldshovelID, dirold).setIconIndex(18).setItemName("diroldshovel");
		diroldhoe = new hybridcraft.IngotStuff.ItemHybridHoe(diroldhoeID, dirold).setIconIndex(19).setItemName("diroldhoe");
		dirmendsword = new hybridcraft.IngotStuff.ItemHybridSword(dirmendswordID, dirmend).setIconIndex(20).setItemName("dirmendsword");
		dirmendpick = new hybridcraft.IngotStuff.ItemHybridPickaxe(dirmendpickID, dirmend).setIconIndex(21).setItemName("dirmendpick");
		dirmendaxe = new hybridcraft.IngotStuff.ItemHybridAxe(dirmendaxeID, dirmend).setIconIndex(22).setItemName("dirmendaxe");
		dirmendshovel = new hybridcraft.IngotStuff.ItemHybridSpade(dirmendshovelID, dirmend).setIconIndex(23).setItemName("dirmendshovel");
		dirmendhoe = new hybridcraft.IngotStuff.ItemHybridHoe(dirmendhoeID, dirmend).setIconIndex(24).setItemName("dirmendhoe");
		stornsword = new hybridcraft.IngotStuff.ItemHybridSword(stornswordID, storn).setIconIndex(25).setItemName("stornsword");
		stornpick = new hybridcraft.IngotStuff.ItemHybridPickaxe(stornpickID, storn).setIconIndex(26).setItemName("stornpick");
		stornaxe = new hybridcraft.IngotStuff.ItemHybridAxe(stornaxeID, storn).setIconIndex(27).setItemName("stornaxe");
		stornshovel = new hybridcraft.IngotStuff.ItemHybridSpade(stornshovelID, storn).setIconIndex(28).setItemName("stornshovel");
		stornhoe = new hybridcraft.IngotStuff.ItemHybridHoe(stornhoeID, storn).setIconIndex(29).setItemName("stornhoe");
		stoldsword = new hybridcraft.IngotStuff.ItemHybridSword(stoldswordID, stold).setIconIndex(30).setItemName("stoldsword");
		stoldpick = new hybridcraft.IngotStuff.ItemHybridPickaxe(stoldpickID, stold).setIconIndex(31).setItemName("stoldpick");
		stoldaxe = new hybridcraft.IngotStuff.ItemHybridAxe(stoldaxeID, stold).setIconIndex(32).setItemName("stoldaxe");
		stoldshovel = new hybridcraft.IngotStuff.ItemHybridSpade(stoldshovelID, stold).setIconIndex(33).setItemName("stoldshovel");
		stoldhoe = new hybridcraft.IngotStuff.ItemHybridHoe(stoldhoeID, stold).setIconIndex(34).setItemName("stoldhoe");
		stomendsword = new hybridcraft.IngotStuff.ItemHybridSword(stomendswordID, stomend).setIconIndex(35).setItemName("stomendsword");
		stomendpick = new hybridcraft.IngotStuff.ItemHybridPickaxe(stomendpickID, stomend).setIconIndex(36).setItemName("stomendpick");
		stomendaxe = new hybridcraft.IngotStuff.ItemHybridAxe(stomendaxeID, stomend).setIconIndex(37).setItemName("stomendaxe");
		stomendshovel = new hybridcraft.IngotStuff.ItemHybridSpade(stomendshovelID, stomend).setIconIndex(38).setItemName("stomendshovel");
		stomendhoe = new hybridcraft.IngotStuff.ItemHybridHoe(stomendhoeID, stomend).setIconIndex(39).setItemName("stomendhoe");
		iroldsword = new hybridcraft.IngotStuff.ItemHybridSword(iroldswordID, irold).setIconIndex(40).setItemName("iroldsword");
		iroldpick = new hybridcraft.IngotStuff.ItemHybridPickaxe(iroldpickID, irold).setIconIndex(41).setItemName("iroldpick");
		iroldaxe = new hybridcraft.IngotStuff.ItemHybridAxe(iroldaxeID, irold).setIconIndex(42).setItemName("iroldaxe");
		iroldshovel = new hybridcraft.IngotStuff.ItemHybridSpade(iroldshovelID, irold).setIconIndex(43).setItemName("iroldshovel");
		iroldhoe = new hybridcraft.IngotStuff.ItemHybridHoe(iroldhoeID, irold).setIconIndex(44).setItemName("iroldhoe");
		irmendsword = new hybridcraft.IngotStuff.ItemHybridSword(irmendswordID, irmend).setIconIndex(45).setItemName("irmendsword");
		irmendpick = new hybridcraft.IngotStuff.ItemHybridPickaxe(irmendpickID, irmend).setIconIndex(46).setItemName("irmendpick");
		irmendaxe = new hybridcraft.IngotStuff.ItemHybridAxe(irmendaxeID, irmend).setIconIndex(47).setItemName("irmendaxe");
		irmendshovel = new hybridcraft.IngotStuff.ItemHybridSpade(irmendshovelID, irmend).setIconIndex(48).setItemName("irmendshovel");
		irmendhoe = new hybridcraft.IngotStuff.ItemHybridHoe(irmendhoeID, irmend).setIconIndex(49).setItemName("irmendhoe");
		gomendsword = new hybridcraft.IngotStuff.ItemHybridSword(gomendswordID, gomend).setIconIndex(50).setItemName("gomendsword");
		gomendpick = new hybridcraft.IngotStuff.ItemHybridPickaxe(gomendpickID, gomend).setIconIndex(51).setItemName("gomendpick");
		gomendaxe = new hybridcraft.IngotStuff.ItemHybridAxe(gomendaxeID, gomend).setIconIndex(52).setItemName("gomendaxe");
		gomendshovel = new hybridcraft.IngotStuff.ItemHybridSpade(gomendshovelID, gomend).setIconIndex(53).setItemName("gomendshovel");
		gomendhoe = new hybridcraft.IngotStuff.ItemHybridHoe(gomendhoeID, gomend).setIconIndex(54).setItemName("gomendhoe");
		obsidiansword = new hybridcraft.IngotStuff.ItemHybridSword(obsidianswordID, obsidian).setIconIndex(55).setItemName("obsidiansword");
		obsidianpick = new hybridcraft.IngotStuff.ItemHybridPickaxe(obsidianpickID, obsidian).setIconIndex(56).setItemName("obsidianpick");
		obsidianaxe = new hybridcraft.IngotStuff.ItemHybridAxe(obsidianaxeID, obsidian).setIconIndex(57).setItemName("obsidianaxe");
		obsidianshovel = new hybridcraft.IngotStuff.ItemHybridSpade(obsidianshovelID, obsidian).setIconIndex(58).setItemName("obsidianshovel");
		obsidianhoe = new hybridcraft.IngotStuff.ItemHybridHoe(obsidianhoeID, obsidian).setIconIndex(59).setItemName("obsidianhoe");
		sandsword = new hybridcraft.IngotStuff.ItemHybridSword(sandswordID, sand).setIconIndex(60).setItemName("sandsword");
		sandpick = new hybridcraft.IngotStuff.ItemHybridPickaxe(sandpickID, sand).setIconIndex(61).setItemName("sandpick");
		sandaxe = new hybridcraft.IngotStuff.ItemHybridAxe(sandaxeID, sand).setIconIndex(62).setItemName("sandaxe");
		sandshovel = new hybridcraft.IngotStuff.ItemHybridSpade(sandshovelID, sand).setIconIndex(63).setItemName("sandshovel");
		sandhoe = new hybridcraft.IngotStuff.ItemHybridHoe(sandhoeID, sand).setIconIndex(64).setItemName("sandhoe");
		cobblesword = new hybridcraft.IngotStuff.ItemHybridSword(cobbleswordID, cobble).setIconIndex(65).setItemName("cobblesword");
		cobblepick = new hybridcraft.IngotStuff.ItemHybridPickaxe(cobblepickID, cobble).setIconIndex(66).setItemName("cobblepick");
		cobbleaxe = new hybridcraft.IngotStuff.ItemHybridAxe(cobbleaxeID, cobble).setIconIndex(67).setItemName("cobbleaxe");
		cobbleshovel = new hybridcraft.IngotStuff.ItemHybridSpade(cobbleshovelID, cobble).setIconIndex(68).setItemName("cobbleshovel");
		cobblehoe = new hybridcraft.IngotStuff.ItemHybridHoe(cobblehoeID, cobble).setIconIndex(69).setItemName("cobblehoe");
		emeraldsword = new hybridcraft.IngotStuff.ItemHybridSword(emeraldswordID, emerald).setIconIndex(70).setItemName("emeraldsword");
		emeraldpick = new hybridcraft.IngotStuff.ItemHybridPickaxe(emeraldpickID, emerald).setIconIndex(71).setItemName("emeraldpick");
		emeraldaxe = new hybridcraft.IngotStuff.ItemHybridAxe(emeraldaxeID, emerald).setIconIndex(72).setItemName("emeraldaxe");
		emeraldshovel = new hybridcraft.IngotStuff.ItemHybridSpade(emeraldshovelID, emerald).setIconIndex(73).setItemName("emeraldshovel");
		emeraldhoe = new hybridcraft.IngotStuff.ItemHybridHoe(emeraldhoeID, emerald).setIconIndex(74).setItemName("emeraldhoe");

		// Ingots
		obsidianShard = new Ingot(obsidianShardID).setIconIndex(12).setItemName("obsidianShard");
		obsidianIngot = new Ingot(obsidianIngotID).setIconIndex(13).setItemName("obsidianIngot");
		sandIngot = new Ingot(sandIngotID).setIconIndex(14).setItemName("sandIngot");
		dirtIngot = new Ingot(dirtIngotID).setIconIndex(0).setItemName("dirtIngot");
		stoneIngot = new Ingot(stoneIngotID).setIconIndex(5).setItemName("stoneIngot");

		// Armors
		dirtHelmet = new Dirt(dirtHelmetID, dirta, proxy.addArmor("Dirt Helmet"), 0).setItemName("dirtHelm").setIconIndex(0);
		dirtPlate = new Dirt(dirtPlateID, dirta, proxy.addArmor("Dirt Plate"), 1).setItemName("dirtPlate").setIconIndex(1);
		dirtLegs = new Dirt(dirtLegsID, dirta, proxy.addArmor("Dirt Legs"), 2).setItemName("dirtLegs").setIconIndex(2);
		dirtBoots = new Dirt(dirtBootsID, dirta, proxy.addArmor("Dirt Boots"), 3).setItemName("dirtBoots").setIconIndex(3);
		dirtoneHelmet = new Dirtone(dirtoneHelmetID, dirtonea, proxy.addArmor("Dirtone Helmet"), 0).setItemName("dirtoneHelm").setIconIndex(4);
		dirtonePlate = new Dirtone(dirtonePlateID, dirtonea, proxy.addArmor("Dirtone Plate"), 1).setItemName("dirtonePlate").setIconIndex(5);
		dirtoneLegs = new Dirtone(dirtoneLegsID, dirtonea, proxy.addArmor("Dirtone Legs"), 2).setItemName("dirtoneLegs").setIconIndex(6);
		dirtoneBoots = new Dirtone(dirtoneBootsID, dirtonea, proxy.addArmor("Dirtone Boots"), 3).setItemName("dirtoneBoots").setIconIndex(7);
		dironHelmet = new Diron(dironHelmetID, dirona, proxy.addArmor("Diron Helmet"), 0).setItemName("dironHelm").setIconIndex(8);
		dironPlate = new Diron(dironPlateID, dirona, proxy.addArmor("Diron Plate"), 1).setItemName("dironPlate").setIconIndex(9);
		dironLegs = new Diron(dironLegsID, dirona, proxy.addArmor("Diron Legs"), 2).setItemName("dironLegs").setIconIndex(10);
		dironBoots = new Diron(dironBootsID, dirona, proxy.addArmor("Diron Boots"), 3).setItemName("dironBoots").setIconIndex(11);
		diroldHelmet = new Dirold(diroldHelmetID, dirolda, proxy.addArmor("Dirold Helmet"), 0).setItemName("diroldHelm").setIconIndex(12);
		diroldPlate = new Dirold(diroldPlateID, dirolda, proxy.addArmor("Dirold Plate"), 1).setItemName("diroldPlate").setIconIndex(13);
		diroldLegs = new Dirold(diroldLegsID, dirolda, proxy.addArmor("Dirold Legs"), 2).setItemName("diroldLegs").setIconIndex(14);
		diroldBoots = new Dirold(diroldBootsID, dirolda, proxy.addArmor("Dirold Boots"), 3).setItemName("diroldBoots").setIconIndex(15);
		dirmendHelmet = new Dirmend(dirmendHelmetID, dirmenda, proxy.addArmor("Dirmend Helmet"), 0).setItemName("DirmendHelm").setIconIndex(16);
		dirmendPlate = new Dirmend(dirmendPlateID, dirmenda, proxy.addArmor("Dirmend Plate"), 1).setItemName("DirmendPlate").setIconIndex(17);
		dirmendLegs = new Dirmend(dirmendLegsID, dirmenda, proxy.addArmor("Dirmend Legs"), 2).setItemName("DirmendLegs").setIconIndex(18);
		dirmendBoots = new Dirmend(dirmendBootsID, dirmenda, proxy.addArmor("Dirmend Boots"), 3).setItemName("DirmendBoots").setIconIndex(19);
		stornHelmet = new Storn(stornHelmetID, storna, proxy.addArmor("Storn Helmet"), 0).setItemName("StornHelm").setIconIndex(20);
		stornPlate = new Storn(stornPlateID, storna, proxy.addArmor("Storn Plate"), 1).setItemName("StornPlate").setIconIndex(21);
		stornLegs = new Storn(stornLegsID, storna, proxy.addArmor("Storn Legs"), 2).setItemName("StornLegs").setIconIndex(22);
		stornBoots = new Storn(stornBootsID, storna, proxy.addArmor("Storn Boots"), 3).setItemName("StornBoots").setIconIndex(23);
		stoldHelmet = new Stold(stoldHelmetID, stolda, proxy.addArmor("Stold Helmet"), 0).setItemName("StoldHelm").setIconIndex(24);
		stoldPlate = new Stold(stoldPlateID, stolda, proxy.addArmor("Stold Plate"), 1).setItemName("StoldPlate").setIconIndex(25);
		stoldLegs = new Stold(stoldLegsID, stolda, proxy.addArmor("Stold Legs"), 2).setItemName("StoldLegs").setIconIndex(26);
		stoldBoots = new Stold(stoldBootsID, stolda, proxy.addArmor("Stold Boots"), 3).setItemName("StoldBoots").setIconIndex(27);
		stomendHelmet = new Stomend(stomendHelmetID, stomenda, proxy.addArmor("Stomend Helmet"), 0).setItemName("StomendHelm").setIconIndex(28);
		stomendPlate = new Stomend(stomendPlateID, stomenda, proxy.addArmor("Stomend Plate"), 1).setItemName("StomendPlate").setIconIndex(29);
		stomendLegs = new Stomend(stomendLegsID, stomenda, proxy.addArmor("Stomend Legs"), 2).setItemName("StomendLegs").setIconIndex(30);
		stomendBoots = new Stomend(stomendBootsID, stomenda, proxy.addArmor("Stomend Boots"), 3).setItemName("StomendBoots").setIconIndex(31);
		iroldHelmet = new Irold(iroldHelmetID, irolda, proxy.addArmor("Irold Helmet"), 0).setItemName("IroldHelm").setIconIndex(32);
		iroldPlate = new Irold(iroldPlateID, irolda, proxy.addArmor("Irold Plate"), 1).setItemName("IroldPlate").setIconIndex(33);
		iroldLegs = new Irold(iroldLegsID, irolda, proxy.addArmor("Irold Legs"), 2).setItemName("IroldLegs").setIconIndex(34);
		iroldBoots = new Irold(iroldBootsID, irolda, proxy.addArmor("Irold Boots"), 3).setItemName("IroldBoots").setIconIndex(35);
		irmendHelmet = new Irmend(irmendHelmetID, irmenda, proxy.addArmor("Irmend Helmet"), 0).setItemName("IrmendHelm").setIconIndex(36);
		irmendPlate = new Irmend(irmendPlateID, irmenda, proxy.addArmor("Irmend Plate"), 1).setItemName("IrmendPlate").setIconIndex(37);
		irmendLegs = new Irmend(irmendLegsID, irmenda, proxy.addArmor("Irmend Legs"), 2).setItemName("IrmendLegs").setIconIndex(38);
		irmendBoots = new Irmend(irmendBootsID, irmenda, proxy.addArmor("Irmend Boots"), 3).setItemName("IrmendBoots").setIconIndex(39);
		gomendHelmet = new Gomend(gomendHelmetID, gomenda, proxy.addArmor("Gomend Helmet"), 0).setItemName("GomendHelm").setIconIndex(40);
		gomendPlate = new Gomend(gomendPlateID, gomenda, proxy.addArmor("Gomend Plate"), 1).setItemName("GomendPlate").setIconIndex(41);
		gomendLegs = new Gomend(gomendLegsID, gomenda, proxy.addArmor("Gomend Legs"), 2).setItemName("GomendLegs").setIconIndex(42);
		gomendBoots = new Gomend(gomendBootsID, gomenda, proxy.addArmor("Gomend Boots"), 3).setItemName("GomendBoots").setIconIndex(43);
		obsidianHelmet = new Obsidian(obsidianHelmetID, obsidiana, proxy.addArmor("Obsidian Helmet"), 0).setItemName("ObsidianHelm").setIconIndex(44);
		obsidianPlate = new Obsidian(obsidianPlateID, obsidiana, proxy.addArmor("Obsidian Plate"), 1).setItemName("ObsidianPlate").setIconIndex(45);
		obsidianLegs = new Obsidian(obsidianLegsID, obsidiana, proxy.addArmor("Obsidian Legs"), 2).setItemName("ObsidianLegs").setIconIndex(46);
		obsidianBoots = new Obsidian(obsidianBootsID, obsidiana, proxy.addArmor("Obsidian Boots"), 3).setItemName("ObsidianBoots").setIconIndex(47);
		stoneHelmet = new Stone(stoneHelmetID, stonea, proxy.addArmor("Stone Helmet"), 0).setItemName("stoneHelm").setIconIndex(48);
		stonePlate = new Stone(stonePlateID, stonea, proxy.addArmor("Stone Plate"), 1).setItemName("stonePlate").setIconIndex(49);
		stoneLegs = new Stone(stoneLegsID, stonea, proxy.addArmor("Stone Legs"), 2).setItemName("stoneLegs").setIconIndex(50);
		stoneBoots = new Stone(stoneBootsID, stonea, proxy.addArmor("Stone Boots"), 3).setItemName("stoneBoots").setIconIndex(51);
		sandHelmet = new Sand(sandHelmetID, sanda, proxy.addArmor("Sand Helmet"), 0).setItemName("sandHelm").setIconIndex(52);
		sandPlate = new Sand(sandPlateID, sanda, proxy.addArmor("Sand Plate"), 1).setItemName("sandPlate").setIconIndex(53);
		sandLegs = new Sand(sandLegsID, sanda, proxy.addArmor("Sand Legs"), 2).setItemName("sandLegs").setIconIndex(54);
		sandBoots = new Sand(sandBootsID, sanda, proxy.addArmor("Sand Boots"), 3).setItemName("sandBoots").setIconIndex(55);
		emeraldHelmet = new Emerald(emeraldhelmetID, emeralda, proxy.addArmor("emerald Helmet"), 0).setItemName("emeraldHelm").setIconIndex(56);
		emeraldPlate = new Emerald(emeraldplateID, emeralda, proxy.addArmor("emerald Plate"), 1).setItemName("emeraldPlate").setIconIndex(57);
		emeraldLegs = new Emerald(emeraldlegsID, emeralda, proxy.addArmor("emerald Legs"), 2).setItemName("emeraldLegs").setIconIndex(58);
		emeraldBoots = new Emerald(emeraldbootsID, emeralda, proxy.addArmor("emerald Boots"), 3).setItemName("emeraldBoots").setIconIndex(59);

		// Ingot Blocks
		dirtBlock = new IngotBlock(dirtBlockID, 0).setStepSound(Block.soundMetalFootstep).setBlockName("dirtBlock").setHardness(3F).setResistance(4F);
		dirtoneBlock = new IngotBlock(dirtoneBlockID, 1).setStepSound(Block.soundMetalFootstep).setBlockName("dirtoneBlock").setHardness(3F).setResistance(4F);
		dironBlock = new IngotBlock(dironBlockID, 2).setStepSound(Block.soundMetalFootstep).setBlockName("dironBlock").setHardness(3F).setResistance(4F);
		diroldBlock = new IngotBlock(diroldBlockID, 3).setStepSound(Block.soundMetalFootstep).setBlockName("diroldBlock").setHardness(3F).setResistance(4F);
		dirmendBlock = new IngotBlock(dirmendBlockID, 4).setStepSound(Block.soundMetalFootstep).setBlockName("dirmendBlock").setHardness(3F).setResistance(4F);
		stoneBlock = new IngotBlock(stoneBlockID, 5).setStepSound(Block.soundMetalFootstep).setBlockName("stoneBlock").setHardness(3F).setResistance(4F);
		stornBlock = new IngotBlock(stornBlockID, 6).setStepSound(Block.soundMetalFootstep).setBlockName("stornBlock").setHardness(3F).setResistance(4F);
		stoldBlock = new IngotBlock(stoldBlockID, 7).setStepSound(Block.soundMetalFootstep).setBlockName("stoldBlock").setHardness(3F).setResistance(4F);
		stomendBlock = new IngotBlock(stomendBlockID, 8).setStepSound(Block.soundMetalFootstep).setBlockName("stomendBlock").setHardness(3F).setResistance(4F);
		iroldBlock = new IngotBlock(iroldBlockID, 9).setStepSound(Block.soundMetalFootstep).setBlockName("iroldBlock").setHardness(3F).setResistance(4F);
		irmendBlock = new IngotBlock(irmendBlockID, 10).setStepSound(Block.soundMetalFootstep).setBlockName("irmendBlock").setHardness(3F).setResistance(4F);
		gomendBlock = new IngotBlock(gomendBlockID, 11).setStepSound(Block.soundMetalFootstep).setBlockName("gomendBlock").setHardness(3F).setResistance(4F);
		sandBlock = new IngotBlock(sandBlockID, 12).setStepSound(Block.soundSandFootstep).setBlockName("sandBlock").setHardness(3F).setResistance(4F);

		// World Blocks
		dand = new WorldBlockFall(dandID, 0).setStepSound(Block.soundSandFootstep).setBlockName("dandBlock").setHardness(1F).setResistance(2F);
		davel = new WorldBlockFall(davelID, 1).setStepSound(Block.soundGravelFootstep).setBlockName("davelBlock").setHardness(1F).setResistance(2F);
		done = new WorldBlockStay(doneID, 2).setStepSound(Block.soundGrassFootstep).setBlockName("doneBlock").setHardness(1F).setResistance(2F);

		// Flowers
		dirtFlower = (BlockFlower) new Flowers(dirtFlowerID, 0).setBlockName("dirtFlower");
		stoneFlower = (BlockFlower) new Flowers(stoneFlowerID, 1).setBlockName("stoneFlower");
		ironFlower = (BlockFlower) new Flowers(ironFlowerID, 2).setBlockName("ironFlower");
		goldFlower = (BlockFlower) new Flowers(goldFlowerID, 3).setBlockName("goldFlower");
		diamondFlower = (BlockFlower) new Flowers(diamondFlowerID, 4).setBlockName("diamondFlower");
		obsidianFlower = (BlockFlower) new Flowers(obsidianFlowerID, 5).setBlockName("obsidianFlower");
		emeraldFlower = (BlockFlower) new Flowers(emeraldflowerID, 6).setBlockName("emeraldFlower");

		// Combiner
		blockHybridizer = (BlockHybridizer) new BlockHybridizer(combinerID).setBlockName("Hybridizer");

		// Register combiner GUI
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);


		// register the crafting listener
		GameRegistry.registerCraftingHandler(this);
		
		// Tool Registry
		LanguageRegistry.addName(dirtsword, "Dirt Sword");
		LanguageRegistry.addName(dirtpick, "Dirt Pickaxe");
		LanguageRegistry.addName(dirtaxe, "Dirt Axe");
		LanguageRegistry.addName(dirtshovel, "Dirt Shovel");
		LanguageRegistry.addName(dirthoe, "Dirt Hoe");
		LanguageRegistry.addName(dirtonesword, "Dirtone Sword");
		LanguageRegistry.addName(dirtonepick, "Dirtone Pickaxe");
		LanguageRegistry.addName(dirtoneaxe, "Dirtone Axe");
		LanguageRegistry.addName(dirtoneshovel, "Dirtone Shovel");
		LanguageRegistry.addName(dirtonehoe, "Dirtone Hoe");
		LanguageRegistry.addName(dironsword, "Diron Sword");
		LanguageRegistry.addName(dironpick, "Diron Pickaxe");
		LanguageRegistry.addName(dironaxe, "Diron Axe");
		LanguageRegistry.addName(dironshovel, "Diron Shovel");
		LanguageRegistry.addName(dironhoe, "Diron Hoe");
		LanguageRegistry.addName(diroldsword, "Dirold Sword");
		LanguageRegistry.addName(diroldpick, "Dirold Pickaxe");
		LanguageRegistry.addName(diroldaxe, "Dirold Axe");
		LanguageRegistry.addName(diroldshovel, "Dirold Shovel");
		LanguageRegistry.addName(diroldhoe, "Dirold Hoe");
		LanguageRegistry.addName(dirmendsword, "Dirmend Sword");
		LanguageRegistry.addName(dirmendpick, "Dirmend Pickaxe");
		LanguageRegistry.addName(dirmendaxe, "Dirmend Axe");
		LanguageRegistry.addName(dirmendshovel, "Dirmend Shovel");
		LanguageRegistry.addName(dirmendhoe, "Dirmend Hoe");
		LanguageRegistry.addName(stornsword, "Storn Sword");
		LanguageRegistry.addName(stornpick, "Storn Pickaxe");
		LanguageRegistry.addName(stornaxe, "Storn Axe");
		LanguageRegistry.addName(stornshovel, "Storn Shovel");
		LanguageRegistry.addName(stornhoe, "Storn Hoe");
		LanguageRegistry.addName(stoldsword, "Stold Sword");
		LanguageRegistry.addName(stoldpick, "Stold Pickaxe");
		LanguageRegistry.addName(stoldaxe, "Stold Axe");
		LanguageRegistry.addName(stoldshovel, "Stold Shovel");
		LanguageRegistry.addName(stoldhoe, "Stold Hoe");
		LanguageRegistry.addName(stomendsword, "Stomend Sword");
		LanguageRegistry.addName(stomendpick, "Stomend Pickaxe");
		LanguageRegistry.addName(stomendaxe, "Stomend Axe");
		LanguageRegistry.addName(stomendshovel, "Stomend Shovel");
		LanguageRegistry.addName(stomendhoe, "Stomend Hoe");
		LanguageRegistry.addName(iroldsword, "Irold Sword");
		LanguageRegistry.addName(iroldpick, "Irold Pickaxe");
		LanguageRegistry.addName(iroldaxe, "Irold Axe");
		LanguageRegistry.addName(iroldshovel, "Irold Shovel");
		LanguageRegistry.addName(iroldhoe, "Irold Hoe");
		LanguageRegistry.addName(irmendsword, "Irmend Sword");
		LanguageRegistry.addName(irmendpick, "Irmend Pickaxe");
		LanguageRegistry.addName(irmendaxe, "Irmend Axe");
		LanguageRegistry.addName(irmendshovel, "Irmend Shovel");
		LanguageRegistry.addName(irmendhoe, "Irmend Hoe");
		LanguageRegistry.addName(gomendsword, "Gomend Sword");
		LanguageRegistry.addName(gomendpick, "Gomend Pickaxe");
		LanguageRegistry.addName(gomendaxe, "Gomend Axe");
		LanguageRegistry.addName(gomendshovel, "Gomend Shovel");
		LanguageRegistry.addName(gomendhoe, "Gomend Hoe");
		LanguageRegistry.addName(obsidiansword, "Obsidian Sword");
		LanguageRegistry.addName(obsidianpick, "Obsidian Pickaxe");
		LanguageRegistry.addName(obsidianaxe, "Obsidian Axe");
		LanguageRegistry.addName(obsidianshovel, "Obsidian Shovel");
		LanguageRegistry.addName(obsidianhoe, "Obsidian Hoe");
		LanguageRegistry.addName(sandsword, "Sand Sword");
		LanguageRegistry.addName(sandpick, "Sand Pickaxe");
		LanguageRegistry.addName(sandaxe, "Sand Axe");
		LanguageRegistry.addName(sandshovel, "Sand Shovel");
		LanguageRegistry.addName(sandhoe, "Sand Hoe");
		LanguageRegistry.addName(cobblesword, "Cobble Sword");
		LanguageRegistry.addName(cobblepick, "Cobble Pickaxe");
		LanguageRegistry.addName(cobbleaxe, "Cobble Axe");
		LanguageRegistry.addName(cobbleshovel, "Cobble Shovel");
		LanguageRegistry.addName(cobblehoe, "Cobble Hoe");
		LanguageRegistry.addName(emeraldsword, "Emerald Sword");
		LanguageRegistry.addName(emeraldpick, "Emerald Pickaxe");
		LanguageRegistry.addName(emeraldaxe, "Emerald Axe");
		LanguageRegistry.addName(emeraldshovel, "Emerald Shovel");
		LanguageRegistry.addName(emeraldhoe, "Emerald Hoe");

		// ingot
		LanguageRegistry.addName(obsidianShard, "Shard 'o Obsidian");
		LanguageRegistry.addName(obsidianIngot, "Obsidian Ingot");
		LanguageRegistry.addName(sandIngot, "Sand Ingot");
		LanguageRegistry.addName(dirtIngot, "Dirt Ingot");
		LanguageRegistry.addName(stoneIngot, "Stone Ingot");

		// Armor Registry
		LanguageRegistry.addName(dirtHelmet, "Dirt Helmet");
		LanguageRegistry.addName(dirtPlate, "Dirt Chestplate");
		LanguageRegistry.addName(dirtLegs, "Dirt Legs");
		LanguageRegistry.addName(dirtBoots, "Dirt Boots");
		LanguageRegistry.addName(dirtoneHelmet, "Dirtone Helmet");
		LanguageRegistry.addName(dirtonePlate, "Dirtone Chestplate");
		LanguageRegistry.addName(dirtoneLegs, "Dirtone Legs");
		LanguageRegistry.addName(dirtoneBoots, "Dirtone Boots");
		LanguageRegistry.addName(dironHelmet, "Diron Helmet");
		LanguageRegistry.addName(dironPlate, "Diron Chestplate");
		LanguageRegistry.addName(dironLegs, "Diron Legs");
		LanguageRegistry.addName(dironBoots, "Diron Boots");
		LanguageRegistry.addName(diroldHelmet, "Dirold Helmet");
		LanguageRegistry.addName(diroldPlate, "Dirold Chestplate");
		LanguageRegistry.addName(diroldLegs, "Dirold Legs");
		LanguageRegistry.addName(diroldBoots, "Dirold Boots");
		LanguageRegistry.addName(dirmendHelmet, "Dirmend Helmet");
		LanguageRegistry.addName(dirmendPlate, "Dirmend Chestplate");
		LanguageRegistry.addName(dirmendLegs, "Dirmend Legs");
		LanguageRegistry.addName(dirmendBoots, "Dirmend Boots");
		LanguageRegistry.addName(stornHelmet, "Storn Helmet");
		LanguageRegistry.addName(stornPlate, "Storn Chestplate");
		LanguageRegistry.addName(stornLegs, "Storn Legs");
		LanguageRegistry.addName(stornBoots, "Storn Boots");
		LanguageRegistry.addName(stoldHelmet, "Stold Helmet");
		LanguageRegistry.addName(stoldPlate, "Stold Chestplate");
		LanguageRegistry.addName(stoldLegs, "Stold Legs");
		LanguageRegistry.addName(stoldBoots, "Stold Boots");
		LanguageRegistry.addName(stomendHelmet, "Stomend Helmet");
		LanguageRegistry.addName(stomendPlate, "Stomend Chestplate");
		LanguageRegistry.addName(stomendLegs, "Stomend Legs");
		LanguageRegistry.addName(stomendBoots, "Stomend Boots");
		LanguageRegistry.addName(iroldHelmet, "Irold Helmet");
		LanguageRegistry.addName(iroldPlate, "Irold Chestplate");
		LanguageRegistry.addName(iroldLegs, "Irold Legs");
		LanguageRegistry.addName(iroldBoots, "Irold Boots");
		LanguageRegistry.addName(irmendHelmet, "Irmend Helmet");
		LanguageRegistry.addName(irmendPlate, "Irmend Chestplate");
		LanguageRegistry.addName(irmendLegs, "Irmend Legs");
		LanguageRegistry.addName(irmendBoots, "Irmend Boots");
		LanguageRegistry.addName(gomendHelmet, "Gomend Helmet");
		LanguageRegistry.addName(gomendPlate, "Gomend Chestplate");
		LanguageRegistry.addName(gomendLegs, "Gomend Legs");
		LanguageRegistry.addName(gomendBoots, "Gomend Boots");
		LanguageRegistry.addName(obsidianHelmet, "Obsidian Helmet");
		LanguageRegistry.addName(obsidianPlate, "Obsidian Chestplate");
		LanguageRegistry.addName(obsidianLegs, "Obsidian Legs");
		LanguageRegistry.addName(obsidianBoots, "Obsidian Boots");
		LanguageRegistry.addName(stoneHelmet, "Stone Helmet");
		LanguageRegistry.addName(stonePlate, "Stone Chestplate");
		LanguageRegistry.addName(stoneLegs, "Stone Legs");
		LanguageRegistry.addName(stoneBoots, "Stone Boots");
		LanguageRegistry.addName(sandHelmet, "Sand Helmet");
		LanguageRegistry.addName(sandPlate, "Sand Chestplate");
		LanguageRegistry.addName(sandLegs, "Sand Legs");
		LanguageRegistry.addName(sandBoots, "Sand Boots");
		LanguageRegistry.addName(emeraldHelmet, "Emerald Helmet");
		LanguageRegistry.addName(emeraldPlate, "Emerald Chestplate");
		LanguageRegistry.addName(emeraldLegs, "Emerald Legs");
		LanguageRegistry.addName(emeraldBoots, "Emerald Boots");

		// Ingot Block Registry
		GameRegistry.registerBlock(dirtBlock);
		GameRegistry.registerBlock(dirtoneBlock);
		GameRegistry.registerBlock(dironBlock);
		GameRegistry.registerBlock(diroldBlock);
		GameRegistry.registerBlock(dirmendBlock);
		GameRegistry.registerBlock(stoneBlock);
		GameRegistry.registerBlock(stornBlock);
		GameRegistry.registerBlock(stoldBlock);
		GameRegistry.registerBlock(stomendBlock);
		GameRegistry.registerBlock(iroldBlock);
		GameRegistry.registerBlock(irmendBlock);
		GameRegistry.registerBlock(gomendBlock);
		GameRegistry.registerBlock(sandBlock);
		LanguageRegistry.addName(dirtBlock, "Dirt Ingot Block");
		LanguageRegistry.addName(dirtoneBlock, "Dirtone Ingot Block");
		LanguageRegistry.addName(dironBlock, "Diron Ingot Block");
		LanguageRegistry.addName(diroldBlock, "Dirold Ingot Block");
		LanguageRegistry.addName(dirmendBlock, "Dirmend Ingot Block");
		LanguageRegistry.addName(stoneBlock, "Stone Ingot Block");
		LanguageRegistry.addName(stornBlock, "Storn Ingot Block");
		LanguageRegistry.addName(stoldBlock, "Stold Ingot Block");
		LanguageRegistry.addName(stomendBlock, "Stomend Ingot Block");
		LanguageRegistry.addName(iroldBlock, "Irold Ingot Block");
		LanguageRegistry.addName(irmendBlock, "Irmend Ingot Block");
		LanguageRegistry.addName(gomendBlock, "Gomend Ingot Block");
		LanguageRegistry.addName(sandBlock, "Sand Ingot Block");

		// World Blocks
		GameRegistry.registerBlock(dand);
		GameRegistry.registerBlock(davel);
		GameRegistry.registerBlock(done);
		LanguageRegistry.addName(dand, "Dirt/Sand Block");
		LanguageRegistry.addName(davel, "Dirt/Gravel Block");
		LanguageRegistry.addName(done, "Dirt/Stone Block");

		// World Generator
		GameRegistry.registerWorldGenerator(new WorldGeneratorHybrid());

		// Flower Registry
		GameRegistry.registerBlock(dirtFlower);
		GameRegistry.registerBlock(stoneFlower);
		GameRegistry.registerBlock(ironFlower);
		GameRegistry.registerBlock(goldFlower);
		GameRegistry.registerBlock(diamondFlower);
		GameRegistry.registerBlock(obsidianFlower);
		GameRegistry.registerBlock(emeraldFlower);
		LanguageRegistry.addName(dirtFlower, "Dirt Flower");
		LanguageRegistry.addName(stoneFlower, "Stone Flower");
		LanguageRegistry.addName(ironFlower, "Iron Flower");
		LanguageRegistry.addName(goldFlower, "Gold Flower");
		LanguageRegistry.addName(diamondFlower, "Diamond Flower");
		LanguageRegistry.addName(obsidianFlower, "Obsidian Flower");
		LanguageRegistry.addName(emeraldFlower, "Emerald Flower");

		// Combiner
		GameRegistry.registerBlock(blockHybridizer);
		LanguageRegistry.addName(blockHybridizer, "Hybridizer");

		// //Tool Recipes

		GameRegistry.addShapelessRecipe(new ItemStack(obsidianShard, 12), new Object[] { new ItemStack(Block.obsidian), new ItemStack(Item.pickaxeDiamond) });
		GameRegistry.addRecipe(new ItemStack(sandIngot), new Object[] { "SSS", "SSS", "SSS", 'S', Block.sand });
		GameRegistry.addRecipe(new ItemStack(dirtIngot), new Object[] { "XXX", "XXX", "XXX", 'X', Block.dirt });
		GameRegistry.addRecipe(new ItemStack(dirtsword), new Object[] { "X", "X", "Z", 'X', dirtIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtpick), new Object[] { "XXX", " S ", " S ", 'X', dirtIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtaxe), new Object[] { "XX ", "XS ", " S ", 'X', dirtIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtshovel), new Object[] { "X", "S", "S", 'X', dirtIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirthoe), new Object[] { "XX ", " S ", " S ", 'X', dirtIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtonesword), new Object[] { "X", "X", "Z", 'X', HybridizingManager.getInstance().dirtoneIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtonepick), new Object[] { "XXX", " S ", " S ", 'X', HybridizingManager.getInstance().dirtoneIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtoneaxe), new Object[] { "XX ", "XS ", " S ", 'X', HybridizingManager.getInstance().dirtoneIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtoneshovel), new Object[] { "X", "S", "S", 'X', HybridizingManager.getInstance().dirtoneIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtonehoe), new Object[] { "XX ", " S ", " S ", 'X', HybridizingManager.getInstance().dirtoneIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dironsword), new Object[] { "X", "X", "Z", 'X', HybridizingManager.getInstance().dironIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dironpick), new Object[] { "XXX", " S ", " S ", 'X', HybridizingManager.getInstance().dironIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dironaxe), new Object[] { "XX ", "XS ", " S ", 'X', HybridizingManager.getInstance().dironIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dironshovel), new Object[] { "X", "S", "S", 'X', HybridizingManager.getInstance().dironIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dironhoe), new Object[] { "XX ", " S ", " S ", 'X', HybridizingManager.getInstance().dironIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(diroldsword), new Object[] { "X", "X", "Z", 'X', HybridizingManager.getInstance().diroldIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(diroldpick), new Object[] { "XXX", " S ", " S ", 'X', HybridizingManager.getInstance().diroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(diroldaxe), new Object[] { "XX ", "XS ", " S ", 'X', HybridizingManager.getInstance().diroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(diroldshovel), new Object[] { "X", "S", "S", 'X', HybridizingManager.getInstance().diroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(diroldhoe), new Object[] { "XX ", " S ", " S ", 'X', HybridizingManager.getInstance().diroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirmendsword), new Object[] { "X", "X", "Z", 'X', HybridizingManager.getInstance().dirmendIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirmendpick), new Object[] { "XXX", " S ", " S ", 'X', HybridizingManager.getInstance().dirmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirmendaxe), new Object[] { "XX ", "XS ", " S ", 'X', HybridizingManager.getInstance().dirmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirmendshovel), new Object[] { "X", "S", "S", 'X', HybridizingManager.getInstance().dirmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirmendhoe), new Object[] { "XX ", " S ", " S ", 'X', HybridizingManager.getInstance().dirmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stornsword), new Object[] { "X", "X", "Z", 'X', HybridizingManager.getInstance().stornIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stornpick), new Object[] { "XXX", " S ", " S ", 'X', HybridizingManager.getInstance().stornIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stornaxe), new Object[] { "XX ", "XS ", " S ", 'X', HybridizingManager.getInstance().stornIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stornshovel), new Object[] { "X", "S", "S", 'X', HybridizingManager.getInstance().stornIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stornhoe), new Object[] { "XX ", " S ", " S ", 'X', HybridizingManager.getInstance().stornIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stoldsword), new Object[] { "X", "X", "Z", 'X', HybridizingManager.getInstance().stoldIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stoldpick), new Object[] { "XXX", " S ", " S ", 'X', HybridizingManager.getInstance().stoldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stoldaxe), new Object[] { "XX ", "XS ", " S ", 'X', HybridizingManager.getInstance().stoldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stoldshovel), new Object[] { "X", "S", "S", 'X', HybridizingManager.getInstance().stoldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stoldhoe), new Object[] { "XX ", " S ", " S ", 'X', HybridizingManager.getInstance().stoldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stomendsword), new Object[] { "X", "X", "Z", 'X', HybridizingManager.getInstance().stomendIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stomendpick), new Object[] { "XXX", " S ", " S ", 'X', HybridizingManager.getInstance().stomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stomendaxe), new Object[] { "XX ", "XS ", " S ", 'X', HybridizingManager.getInstance().stomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stomendshovel), new Object[] { "X", "S", "S", 'X', HybridizingManager.getInstance().stomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stomendhoe), new Object[] { "XX ", " S ", " S ", 'X', HybridizingManager.getInstance().stomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(iroldsword), new Object[] { "X", "X", "Z", 'X', HybridizingManager.getInstance().iroldIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(iroldpick), new Object[] { "XXX", " S ", " S ", 'X', HybridizingManager.getInstance().iroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(iroldaxe), new Object[] { "XX ", "XS ", " S ", 'X', HybridizingManager.getInstance().iroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(iroldshovel), new Object[] { "X", "S", "S", 'X', HybridizingManager.getInstance().iroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(iroldhoe), new Object[] { "XX ", " S ", " S ", 'X', HybridizingManager.getInstance().iroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(irmendsword), new Object[] { "X", "X", "Z", 'X', HybridizingManager.getInstance().irmendIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(irmendpick), new Object[] { "XXX", " S ", " S ", 'X', HybridizingManager.getInstance().irmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(irmendaxe), new Object[] { "XX ", "XS ", " S ", 'X', HybridizingManager.getInstance().irmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(irmendshovel), new Object[] { "X", "S", "S", 'X', HybridizingManager.getInstance().irmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(irmendhoe), new Object[] { "XX ", " S ", " S ", 'X', HybridizingManager.getInstance().irmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(gomendsword), new Object[] { "X", "X", "Z", 'X', HybridizingManager.getInstance().gomendIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(gomendpick), new Object[] { "XXX", " S ", " S ", 'X', HybridizingManager.getInstance().gomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(gomendaxe), new Object[] { "XX ", "XS ", " S ", 'X', HybridizingManager.getInstance().gomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(gomendshovel), new Object[] { "X", "S", "S", 'X', HybridizingManager.getInstance().gomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(gomendhoe), new Object[] { "XX ", " S ", " S ", 'X', HybridizingManager.getInstance().gomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(obsidiansword), new Object[] { "X", "X", "Z", 'X', obsidianIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(obsidianpick), new Object[] { "XXX", " S ", " S ", 'X', obsidianIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(obsidianaxe), new Object[] { "XX ", "XS ", " S ", 'X', obsidianIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(obsidianshovel), new Object[] { "X", "S", "S", 'X', obsidianIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(obsidianhoe), new Object[] { "XX ", " S ", " S ", 'X', obsidianIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(sandsword), new Object[] { "X", "X", "Z", 'X', sandIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(sandpick), new Object[] { "XXX", " S ", " S ", 'X', sandIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(sandaxe), new Object[] { "XX ", "XS ", " S ", 'X', sandIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(sandshovel), new Object[] { "X", "S", "S", 'X', sandIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(sandhoe), new Object[] { "XX ", " S ", " S ", 'X', sandIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(cobblesword), new Object[] { "X", "X", "Z", 'X', Block.cobblestone, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(cobblepick), new Object[] { "XXX", " S ", " S ", 'X', Block.cobblestone, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(cobbleaxe), new Object[] { "XX ", "XS ", " S ", 'X', Block.cobblestone, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(cobbleshovel), new Object[] { "X", "S", "S", 'X', Block.cobblestone, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(cobblehoe), new Object[] { "XX ", " S ", " S ", 'X', Block.cobblestone, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(emeraldsword), new Object[] { "X", "X", "Z", 'X', Item.emerald, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(emeraldpick), new Object[] { "XXX", " S ", " S ", 'X', Item.emerald, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(emeraldaxe), new Object[] { "XX ", "XS ", " S ", 'X', Item.emerald, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(emeraldshovel), new Object[] { "X", "S", "S", 'X', Item.emerald, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(emeraldhoe), new Object[] { "XX ", " S ", " S ", 'X', Item.emerald, 'S', Item.stick });

		// //Armor Recipes
		GameRegistry.addRecipe(new ItemStack(dirtHelmet), new Object[] { "XXX", "X X", "   ", 'X', dirtIngot });
		GameRegistry.addRecipe(new ItemStack(dirtHelmet), new Object[] { "   ", "XXX", "X X", 'X', dirtIngot });
		GameRegistry.addRecipe(new ItemStack(dirtPlate), new Object[] { "X X", "XXX", "XXX", 'X', dirtIngot });
		GameRegistry.addRecipe(new ItemStack(dirtLegs), new Object[] { "XXX", "X X", "X X", 'X', dirtIngot });
		GameRegistry.addRecipe(new ItemStack(dirtBoots), new Object[] { "X X", "X X", "   ", 'X', dirtIngot });
		GameRegistry.addRecipe(new ItemStack(dirtBoots), new Object[] { "   ", "X X", "X X", 'X', dirtIngot });
		GameRegistry.addRecipe(new ItemStack(dirtoneHelmet), new Object[] { "XXX", "X X", "   ", 'X', HybridizingManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtoneHelmet), new Object[] { "   ", "XXX", "X X", 'X', HybridizingManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtonePlate), new Object[] { "X X", "XXX", "XXX", 'X', HybridizingManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtoneLegs), new Object[] { "XXX", "X X", "X X", 'X', HybridizingManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtoneBoots), new Object[] { "X X", "X X", "   ", 'X', HybridizingManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtoneBoots), new Object[] { "   ", "X X", "X X", 'X', HybridizingManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dironHelmet), new Object[] { "XXX", "X X", "   ", 'X', HybridizingManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(dironHelmet), new Object[] { "   ", "XXX", "X X", 'X', HybridizingManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(dironPlate), new Object[] { "X X", "XXX", "XXX", 'X', HybridizingManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(dironLegs), new Object[] { "XXX", "X X", "X X", 'X', HybridizingManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(dironBoots), new Object[] { "X X", "X X", "   ", 'X', HybridizingManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(dironBoots), new Object[] { "   ", "X X", "X X", 'X', HybridizingManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldHelmet), new Object[] { "XXX", "X X", "   ", 'X', HybridizingManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldHelmet), new Object[] { "   ", "XXX", "X X", 'X', HybridizingManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldPlate), new Object[] { "X X", "XXX", "XXX", 'X', HybridizingManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldLegs), new Object[] { "XXX", "X X", "X X", 'X', HybridizingManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldBoots), new Object[] { "X X", "X X", "   ", 'X', HybridizingManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldBoots), new Object[] { "   ", "X X", "X X", 'X', HybridizingManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendHelmet), new Object[] { "XXX", "X X", "   ", 'X', HybridizingManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendHelmet), new Object[] { "   ", "XXX", "X X", 'X', HybridizingManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendPlate), new Object[] { "X X", "XXX", "XXX", 'X', HybridizingManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendLegs), new Object[] { "XXX", "X X", "X X", 'X', HybridizingManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendBoots), new Object[] { "X X", "X X", "   ", 'X', HybridizingManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendBoots), new Object[] { "   ", "X X", "X X", 'X', HybridizingManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(stornHelmet), new Object[] { "XXX", "X X", "   ", 'X', HybridizingManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stornHelmet), new Object[] { "   ", "XXX", "X X", 'X', HybridizingManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stornPlate), new Object[] { "X X", "XXX", "XXX", 'X', HybridizingManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stornLegs), new Object[] { "XXX", "X X", "X X", 'X', HybridizingManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stornBoots), new Object[] { "X X", "X X", "   ", 'X', HybridizingManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stornBoots), new Object[] { "   ", "X X", "X X", 'X', HybridizingManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldHelmet), new Object[] { "XXX", "X X", "   ", 'X', HybridizingManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldHelmet), new Object[] { "   ", "XXX", "X X", 'X', HybridizingManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldPlate), new Object[] { "X X", "XXX", "XXX", 'X', HybridizingManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldLegs), new Object[] { "XXX", "X X", "X X", 'X', HybridizingManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldBoots), new Object[] { "X X", "X X", "   ", 'X', HybridizingManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldBoots), new Object[] { "   ", "X X", "X X", 'X', HybridizingManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendHelmet), new Object[] { "XXX", "X X", "   ", 'X', HybridizingManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendHelmet), new Object[] { "   ", "XXX", "X X", 'X', HybridizingManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendPlate), new Object[] { "X X", "XXX", "XXX", 'X', HybridizingManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendLegs), new Object[] { "XXX", "X X", "X X", 'X', HybridizingManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendBoots), new Object[] { "X X", "X X", "   ", 'X', HybridizingManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendBoots), new Object[] { "   ", "X X", "X X", 'X', HybridizingManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldHelmet), new Object[] { "XXX", "X X", "   ", 'X', HybridizingManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldHelmet), new Object[] { "   ", "XXX", "X X", 'X', HybridizingManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldPlate), new Object[] { "X X", "XXX", "XXX", 'X', HybridizingManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldLegs), new Object[] { "XXX", "X X", "X X", 'X', HybridizingManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldBoots), new Object[] { "X X", "X X", "   ", 'X', HybridizingManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldBoots), new Object[] { "   ", "X X", "X X", 'X', HybridizingManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendHelmet), new Object[] { "XXX", "X X", "   ", 'X', HybridizingManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendHelmet), new Object[] { "   ", "XXX", "X X", 'X', HybridizingManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendPlate), new Object[] { "X X", "XXX", "XXX", 'X', HybridizingManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendLegs), new Object[] { "XXX", "X X", "X X", 'X', HybridizingManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendBoots), new Object[] { "X X", "X X", "   ", 'X', HybridizingManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendBoots), new Object[] { "   ", "X X", "X X", 'X', HybridizingManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendHelmet), new Object[] { "XXX", "X X", "   ", 'X', HybridizingManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendHelmet), new Object[] { "   ", "XXX", "X X", 'X', HybridizingManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendPlate), new Object[] { "X X", "XXX", "XXX", 'X', HybridizingManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendLegs), new Object[] { "XXX", "X X", "X X", 'X', HybridizingManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendBoots), new Object[] { "X X", "X X", "   ", 'X', HybridizingManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendBoots), new Object[] { "   ", "X X", "X X", 'X', HybridizingManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(obsidianHelmet), new Object[] { "XXX", "X X", "   ", 'X', obsidianIngot, });
		GameRegistry.addRecipe(new ItemStack(obsidianHelmet), new Object[] { "   ", "XXX", "X X", 'X', obsidianIngot, });
		GameRegistry.addRecipe(new ItemStack(obsidianPlate), new Object[] { "X X", "XXX", "XXX", 'X', obsidianIngot, });
		GameRegistry.addRecipe(new ItemStack(obsidianLegs), new Object[] { "XXX", "X X", "X X", 'X', obsidianIngot, });
		GameRegistry.addRecipe(new ItemStack(obsidianBoots), new Object[] { "X X", "X X", "   ", 'X', obsidianIngot, });
		GameRegistry.addRecipe(new ItemStack(obsidianBoots), new Object[] { "   ", "X X", "X X", 'X', obsidianIngot, });
		GameRegistry.addRecipe(new ItemStack(stoneHelmet), new Object[] { "XXX", "X X", "   ", 'X', stoneIngot, });
		GameRegistry.addRecipe(new ItemStack(stoneHelmet), new Object[] { "   ", "XXX", "X X", 'X', stoneIngot, });
		GameRegistry.addRecipe(new ItemStack(stonePlate), new Object[] { "X X", "XXX", "XXX", 'X', stoneIngot, });
		GameRegistry.addRecipe(new ItemStack(stoneLegs), new Object[] { "XXX", "X X", "X X", 'X', stoneIngot, });
		GameRegistry.addRecipe(new ItemStack(stoneBoots), new Object[] { "X X", "X X", "   ", 'X', stoneIngot, });
		GameRegistry.addRecipe(new ItemStack(stoneBoots), new Object[] { "   ", "X X", "X X", 'X', stoneIngot, });
		GameRegistry.addRecipe(new ItemStack(sandHelmet), new Object[] { "XXX", "X X", "   ", 'X', sandIngot, });
		GameRegistry.addRecipe(new ItemStack(sandHelmet), new Object[] { "   ", "XXX", "X X", 'X', sandIngot, });
		GameRegistry.addRecipe(new ItemStack(sandPlate), new Object[] { "X X", "XXX", "XXX", 'X', sandIngot, });
		GameRegistry.addRecipe(new ItemStack(sandLegs), new Object[] { "XXX", "X X", "X X", 'X', sandIngot, });
		GameRegistry.addRecipe(new ItemStack(sandBoots), new Object[] { "X X", "X X", "   ", 'X', sandIngot, });
		GameRegistry.addRecipe(new ItemStack(sandBoots), new Object[] { "   ", "X X", "X X", 'X', sandIngot, });
		GameRegistry.addRecipe(new ItemStack(emeraldHelmet), new Object[] { "XXX", "X X", "   ", 'X', Item.emerald, });
		GameRegistry.addRecipe(new ItemStack(emeraldHelmet), new Object[] { "   ", "XXX", "X X", 'X', Item.emerald, });
		GameRegistry.addRecipe(new ItemStack(emeraldPlate), new Object[] { "X X", "XXX", "XXX", 'X', Item.emerald, });
		GameRegistry.addRecipe(new ItemStack(emeraldLegs), new Object[] { "XXX", "X X", "X X", 'X', Item.emerald, });
		GameRegistry.addRecipe(new ItemStack(emeraldBoots), new Object[] { "X X", "X X", "   ", 'X', Item.emerald, });
		GameRegistry.addRecipe(new ItemStack(emeraldBoots), new Object[] { "   ", "X X", "X X", 'X', Item.emerald, });

		// Block Recipes
		GameRegistry.addRecipe(new ItemStack(dirtBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', dirtIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtoneBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', HybridizingManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dironBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', HybridizingManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', HybridizingManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', HybridizingManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(stoneBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', stoneIngot, });
		GameRegistry.addRecipe(new ItemStack(stornBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', HybridizingManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', HybridizingManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', HybridizingManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', HybridizingManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', HybridizingManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', HybridizingManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(sandBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', sandIngot, });

		// Block -> Ingot Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(HybridizingManager.getInstance().dirtoneIngot, 9), new Object[] { new ItemStack(dirtoneBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(HybridizingManager.getInstance().dironIngot, 9), new Object[] { new ItemStack(dironBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(HybridizingManager.getInstance().diroldIngot, 9), new Object[] { new ItemStack(diroldBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(HybridizingManager.getInstance().dirmendIngot, 9), new Object[] { new ItemStack(dirmendBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(stoneIngot, 9), new Object[] { new ItemStack(stoneBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(HybridizingManager.getInstance().stornIngot, 9), new Object[] { new ItemStack(stornBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(HybridizingManager.getInstance().stoldIngot, 9), new Object[] { new ItemStack(stoldBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(HybridizingManager.getInstance().stomendIngot, 9), new Object[] { new ItemStack(stomendBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(HybridizingManager.getInstance().iroldIngot, 9), new Object[] { new ItemStack(iroldBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(HybridizingManager.getInstance().irmendIngot, 9), new Object[] { new ItemStack(irmendBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(HybridizingManager.getInstance().gomendIngot, 9), new Object[] { new ItemStack(gomendBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(sandIngot, 9), new Object[] { new ItemStack(sandBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(dirtIngot, 9), new Object[] { new ItemStack(dirtBlock) });
		GameRegistry.addRecipe(new ItemStack(stoneIngot), new Object[] { "XXX", "XXX", "XXX", 'X', Block.stone, });

		// Flowers
		GameRegistry.addShapelessRecipe(new ItemStack(Block.dirt, 1), new Object[] { new ItemStack(dirtFlower) });
		GameRegistry.addShapelessRecipe(new ItemStack(Block.stone, 1), new Object[] { new ItemStack(stoneFlower) });
		GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron, 1), new Object[] { new ItemStack(ironFlower) });
		GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotGold, 1), new Object[] { new ItemStack(goldFlower) });
		GameRegistry.addShapelessRecipe(new ItemStack(Item.diamond, 1), new Object[] { new ItemStack(diamondFlower) });
		GameRegistry.addShapelessRecipe(new ItemStack(obsidianIngot, 1), new Object[] { new ItemStack(obsidianFlower) });
		GameRegistry.addShapelessRecipe(new ItemStack(Item.emerald, 1), new Object[] { new ItemStack(emeraldFlower) });

		// Smelting
		GameRegistry.addSmelting(obsidianShard.shiftedIndex, new ItemStack(obsidianIngot, 1), 2F);

		proxy.registerRenderThings();
		
		// Achievements
	
	
	
	
	}

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {

		// add enchantments
		// dirt = silkTouch
		// stone = efficiency
		// iron = sharpness
		// gold = looting
		// diamond = fortune

		net.minecraft.src.Enchantment[] i = new net.minecraft.src.Enchantment[] {net.minecraft.src.Enchantment.looting,net.minecraft.src.Enchantment.sharpness};
		
		if (item.getItem() instanceof hybridcraft.IngotStuff.ItemHybridAxe) {
			item.addEnchantment(i[(int) (new Random().nextDouble()*2)], 1);
		} else if (item.getItem() instanceof hybridcraft.IngotStuff.ItemHybridHoe) {
			item.addEnchantment(i[(int) (new Random().nextDouble()*2)], 1);
		} else if (item.getItem() instanceof hybridcraft.IngotStuff.ItemHybridPickaxe) {
			item.addEnchantment(i[(int) (new Random().nextDouble()*2)], 1);
		} else if (item.getItem() instanceof hybridcraft.IngotStuff.ItemHybridSpade) {
			item.addEnchantment(i[(int) (new Random().nextDouble()*2)], 1);
		} else if (item.getItem() instanceof hybridcraft.IngotStuff.ItemHybridSword) {
			item.addEnchantment(i[(int) (new Random().nextDouble()*2)], 1);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
	}
	
	

}