//Tools 601-700
//Ingots 701-800
//Armors 801-900
//Blocks 401-800
//Flowers 901-950

package hybridcraft.IngotStuff;

import hybridcraft.IngotStuff.Armor.Dirmend;
import hybridcraft.IngotStuff.Armor.Dirold;
import hybridcraft.IngotStuff.Armor.Diron;
import hybridcraft.IngotStuff.Armor.Dirt;
import hybridcraft.IngotStuff.Armor.Dirtone;
import hybridcraft.IngotStuff.Armor.Emerald;
import hybridcraft.IngotStuff.Armor.Gomend;
import hybridcraft.IngotStuff.Armor.Irmend;
import hybridcraft.IngotStuff.Armor.Irold;
import hybridcraft.IngotStuff.Armor.Obsidian;
import hybridcraft.IngotStuff.Armor.Sand;
import hybridcraft.IngotStuff.Armor.Stold;
import hybridcraft.IngotStuff.Armor.Stomend;
import hybridcraft.IngotStuff.Armor.Stone;
import hybridcraft.IngotStuff.Armor.Storn;
import hybridcraft.IngotStuff.combiner.BlockCombiner;
import hybridcraft.IngotStuff.combiner.CombiningManager;
import hybridcraft.IngotStuff.combiner.GuiHandler;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "HybridCraft 2 Materials", name = "HybridCraft 2 Materials", version = "2.2 beta 1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class HybridModIngotStuff implements ICraftingHandler {

	// Instance
	@Instance("HybridCraft 2 Materials")
	public static HybridModIngotStuff instance = new HybridModIngotStuff();

	// Proxy
	@SidedProxy(clientSide = "hybrid.client.ClientProxyHybrid", serverSide = "hybridcraft.IngotStuff.CommonProxyHybrid")
	public static CommonProxyHybrid proxy;


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

	
	// Combiner GUI
	private GuiHandler guiHandler = new GuiHandler();
	
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

	// Crafting
	public static BlockCombiner blockCombiner;

	@Init
	public void load(FMLInitializationEvent event) {

		// Tools
		dirtsword = new ItemHybridSword(hybridcraft.Config.dirtswordID, dirt).setIconIndex(0).setItemName("dirtsword");
		dirtpick = new ItemHybridPickaxe(hybridcraft.Config.dirtpickID, dirt).setIconIndex(1).setItemName("dirtpick");
		dirtaxe = new ItemHybridAxe(hybridcraft.Config.dirtaxeID, dirt).setIconIndex(2).setItemName("dirtaxe");
		dirtshovel = new ItemHybridSpade(hybridcraft.Config.dirtshovelID, dirt).setIconIndex(3).setItemName("dirtshovel");
		dirthoe = new ItemHybridHoe(hybridcraft.Config.dirthoeID, dirt).setIconIndex(4).setItemName("dirthoe");
		dirtonesword = new ItemHybridSword(hybridcraft.Config.dirtoneswordID, dirtone).setIconIndex(5).setItemName("dirtonesword");
		dirtonepick = new ItemHybridPickaxe(hybridcraft.Config.dirtonepickID, dirtone).setIconIndex(6).setItemName("dirtonepick");
		dirtoneaxe = new ItemHybridAxe(hybridcraft.Config.dirtoneaxeID, dirtone).setIconIndex(7).setItemName("dirtoneaxe");
		dirtoneshovel = new ItemHybridSpade(hybridcraft.Config.dirtoneshovelID, dirtone).setIconIndex(8).setItemName("dirtoneshovel");
		dirtonehoe = new ItemHybridHoe(hybridcraft.Config.dirtonehoeID, dirtone).setIconIndex(9).setItemName("dirtonehoe");
		dironsword = new ItemHybridSword(hybridcraft.Config.dironswordID, dirtone).setIconIndex(10).setItemName("dironsword");
		dironpick = new ItemHybridPickaxe(hybridcraft.Config.dironpickID, diron).setIconIndex(11).setItemName("dironpick");
		dironaxe = new ItemHybridAxe(hybridcraft.Config.dironaxeID, diron).setIconIndex(12).setItemName("dironaxe");
		dironshovel = new ItemHybridSpade(hybridcraft.Config.dironshovelID, diron).setIconIndex(13).setItemName("dironshovel");
		dironhoe = new ItemHybridHoe(hybridcraft.Config.dironhoeID, diron).setIconIndex(14).setItemName("dironhoe");
		diroldsword = new ItemHybridSword(hybridcraft.Config.diroldswordID, dirold).setIconIndex(15).setItemName("diroldsword");
		diroldpick = new ItemHybridPickaxe(hybridcraft.Config.diroldpickID, dirold).setIconIndex(16).setItemName("diroldpick");
		diroldaxe = new ItemHybridAxe(hybridcraft.Config.diroldaxeID, dirold).setIconIndex(17).setItemName("diroldaxe");
		diroldshovel = new ItemHybridSpade(hybridcraft.Config.diroldshovelID, dirold).setIconIndex(18).setItemName("diroldshovel");
		diroldhoe = new ItemHybridHoe(hybridcraft.Config.diroldhoeID, dirold).setIconIndex(19).setItemName("diroldhoe");
		dirmendsword = new ItemHybridSword(hybridcraft.Config.dirmendswordID, dirmend).setIconIndex(20).setItemName("dirmendsword");
		dirmendpick = new ItemHybridPickaxe(hybridcraft.Config.dirmendpickID, dirmend).setIconIndex(21).setItemName("dirmendpick");
		dirmendaxe = new ItemHybridAxe(hybridcraft.Config.dirmendaxeID, dirmend).setIconIndex(22).setItemName("dirmendaxe");
		dirmendshovel = new ItemHybridSpade(hybridcraft.Config.dirmendshovelID, dirmend).setIconIndex(23).setItemName("dirmendshovel");
		dirmendhoe = new ItemHybridHoe(hybridcraft.Config.dirmendhoeID, dirmend).setIconIndex(24).setItemName("dirmendhoe");
		stornsword = new ItemHybridSword(hybridcraft.Config.stornswordID, storn).setIconIndex(25).setItemName("stornsword");
		stornpick = new ItemHybridPickaxe(hybridcraft.Config.stornpickID, storn).setIconIndex(26).setItemName("stornpick");
		stornaxe = new ItemHybridAxe(hybridcraft.Config.stornaxeID, storn).setIconIndex(27).setItemName("stornaxe");
		stornshovel = new ItemHybridSpade(hybridcraft.Config.stornshovelID, storn).setIconIndex(28).setItemName("stornshovel");
		stornhoe = new ItemHybridHoe(hybridcraft.Config.stornhoeID, storn).setIconIndex(29).setItemName("stornhoe");
		stoldsword = new ItemHybridSword(hybridcraft.Config.stoldswordID, stold).setIconIndex(30).setItemName("stoldsword");
		stoldpick = new ItemHybridPickaxe(hybridcraft.Config.stoldpickID, stold).setIconIndex(31).setItemName("stoldpick");
		stoldaxe = new ItemHybridAxe(hybridcraft.Config.stoldaxeID, stold).setIconIndex(32).setItemName("stoldaxe");
		stoldshovel = new ItemHybridSpade(hybridcraft.Config.stoldshovelID, stold).setIconIndex(33).setItemName("stoldshovel");
		stoldhoe = new ItemHybridHoe(hybridcraft.Config.stoldhoeID, stold).setIconIndex(34).setItemName("stoldhoe");
		stomendsword = new ItemHybridSword(hybridcraft.Config.stomendswordID, stomend).setIconIndex(35).setItemName("stomendsword");
		stomendpick = new ItemHybridPickaxe(hybridcraft.Config.stomendpickID, stomend).setIconIndex(36).setItemName("stomendpick");
		stomendaxe = new ItemHybridAxe(hybridcraft.Config.stomendaxeID, stomend).setIconIndex(37).setItemName("stomendaxe");
		stomendshovel = new ItemHybridSpade(hybridcraft.Config.stomendshovelID, stomend).setIconIndex(38).setItemName("stomendshovel");
		stomendhoe = new ItemHybridHoe(hybridcraft.Config.stomendhoeID, stomend).setIconIndex(39).setItemName("stomendhoe");
		iroldsword = new ItemHybridSword(hybridcraft.Config.iroldswordID, irold).setIconIndex(40).setItemName("iroldsword");
		iroldpick = new ItemHybridPickaxe(hybridcraft.Config.iroldpickID, irold).setIconIndex(41).setItemName("iroldpick");
		iroldaxe = new ItemHybridAxe(hybridcraft.Config.iroldaxeID, irold).setIconIndex(42).setItemName("iroldaxe");
		iroldshovel = new ItemHybridSpade(hybridcraft.Config.iroldshovelID, irold).setIconIndex(43).setItemName("iroldshovel");
		iroldhoe = new ItemHybridHoe(hybridcraft.Config.iroldhoeID, irold).setIconIndex(44).setItemName("iroldhoe");
		irmendsword = new ItemHybridSword(hybridcraft.Config.irmendswordID, irmend).setIconIndex(45).setItemName("irmendsword");
		irmendpick = new ItemHybridPickaxe(hybridcraft.Config.irmendpickID, irmend).setIconIndex(46).setItemName("irmendpick");
		irmendaxe = new ItemHybridAxe(hybridcraft.Config.irmendaxeID, irmend).setIconIndex(47).setItemName("irmendaxe");
		irmendshovel = new ItemHybridSpade(hybridcraft.Config.irmendshovelID, irmend).setIconIndex(48).setItemName("irmendshovel");
		irmendhoe = new ItemHybridHoe(hybridcraft.Config.irmendhoeID, irmend).setIconIndex(49).setItemName("irmendhoe");
		gomendsword = new ItemHybridSword(hybridcraft.Config.gomendswordID, gomend).setIconIndex(50).setItemName("gomendsword");
		gomendpick = new ItemHybridPickaxe(hybridcraft.Config.gomendpickID, gomend).setIconIndex(51).setItemName("gomendpick");
		gomendaxe = new ItemHybridAxe(hybridcraft.Config.gomendaxeID, gomend).setIconIndex(52).setItemName("gomendaxe");
		gomendshovel = new ItemHybridSpade(hybridcraft.Config.gomendshovelID, gomend).setIconIndex(53).setItemName("gomendshovel");
		gomendhoe = new ItemHybridHoe(hybridcraft.Config.gomendhoeID, gomend).setIconIndex(54).setItemName("gomendhoe");
		obsidiansword = new ItemHybridSword(hybridcraft.Config.obsidianswordID, obsidian).setIconIndex(55).setItemName("obsidiansword");
		obsidianpick = new ItemHybridPickaxe(hybridcraft.Config.obsidianpickID, obsidian).setIconIndex(56).setItemName("obsidianpick");
		obsidianaxe = new ItemHybridAxe(hybridcraft.Config.obsidianaxeID, obsidian).setIconIndex(57).setItemName("obsidianaxe");
		obsidianshovel = new ItemHybridSpade(hybridcraft.Config.obsidianshovelID, obsidian).setIconIndex(58).setItemName("obsidianshovel");
		obsidianhoe = new ItemHybridHoe(hybridcraft.Config.obsidianhoeID, obsidian).setIconIndex(59).setItemName("obsidianhoe");
		sandsword = new ItemHybridSword(hybridcraft.Config.sandswordID, sand).setIconIndex(60).setItemName("sandsword");
		sandpick = new ItemHybridPickaxe(hybridcraft.Config.sandpickID, sand).setIconIndex(61).setItemName("sandpick");
		sandaxe = new ItemHybridAxe(hybridcraft.Config.sandaxeID, sand).setIconIndex(62).setItemName("sandaxe");
		sandshovel = new ItemHybridSpade(hybridcraft.Config.sandshovelID, sand).setIconIndex(63).setItemName("sandshovel");
		sandhoe = new ItemHybridHoe(hybridcraft.Config.sandhoeID, sand).setIconIndex(64).setItemName("sandhoe");
		cobblesword = new ItemHybridSword(hybridcraft.Config.cobbleswordID, cobble).setIconIndex(65).setItemName("cobblesword");
		cobblepick = new ItemHybridPickaxe(hybridcraft.Config.cobblepickID, cobble).setIconIndex(66).setItemName("cobblepick");
		cobbleaxe = new ItemHybridAxe(hybridcraft.Config.cobbleaxeID, cobble).setIconIndex(67).setItemName("cobbleaxe");
		cobbleshovel = new ItemHybridSpade(hybridcraft.Config.cobbleshovelID, cobble).setIconIndex(68).setItemName("cobbleshovel");
		cobblehoe = new ItemHybridHoe(hybridcraft.Config.cobblehoeID, cobble).setIconIndex(69).setItemName("cobblehoe");
		emeraldsword = new ItemHybridSword(hybridcraft.Config.emeraldswordID, emerald).setIconIndex(70).setItemName("emeraldsword");
		emeraldpick = new ItemHybridPickaxe(hybridcraft.Config.emeraldpickID, emerald).setIconIndex(71).setItemName("emeraldpick");
		emeraldaxe = new ItemHybridAxe(hybridcraft.Config.emeraldaxeID, emerald).setIconIndex(72).setItemName("emeraldaxe");
		emeraldshovel = new ItemHybridSpade(hybridcraft.Config.emeraldshovelID, emerald).setIconIndex(73).setItemName("emeraldshovel");
		emeraldhoe = new ItemHybridHoe(hybridcraft.Config.emeraldhoeID, emerald).setIconIndex(74).setItemName("emeraldhoe");

		// Ingots
		obsidianShard = new Ingot(hybridcraft.Config.obsidianShardID).setIconIndex(12).setItemName("obsidianShard");
		obsidianIngot = new Ingot(hybridcraft.Config.obsidianIngotID).setIconIndex(13).setItemName("obsidianIngot");
		sandIngot = new Ingot(hybridcraft.Config.sandIngotID).setIconIndex(14).setItemName("sandIngot");
		dirtIngot = new Ingot(hybridcraft.Config.dirtIngotID).setIconIndex(0).setItemName("dirtIngot");

		// Armors
		dirtHelmet = new Dirt(hybridcraft.Config.dirtHelmetID, dirta, proxy.addArmor("Dirt Helmet"), 0).setItemName("dirtHelm").setIconIndex(0);
		dirtPlate = new Dirt(hybridcraft.Config.dirtPlateID, dirta, proxy.addArmor("Dirt Plate"), 1).setItemName("dirtPlate").setIconIndex(1);
		dirtLegs = new Dirt(hybridcraft.Config.dirtLegsID, dirta, proxy.addArmor("Dirt Legs"), 2).setItemName("dirtLegs").setIconIndex(2);
		dirtBoots = new Dirt(hybridcraft.Config.dirtBootsID, dirta, proxy.addArmor("Dirt Boots"), 3).setItemName("dirtBoots").setIconIndex(3);
		dirtoneHelmet = new Dirtone(hybridcraft.Config.dirtoneHelmetID, dirtonea, proxy.addArmor("Dirtone Helmet"), 0).setItemName("dirtoneHelm").setIconIndex(4);
		dirtonePlate = new Dirtone(hybridcraft.Config.dirtonePlateID, dirtonea, proxy.addArmor("Dirtone Plate"), 1).setItemName("dirtonePlate").setIconIndex(5);
		dirtoneLegs = new Dirtone(hybridcraft.Config.dirtoneLegsID, dirtonea, proxy.addArmor("Dirtone Legs"), 2).setItemName("dirtoneLegs").setIconIndex(6);
		dirtoneBoots = new Dirtone(hybridcraft.Config.dirtoneBootsID, dirtonea, proxy.addArmor("Dirtone Boots"), 3).setItemName("dirtoneBoots").setIconIndex(7);
		dironHelmet = new Diron(hybridcraft.Config.dironHelmetID, dirona, proxy.addArmor("Diron Helmet"), 0).setItemName("dironHelm").setIconIndex(8);
		dironPlate = new Diron(hybridcraft.Config.dironPlateID, dirona, proxy.addArmor("Diron Plate"), 1).setItemName("dironPlate").setIconIndex(9);
		dironLegs = new Diron(hybridcraft.Config.dironLegsID, dirona, proxy.addArmor("Diron Legs"), 2).setItemName("dironLegs").setIconIndex(10);
		dironBoots = new Diron(hybridcraft.Config.dironBootsID, dirona, proxy.addArmor("Diron Boots"), 3).setItemName("dironBoots").setIconIndex(11);
		diroldHelmet = new Dirold(hybridcraft.Config.diroldHelmetID, dirolda, proxy.addArmor("Dirold Helmet"), 0).setItemName("diroldHelm").setIconIndex(12);
		diroldPlate = new Dirold(hybridcraft.Config.diroldPlateID, dirolda, proxy.addArmor("Dirold Plate"), 1).setItemName("diroldPlate").setIconIndex(13);
		diroldLegs = new Dirold(hybridcraft.Config.diroldLegsID, dirolda, proxy.addArmor("Dirold Legs"), 2).setItemName("diroldLegs").setIconIndex(14);
		diroldBoots = new Dirold(hybridcraft.Config.diroldBootsID, dirolda, proxy.addArmor("Dirold Boots"), 3).setItemName("diroldBoots").setIconIndex(15);
		dirmendHelmet = new Dirmend(hybridcraft.Config.dirmendHelmetID, dirmenda, proxy.addArmor("Dirmend Helmet"), 0).setItemName("DirmendHelm").setIconIndex(16);
		dirmendPlate = new Dirmend(hybridcraft.Config.dirmendPlateID, dirmenda, proxy.addArmor("Dirmend Plate"), 1).setItemName("DirmendPlate").setIconIndex(17);
		dirmendLegs = new Dirmend(hybridcraft.Config.dirmendLegsID, dirmenda, proxy.addArmor("Dirmend Legs"), 2).setItemName("DirmendLegs").setIconIndex(18);
		dirmendBoots = new Dirmend(hybridcraft.Config.dirmendBootsID, dirmenda, proxy.addArmor("Dirmend Boots"), 3).setItemName("DirmendBoots").setIconIndex(19);
		stornHelmet = new Storn(hybridcraft.Config.stornHelmetID, storna, proxy.addArmor("Storn Helmet"), 0).setItemName("StornHelm").setIconIndex(20);
		stornPlate = new Storn(hybridcraft.Config.stornPlateID, storna, proxy.addArmor("Storn Plate"), 1).setItemName("StornPlate").setIconIndex(21);
		stornLegs = new Storn(hybridcraft.Config.stornLegsID, storna, proxy.addArmor("Storn Legs"), 2).setItemName("StornLegs").setIconIndex(22);
		stornBoots = new Storn(hybridcraft.Config.stornBootsID, storna, proxy.addArmor("Storn Boots"), 3).setItemName("StornBoots").setIconIndex(23);
		stoldHelmet = new Stold(hybridcraft.Config.stoldHelmetID, stolda, proxy.addArmor("Stold Helmet"), 0).setItemName("StoldHelm").setIconIndex(24);
		stoldPlate = new Stold(hybridcraft.Config.stoldPlateID, stolda, proxy.addArmor("Stold Plate"), 1).setItemName("StoldPlate").setIconIndex(25);
		stoldLegs = new Stold(hybridcraft.Config.stoldLegsID, stolda, proxy.addArmor("Stold Legs"), 2).setItemName("StoldLegs").setIconIndex(26);
		stoldBoots = new Stold(hybridcraft.Config.stoldBootsID, stolda, proxy.addArmor("Stold Boots"), 3).setItemName("StoldBoots").setIconIndex(27);
		stomendHelmet = new Stomend(hybridcraft.Config.stomendHelmetID, stomenda, proxy.addArmor("Stomend Helmet"), 0).setItemName("StomendHelm").setIconIndex(28);
		stomendPlate = new Stomend(hybridcraft.Config.stomendPlateID, stomenda, proxy.addArmor("Stomend Plate"), 1).setItemName("StomendPlate").setIconIndex(29);
		stomendLegs = new Stomend(hybridcraft.Config.stomendLegsID, stomenda, proxy.addArmor("Stomend Legs"), 2).setItemName("StomendLegs").setIconIndex(30);
		stomendBoots = new Stomend(hybridcraft.Config.stomendBootsID, stomenda, proxy.addArmor("Stomend Boots"), 3).setItemName("StomendBoots").setIconIndex(31);
		iroldHelmet = new Irold(hybridcraft.Config.iroldHelmetID, irolda, proxy.addArmor("Irold Helmet"), 0).setItemName("IroldHelm").setIconIndex(32);
		iroldPlate = new Irold(hybridcraft.Config.iroldPlateID, irolda, proxy.addArmor("Irold Plate"), 1).setItemName("IroldPlate").setIconIndex(33);
		iroldLegs = new Irold(hybridcraft.Config.iroldLegsID, irolda, proxy.addArmor("Irold Legs"), 2).setItemName("IroldLegs").setIconIndex(34);
		iroldBoots = new Irold(hybridcraft.Config.iroldBootsID, irolda, proxy.addArmor("Irold Boots"), 3).setItemName("IroldBoots").setIconIndex(35);
		irmendHelmet = new Irmend(hybridcraft.Config.irmendHelmetID, irmenda, proxy.addArmor("Irmend Helmet"), 0).setItemName("IrmendHelm").setIconIndex(36);
		irmendPlate = new Irmend(hybridcraft.Config.irmendPlateID, irmenda, proxy.addArmor("Irmend Plate"), 1).setItemName("IrmendPlate").setIconIndex(37);
		irmendLegs = new Irmend(hybridcraft.Config.irmendLegsID, irmenda, proxy.addArmor("Irmend Legs"), 2).setItemName("IrmendLegs").setIconIndex(38);
		irmendBoots = new Irmend(hybridcraft.Config.irmendBootsID, irmenda, proxy.addArmor("Irmend Boots"), 3).setItemName("IrmendBoots").setIconIndex(39);
		gomendHelmet = new Gomend(hybridcraft.Config.gomendHelmetID, gomenda, proxy.addArmor("Gomend Helmet"), 0).setItemName("GomendHelm").setIconIndex(40);
		gomendPlate = new Gomend(hybridcraft.Config.gomendPlateID, gomenda, proxy.addArmor("Gomend Plate"), 1).setItemName("GomendPlate").setIconIndex(41);
		gomendLegs = new Gomend(hybridcraft.Config.gomendLegsID, gomenda, proxy.addArmor("Gomend Legs"), 2).setItemName("GomendLegs").setIconIndex(42);
		gomendBoots = new Gomend(hybridcraft.Config.gomendBootsID, gomenda, proxy.addArmor("Gomend Boots"), 3).setItemName("GomendBoots").setIconIndex(43);
		obsidianHelmet = new Obsidian(hybridcraft.Config.obsidianHelmetID, obsidiana, proxy.addArmor("Obsidian Helmet"), 0).setItemName("ObsidianHelm").setIconIndex(44);
		obsidianPlate = new Obsidian(hybridcraft.Config.obsidianPlateID, obsidiana, proxy.addArmor("Obsidian Plate"), 1).setItemName("ObsidianPlate").setIconIndex(45);
		obsidianLegs = new Obsidian(hybridcraft.Config.obsidianLegsID, obsidiana, proxy.addArmor("Obsidian Legs"), 2).setItemName("ObsidianLegs").setIconIndex(46);
		obsidianBoots = new Obsidian(hybridcraft.Config.obsidianBootsID, obsidiana, proxy.addArmor("Obsidian Boots"), 3).setItemName("ObsidianBoots").setIconIndex(47);
		stoneHelmet = new Stone(hybridcraft.Config.stoneHelmetID, stonea, proxy.addArmor("Stone Helmet"), 0).setItemName("stoneHelm").setIconIndex(48);
		stonePlate = new Stone(hybridcraft.Config.stonePlateID, stonea, proxy.addArmor("Stone Plate"), 1).setItemName("stonePlate").setIconIndex(49);
		stoneLegs = new Stone(hybridcraft.Config.stoneLegsID, stonea, proxy.addArmor("Stone Legs"), 2).setItemName("stoneLegs").setIconIndex(50);
		stoneBoots = new Stone(hybridcraft.Config.stoneBootsID, stonea, proxy.addArmor("Stone Boots"), 3).setItemName("stoneBoots").setIconIndex(51);
		sandHelmet = new Sand(hybridcraft.Config.sandHelmetID, sanda, proxy.addArmor("Sand Helmet"), 0).setItemName("sandHelm").setIconIndex(52);
		sandPlate = new Sand(hybridcraft.Config.sandPlateID, sanda, proxy.addArmor("Sand Plate"), 1).setItemName("sandPlate").setIconIndex(53);
		sandLegs = new Sand(hybridcraft.Config.sandLegsID, sanda, proxy.addArmor("Sand Legs"), 2).setItemName("sandLegs").setIconIndex(54);
		sandBoots = new Sand(hybridcraft.Config.sandBootsID, sanda, proxy.addArmor("Sand Boots"), 3).setItemName("sandBoots").setIconIndex(55);
		emeraldHelmet = new Emerald(hybridcraft.Config.emeraldhelmetID, emeralda, proxy.addArmor("emerald Helmet"), 0).setItemName("emeraldHelm").setIconIndex(56);
		emeraldPlate = new Emerald(hybridcraft.Config.emeraldplateID, emeralda, proxy.addArmor("emerald Plate"), 1).setItemName("emeraldPlate").setIconIndex(57);
		emeraldLegs = new Emerald(hybridcraft.Config.emeraldlegsID, emeralda, proxy.addArmor("emerald Legs"), 2).setItemName("emeraldLegs").setIconIndex(58);
		emeraldBoots = new Emerald(hybridcraft.Config.emeraldbootsID, emeralda, proxy.addArmor("emerald Boots"), 3).setItemName("emeraldBoots").setIconIndex(59);

		// Ingot Blocks
		dirtBlock = new IngotBlock(hybridcraft.Config.dirtBlockID, 0).setStepSound(Block.soundMetalFootstep).setBlockName("dirtBlock").setHardness(3F).setResistance(4F);
		dirtoneBlock = new IngotBlock(hybridcraft.Config.dirtoneBlockID, 1).setStepSound(Block.soundMetalFootstep).setBlockName("dirtoneBlock").setHardness(3F).setResistance(4F);
		dironBlock = new IngotBlock(hybridcraft.Config.dironBlockID, 2).setStepSound(Block.soundMetalFootstep).setBlockName("dironBlock").setHardness(3F).setResistance(4F);
		diroldBlock = new IngotBlock(hybridcraft.Config.diroldBlockID, 3).setStepSound(Block.soundMetalFootstep).setBlockName("diroldBlock").setHardness(3F).setResistance(4F);
		dirmendBlock = new IngotBlock(hybridcraft.Config.dirmendBlockID, 4).setStepSound(Block.soundMetalFootstep).setBlockName("dirmendBlock").setHardness(3F).setResistance(4F);
		stoneBlock = new IngotBlock(hybridcraft.Config.stoneBlockID, 5).setStepSound(Block.soundMetalFootstep).setBlockName("stoneBlock").setHardness(3F).setResistance(4F);
		stornBlock = new IngotBlock(hybridcraft.Config.stornBlockID, 6).setStepSound(Block.soundMetalFootstep).setBlockName("stornBlock").setHardness(3F).setResistance(4F);
		stoldBlock = new IngotBlock(hybridcraft.Config.stoldBlockID, 7).setStepSound(Block.soundMetalFootstep).setBlockName("stoldBlock").setHardness(3F).setResistance(4F);
		stomendBlock = new IngotBlock(hybridcraft.Config.stomendBlockID, 8).setStepSound(Block.soundMetalFootstep).setBlockName("stomendBlock").setHardness(3F).setResistance(4F);
		iroldBlock = new IngotBlock(hybridcraft.Config.iroldBlockID, 9).setStepSound(Block.soundMetalFootstep).setBlockName("iroldBlock").setHardness(3F).setResistance(4F);
		irmendBlock = new IngotBlock(hybridcraft.Config.irmendBlockID, 10).setStepSound(Block.soundMetalFootstep).setBlockName("irmendBlock").setHardness(3F).setResistance(4F);
		gomendBlock = new IngotBlock(hybridcraft.Config.gomendBlockID, 11).setStepSound(Block.soundMetalFootstep).setBlockName("gomendBlock").setHardness(3F).setResistance(4F);
		sandBlock = new IngotBlock(hybridcraft.Config.sandBlockID, 12).setStepSound(Block.soundSandFootstep).setBlockName("sandBlock").setHardness(3F).setResistance(4F);

		// World Blocks
		dand = new WorldBlockFall(hybridcraft.Config.dandID, 0).setStepSound(Block.soundSandFootstep).setBlockName("dandBlock").setHardness(1F).setResistance(2F);
		davel = new WorldBlockFall(hybridcraft.Config.davelID, 1).setStepSound(Block.soundGravelFootstep).setBlockName("davelBlock").setHardness(1F).setResistance(2F);
		done = new WorldBlockStay(hybridcraft.Config.doneID, 2).setStepSound(Block.soundGrassFootstep).setBlockName("doneBlock").setHardness(1F).setResistance(2F);

		// Flowers
		dirtFlower = (BlockFlower) new Flowers(hybridcraft.Config.dirtFlowerID, 0).setBlockName("dirtFlower");
		stoneFlower = (BlockFlower) new Flowers(hybridcraft.Config.stoneFlowerID, 1).setBlockName("stoneFlower");
		ironFlower = (BlockFlower) new Flowers(hybridcraft.Config.ironFlowerID, 2).setBlockName("ironFlower");
		goldFlower = (BlockFlower) new Flowers(hybridcraft.Config.goldFlowerID, 3).setBlockName("goldFlower");
		diamondFlower = (BlockFlower) new Flowers(hybridcraft.Config.diamondFlowerID, 4).setBlockName("diamondFlower");
		obsidianFlower = (BlockFlower) new Flowers(hybridcraft.Config.obsidianFlowerID, 5).setBlockName("obsidianFlower");
		emeraldFlower = (BlockFlower) new Flowers(hybridcraft.Config.emeraldflowerID, 6).setBlockName("emeraldFlower");

		// Combiner
		blockCombiner = (BlockCombiner) new BlockCombiner(hybridcraft.Config.combinerID).setBlockName("Combiner");

		// Register combiner GUI
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);

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

		// register the crafting listener
		GameRegistry.registerCraftingHandler(this);

		
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
		GameRegistry.registerBlock(blockCombiner);
		LanguageRegistry.addName(blockCombiner, "Combiner");

		// //Tool Recipes

		GameRegistry.addShapelessRecipe(new ItemStack(obsidianShard, 12), new Object[] { new ItemStack(Block.obsidian), new ItemStack(Item.pickaxeDiamond) });
		GameRegistry.addRecipe(new ItemStack(sandIngot), new Object[] { "SSS", "SSS", "SSS", 'S', Block.sand });
		GameRegistry.addRecipe(new ItemStack(dirtIngot), new Object[] { "XXX", "XXX", "XXX", 'X', Block.dirt });

		GameRegistry.addRecipe(new ItemStack(dirtsword), new Object[] { "X", "X", "Z", 'X', dirtIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtpick), new Object[] { "XXX", " S ", " S ", 'X', dirtIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtaxe), new Object[] { "XX ", "XS ", " S ", 'X', dirtIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtshovel), new Object[] { "X", "S", "S", 'X', dirtIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirthoe), new Object[] { "XX ", " S ", " S ", 'X', dirtIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtonesword), new Object[] { "X", "X", "Z", 'X', CombiningManager.getInstance().dirtoneIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtonepick), new Object[] { "XXX", " S ", " S ", 'X', CombiningManager.getInstance().dirtoneIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtoneaxe), new Object[] { "XX ", "XS ", " S ", 'X', CombiningManager.getInstance().dirtoneIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtoneshovel), new Object[] { "X", "S", "S", 'X', CombiningManager.getInstance().dirtoneIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirtonehoe), new Object[] { "XX ", " S ", " S ", 'X', CombiningManager.getInstance().dirtoneIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dironsword), new Object[] { "X", "X", "Z", 'X', CombiningManager.getInstance().dironIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dironpick), new Object[] { "XXX", " S ", " S ", 'X', CombiningManager.getInstance().dironIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dironaxe), new Object[] { "XX ", "XS ", " S ", 'X', CombiningManager.getInstance().dironIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dironshovel), new Object[] { "X", "S", "S", 'X', CombiningManager.getInstance().dironIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dironhoe), new Object[] { "XX ", " S ", " S ", 'X', CombiningManager.getInstance().dironIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(diroldsword), new Object[] { "X", "X", "Z", 'X', CombiningManager.getInstance().diroldIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(diroldpick), new Object[] { "XXX", " S ", " S ", 'X', CombiningManager.getInstance().diroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(diroldaxe), new Object[] { "XX ", "XS ", " S ", 'X', CombiningManager.getInstance().diroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(diroldshovel), new Object[] { "X", "S", "S", 'X', CombiningManager.getInstance().diroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(diroldhoe), new Object[] { "XX ", " S ", " S ", 'X', CombiningManager.getInstance().diroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirmendsword), new Object[] { "X", "X", "Z", 'X', CombiningManager.getInstance().dirmendIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirmendpick), new Object[] { "XXX", " S ", " S ", 'X', CombiningManager.getInstance().dirmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirmendaxe), new Object[] { "XX ", "XS ", " S ", 'X', CombiningManager.getInstance().dirmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirmendshovel), new Object[] { "X", "S", "S", 'X', CombiningManager.getInstance().dirmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(dirmendhoe), new Object[] { "XX ", " S ", " S ", 'X', CombiningManager.getInstance().dirmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stornsword), new Object[] { "X", "X", "Z", 'X', CombiningManager.getInstance().stornIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stornpick), new Object[] { "XXX", " S ", " S ", 'X', CombiningManager.getInstance().stornIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stornaxe), new Object[] { "XX ", "XS ", " S ", 'X', CombiningManager.getInstance().stornIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stornshovel), new Object[] { "X", "S", "S", 'X', CombiningManager.getInstance().stornIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stornhoe), new Object[] { "XX ", " S ", " S ", 'X', CombiningManager.getInstance().stornIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stoldsword), new Object[] { "X", "X", "Z", 'X', CombiningManager.getInstance().stoldIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stoldpick), new Object[] { "XXX", " S ", " S ", 'X', CombiningManager.getInstance().stoldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stoldaxe), new Object[] { "XX ", "XS ", " S ", 'X', CombiningManager.getInstance().stoldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stoldshovel), new Object[] { "X", "S", "S", 'X', CombiningManager.getInstance().stoldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stoldhoe), new Object[] { "XX ", " S ", " S ", 'X', CombiningManager.getInstance().stoldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stomendsword), new Object[] { "X", "X", "Z", 'X', CombiningManager.getInstance().stomendIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stomendpick), new Object[] { "XXX", " S ", " S ", 'X', CombiningManager.getInstance().stomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stomendaxe), new Object[] { "XX ", "XS ", " S ", 'X', CombiningManager.getInstance().stomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stomendshovel), new Object[] { "X", "S", "S", 'X', CombiningManager.getInstance().stomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(stomendhoe), new Object[] { "XX ", " S ", " S ", 'X', CombiningManager.getInstance().stomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(iroldsword), new Object[] { "X", "X", "Z", 'X', CombiningManager.getInstance().iroldIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(iroldpick), new Object[] { "XXX", " S ", " S ", 'X', CombiningManager.getInstance().iroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(iroldaxe), new Object[] { "XX ", "XS ", " S ", 'X', CombiningManager.getInstance().iroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(iroldshovel), new Object[] { "X", "S", "S", 'X', CombiningManager.getInstance().iroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(iroldhoe), new Object[] { "XX ", " S ", " S ", 'X', CombiningManager.getInstance().iroldIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(irmendsword), new Object[] { "X", "X", "Z", 'X', CombiningManager.getInstance().irmendIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(irmendpick), new Object[] { "XXX", " S ", " S ", 'X', CombiningManager.getInstance().irmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(irmendaxe), new Object[] { "XX ", "XS ", " S ", 'X', CombiningManager.getInstance().irmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(irmendshovel), new Object[] { "X", "S", "S", 'X', CombiningManager.getInstance().irmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(irmendhoe), new Object[] { "XX ", " S ", " S ", 'X', CombiningManager.getInstance().irmendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(gomendsword), new Object[] { "X", "X", "Z", 'X', CombiningManager.getInstance().gomendIngot, 'Z', Item.stick });
		GameRegistry.addRecipe(new ItemStack(gomendpick), new Object[] { "XXX", " S ", " S ", 'X', CombiningManager.getInstance().gomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(gomendaxe), new Object[] { "XX ", "XS ", " S ", 'X', CombiningManager.getInstance().gomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(gomendshovel), new Object[] { "X", "S", "S", 'X', CombiningManager.getInstance().gomendIngot, 'S', Item.stick });
		GameRegistry.addRecipe(new ItemStack(gomendhoe), new Object[] { "XX ", " S ", " S ", 'X', CombiningManager.getInstance().gomendIngot, 'S', Item.stick });
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
		GameRegistry.addRecipe(new ItemStack(dirtHelmet), new Object[] { "XXX", "X X", "   ", 'X', dirtIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtHelmet), new Object[] { "   ", "XXX", "X X", 'X', dirtIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtPlate), new Object[] { "X X", "XXX", "XXX", 'X', dirtIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtLegs), new Object[] { "XXX", "X X", "X X", 'X', dirtIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtBoots), new Object[] { "X X", "X X", "   ", 'X', dirtIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtBoots), new Object[] { "   ", "X X", "X X", 'X', dirtIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtoneHelmet), new Object[] { "XXX", "X X", "   ", 'X', CombiningManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtoneHelmet), new Object[] { "   ", "XXX", "X X", 'X', CombiningManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtonePlate), new Object[] { "X X", "XXX", "XXX", 'X', CombiningManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtoneLegs), new Object[] { "XXX", "X X", "X X", 'X', CombiningManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtoneBoots), new Object[] { "X X", "X X", "   ", 'X', CombiningManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dirtoneBoots), new Object[] { "   ", "X X", "X X", 'X', CombiningManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dironHelmet), new Object[] { "XXX", "X X", "   ", 'X', CombiningManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(dironHelmet), new Object[] { "   ", "XXX", "X X", 'X', CombiningManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(dironPlate), new Object[] { "X X", "XXX", "XXX", 'X', CombiningManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(dironLegs), new Object[] { "XXX", "X X", "X X", 'X', CombiningManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(dironBoots), new Object[] { "X X", "X X", "   ", 'X', CombiningManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(dironBoots), new Object[] { "   ", "X X", "X X", 'X', CombiningManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldHelmet), new Object[] { "XXX", "X X", "   ", 'X', CombiningManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldHelmet), new Object[] { "   ", "XXX", "X X", 'X', CombiningManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldPlate), new Object[] { "X X", "XXX", "XXX", 'X', CombiningManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldLegs), new Object[] { "XXX", "X X", "X X", 'X', CombiningManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldBoots), new Object[] { "X X", "X X", "   ", 'X', CombiningManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldBoots), new Object[] { "   ", "X X", "X X", 'X', CombiningManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendHelmet), new Object[] { "XXX", "X X", "   ", 'X', CombiningManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendHelmet), new Object[] { "   ", "XXX", "X X", 'X', CombiningManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendPlate), new Object[] { "X X", "XXX", "XXX", 'X', CombiningManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendLegs), new Object[] { "XXX", "X X", "X X", 'X', CombiningManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendBoots), new Object[] { "X X", "X X", "   ", 'X', CombiningManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendBoots), new Object[] { "   ", "X X", "X X", 'X', CombiningManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(stornHelmet), new Object[] { "XXX", "X X", "   ", 'X', CombiningManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stornHelmet), new Object[] { "   ", "XXX", "X X", 'X', CombiningManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stornPlate), new Object[] { "X X", "XXX", "XXX", 'X', CombiningManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stornLegs), new Object[] { "XXX", "X X", "X X", 'X', CombiningManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stornBoots), new Object[] { "X X", "X X", "   ", 'X', CombiningManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stornBoots), new Object[] { "   ", "X X", "X X", 'X', CombiningManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldHelmet), new Object[] { "XXX", "X X", "   ", 'X', CombiningManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldHelmet), new Object[] { "   ", "XXX", "X X", 'X', CombiningManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldPlate), new Object[] { "X X", "XXX", "XXX", 'X', CombiningManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldLegs), new Object[] { "XXX", "X X", "X X", 'X', CombiningManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldBoots), new Object[] { "X X", "X X", "   ", 'X', CombiningManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldBoots), new Object[] { "   ", "X X", "X X", 'X', CombiningManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendHelmet), new Object[] { "XXX", "X X", "   ", 'X', CombiningManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendHelmet), new Object[] { "   ", "XXX", "X X", 'X', CombiningManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendPlate), new Object[] { "X X", "XXX", "XXX", 'X', CombiningManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendLegs), new Object[] { "XXX", "X X", "X X", 'X', CombiningManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendBoots), new Object[] { "X X", "X X", "   ", 'X', CombiningManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendBoots), new Object[] { "   ", "X X", "X X", 'X', CombiningManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldHelmet), new Object[] { "XXX", "X X", "   ", 'X', CombiningManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldHelmet), new Object[] { "   ", "XXX", "X X", 'X', CombiningManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldPlate), new Object[] { "X X", "XXX", "XXX", 'X', CombiningManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldLegs), new Object[] { "XXX", "X X", "X X", 'X', CombiningManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldBoots), new Object[] { "X X", "X X", "   ", 'X', CombiningManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldBoots), new Object[] { "   ", "X X", "X X", 'X', CombiningManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendHelmet), new Object[] { "XXX", "X X", "   ", 'X', CombiningManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendHelmet), new Object[] { "   ", "XXX", "X X", 'X', CombiningManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendPlate), new Object[] { "X X", "XXX", "XXX", 'X', CombiningManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendLegs), new Object[] { "XXX", "X X", "X X", 'X', CombiningManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendBoots), new Object[] { "X X", "X X", "   ", 'X', CombiningManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendBoots), new Object[] { "   ", "X X", "X X", 'X', CombiningManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendHelmet), new Object[] { "XXX", "X X", "   ", 'X', CombiningManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendHelmet), new Object[] { "   ", "XXX", "X X", 'X', CombiningManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendPlate), new Object[] { "X X", "XXX", "XXX", 'X', CombiningManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendLegs), new Object[] { "XXX", "X X", "X X", 'X', CombiningManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendBoots), new Object[] { "X X", "X X", "   ", 'X', CombiningManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendBoots), new Object[] { "   ", "X X", "X X", 'X', CombiningManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(obsidianHelmet), new Object[] { "XXX", "X X", "   ", 'X', obsidianIngot, });
		GameRegistry.addRecipe(new ItemStack(obsidianHelmet), new Object[] { "   ", "XXX", "X X", 'X', obsidianIngot, });
		GameRegistry.addRecipe(new ItemStack(obsidianPlate), new Object[] { "X X", "XXX", "XXX", 'X', obsidianIngot, });
		GameRegistry.addRecipe(new ItemStack(obsidianLegs), new Object[] { "XXX", "X X", "X X", 'X', obsidianIngot, });
		GameRegistry.addRecipe(new ItemStack(obsidianBoots), new Object[] { "X X", "X X", "   ", 'X', obsidianIngot, });
		GameRegistry.addRecipe(new ItemStack(obsidianBoots), new Object[] { "   ", "X X", "X X", 'X', obsidianIngot, });
		GameRegistry.addRecipe(new ItemStack(stoneHelmet), new Object[] { "XXX", "X X", "   ", 'X', CombiningManager.getInstance().stoneIngot, });
		GameRegistry.addRecipe(new ItemStack(stoneHelmet), new Object[] { "   ", "XXX", "X X", 'X', CombiningManager.getInstance().stoneIngot, });
		GameRegistry.addRecipe(new ItemStack(stonePlate), new Object[] { "X X", "XXX", "XXX", 'X', CombiningManager.getInstance().stoneIngot, });
		GameRegistry.addRecipe(new ItemStack(stoneLegs), new Object[] { "XXX", "X X", "X X", 'X', CombiningManager.getInstance().stoneIngot, });
		GameRegistry.addRecipe(new ItemStack(stoneBoots), new Object[] { "X X", "X X", "   ", 'X', CombiningManager.getInstance().stoneIngot, });
		GameRegistry.addRecipe(new ItemStack(stoneBoots), new Object[] { "   ", "X X", "X X", 'X', CombiningManager.getInstance().stoneIngot, });
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
		GameRegistry.addRecipe(new ItemStack(dirtoneBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', CombiningManager.getInstance().dirtoneIngot, });
		GameRegistry.addRecipe(new ItemStack(dironBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', CombiningManager.getInstance().dironIngot, });
		GameRegistry.addRecipe(new ItemStack(diroldBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', CombiningManager.getInstance().diroldIngot, });
		GameRegistry.addRecipe(new ItemStack(dirmendBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', CombiningManager.getInstance().dirmendIngot, });
		GameRegistry.addRecipe(new ItemStack(stoneBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', CombiningManager.getInstance().stoneIngot, });
		GameRegistry.addRecipe(new ItemStack(stornBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', CombiningManager.getInstance().stornIngot, });
		GameRegistry.addRecipe(new ItemStack(stoldBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', CombiningManager.getInstance().stoldIngot, });
		GameRegistry.addRecipe(new ItemStack(stomendBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', CombiningManager.getInstance().stomendIngot, });
		GameRegistry.addRecipe(new ItemStack(iroldBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', CombiningManager.getInstance().iroldIngot, });
		GameRegistry.addRecipe(new ItemStack(irmendBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', CombiningManager.getInstance().irmendIngot, });
		GameRegistry.addRecipe(new ItemStack(gomendBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', CombiningManager.getInstance().gomendIngot, });
		GameRegistry.addRecipe(new ItemStack(sandBlock, 1), new Object[] { "XXX", "XXX", "XXX", 'X', sandIngot, });

		// Block -> Ingot Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(CombiningManager.getInstance().dirtoneIngot, 9), new Object[] { new ItemStack(dirtoneBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(CombiningManager.getInstance().dironIngot, 9), new Object[] { new ItemStack(dironBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(CombiningManager.getInstance().diroldIngot, 9), new Object[] { new ItemStack(diroldBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(CombiningManager.getInstance().dirmendIngot, 9), new Object[] { new ItemStack(dirmendBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(CombiningManager.getInstance().stoneIngot, 9), new Object[] { new ItemStack(stoneBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(CombiningManager.getInstance().stornIngot, 9), new Object[] { new ItemStack(stornBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(CombiningManager.getInstance().stoldIngot, 9), new Object[] { new ItemStack(stoldBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(CombiningManager.getInstance().stomendIngot, 9), new Object[] { new ItemStack(stomendBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(CombiningManager.getInstance().iroldIngot, 9), new Object[] { new ItemStack(iroldBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(CombiningManager.getInstance().irmendIngot, 9), new Object[] { new ItemStack(irmendBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(CombiningManager.getInstance().gomendIngot, 9), new Object[] { new ItemStack(gomendBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(sandIngot, 9), new Object[] { new ItemStack(sandBlock) });
		GameRegistry.addShapelessRecipe(new ItemStack(dirtIngot, 9), new Object[] { new ItemStack(dirtBlock) });

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
		} else if (item.getItem() instanceof hybridcraft.IngotStuff.ItemHybridSpade) {
			item.addEnchantment(i[(int) (new Random().nextDouble()*2)], 1);
		} else if (item.getItem() instanceof hybridcraft.IngotStuff.ItemHybridSword) {
			item.addEnchantment(i[(int) (new Random().nextDouble()*2)], 1);
		} else if (item.getItem() instanceof hybridcraft.IngotStuff.ItemHybridHoe) {
			item.addEnchantment(i[(int) (new Random().nextDouble()*2)], 1);
		} else if (item.getItem() instanceof hybridcraft.IngotStuff.ItemHybridPickaxe) {
			item.addEnchantment(i[(int) (new Random().nextDouble()*2)], 1);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {

	}

}