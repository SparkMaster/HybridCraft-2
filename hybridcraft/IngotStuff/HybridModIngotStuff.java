//Tools 601-700
//Ingots 701-800
//Armors 801-900
//Blocks 401-800
//Flowers 901-950

package hybridcraft.IngotStuff;

import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemMinecart;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import hybridcraft.IngotStuff.*;

@Mod(modid = "HybridCraft 2", name = "HybridCraft 2 Materials", version = "2.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)



public class HybridModIngotStuff {
	
	//Proxy
	@SidedProxy(clientSide = "hybrid.client.ClientProxyHybrid", serverSide = "hybridcraft.IngotStuff.CommonProxyHybrid")
	public static CommonProxyHybrid proxy;
	
	//Enums Tools
	//WOOD(0, 59, 2.0F, 0, 15),
    //STONE(1, 131, 4.0F, 1, 5),
    //IRON(2, 250, 6.0F, 2, 14),
    //EMERALD(3, 1561, 8.0F, 3, 10),
    //GOLD(0, 32, 12.0F, 0, 22);
	
	//Tool Materials
	static EnumToolMaterial dirt = EnumHelper.addToolMaterial("dirt", 0, 30, 1.0F, 0, 15);
	static EnumToolMaterial dirtone = EnumHelper.addToolMaterial("dirtone", 1, 80, 2.0F, 1, 14);
	static EnumToolMaterial diron = EnumHelper.addToolMaterial("diron", 1, 140, 3.5F, 1, 14);
	static EnumToolMaterial dirold = EnumHelper.addToolMaterial("dirold", 0, 31, 6.5F, 0, 14);
	static EnumToolMaterial dirmend = EnumHelper.addToolMaterial("dirmend", 2,  795, 4.5F, 2, 14);
	static EnumToolMaterial storn = EnumHelper.addToolMaterial("storn", 2, 190, 5.0F, 2, 14);
	static EnumToolMaterial stold = EnumHelper.addToolMaterial("stold", 2, 81, 8.0F, 2, 14);
	static EnumToolMaterial stomend = EnumHelper.addToolMaterial("stomend", 2, 846, 6.0F, 2, 14);
	static EnumToolMaterial irold = EnumHelper.addToolMaterial("irold", 2, 141, 9.0F, 2, 14);
	static EnumToolMaterial irmend = EnumHelper.addToolMaterial("irmend", 2, 905, 7.0F, 2, 14);
	static EnumToolMaterial gomend = EnumHelper.addToolMaterial("gomend", 2, 796, 10.0F, 2, 14);
	static EnumToolMaterial obsidian = EnumHelper.addToolMaterial("obsidian", 3, 1233, 12.0F, 3, 14);
	static EnumToolMaterial sand = EnumHelper.addToolMaterial("sand", 0, 35, 2.0F, 0, 14);
	static EnumToolMaterial cobble = EnumHelper.addToolMaterial("cobble", 0, 75, 1.0F, 0, 14);
	
	//Enums
	//CLOTH(5, new int[]{1, 3, 2, 1}, 15),
    //CHAIN(15, new int[]{2, 5, 4, 1}, 12),
    //IRON(15, new int[]{2, 6, 5, 2}, 9),
    //GOLD(7, new int[]{2, 5, 3, 1}, 25),
    //DIAMOND(33, new int[]{3, 8, 6, 3}, 10);
	
	//Armor Materials
	static EnumArmorMaterial dirta = EnumHelper.addArmorMaterial("dirt", 30, new int[]{1, 1, 1, 1}, 14);
	static EnumArmorMaterial dirtonea = EnumHelper.addArmorMaterial("dirtone", 40, new int[]{1, 2, 1, 1}, 14);
	static EnumArmorMaterial dirona = EnumHelper.addArmorMaterial("diron", 70, new int[]{1, 2, 1, 2}, 14);
	static EnumArmorMaterial dirolda = EnumHelper.addArmorMaterial("dirold", 31, new int[]{1, 2, 2, 2}, 14);
	static EnumArmorMaterial dirmenda = EnumHelper.addArmorMaterial("dirmend", 90, new int[]{2, 2, 2, 2}, 14);
	static EnumArmorMaterial storna = EnumHelper.addArmorMaterial("storn", 80, new int[]{2, 3, 2, 3}, 14);
	static EnumArmorMaterial stolda = EnumHelper.addArmorMaterial("stold", 37, new int[]{2, 3, 3, 3}, 14);
	static EnumArmorMaterial stomenda = EnumHelper.addArmorMaterial("stomend", 100, new int[]{3, 3, 3, 3}, 14);
	static EnumArmorMaterial irolda = EnumHelper.addArmorMaterial("irold", 44, new int[]{3, 4, 3, 3}, 14);
	static EnumArmorMaterial irmenda = EnumHelper.addArmorMaterial("irmend", 120, new int[]{3, 4, 3, 4}, 14);
	static EnumArmorMaterial gomenda = EnumHelper.addArmorMaterial("gomend", 150, new int[]{4, 4, 4, 4}, 14);
	static EnumArmorMaterial obsidiana = EnumHelper.addArmorMaterial("obsidian", 300, new int[]{10, 10, 10, 10}, 14);
	static EnumArmorMaterial stonea = EnumHelper.addArmorMaterial("stone", 50, new int[]{2, 3, 2, 2}, 14);
	static EnumArmorMaterial sanda = EnumHelper.addArmorMaterial("sand", 60, new int[]{2, 1, 2, 2,}, 14);
	
	//Tools
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
	
	//Ingots
	public static Item dirtIngot;
	public static Item dirtoneIngot;
	public static Item dironIngot;
	public static Item diroldIngot;
	public static Item dirmendIngot;
	public static Item stoneIngot;
	public static Item stornIngot;
	public static Item stoldIngot;
	public static Item stomendIngot;
	public static Item iroldIngot;
	public static Item irmendIngot;
	public static Item gomendIngot;
	public static Item obsidianShard;
	public static Item obsidianIngot;
	public static Item sandIngot;
	
	//Armors
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
	
	//Ingot Blocks
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
	
	//World Blocks
	public static Block dand;
	public static Block davel;
	public static Block done;
	
	//Flowers
	public static BlockFlower dirtFlower;
	public static BlockFlower stoneFlower;
	public static BlockFlower ironFlower;
	public static BlockFlower goldFlower;
	public static BlockFlower diamondFlower;
	
	//Potion
	
	
	//NPCs
	
	
	//Chest
	
	
	//Furnaces
	
	
	//Crafting Tables
	
	
	
	
	//Config
	public int dirtswordID;
	public int dirtpickID;
	public int dirtaxeID;
	public int dirtshovelID;
	public int dirthoeID;
	public int dirtoneswordID;
	public int dirtonepickID;
	public int dirtoneaxeID;
	public int dirtoneshovelID;
	public int dirtonehoeID;
	public int dironswordID;
	public int dironpickID;
	public int dironaxeID;
	public int dironshovelID;
	public int dironhoeID;
	public int diroldswordID;
	public int diroldpickID;
	public int diroldaxeID;
	public int diroldshovelID;
	public int diroldhoeID;
	public int dirmendswordID;
	public int dirmendpickID;
	public int dirmendaxeID;
	public int dirmendshovelID;
	public int dirmendhoeID;
	public int stornswordID;
	public int stornpickID;
	public int stornaxeID;
	public int stornshovelID;
	public int stornhoeID;
	public int stoldswordID;
	public int stoldpickID;
	public int stoldaxeID;
	public int stoldshovelID;
	public int stoldhoeID;
	public int stomendswordID;
	public int stomendpickID;
	public int stomendaxeID;
	public int stomendshovelID;
	public int stomendhoeID;
	public int iroldswordID;
	public int iroldpickID;
	public int iroldaxeID;
	public int iroldshovelID;
	public int iroldhoeID;
	public int irmendswordID;
	public int irmendpickID;
	public int irmendaxeID;
	public int irmendshovelID;
	public int irmendhoeID;
	public int gomendswordID;
	public int gomendpickID;
	public int gomendaxeID;
	public int gomendshovelID;
	public int gomendhoeID;
	public int obsidianswordID;
	public int obsidianpickID;
	public int obsidianaxeID;
	public int obsidianshovelID;
	public int obsidianhoeID;
	public int dirtIngotID;
	public int dirtoneIngotID;
	public int dironIngotID;
	public int diroldIngotID;
	public int dirmendIngotID;
	public int stoneIngotID;
	public int stornIngotID;
	public int stoldIngotID;
	public int stomendIngotID;
	public int iroldIngotID;
	public int irmendIngotID;
	public int gomendIngotID;
	public int obsidianShardID;
	public int obsidianIngotID;
	public int dirtHelmetID;
	public int dirtPlateID;
	public int dirtLegsID;
	public int dirtBootsID;
	public int dirtoneHelmetID;
	public int dirtonePlateID;
	public int dirtoneLegsID;
	public int dirtoneBootsID;
	public int dironHelmetID;
	public int dironPlateID;
	public int dironLegsID;
	public int dironBootsID;
	public int diroldHelmetID;
	public int diroldPlateID;
	public int diroldLegsID;
	public int diroldBootsID;
	public int dirmendHelmetID;
	public int dirmendPlateID;
	public int dirmendLegsID;
	public int dirmendBootsID;
	public int stornHelmetID;
	public int stornPlateID;
	public int stornLegsID;
	public int stornBootsID;
	public int stoldHelmetID;
	public int stoldPlateID;
	public int stoldLegsID;
	public int stoldBootsID;
	public int stomendHelmetID;
	public int stomendPlateID;
	public int stomendLegsID;
	public int stomendBootsID;
	public int iroldHelmetID;
	public int iroldPlateID;
	public int iroldLegsID;
	public int iroldBootsID;
	public int irmendHelmetID;
	public int irmendPlateID;
	public int irmendLegsID;
	public int irmendBootsID;
	public int gomendHelmetID;
	public int gomendPlateID;
	public int gomendLegsID;
	public int gomendBootsID;
	public int obsidianHelmetID;
	public int obsidianPlateID;
	public int obsidianLegsID;
	public int obsidianBootsID;	
	public int dirtBlockID;
	public int dirtoneBlockID;
	public int dironBlockID;
	public int diroldBlockID;
	public int dirmendBlockID;
	public int stoneBlockID;
	public int stornBlockID;
	public int stoldBlockID;
	public int stomendBlockID;
	public int iroldBlockID;
	public int irmendBlockID;
	public int gomendBlockID;
	public int dandID;
	public int davelID;
	public int doneID;
	public int dirtFlowerID;
	public int stoneFlowerID;
	public int ironFlowerID;
	public int goldFlowerID;
	public int diamondFlowerID;
	public int sandIngotID;
	public int sandBlockID;
	public int stoneHelmetID;
	public int stonePlateID;
	public int stoneLegsID;
	public int stoneBootsID;
	public int sandHelmetID;
	public int sandPlateID;
	public int sandLegsID;
	public int sandBootsID;
	public int sandswordID;
	public int sandpickID;
	public int sandaxeID;
	public int sandshovelID;
	public int sandhoeID;
	public int cobbleswordID;
	public int cobblepickID;
	public int cobbleaxeID;
	public int cobbleshovelID;
	public int cobblehoeID;
	
@PreInit
public void PreLoad(FMLPreInitializationEvent event){
	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	
	config.load();
	
	dirtswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirt Sword", 500).getInt();
	dirtpickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirt Pickaxe", 501).getInt();
	dirtaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirt Axe", 502).getInt();
	dirtshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirt Shovel", 503).getInt();
	dirthoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirt Hoe", 504).getInt();
	dirtoneswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirtone Sword", 505).getInt();
	dirtonepickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirtone Pickaxe", 506).getInt();
	dirtoneaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirtone Axe", 507).getInt();
	dirtoneshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirtone Shovel", 508).getInt();
	dirtonehoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirtone Hoe",  509).getInt();
	dironswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Diron Sword",  510).getInt();
	dironpickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Diron Pickaxe",  511).getInt();
	dironaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Diron Axe",  512).getInt();
	dironshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Diron Shovel",  513).getInt();
	dironhoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Diron Hoe",  514).getInt();
	diroldswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirold Sword",  515).getInt();
	diroldpickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirold Pickaxe",  516).getInt();
	diroldaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirold Axe",  517).getInt();
	diroldshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirold Shovel",  518).getInt();
	diroldhoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirold Hoe",  519).getInt();
	dirmendswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirmend Sword",  520).getInt();
	dirmendpickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirmend Pickaxe",  521).getInt();
	dirmendaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirmend Axe",  522).getInt();
	dirmendshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirmend Shovel",  523).getInt();
	dirmendhoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Dirmend Hoe",  524).getInt();
	stornswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Storn Sword",  525).getInt();
	stornpickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Storn Pick",  526).getInt();
	stornaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Storn Axe",  527).getInt();
	stornshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Storn Shovel",  528).getInt();
	stornhoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Storn Hoe",  529).getInt();
	stoldswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Stold Sword",  530).getInt();
	stoldpickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Stold Pickaxe",  531).getInt();
	stoldaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Stold Axe",  532).getInt();
	stoldshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Stold Shovel",  533).getInt();
	stoldhoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Stold Hoe",  534).getInt();
	stomendswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Stomend Sword",  535).getInt();
	stomendpickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Stomend Pickaxe",  536).getInt();
	stomendaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Stomend Axe",  537).getInt();
	stomendshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Stomend Shovel",  538).getInt();
	stomendhoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Stomend Hoe",  539).getInt();
	iroldswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Irold Sword",  540).getInt();
	iroldpickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Irold Pickaxe",  541).getInt();
	iroldaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Irold Axe",  542).getInt();
	iroldshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Irold Shovel",  543).getInt();
	iroldhoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Irold Hoe",  544).getInt();
	irmendswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Irmend Sword",  545).getInt();
	irmendpickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Irmend Pick",  546).getInt();
	irmendaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Irmend Axe",  547).getInt();
	irmendshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Irmend Shovel",  548).getInt();
	irmendhoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Irmend Hoe",  549).getInt();
	gomendswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Gomend Sword",  550).getInt();
	gomendpickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Gomend Pickaxe",  551).getInt();
	gomendaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Gomend Axe",  552).getInt();
	gomendshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Gomend Shovel",  553).getInt();
	gomendhoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Gomend Hoe",  554).getInt();
	obsidianswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Obsidian Sword",  555).getInt();
	obsidianpickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Obsidian Pickaxe",  556).getInt();
	obsidianaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Obsidian Axe",  557).getInt();
	obsidianshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Obsidian Shovel",  558).getInt();
	obsidianhoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Obsidian Hoe",  559).getInt();
	dirtIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Dirt Ingot",  560).getInt();
	dirtoneIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Dirtone Ingot",  561).getInt();
	dironIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Diron Ingot",  562).getInt();
 	diroldIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Dirold Ingot",  563).getInt();
	dirmendIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Dirmend Ingot",  564).getInt();
   	stoneIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Stone Ingot",  565).getInt();
	stornIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Storn Ingot",  566).getInt();
	stoldIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Stold Ingot",  567).getInt();
	stomendIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Stomend Ingot",  568).getInt();
	iroldIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Irold Ingot",  569).getInt();
	irmendIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Irmend Ingot",  570).getInt();
	gomendIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Gomend Ingot",  571).getInt();
	obsidianShardID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Obsidian Shard",  572).getInt();
	obsidianIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Obsidian Ingot",  573).getInt();	
	dirtHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirt Helmet ",  574).getInt();
	dirtPlateID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirt Chestplate",  575).getInt();
	dirtLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirt Leggings",  576).getInt();
	dirtBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirt Boots",  577).getInt();
	dirtoneHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirtone Helmet",  578).getInt();
	dirtonePlateID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirtone Chestplate",  579).getInt();
	dirtoneLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirtone Leggings",  580).getInt();
	dirtoneBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirtone Boots",  581).getInt();
	dironHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Diron Helmet",  582).getInt();
	dironPlateID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Diron Chestplate",  583).getInt();
	dironLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Diron Leggings",  584).getInt();
	dironBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Diron Boots",  585).getInt();
	diroldHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirold Helmet",  586).getInt();
	diroldPlateID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirold Chestplate",  587).getInt();
	diroldLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirold Leggings",  588).getInt();
	diroldBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirold Boots",  589).getInt();
	dirmendHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirmend Helmet",  590).getInt();
	dirmendPlateID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirmend Chestplate",  591).getInt();
	dirmendLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirmend Leggings",  592).getInt();
	dirmendBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Dirmend Boots",  593).getInt();
	stornHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Storn Helmet",  594).getInt();
	stornPlateID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Storn Chestplate",  595).getInt();
	stornLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Storn Leggings",  596).getInt();
	stornBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Storn Boots",  597).getInt();
	stoldHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Stold Helmet",  598).getInt();
	stoldPlateID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Stold Chestplate",  599).getInt();
	stoldLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Stold Leggings",  600).getInt();
	stoldBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Stold Boots",  601).getInt();
	stomendHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Stomend Helmet",  602).getInt();
	stomendPlateID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Stomend Chestplate",  603).getInt();
	stomendLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Stomend Leggings",  604).getInt();
	stomendBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Stomend Boots",  605).getInt();
	iroldHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Irold Helmet",  606).getInt();
	iroldPlateID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Irold Chestplate",  607).getInt();
	iroldLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Irold Leggings",  608).getInt();
	iroldBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Irold Boots",  609).getInt();
	irmendHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Irmend Helmet",  610).getInt();
	irmendPlateID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Irmend Chestplate",  611).getInt();
	irmendLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Irmend Leggings",  612).getInt();
	irmendBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Irmend Boots",  613).getInt();
	gomendHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Gomend Helmet",  614).getInt();
	gomendPlateID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Gomend Chestplate",  615).getInt();
	gomendLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Gomend Leggings",  616).getInt();
	gomendBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Gomend Boots",  617).getInt();
	obsidianHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Obsidian Helmet",  618).getInt();
	obsidianPlateID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Obsidian Chestplate",  619).getInt();
	obsidianLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Obsidian Leggings",  620).getInt();
	obsidianBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Obsidian Boots",  621).getInt();
	dirtBlockID = config.get(Configuration.CATEGORY_BLOCK, "Dirt Ingot Block", 622).getInt();
	dirtoneBlockID = config.get(Configuration.CATEGORY_BLOCK, "Dirtone Ingot Block", 623).getInt();
	dironBlockID = config.get(Configuration.CATEGORY_BLOCK, "Diron Ingot Block", 624).getInt();
	diroldBlockID = config.get(Configuration.CATEGORY_BLOCK, "Dirold Ingot Block", 625).getInt();
	dirmendBlockID = config.get(Configuration.CATEGORY_BLOCK, "Dirmend Ingot Block", 626).getInt();
	stoneBlockID = config.get(Configuration.CATEGORY_BLOCK, "Stone Ingot Block", 627).getInt();
	stornBlockID = config.get(Configuration.CATEGORY_BLOCK, "Storn Ingot Block", 628).getInt();
	stoldBlockID = config.get(Configuration.CATEGORY_BLOCK, "Stold Ingot Block", 629).getInt();
	stomendBlockID = config.get(Configuration.CATEGORY_BLOCK, "Stomend Ingot Block", 630).getInt();
	iroldBlockID = config.get(Configuration.CATEGORY_BLOCK, "Irold Ingot Block", 631).getInt();
	irmendBlockID = config.get(Configuration.CATEGORY_BLOCK, "Irmend Ingot Block", 632).getInt();
	gomendBlockID = config.get(Configuration.CATEGORY_BLOCK, "Gomend Ingot Block", 633).getInt();
	dandID = config.get(Configuration.CATEGORY_BLOCK, "Dirt/Sand Block", 634).getInt();
	davelID = config.get(Configuration.CATEGORY_BLOCK, "Dirt/Gravel Block", 635).getInt();
	doneID = config.get(Configuration.CATEGORY_BLOCK, "Dirt/Stone Block", 636).getInt();
	dirtFlowerID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_FLOWER, "Dirt Flower", 637).getInt();
	stoneFlowerID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_FLOWER, "Stone Flower", 638).getInt();
	ironFlowerID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_FLOWER, "Iron Flower", 639).getInt();
	goldFlowerID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_FLOWER, "Gold Flower", 640).getInt();
	diamondFlowerID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_FLOWER, "Diamond Flower", 641).getInt();
	sandIngotID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_INGOT, "Sand Ingot", 642).getInt();
	sandBlockID = config.get(Configuration.CATEGORY_BLOCK, "Sand Ingot Block", 643).getInt();
	stoneHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Stone Helmet", 644).getInt();
	stoneHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Stone Chestplate", 645).getInt();
	stoneLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Stone Leggings", 646).getInt();
	stoneBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Stone Boots", 647).getInt();
	sandHelmetID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Sand Helmet", 648).getInt();
	sandPlateID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Sand Chestplate", 649).getInt();
	sandLegsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Sand Leggings", 650).getInt();
	sandBootsID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_ARMOR, "Sand Boots", 651).getInt();
	sandswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Sand Sword", 652).getInt();
	sandpickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Sand Pickaxe", 653).getInt();
	sandaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Sand Axe", 654).getInt();
	sandshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Sand Shovel", 655).getInt();
	sandhoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Sand Hoe", 656).getInt();
	cobbleswordID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Cobble Sword", 652).getInt();
	cobblepickID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Cobble Pickaxe", 653).getInt();
	cobbleaxeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Cobble Axe", 654).getInt();
	cobbleshovelID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Cobble Shovel", 655).getInt();
	cobblehoeID = config.get(hybridcraft.IngotStuff.Config.CATEGORY_TOOL, "Cobble Hoe", 656).getInt();
	
	config.save();
	
}
	
