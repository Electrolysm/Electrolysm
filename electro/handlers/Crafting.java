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
                               " IB", "III", "CI ",
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
                               "XYX", "Y Y", "XYX",
                               'X', Item.ingotIron,
                               'Y', electrolysmCore.stoneObsidian);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.stoneObsidian, 8),
                               "XXX", "XYX", "XXX",
                               'X', Block.stone,
                               'Y', Block.obsidian);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.glassModifire),
                               "XGX", " Y ", "Y",
                               Character.valueOf('X'), Item.ingotIron,
                               Character.valueOf('G'), Item.ingotGold,
                               Character.valueOf('Y'), Item.stick);

        GameRegistry.addRecipe(new ItemStack(electrolysmCore.electrolChamber, 4),
                               "XYX", "YYY", "XYX",
                               'X', electrolysmCore.blastProof,
                               'Y', Item.ingotIron);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.electrolisisCore),
                               "YIY", "RXR", "YIY",
                               'i', Item.ingotIron,
                               'Y', electrolysmCore.electrolChamber,
                               'X', electrolysmCore.advancedMicrochip,
                               'R', Item.redstone);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.node),
                               " Y ", " Y ", "ICI",
                               'I', Item.ingotIron,
                               'Y', electrolysmCore.graphiteRod,
                               'C', electrolysmCore.copperIngot);
        
        GameRegistry.addRecipe(new ItemStack(Block.tnt),
                               "XYX", "XXX", "XYX",
                               'X', electrolysmCore.sulphur,
                               'Y', Block.sand);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.luminousRedstone),
        		               " R ", "RGR", " R ",
        		               'R', Item.redstone,
        		               'G', Item.glowstone);
        
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.diamondShard, 4),
        		//new ItemStack(electrolysmCore.hammer),
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

        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.BlockLumRed),
                                        new ItemStack(electrolysmCore.luminousRedstone),
                                        new ItemStack(electrolysmCore.luminousRedstone),
                                        new ItemStack(electrolysmCore.luminousRedstone),
                                        new ItemStack(electrolysmCore.luminousRedstone));

        GameRegistry.addRecipe(new ItemStack(electrolysmCore.generator, 1, 3),
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

        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.endoInsulator, 6),
        		new ItemStack(electrolysmCore.ballOfPlastic),
        		new ItemStack(electrolysmCore.ballOfPlastic),
        		new ItemStack(Item.enderPearl));
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.idifier),
        		"IGI", "RMR", "ICI",
        		'I', Item.ingotIron,
        		'G', Block.glass,
        		'C', Block.chest,
        		'R', Item.redstone,
        		'M', electrolysmCore.advancedMicrochip);
        
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
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.advancedMicrochip, 1, 0),
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
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.grindStone, 1, 2),
        		"III", "ISI", "III",
        		Character.valueOf('I'), Item.diamond,
        		Character.valueOf('S'), new ItemStack(electrolysmCore.grindStone, 1, 1));
        
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
        
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.graphiteRod), 
        		 "X  ", "X  ", "   ",
        		 'X', electrolysmCore.chunkGraphite);
         	
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.charger),
        		 "CCC", "IRI", "IMI",
        		 'C', electrolysmCore.copperIngot,
        		 'I', Item.ingotIron,
        		 'R', Item.redstone);
         
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.matterGen, 1, 3),
        		 "AAA", "BEB", "BMB",
        		 'A', electrolysmCore.antiMatterCasing,
        		 'M', electrolysmCore.experimentalMicrochip,
        		 'B', electrolysmCore.blastProof,
        		 'E', electrolysmCore.electroMagnet);
         
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.electroMagnet),
        		 "C C", "DMD", "MDM",
        		 Character.valueOf('C'), electrolysmCore.advancedCPU,
        		 Character.valueOf('D'), Item.diamond,
        		 Character.valueOf('M'), electrolysmCore.magnet);
         
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.antiMatterCasing),
        		 "GBG", "BSB", "GBG",
        		 Character.valueOf('G'), Block.glass,
        		 Character.valueOf('B'), electrolysmCore.blastProof,
        		 Character.valueOf('S'), electrolysmCore.diamondShard);
         	
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.magnet),
        		 "III", "IBI", "III",
        		 Character.valueOf('I'), new ItemStack(electrolysmCore.Scandium, 1, 1),
        		 Character.valueOf('B'), electrolysmCore.Yttrium);
        		 
        		 
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.crusher, 1, 3),
        		"IMI", "PGP", "ICI",
        		Character.valueOf('I'), Item.ingotIron,
        		Character.valueOf('M'), electrolysmCore.BasicMicrochip,
        		Character.valueOf('P'), Block.cobblestone,
        		Character.valueOf('G'), electrolysmCore.grindStone,
        		Character.valueOf('C'), electrolysmCore.copperIngot);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.liquidiser, 1, 3),
        		"ILI", "RLM", "IFI",
        		Character.valueOf('I'), Item.ingotIron,
        		Character.valueOf('L'), electrolysmCore.fluidStorage,
        		Character.valueOf('R'), Item.redstone,
        		Character.valueOf('M'), electrolysmCore.advancedMicrochip,
        		Character.valueOf('F'), Block.furnaceIdle);

        GameRegistry.addRecipe(new ItemStack(electrolysmCore.smeltery, 1, 3),
        		"IRI", "IMI", "FFF",
        		Character.valueOf('I'), Item.ingotIron,
        		Character.valueOf('R'), Item.redstone,
        		Character.valueOf('M'), electrolysmCore.advancedMicrochip,
        		Character.valueOf('F'), Block.furnaceIdle);
       
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.net),
        		"   S", " WS", "W  ",
        		'S', Item.silk,
        		'W', Item.stick);
        
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.ballOfPlastic, 8),
        		new ItemStack(Block.sand),
        		new ItemStack(Item.slimeBall),
        		new ItemStack(electrolysmCore.sulphur),
        		new ItemStack(Item.bucketWater));
        
    }	

    public static void addFurnaceRecipes() 
	{
		int impureID = electrolysmCore.impureDusts.itemID;
		int pureID = electrolysmCore.dusts.itemID;
		ItemStack copperIngot = new ItemStack(electrolysmCore.copperIngot, 1);
		ItemStack tinIngot = new ItemStack(electrolysmCore.ingots, 1, 0);
		ItemStack silverIngot = new ItemStack(electrolysmCore.ingots, 1, 1);
		ItemStack leadIngot = new ItemStack(electrolysmCore.ingots, 1, 2);

		ItemStack ironIngot = new ItemStack(Item.ingotIron, 1, 0);
        ItemStack goldIngot = new ItemStack(Item.ingotGold, 1, 0);
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
	    
		GameRegistry.addSmelting(electrolysmCore.copperOre.blockID, new ItemStack(electrolysmCore.copperIngot, 1), 2F);
		FurnaceRecipes.smelting().addSmelting(electrolysmCore.Scandium.itemID, 0, 
				new ItemStack(electrolysmCore.Scandium, 1, 1), pureXP);
		
		//GameRegistry.addSmelting(pureID, goldIngot, pureXP);

	}
}
