package assets.electrolysm.electro.handlers;

import java.awt.List;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting
{

    public static void addCrafting()
    {
    	ItemStack ingotCopper = new ItemStack(electrolysmCore.copperIngot);
    	
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.researchDesk),
                               " X ", "YZY", "BMB",
                               'X', electrolysmCore.inkAndQuill,
                               'Y', Item.ingotIron,
                               'Z', Item.paper,
                               'B', Block.bookShelf,
                               'M', Block.workbench);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.workBench),
                               "YXY", "Y Y", "Y Y",
                               'X', Block.workbench,
                               'Y', Item.ingotIron);
        GameRegistry.addShapedRecipe(new ItemStack(electrolysmCore.card, 1, 1),
                                     "XYX",
                                     'Y', new ItemStack(Item.paper),
                                     'X', new ItemStack(Item.stick));

        for (int i = 1; i <= 9; i++)
        {
            ItemStack cardLevels = new ItemStack(electrolysmCore.card, 1, i);
            GameRegistry.addRecipe(new ItemStack(electrolysmCore.card, 1, i + 1),
                                   "XXX", "XZX", "XXX",
                                   'X', electrolysmCore.knowledge,
                                   'Z', cardLevels);
        }

        GameRegistry.addRecipe(new ItemStack(electrolysmCore.blastDoor),
                               "XX", "XX", "XX",
                               'X', electrolysmCore.blastProof);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.blastGlass, 4),
                               "XYX", "Y Y", "XYX",
                               'X', electrolysmCore.blastProof,
                               'Y', Block.glass);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.drillCasing),
                               " YY", "XZY", "XX ",
                               'X', Item.ingotIron,
                               'Y', Item.diamond,
                               'Z', electrolysmCore.experimentalMicrochip);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.fluidStorage, 4),
                               " X ", "Y Y", " Y ",
                               'X', electrolysmCore.blastGlass,
                               'Y', electrolysmCore.blastProof);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.injector),
                               "XMX", "BYN", "XMX",
                               'X', electrolysmCore.blastProof,
                               'Y', electrolysmCore.advancedMicrochip,
                               'B', Item.diamond,
                               'N', electrolysmCore.injectionArm,
                               'M', electrolysmCore.fluidStorage);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.energiser),
                               "XFX", "YIY", "XDX",
                               'X', electrolysmCore.blastProof,
                               'Y', electrolysmCore.graphiteRod,
                               'F', electrolysmCore.fluidStorage,
                               'I', electrolysmCore.energisingRod,
                               'D', electrolysmCore.advancedMicrochip);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.injectionArm),
                               " IB", "II", "CI ",
                               'B', electrolysmCore.fluidStorage,
                               'C', electrolysmCore.BasicMicrochip,
                               'I', Item.ingotIron);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.energisingRod),
                               "XYX", " Z ", " Z ",
                               'X', Item.ingotGold,
                               'Y', Item.redstone,
                               'Z', electrolysmCore.graphiteRod);
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.chunkGraphite, 9),
                                        new ItemStack(electrolysmCore.graphite));
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.graphite),
                               "XXX", "XXX", "XXX",
                               'X', electrolysmCore.chunkGraphite);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.blastProof, 2),
                               "XYX", "YYY", "XYX",
                               'X', Item.ingotIron,
                               'Y', electrolysmCore.stoneObsidian);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.stoneObsidian, 8),
                               "XXX", "XYX", "XXX",
                               'X', Block.stone,
                               'Y', Block.obsidian);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.glassModifire),
                               "XGX", " Y ", "Y",
                               'X', Item.ingotIron,
                               'G', Item.ingotGold,
                               'Y', Item.stick);
        /*
        		GameRegistry.addRecipe(new ItemStack(electrolysmCore.copperwire) ,
        				"WWW" , "CCC" , "WWW",
        				'W', Block.cloth,
        				'C', ingotCopper) ;

        		*/
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.electrolChamber, 4),
                               "XYX", "YDY", "XYX",
                               'X', Item.ingotIron,
                               'Y', Item.ingotGold,
                               'D', Item.diamond);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.electrolisisCore),
                               "G G", "YXY", "RYR",
                               'G', Item.ingotGold,
                               'Y', electrolysmCore.electrolChamber,
                               'X', Item.cauldron,
                               'R', Item.redstone);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.node),
                               "XYX", "XYX", " Z ",
                               'X', Item.ingotIron,
                               'Y', electrolysmCore.graphite,
                               'Z', electrolysmCore.chunkGraphite);
        GameRegistry.addRecipe(new ItemStack(Block.tnt),
                               "XYX", "XXX", "XYX",
                               'X', electrolysmCore.sulphur,
                               'Y', Block.sand);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.luminousRedstone),
        		               " R ", "RGR", " R ",
        		               'R', Item.redstone,
        		               'G', Item.glowstone);
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.diamondShard, 4),
                                        new ItemStack(electrolysmCore.hammer),
                                        new ItemStack(electrolysmCore.fluidStorage, 1, 2),
                                        new ItemStack(Item.diamond));
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.hammer),
                               "XYX", " Z ", " Z ",
                               'X', Item.ingotIron,
                               'Y', Block.cobblestone,
                               'Z', Item.stick);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.crystalBase),
                               "XYX", "YGY", "XYX",
                               'X', electrolysmCore.diamondShard,
                               'Y', electrolysmCore.BlockLumRed,
                               'G', Item.diamond);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.crystal1),
                               " X ", "SYS", "QRQ",
                               'X', Block.glowStone,
                               'S', electrolysmCore.diamondShard,
                               'Y', electrolysmCore.crystalBase,
                               'Q', Block.blockNetherQuartz,
                               'R', Item.redstone);
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.BlockLumRed),
                                        new ItemStack(electrolysmCore.luminousRedstone),
                                        new ItemStack(electrolysmCore.luminousRedstone),
                                        new ItemStack(electrolysmCore.luminousRedstone),
                                        new ItemStack(electrolysmCore.luminousRedstone));
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.ironFrames, 2),
                               "X X", " Y ", "X X",
                               'X', Item.ingotIron,
                               'Y', electrolysmCore.copperCoil);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.plug),
                               "ICI", "CBC", "ICI",
                               'I', Item.ingotIron,
                               'C', electrolysmCore.copperIngot,
                               'B', electrolysmCore.copperCoil);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.copperCoil, 2),
                               "XXX", "XYX", "XXX",
                               'Y', Item.ingotIron,
                               'X', ingotCopper);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.energyMeter),
                               "C C", "IMI", "IRI",
                               'C', ingotCopper,
                               'I', Item.ingotIron,
                               'R', Item.redstone,
                               'M', electrolysmCore.BasicMicrochip);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.largeCopperCoil),
                               "XXX", "XYX", "XXX",
                               'X', electrolysmCore.copperCoil,
                               'Y', Item.ingotIron);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.generator),
                               "III", "RBR", "IFI",
                               'F', Block.furnaceIdle,
                               'R', Item.redstone,
                               'I', Item.ingotIron,
                               'B', Item.bucketEmpty);
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.luminousRedstone, 4),
                                        new ItemStack(electrolysmCore.BlockLumRed));
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.BlockLumRed),
                                        new ItemStack(Block.blockRedstone),
                                        new ItemStack(Block.glowStone),
                                        new ItemStack(electrolysmCore.sulphur));
        GameRegistry.addShapedRecipe(new ItemStack(electrolysmCore.wire, 28),
                                     "WWW", "GGG", "WWW",
                                     'W', electrolysmCore.endoInsulator,
                                     'G', electrolysmCore.graphite);
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.endoInsulator, 6),
                                        new ItemStack(electrolysmCore.ballOfPlastic),
                                        new ItemStack(electrolysmCore.ballOfPlastic),
                                        new ItemStack(Item.enderPearl));
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.idifier),
                               "IGI", "CGC", "IGI",
                               'I', Item.ingotIron,
                               'G', Material.glass,
                               'C', Block.chest,
                               'G', Item.ingotGold);
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.blastBrick),
                                        new ItemStack(electrolysmCore.blastProof),
                                        new ItemStack(electrolysmCore.blastProof),
                                        new ItemStack(electrolysmCore.blastProof),
                                        new ItemStack(electrolysmCore.blastProof));
        
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.blastProof, 4),
                                        new ItemStack(electrolysmCore.blastBrick));
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.microchipBoard),
        		                        new ItemStack(electrolysmCore.ballOfPlastic),
        		                        new ItemStack(electrolysmCore.ballOfPlastic),
        		                        new ItemStack(electrolysmCore.ballOfPlastic));
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.transistor),
        		               " I ", " R ", "C C",
        		               'I', Item.ingotIron,
        		               'R', Item.redstone,
        		               'C', electrolysmCore.copperIngot);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.CPU),
        		              "CTC", "TRT", "CTC",
        		              'C', electrolysmCore.copperIngot,
        		              'T', electrolysmCore.transistor,
        		              'R', Item.redstone);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.BasicMicrochip),
        		              "   ", "RTR", "CMC",
        		              'T', electrolysmCore.transistor,
        		              'R', Item.redstone,
        		              'C', electrolysmCore.copperIngot,
        		              'M', electrolysmCore.microchipBoard);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.advancedMicrochip),
        		              "   ", "CPC", "BRB",
        		              'C', electrolysmCore.copperIngot,
        		              'P', electrolysmCore.CPU,
        		              'B', electrolysmCore.BasicMicrochip,
        		              'R', Item.redstone);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.grindStone, 1, 0),
        		"CCC", "CSC", "CCC",
        		Character.valueOf('C'), Block.cobblestone,
        		Character.valueOf('S'), Item.stick);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.grindStone, 1, 1),
        		"III", "ISI", "III",
        		Character.valueOf('I'), Item.ingotIron,
        		Character.valueOf('S'), new ItemStack(electrolysmCore.grindStone, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.inkAndQuill),
        		                        new ItemStack(Item.dyePowder, 2, 0),
        		                        new ItemStack(Item.potion, 0),
        		                        new ItemStack(Item.feather));
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.advancedCPU),
        		              "RCR", "PDP", "RCR",
        		              'R', Item.redstone,
        		              'C', electrolysmCore.copperIngot,
        		              'P', electrolysmCore.CPU,
        		              'D', Item.diamond);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.experimentalMicrochip),
        		              "   ", "ADA", "MCM",
        		              'A', electrolysmCore.advancedCPU,
        		              'D', Item.diamond,
        		              'M', electrolysmCore.advancedMicrochip,
        		              'C', electrolysmCore.copperIngot);
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.graphiteRod),
        		                        new ItemStack(electrolysmCore.graphite),
        		                        new ItemStack(electrolysmCore.graphite));
        		                        
        		              
        		              
    }
    //		"Copper", "Tin", "Iron", "Gold", "Silver", "Lead"};
    //METAs		0		   1	  2		  3			4		5
	public static void addFurnaceRecipes() 
	{
		int impureID = electrolysmCore.impureDusts.itemID;
		int pureID = electrolysmCore.dusts.itemID;
		ItemStack copperIngot = new ItemStack(electrolysmCore.copperIngot);
		ItemStack tinIngot = new ItemStack(electrolysmCore.ingots, 1, 0);
		ItemStack silverIngot = new ItemStack(electrolysmCore.ingots, 1, 1);
		ItemStack leadIngot = new ItemStack(electrolysmCore.ingots, 1, 2);

		ItemStack ironIngot = new ItemStack(Item.ingotIron);
        ItemStack goldIngot = new ItemStack(Item.ingotGold);
        float impureXP = 1.23456789F;
        float pureXP = 5.789F;
        
		FurnaceRecipes.smelting().addSmelting(impureID, 0, copperIngot, impureXP);
		FurnaceRecipes.smelting().addSmelting(impureID, 1, tinIngot, impureXP);
		FurnaceRecipes.smelting().addSmelting(impureID, 2, ironIngot, impureXP);
		FurnaceRecipes.smelting().addSmelting(impureID, 3, goldIngot, impureXP);
		FurnaceRecipes.smelting().addSmelting(impureID, 4, silverIngot, impureXP);
		FurnaceRecipes.smelting().addSmelting(impureID, 5, leadIngot, impureXP);
		
		FurnaceRecipes.smelting().addSmelting(pureID, 0, copperIngot, pureXP);
		FurnaceRecipes.smelting().addSmelting(pureID, 1, tinIngot, pureXP);
		FurnaceRecipes.smelting().addSmelting(pureID, 2, ironIngot, pureXP);
		FurnaceRecipes.smelting().addSmelting(pureID, 3, goldIngot, pureXP);
		FurnaceRecipes.smelting().addSmelting(pureID, 4, silverIngot, pureXP);
		FurnaceRecipes.smelting().addSmelting(pureID, 5, leadIngot, pureXP);

	}
}