@Init
public void load(FMLInitializationEvent event)
{
	//Tools
	dirtsword = new ItemDirtSword(dirtswordID, dirt).setIconIndex(0).setItemName("dirtsword");
	dirtpick = new ItemDirtPick(dirtpickID, dirt).setIconIndex(1).setItemName("dirtpick");
	dirtaxe = new ItemDirtAxe(dirtaxeID, dirt).setIconIndex(2).setItemName("dirtaxe");
	dirtshovel = new ItemDirtShovel(dirtshovelID, dirt).setIconIndex(3).setItemName("dirtshovel");
	dirthoe = new ItemDirtHoe(dirthoeID, dirt).setIconIndex(4).setItemName("dirthoe");
	dirtonesword = new ItemDirtoneSword(dirtoneswordID, dirtone).setIconIndex(5).setItemName("dirtonesword");
	dirtonepick = new ItemDirtonePick(dirtonepickID, dirtone).setIconIndex(6).setItemName("dirtonepick");
	dirtoneaxe = new ItemDirtoneAxe(dirtoneaxeID, dirtone).setIconIndex(7).setItemName("dirtoneaxe");
	dirtoneshovel = new ItemDirtoneShovel(dirtoneshovelID, dirtone).setIconIndex(8).setItemName("dirtoneshovel");
	dirtonehoe = new ItemDirtoneHoe(dirtonehoeID, dirtone).setIconIndex(9).setItemName("dirtonehoe");
	dironsword = new ItemDironSword(dironswordID, dirtone).setIconIndex(10).setItemName("dironsword");
	dironpick = new ItemDironPick(dironpickID, diron).setIconIndex(11).setItemName("dironpick");
	dironaxe = new ItemDironAxe(dironaxeID, diron).setIconIndex(12).setItemName("dironaxe");
	dironshovel = new ItemDironShovel(dironshovelID, diron).setIconIndex(13).setItemName("dironshovel");
	dironhoe = new ItemDironHoe(dironhoeID, diron).setIconIndex(14).setItemName("dironhoe");
	diroldsword = new ItemDiroldSword(diroldswordID, dirold).setIconIndex(15).setItemName("diroldsword");
	diroldpick = new ItemDiroldPick(diroldpickID, dirold).setIconIndex(16).setItemName("diroldpick");
	diroldaxe = new ItemDiroldAxe(diroldaxeID, dirold).setIconIndex(17).setItemName("diroldaxe");
	diroldshovel = new ItemDiroldShovel(diroldshovelID, dirold).setIconIndex(18).setItemName("diroldshovel");
	diroldhoe = new ItemDiroldHoe(diroldhoeID, dirold).setIconIndex(19).setItemName("diroldhoe");
	dirmendsword = new ItemDirmendSword(dirmendswordID, dirmend).setIconIndex(20).setItemName("dirmendsword");
	dirmendpick = new ItemDirmendPick(dirmendpickID, dirmend).setIconIndex(21).setItemName("dirmendpick");
	dirmendaxe = new ItemDirmendAxe(dirmendaxeID, dirmend).setIconIndex(22).setItemName("dirmendaxe");
	dirmendshovel = new ItemDirmendShovel(dirmendshovelID, dirmend).setIconIndex(23).setItemName("dirmendshovel");
	dirmendhoe = new ItemDirmendHoe(dirmendhoeID, dirmend).setIconIndex(24).setItemName("dirmendhoe");
	stornsword = new ItemStornSword(stornswordID, storn).setIconIndex(25).setItemName("stornsword");
	stornpick = new ItemStornPick(stornpickID, storn).setIconIndex(26).setItemName("stornpick");
	stornaxe = new ItemStornAxe(stornaxeID, storn).setIconIndex(27).setItemName("stornaxe");
	stornshovel = new ItemStornShovel(stornshovelID, storn).setIconIndex(28).setItemName("stornshovel");
	stornhoe = new ItemStornHoe(stornhoeID, storn).setIconIndex(29).setItemName("stornhoe");
	stoldsword = new ItemStoldSword(stoldswordID, stold).setIconIndex(30).setItemName("stoldsword");
	stoldpick = new ItemStoldPick(stoldpickID, stold).setIconIndex(31).setItemName("stoldpick");
	stoldaxe = new ItemStoldAxe(stoldaxeID, stold).setIconIndex(32).setItemName("stoldaxe");
	stoldshovel = new ItemStoldShovel(stoldshovelID, stold).setIconIndex(33).setItemName("stoldshovel");
	stoldhoe = new ItemStoldHoe(stoldhoeID, stold).setIconIndex(34).setItemName("stoldhoe");
	stomendsword = new ItemStomendSword(stomendswordID, stomend).setIconIndex(35).setItemName("stomendsword");
	stomendpick = new ItemStomendPick(stomendpickID, stomend).setIconIndex(36).setItemName("stomendpick");
	stomendaxe = new ItemStomendAxe(stomendaxeID, stomend).setIconIndex(37).setItemName("stomendaxe");
	stomendshovel = new ItemStomendShovel(stomendshovelID, stomend).setIconIndex(38).setItemName("stomendshovel");
	stomendhoe = new ItemStomendHoe(stomendhoeID, stomend).setIconIndex(39).setItemName("stomendhoe");
	iroldsword = new ItemIroldSword(iroldswordID, irold).setIconIndex(40).setItemName("iroldsword");
	iroldpick = new ItemIroldPick(iroldpickID, irold).setIconIndex(41).setItemName("iroldpick");
	iroldaxe = new ItemIroldAxe(iroldaxeID, irold).setIconIndex(42).setItemName("iroldaxe");
	iroldshovel = new ItemIroldShovel(iroldshovelID, irold).setIconIndex(43).setItemName("iroldshovel");
	iroldhoe = new ItemIroldHoe(iroldhoeID, irold).setIconIndex(44).setItemName("iroldhoe");
	irmendsword = new ItemIrmendSword(irmendswordID, irmend).setIconIndex(45).setItemName("irmendsword");
	irmendpick = new ItemIrmendPick(irmendpickID, irmend).setIconIndex(46).setItemName("irmendpick");
	irmendaxe = new ItemIrmendAxe(irmendaxeID, irmend).setIconIndex(47).setItemName("irmendaxe");
	irmendshovel = new ItemIrmendShovel(irmendshovelID, irmend).setIconIndex(48).setItemName("irmendshovel");
	irmendhoe = new ItemIrmendHoe(irmendhoeID, irmend).setIconIndex(49).setItemName("irmendhoe");
	gomendsword = new ItemGomendSword(gomendswordID, gomend).setIconIndex(50).setItemName("gomendsword");
	gomendpick = new ItemGomendPick(gomendpickID, gomend).setIconIndex(51).setItemName("gomendpick");
	gomendaxe = new ItemGomendAxe(gomendaxeID, gomend).setIconIndex(52).setItemName("gomendaxe");
	gomendshovel = new ItemGomendShovel(gomendshovelID, gomend).setIconIndex(53).setItemName("gomendshovel");
	gomendhoe = new ItemGomendHoe(gomendhoeID, gomend).setIconIndex(54).setItemName("gomendhoe");
	obsidiansword = new ItemObsidianSword(obsidianswordID, obsidian).setIconIndex(55).setItemName("obsidiansword");
	obsidianpick = new ItemObsidianPick(obsidianpickID, obsidian).setIconIndex(56).setItemName("obsidianpick");
	obsidianaxe = new ItemObsidianAxe(obsidianaxeID, obsidian).setIconIndex(57).setItemName("obsidianaxe");
	obsidianshovel = new ItemObsidianShovel(obsidianshovelID, obsidian).setIconIndex(58).setItemName("obsidianshovel");
	obsidianhoe = new ItemObsidianHoe(obsidianhoeID, obsidian).setIconIndex(59).setItemName("obsidianhoe");
	sandsword = new ItemSandSword(sandswordID, sand).setIconIndex(60).setItemName("sandsword");
	sandpick = new ItemSandPick(sandpickID, sand).setIconIndex(61).setItemName("sandpick");
	sandaxe = new ItemSandAxe(sandaxeID, sand).setIconIndex(62).setItemName("sandaxe");
	sandshovel = new ItemSandShovel(sandshovelID, sand).setIconIndex(63).setItemName("sandshovel");
	sandhoe = new ItemSandHoe(sandhoeID, sand).setIconIndex(64).setItemName("sandhoe");
	cobblesword = new ItemCobbleSword(cobbleswordID, cobble).setIconIndex(65).setItemName("cobblesword");
	cobblepick = new ItemCobblePick(cobblepickID, cobble).setIconIndex(66).setItemName("cobblepick");
	cobbleaxe = new ItemCobbleAxe(cobbleaxeID, cobble).setIconIndex(67).setItemName("cobbleaxe");
	cobbleshovel = new ItemCobbleShovel(cobbleshovelID, cobble).setIconIndex(68).setItemName("cobbleshovel");
	cobblehoe = new ItemCobbleHoe(cobblehoeID, cobble).setIconIndex(69).setItemName("cobblehoe");
	
	
	//Ingot
	dirtIngot = new IngotDirt(dirtIngotID).setIconIndex(0).setItemName("dirtIngot");
	dirtoneIngot = new IngotDirtone(dirtoneIngotID).setIconIndex(1).setItemName("dirtoneIngot");
	dironIngot = new IngotDiron(dironIngotID).setIconIndex(2).setItemName("dironIngot");
	diroldIngot = new IngotDirold(diroldIngotID).setIconIndex(3).setItemName("diroldIngot");
	dirmendIngot = new IngotDirmend(dirmendIngotID).setIconIndex(4).setItemName("dirmendIngot");
	stoneIngot = new IngotStone(stoneIngotID).setIconIndex(5).setItemName("stoneIngot");
	stornIngot = new IngotStorn(stornIngotID).setIconIndex(6).setItemName("stornIngot");
	stoldIngot = new IngotStold(stoldIngotID).setIconIndex(7).setItemName("stoldIngot");
	stomendIngot = new IngotStormend(stomendIngotID).setIconIndex(8).setItemName("stormendIngot");
	iroldIngot = new IngotIrold(iroldIngotID).setIconIndex(9).setItemName("iroldIngot");
	irmendIngot = new IngotIrmend(irmendIngotID).setIconIndex(10).setItemName("irmendIngot");
	gomendIngot = new IngotGomend(gomendIngotID).setIconIndex(11).setItemName("gomendIngot");
	obsidianShard = new ShardObsidian(obsidianShardID).setIconIndex(12).setItemName("obsidianShard");
	obsidianIngot = new IngotObsidian(obsidianIngotID).setIconIndex(13).setItemName("obsidianIngot");
	sandIngot = new IngotSand(sandIngotID).setIconIndex(14).setItemName("sandIngot");
	
	//Armors
	dirtHelmet = new ArmorDirtHelmet(dirtHelmetID, dirta, proxy.addArmor("Dirt Helmet"),0).setItemName("dirtHelm").setIconIndex(0);
	dirtPlate = new ArmorDirtPlate(dirtPlateID, dirta, proxy.addArmor("Dirt Plate"),1).setItemName("dirtPlate").setIconIndex(1);
	dirtLegs = new ArmorDirtLegs(dirtLegsID, dirta, proxy.addArmor("Dirt Legs"),2).setItemName("dirtLegs").setIconIndex(2);
	dirtBoots = new ArmorDirtBoots(dirtBootsID, dirta, proxy.addArmor("Dirt Boots"),3).setItemName("dirtBoots").setIconIndex(3);
	dirtoneHelmet = new ArmorDirtoneHelmet(dirtoneHelmetID, dirtonea, proxy.addArmor("Dirtone Helmet"),0).setItemName("dirtoneHelm").setIconIndex(4);
	dirtonePlate = new ArmorDirtonePlate(dirtonePlateID, dirtonea, proxy.addArmor("Dirtone Plate"),1).setItemName("dirtonePlate").setIconIndex(5);
	dirtoneLegs = new ArmorDirtoneLegs(dirtoneLegsID, dirtonea, proxy.addArmor("Dirtone Legs"),2).setItemName("dirtoneLegs").setIconIndex(6);
	dirtoneBoots = new ArmorDirtoneBoots(dirtoneBootsID, dirtonea, proxy.addArmor("Dirtone Boots"),3).setItemName("dirtoneBoots").setIconIndex(7);
	dironHelmet = new ArmorDironHelmet(dironHelmetID, dirona, proxy.addArmor("Diron Helmet"),0).setItemName("dironHelm").setIconIndex(8);
	dironPlate = new ArmorDironPlate(dironPlateID, dirona, proxy.addArmor("Diron Plate"), 1).setItemName("dironPlate").setIconIndex(9);
	dironLegs = new ArmorDironLegs(dironLegsID, dirona, proxy.addArmor("Diron Legs"), 2).setItemName("dironLegs").setIconIndex(10);
	dironBoots = new ArmorDironBoots(dironBootsID, dirona, proxy.addArmor("Diron Boots"), 3).setItemName("dironBoots").setIconIndex(11);
	diroldHelmet = new ArmorDiroldHelmet(diroldHelmetID, dirolda, proxy.addArmor("Dirold Helmet"),0).setItemName("diroldHelm").setIconIndex(12);
	diroldPlate = new ArmorDiroldPlate(diroldPlateID, dirolda, proxy.addArmor("Dirold Plate"), 1).setItemName("diroldPlate").setIconIndex(13);
	diroldLegs = new ArmorDiroldLegs(diroldLegsID, dirolda, proxy.addArmor("Dirold Legs"), 2).setItemName("diroldLegs").setIconIndex(14);
	diroldBoots = new ArmorDiroldBoots(diroldBootsID, dirolda, proxy.addArmor("Dirold Boots"), 3).setItemName("diroldBoots").setIconIndex(15);
	dirmendHelmet = new ArmorDirmendHelmet(dirmendHelmetID, dirmenda, proxy.addArmor("Dirmend Helmet"),0).setItemName("DirmendHelm").setIconIndex(16);
	dirmendPlate = new ArmorDirmendPlate(dirmendPlateID, dirmenda, proxy.addArmor("Dirmend Plate"), 1).setItemName("DirmendPlate").setIconIndex(17);
	dirmendLegs = new ArmorDirmendLegs(dirmendLegsID, dirmenda, proxy.addArmor("Dirmend Legs"), 2).setItemName("DirmendLegs").setIconIndex(18);
	dirmendBoots = new ArmorDirmendBoots(dirmendBootsID, dirmenda, proxy.addArmor("Dirmend Boots"), 3).setItemName("DirmendBoots").setIconIndex(19);
	stornHelmet = new ArmorStornHelmet(stornHelmetID, storna, proxy.addArmor("Storn Helmet"),0).setItemName("StornHelm").setIconIndex(20);
	stornPlate = new ArmorStornPlate(stornPlateID, storna, proxy.addArmor("Storn Plate"), 1).setItemName("StornPlate").setIconIndex(21);
	stornLegs = new ArmorStornLegs(stornLegsID, storna, proxy.addArmor("Storn Legs"), 2).setItemName("StornLegs").setIconIndex(22);
	stornBoots = new ArmorStornBoots(stornBootsID, storna, proxy.addArmor("Storn Boots"), 3).setItemName("StornBoots").setIconIndex(23);
	stoldHelmet = new ArmorStoldHelmet(stoldHelmetID, stolda, proxy.addArmor("Stold Helmet"),0).setItemName("StoldHelm").setIconIndex(24);
	stoldPlate = new ArmorStoldPlate(stoldPlateID, stolda, proxy.addArmor("Stold Plate"), 1).setItemName("StoldPlate").setIconIndex(25);
	stoldLegs = new ArmorStoldLegs(stoldLegsID, stolda, proxy.addArmor("Stold Legs"), 2).setItemName("StoldLegs").setIconIndex(26);
	stoldBoots = new ArmorStoldBoots(stoldBootsID, stolda, proxy.addArmor("Stold Boots"), 3).setItemName("StoldBoots").setIconIndex(27);
	stomendHelmet = new ArmorStomendHelmet(stomendHelmetID, stomenda, proxy.addArmor("Stomend Helmet"),0).setItemName("StomendHelm").setIconIndex(28);
	stomendPlate = new ArmorStomendPlate(stomendPlateID, stomenda, proxy.addArmor("Stomend Plate"), 1).setItemName("StomendPlate").setIconIndex(29);
	stomendLegs = new ArmorStomendLegs(stomendLegsID, stomenda, proxy.addArmor("Stomend Legs"), 2).setItemName("StomendLegs").setIconIndex(30);
	stomendBoots = new ArmorStomendBoots(stomendBootsID, stomenda, proxy.addArmor("Stomend Boots"), 3).setItemName("StomendBoots").setIconIndex(31);
	iroldHelmet = new ArmorIroldHelmet(iroldHelmetID, irolda, proxy.addArmor("Irold Helmet"),0).setItemName("IroldHelm").setIconIndex(32);
	iroldPlate = new ArmorIroldPlate(iroldPlateID, irolda, proxy.addArmor("Irold Plate"), 1).setItemName("IroldPlate").setIconIndex(33);
	iroldLegs = new ArmorIroldLegs(iroldLegsID, irolda, proxy.addArmor("Irold Legs"), 2).setItemName("IroldLegs").setIconIndex(34);
	iroldBoots = new ArmorIroldBoots(iroldBootsID, irolda, proxy.addArmor("Irold Boots"), 3).setItemName("IroldBoots").setIconIndex(35);
	irmendHelmet = new ArmorIrmendHelmet(irmendHelmetID, irmenda, proxy.addArmor("Irmend Helmet"),0).setItemName("IrmendHelm").setIconIndex(36);
	irmendPlate = new ArmorIrmendPlate(irmendPlateID, irmenda, proxy.addArmor("Irmend Plate"), 1).setItemName("IrmendPlate").setIconIndex(37);
	irmendLegs = new ArmorIrmendLegs(irmendLegsID, irmenda, proxy.addArmor("Irmend Legs"), 2).setItemName("IrmendLegs").setIconIndex(38);
	irmendBoots = new ArmorIrmendBoots(irmendBootsID, irmenda, proxy.addArmor("Irmend Boots"), 3).setItemName("IrmendBoots").setIconIndex(39);
	gomendHelmet = new ArmorGomendHelmet(gomendHelmetID, gomenda, proxy.addArmor("Gomend Helmet"),0).setItemName("GomendHelm").setIconIndex(40);
	gomendPlate = new ArmorGomendPlate(gomendPlateID, gomenda, proxy.addArmor("Gomend Plate"), 1).setItemName("GomendPlate").setIconIndex(41);
	gomendLegs = new ArmorGomendLegs(gomendLegsID, gomenda, proxy.addArmor("Gomend Legs"), 2).setItemName("GomendLegs").setIconIndex(42);
	gomendBoots = new ArmorGomendBoots(gomendBootsID, gomenda, proxy.addArmor("Gomend Boots"), 3).setItemName("GomendBoots").setIconIndex(43);
	obsidianHelmet = new ArmorObsidianHelmet(obsidianHelmetID, obsidiana, proxy.addArmor("Obsidian Helmet"),0).setItemName("ObsidianHelm").setIconIndex(44);
	obsidianPlate = new ArmorObsidianPlate(obsidianPlateID, obsidiana, proxy.addArmor("Obsidian Plate"), 1).setItemName("ObsidianPlate").setIconIndex(45);
	obsidianLegs = new ArmorObsidianLegs(obsidianLegsID, obsidiana, proxy.addArmor("Obsidian Legs"), 2).setItemName("ObsidianLegs").setIconIndex(46);
	obsidianBoots = new ArmorObsidianBoots(obsidianBootsID, obsidiana, proxy.addArmor("Obsidian Boots"), 3).setItemName("ObsidianBoots").setIconIndex(47);
	stoneHelmet = new ArmorStoneHelmet(stoneHelmetID, stonea, proxy.addArmor("Stone Helmet"),0).setItemName("stoneHelm").setIconIndex(48);
	stonePlate = new ArmorStonePlate(stonePlateID, stonea, proxy.addArmor("Stone Plate"), 1).setItemName("stonePlate").setIconIndex(49);
	stoneLegs = new ArmorStoneLegs(stoneLegsID, stonea, proxy.addArmor("Stone Legs"), 2).setItemName("stoneLegs").setIconIndex(50);
	stoneBoots = new ArmorStoneBoots(stoneBootsID, stonea, proxy.addArmor("Stone Boots"), 3).setItemName("stoneBoots").setIconIndex(51);
	sandHelmet = new ArmorSandHelmet(sandHelmetID, sanda, proxy.addArmor("Sand Helmet"),0).setItemName("sandHelm").setIconIndex(52);
	sandPlate = new ArmorSandPlate(sandPlateID, sanda, proxy.addArmor("Sand Plate"), 1).setItemName("sandPlate").setIconIndex(53);
	sandLegs = new ArmorSandLegs(sandLegsID, sanda, proxy.addArmor("Sand Legs"), 2).setItemName("sandLegs").setIconIndex(54);
	sandBoots = new ArmorSandBoots(sandBootsID, sanda, proxy.addArmor("Sand Boots"), 3).setItemName("sandBoots").setIconIndex(55);
	
	
	//Ingot Blocks
	dirtBlock = new IngotDirtBlock(dirtBlockID, 0).setStepSound(Block.soundMetalFootstep).setBlockName("dirtBlock").setHardness(3F).setResistance(4F);
	dirtoneBlock = new IngotDirtoneBlock(dirtoneBlockID, 1).setStepSound(Block.soundMetalFootstep).setBlockName("dirtoneBlock").setHardness(3F).setResistance(4F);
	dironBlock = new IngotDironBlock(dironBlockID, 2).setStepSound(Block.soundMetalFootstep).setBlockName("dironBlock").setHardness(3F).setResistance(4F);
	diroldBlock = new IngotDiroldBlock(diroldBlockID, 3).setStepSound(Block.soundMetalFootstep).setBlockName("diroldBlock").setHardness(3F).setResistance(4F);
	dirmendBlock = new IngotDirmendBlock(dirmendBlockID, 4).setStepSound(Block.soundMetalFootstep).setBlockName("dirmendBlock").setHardness(3F).setResistance(4F);
	stoneBlock = new IngotStoneBlock(stoneBlockID, 5).setStepSound(Block.soundMetalFootstep).setBlockName("stoneBlock").setHardness(3F).setResistance(4F);
	stornBlock = new IngotStornBlock(stornBlockID, 6).setStepSound(Block.soundMetalFootstep).setBlockName("stornBlock").setHardness(3F).setResistance(4F);
	stoldBlock = new IngotStoldBlock(stoldBlockID, 7).setStepSound(Block.soundMetalFootstep).setBlockName("stoldBlock").setHardness(3F).setResistance(4F);
	stomendBlock = new IngotStomendBlock(stomendBlockID, 8).setStepSound(Block.soundMetalFootstep).setBlockName("stomendBlock").setHardness(3F).setResistance(4F);
	iroldBlock = new IngotIroldBlock(iroldBlockID, 9).setStepSound(Block.soundMetalFootstep).setBlockName("iroldBlock").setHardness(3F).setResistance(4F);
	irmendBlock = new IngotIrmendBlock(irmendBlockID, 10).setStepSound(Block.soundMetalFootstep).setBlockName("irmendBlock").setHardness(3F).setResistance(4F);
	gomendBlock = new IngotGomendBlock(gomendBlockID, 11).setStepSound(Block.soundMetalFootstep).setBlockName("gomendBlock").setHardness(3F).setResistance(4F);
	sandBlock = new IngotSandBlock(sandBlockID, 12).setStepSound(Block.soundSandFootstep).setBlockName("sandBlock").setHardness(3F).setResistance(4F);
	
	//World Blocks
	dand = new BlockDand(dandID, 0).setStepSound(Block.soundSandFootstep).setBlockName("dandBlock").setHardness(1F).setResistance(2F);
	davel = new BlockDavel(davelID, 1).setStepSound(Block.soundGravelFootstep).setBlockName("davelBlock").setHardness(1F).setResistance(2F);
	done = new BlockDone(doneID, 2).setStepSound(Block.soundGrassFootstep).setBlockName("doneBlock").setHardness(1F).setResistance(2F);
	
	//Flowers
	dirtFlower = (BlockFlower) new FlowerDirt(dirtFlowerID, 0).setBlockName("dirtFlower");
	stoneFlower = (BlockFlower) new FlowerStone(stoneFlowerID, 1).setBlockName("stoneFlower");
	ironFlower = (BlockFlower) new FlowerIron(ironFlowerID, 2).setBlockName("ironFlower");
	goldFlower = (BlockFlower) new FlowerGold(goldFlowerID, 3).setBlockName("goldFlower");
	diamondFlower = (BlockFlower) new FlowerDiamond(diamondFlowerID, 4).setBlockName("diamondFlower");
	
	
	//Tool Registry
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
	
	//Ingot Registry
	LanguageRegistry.addName(dirtIngot, "Dirt Ingot");
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
	LanguageRegistry.addName(obsidianShard, "Shard 'o Obsidian");
	LanguageRegistry.addName(obsidianIngot, "Obsidian Ingot");
	LanguageRegistry.addName(sandIngot, "Sand Ingot");
	
	//Armor Registry
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
	
	//Ingot Block Registry
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
	
	//World Blocks
	GameRegistry.registerBlock(dand);
	GameRegistry.registerBlock(davel);
	GameRegistry.registerBlock(done);
	LanguageRegistry.addName(dand, "Dirt/Sand Block");
	LanguageRegistry.addName(davel, "Dirt/Gravel Block");
	LanguageRegistry.addName(done, "Dirt/Stone Block");
	
	//World Generator
	GameRegistry.registerWorldGenerator(new WorldGeneratorHybrid());
	
	//Flower Registry
	GameRegistry.registerBlock(dirtFlower);
	GameRegistry.registerBlock(stoneFlower);
	GameRegistry.registerBlock(ironFlower);
	GameRegistry.registerBlock(goldFlower);
	GameRegistry.registerBlock(diamondFlower);
	LanguageRegistry.addName(dirtFlower, "Dirt Flower");
	LanguageRegistry.addName(stoneFlower, "Stone Flower");
	LanguageRegistry.addName(ironFlower, "Iron Flower");
	LanguageRegistry.addName(goldFlower, "Gold Flower");
	LanguageRegistry.addName(diamondFlower, "Diamond Flower");
	
	//Tool Recipes
	GameRegistry.addRecipe(new ItemStack(dirtsword), new Object[]
			  {
		"X", "X", "Z", 'X', dirtIngot, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(dirtpick), new Object[]
			{
		"XXX", " S ", " S ", 'X', dirtIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dirtaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', dirtIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dirtshovel), new Object[]
			{
		"X", "S", "S", 'X', dirtIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dirthoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', dirtIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dirtonesword), new Object[]
			  {
		"X", "X", "Z", 'X', dirtoneIngot, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(dirtonepick), new Object[]
			{
		"XXX", " S ", " S ", 'X', dirtoneIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dirtoneaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', dirtoneIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dirtoneshovel), new Object[]
			{
		"X", "S", "S", 'X', dirtoneIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dirtonehoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', dirtoneIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dironsword), new Object[]
			  {
		"X", "X", "Z", 'X', dironIngot, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(dironpick), new Object[]
			{
		"XXX", " S ", " S ", 'X', dironIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dironaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', dironIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dironshovel), new Object[]
			{
		"X", "S", "S", 'X', dironIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dironhoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', dironIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(diroldsword), new Object[]
			  {
		"X", "X", "Z", 'X', diroldIngot, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(diroldpick), new Object[]
			{
		"XXX", " S ", " S ", 'X', diroldIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(diroldaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', diroldIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(diroldshovel), new Object[]
			{
		"X", "S", "S", 'X', diroldIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(diroldhoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', diroldIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dirmendsword), new Object[]
			  {
		"X", "X", "Z", 'X', dirmendIngot, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(dirmendpick), new Object[]
			{
		"XXX", " S ", " S ", 'X', dirmendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dirmendaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', dirmendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dirmendshovel), new Object[]
			{
		"X", "S", "S", 'X', dirmendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(dirmendhoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', dirmendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(stornsword), new Object[]
			  {
		"X", "X", "Z", 'X', stornIngot, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(stornpick), new Object[]
			{
		"XXX", " S ", " S ", 'X', stornIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(stornaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', stornIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(stornshovel), new Object[]
			{
		"X", "S", "S", 'X', stornIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(stornhoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', stornIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(stoldsword), new Object[]
			  {
		"X", "X", "Z", 'X', stoldIngot, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(stoldpick), new Object[]
			{
		"XXX", " S ", " S ", 'X', stoldIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(stoldaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', stoldIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(stoldshovel), new Object[]
			{
		"X", "S", "S", 'X', stoldIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(stoldhoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', stoldIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(stomendsword), new Object[]
			  {
		"X", "X", "Z", 'X', stomendIngot, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(stomendpick), new Object[]
			{
		"XXX", " S ", " S ", 'X', stomendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(stomendaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', stomendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(stomendshovel), new Object[]
			{
		"X", "S", "S", 'X', stomendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(stomendhoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', stomendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(iroldsword), new Object[]
			  {
		"X", "X", "Z", 'X', iroldIngot, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(iroldpick), new Object[]
			{
		"XXX", " S ", " S ", 'X', iroldIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(iroldaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', iroldIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(iroldshovel), new Object[]
			{
		"X", "S", "S", 'X', iroldIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(iroldhoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', iroldIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(irmendsword), new Object[]
			  {
		"X", "X", "Z", 'X', irmendIngot, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(irmendpick), new Object[]
			{
		"XXX", " S ", " S ", 'X', irmendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(irmendaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', irmendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(irmendshovel), new Object[]
			{
		"X", "S", "S", 'X', irmendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(irmendhoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', irmendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(gomendsword), new Object[]
			  {
		"X", "X", "Z", 'X', gomendIngot, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(gomendpick), new Object[]
			{
		"XXX", " S ", " S ", 'X', gomendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(gomendaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', gomendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(gomendshovel), new Object[]
			{
		"X", "S", "S", 'X', gomendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(gomendhoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', gomendIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(obsidiansword), new Object[]
			  {
		"X", "X", "Z", 'X', obsidianIngot, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(obsidianpick), new Object[]
			{
		"XXX", " S ", " S ", 'X', obsidianIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(obsidianaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', obsidianIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(obsidianshovel), new Object[]
			{
		"X", "S", "S", 'X', obsidianIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(obsidianhoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', obsidianIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(sandsword), new Object[]
			  {
		"X", "X", "Z", 'X', sandIngot, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(sandpick), new Object[]
			{
		"XXX", " S ", " S ", 'X', sandIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(sandaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', sandIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(sandshovel), new Object[]
			{
		"X", "S", "S", 'X', sandIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(sandhoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', sandIngot, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(cobblesword), new Object[]
			  {
		"X", "X", "Z", 'X', Block.cobblestone, 'Z', Item.stick
			  });
	GameRegistry.addRecipe(new ItemStack(cobblepick), new Object[]
			{
		"XXX", " S ", " S ", 'X', Block.cobblestone, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(cobbleaxe), new Object[]
			{
		"XX ", "XS ", " S ", 'X', Block.cobblestone, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(cobbleshovel), new Object[]
			{
		"X", "S", "S", 'X', Block.cobblestone, 'S', Item.stick
			});
	GameRegistry.addRecipe(new ItemStack(cobblehoe), new Object[]
			{
		"XX ", " S ", " S ", 'X', Block.cobblestone, 'S', Item.stick
			});
	
	//Ingot Recipes
	GameRegistry.addRecipe(new ItemStack(dirtIngot), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', Block.dirt
			});
	GameRegistry.addRecipe(new ItemStack(dirtoneIngot), new Object[]
			{
		"XXX", "SSS", "XXX", 'X', Block.dirt, 'S', Block.stone,
			});
	GameRegistry.addRecipe(new ItemStack(dironIngot), new Object[]
			{
		"XXX", "XIX", "XXX", 'X', Block.dirt, 'I', Item.ingotIron,
			});
	GameRegistry.addRecipe(new ItemStack(diroldIngot), new Object[]
			{
		"XXX", "XGX", "XXX", 'X', Block.dirt, 'G', Item.ingotGold,
			});
	GameRegistry.addRecipe(new ItemStack(dirmendIngot), new Object[]
			{
		"XXX", "XDX", "XXX", 'X', Block.dirt, 'D', Item.diamond,
			});
	GameRegistry.addRecipe(new ItemStack(stoneIngot), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', Block.stone,
			});
	GameRegistry.addRecipe(new ItemStack(stornIngot), new Object[]
			{
		"XXX", "XIX", "XXX", 'X', Block.stone, 'I', Item.ingotIron,
			});
	GameRegistry.addRecipe(new ItemStack(stoldIngot), new Object[]
			{
		"XXX", "XGX", "XXX", 'X', Block.stone, 'G', Item.ingotGold,
			});
	GameRegistry.addRecipe(new ItemStack(stomendIngot), new Object[]
			{
		"XXX", "XDX", "XXX", 'X', Block.stone, 'D', Item.diamond,
			});
	GameRegistry.addRecipe(new ItemStack(iroldIngot), new Object[]
			{
		"GXG", "XGX", "GXG", 'X', Item.ingotIron, 'G', Item.ingotGold,
			});
	GameRegistry.addRecipe(new ItemStack(irmendIngot), new Object[]
			{
		"XXX", "XDX", "XXX", 'X', Item.ingotIron, 'D', Item.diamond,
			});
	GameRegistry.addRecipe(new ItemStack(gomendIngot), new Object[]
			{
		"GGG", "GDG", "GGG", 'D', Item.diamond, 'G', Item.ingotGold,
			});
	GameRegistry.addShapelessRecipe(new ItemStack(obsidianShard, 12), new Object[]
			{
		new ItemStack(Block.obsidian), new ItemStack(Item.pickaxeDiamond)
			});
	GameRegistry.addRecipe(new ItemStack(sandIngot), new Object[]
			{
		"SSS", "SSS", "SSS", 'S', Block.sand
			});
	
	//Armor Recipes
	GameRegistry.addRecipe(new ItemStack(dirtHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', dirtIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirtHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', dirtIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirtPlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', dirtIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirtLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', dirtIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirtBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', dirtIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirtBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', dirtIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirtoneHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', dirtoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirtoneHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', dirtoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirtonePlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', dirtoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirtoneLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', dirtoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirtoneBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', dirtoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirtoneBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', dirtoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dironHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', dironIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dironHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', dironIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dironPlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', dironIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dironLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', dironIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dironBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', dironIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dironBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', dironIngot,
			});
	GameRegistry.addRecipe(new ItemStack(diroldHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', diroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(diroldHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', diroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(diroldPlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', diroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(diroldLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', diroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(diroldBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', diroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(diroldBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', diroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirmendHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', dirmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirmendHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', dirmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirmendPlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', dirmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirmendLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', dirmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirmendBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', dirmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirmendBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', dirmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stornHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', stornIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stornHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', stornIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stornPlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', stornIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stornLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', stornIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stornBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', stornIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stornBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', stornIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stoldHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', stoldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stoldHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', stoldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stoldPlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', stoldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stoldLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', stoldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stoldBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', stoldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stoldBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', stoldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stomendHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', stomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stomendHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', stomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stomendPlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', stomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stomendLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', stomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stomendBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', stomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stomendBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', stomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(iroldHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', iroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(iroldHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', iroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(iroldPlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', iroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(iroldLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', iroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(iroldBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', iroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(iroldBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', iroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(irmendHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', irmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(irmendHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', irmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(irmendPlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', irmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(irmendLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', irmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(irmendBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', irmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(irmendBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', irmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(gomendHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', gomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(gomendHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', gomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(gomendPlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', gomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(gomendLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', gomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(gomendBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', gomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(gomendBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', gomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(obsidianHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', obsidianIngot,
			});
	GameRegistry.addRecipe(new ItemStack(obsidianHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', obsidianIngot,
			});
	GameRegistry.addRecipe(new ItemStack(obsidianPlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', obsidianIngot,
			});
	GameRegistry.addRecipe(new ItemStack(obsidianLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', obsidianIngot,
			});
	GameRegistry.addRecipe(new ItemStack(obsidianBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', obsidianIngot,
			});
	GameRegistry.addRecipe(new ItemStack(obsidianBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', obsidianIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stoneHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', stoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stoneHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', stoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stonePlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', stoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stoneLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', stoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stoneBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', stoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stoneBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', stoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(sandHelmet), new Object[]
			{
		"XXX", "X X", "   ", 'X', sandIngot,
			});
	GameRegistry.addRecipe(new ItemStack(sandHelmet), new Object[]
			{
		"   ", "XXX", "X X", 'X', sandIngot,
			});
	GameRegistry.addRecipe(new ItemStack(sandPlate), new Object[]
			{
		"X X", "XXX", "XXX", 'X', sandIngot,
			});
	GameRegistry.addRecipe(new ItemStack(sandLegs), new Object[]
			{
		"XXX", "X X", "X X", 'X', sandIngot,
			});
	GameRegistry.addRecipe(new ItemStack(sandBoots), new Object[]
			{
		"X X", "X X", "   ", 'X', sandIngot,
			});
	GameRegistry.addRecipe(new ItemStack(sandBoots), new Object[]
			{
		"   ", "X X", "X X", 'X', sandIngot,
			});
	
	//Block Recipes
	GameRegistry.addRecipe(new ItemStack(dirtBlock, 1), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', dirtIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirtoneBlock, 1), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', dirtoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dironBlock, 1), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', dironIngot,
			});
	GameRegistry.addRecipe(new ItemStack(diroldBlock, 1), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', diroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(dirmendBlock, 1), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', dirmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stoneBlock, 1), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', stoneIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stornBlock, 1), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', stornIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stoldBlock, 1), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', stoldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(stomendBlock, 1), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', stomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(iroldBlock, 1), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', iroldIngot,
			});
	GameRegistry.addRecipe(new ItemStack(irmendBlock, 1), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', irmendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(gomendBlock, 1), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', gomendIngot,
			});
	GameRegistry.addRecipe(new ItemStack(sandBlock, 1), new Object[]
			{
		"XXX", "XXX", "XXX", 'X', sandIngot,
			});
	
	//Block -> Ingot Recipes
	GameRegistry.addShapelessRecipe(new ItemStack(dirtIngot, 9), new Object[]
			{
		new ItemStack(dirtBlock)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(dirtoneIngot, 9), new Object[]
			{
		new ItemStack(dirtoneBlock)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(dironIngot, 9), new Object[]
			{
		new ItemStack(dironBlock)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(diroldIngot, 9), new Object[]
			{
		new ItemStack(diroldBlock)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(dirmendIngot, 9), new Object[]
			{
		new ItemStack(dirmendBlock)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(stoneIngot, 9), new Object[]
			{
		new ItemStack(stoneBlock)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(stornIngot, 9), new Object[]
			{
		new ItemStack(stornBlock)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(stoldIngot, 9), new Object[]
			{
		new ItemStack(stoldBlock)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(stomendIngot, 9), new Object[]
			{
		new ItemStack(stomendBlock)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(iroldIngot, 9), new Object[]
			{
		new ItemStack(iroldBlock)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(irmendIngot, 9), new Object[]
			{
		new ItemStack(irmendBlock)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(gomendIngot, 9), new Object[]
			{
		new ItemStack(gomendBlock)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(sandIngot, 9), new Object[]
			{
		new ItemStack(sandBlock)
			});
	
	//Flowers
	GameRegistry.addShapelessRecipe(new ItemStack(Block.dirt, 1), new Object[]
			{
		new ItemStack(dirtFlower)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(Block.stone, 1), new Object[]
			{
		new ItemStack(stoneFlower)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotIron, 1), new Object[]
			{
		new ItemStack(ironFlower)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(Item.ingotGold, 1), new Object[]
			{
		new ItemStack(goldFlower)
			});
	GameRegistry.addShapelessRecipe(new ItemStack(Item.diamond, 1), new Object[]
			{
		new ItemStack(diamondFlower)
			});
	
	//Smelting
	GameRegistry.addSmelting(obsidianShard.shiftedIndex, new ItemStack(obsidianIngot, 1), 2F);
	
	
	proxy.registerRenderThings();
}

}