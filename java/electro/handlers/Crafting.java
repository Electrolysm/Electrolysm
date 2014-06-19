package electro.handlers;

import java.awt.List;
import java.util.ArrayList;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting
{

    public static void addCrafting()
    {
    	ItemStack ingotCopper = new ItemStack(electrolysmCore.copperIngot);
    	
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.researchDesk),
                               " X ", "YZY", "BMB",
                               'X', electrolysmCore.inkAndQuill,
                               'Y', Items.iron_ingot,
                               'Z', Items.paper,
                               'B', Blocks.bookshelf,
                               'M', Blocks.crafting_table);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.workBench),
                               "YXY", "Y Y", "Y Y",
                               'X', Blocks.crafting_table,
                               'Y', Items.iron_ingot);
        GameRegistry.addShapedRecipe(new ItemStack(electrolysmCore.card, 1, 1),
                                     "XYX",
                                     'Y', new ItemStack(Items.paper),
                                     'X', new ItemStack(Items.stick));

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
                               'Y', Blocks.glass);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.drillCasing),
                               " YY", "XZY", "XX ",
                               'X', Items.iron_ingot,
                               'Y', Items.diamond,
                               'Z', electrolysmCore.experimentalMicrochip);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.fluidStorage, 4),
                               " X ", "Y Y", " Y ",
                               'X', electrolysmCore.blastGlass,
                               'Y', electrolysmCore.blastProof);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.injector),
                               "XMX", "BYN", "XMX",
                               'X', electrolysmCore.blastProof,
                               'Y', electrolysmCore.advancedMicrochip,
                               'B', Items.diamond,
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
                               'I', Items.iron_ingot);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.energisingRod),
                               "XYX", " Z ", " Z ",
                               'X', Items.gold_ingot,
                               'Y', Items.redstone,
                               'Z', electrolysmCore.graphiteRod);
        
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.chunkGraphite, 9),
                                        new ItemStack(electrolysmCore.graphite, 1, 0));
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.graphite),
                               "XXX", "XXX", "XXX",
                               'X', electrolysmCore.chunkGraphite);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.blastProof, 2),
                               "XYX", "Y Y", "XYX",
                               'X', Items.iron_ingot,
                               'Y', electrolysmCore.stoneObsidian);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.stoneObsidian, 8),
                               "XXX", "XYX", "XXX",
                               'X', Blocks.stone,
                               'Y', Blocks.obsidian);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.glassModifire),
                               "XGX", " Y ", " Y ",
                               Character.valueOf('X'), Items.iron_ingot,
                               Character.valueOf('G'), Items.gold_ingot,
                               Character.valueOf('Y'), Items.stick);

        GameRegistry.addRecipe(new ItemStack(electrolysmCore.electrolChamber, 4),
                               "XYX", "YYY", "XYX",
                               'X', electrolysmCore.blastProof,
                               'Y', Items.iron_ingot);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.electrolisisCore),
                               "YIY", "RXR", "YIY",
                               'i', Items.iron_ingot,
                               'Y', electrolysmCore.electrolChamber,
                               'X', electrolysmCore.advancedMicrochip,
                               'R', Items.redstone);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.node),
                               " Y ", " Y ", "ICI",
                               'I', Items.iron_ingot,
                               'Y', electrolysmCore.graphiteRod,
                               'C', electrolysmCore.copperIngot);
        
        GameRegistry.addRecipe(new ItemStack(Blocks.tnt),
                               "XYX", "XXX", "XYX",
                               'X', electrolysmCore.sulphur,
                               'Y', Blocks.sand);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.luminousRedstone),
        		               " R ", "RGR", " R ",
        		               'R', Items.redstone,
        		               'G', Items.glowstone_dust);
        
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.diamondShard, 4),
        		//new ItemStack(electrolysmCore.hammer),
        		new ItemStack(Items.diamond));
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.hammer),
                               "XYX", " Z ", " Z ",
                               'X', Items.iron_ingot,
                               'Y', Blocks.cobblestone,
                               'Z', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.crystalBase),
                               "XYX", "YGY", "XYX",
                               'X', electrolysmCore.diamondShard,
                               Character.valueOf('Y'), new ItemStack(electrolysmCore.BlockLumRed, 1, 0),
                               'G', Items.diamond);

        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.BlockLumRed, 1, 0),
                                        new ItemStack(electrolysmCore.luminousRedstone),
                                        new ItemStack(electrolysmCore.luminousRedstone),
                                        new ItemStack(electrolysmCore.luminousRedstone),
                                        new ItemStack(electrolysmCore.luminousRedstone));

        GameRegistry.addRecipe(new ItemStack(electrolysmCore.generator, 1, 3),
        		"III", "RBR", "IFI",
        		'F', Blocks.furnace,
        		'R', Items.redstone,
        		'I', Items.iron_ingot,
        		'B', Items.water_bucket);

        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.luminousRedstone, 4),
        		new ItemStack(electrolysmCore.BlockLumRed));
        
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.BlockLumRed),
        		new ItemStack(Blocks.redstone_block),
        		new ItemStack(Blocks.glowstone),
        		new ItemStack(electrolysmCore.sulphur));

        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.endoInsulator, 6),
        		new ItemStack(electrolysmCore.ballOfPlastic),
        		new ItemStack(electrolysmCore.ballOfPlastic),
        		new ItemStack(Items.ender_pearl));
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.idifier),
        		"IGI", "RMR", "ICI",
        		'I', Items.iron_ingot,
        		'G', Blocks.glass,
        		'C', Blocks.chest,
        		'R', Items.redstone,
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
        		'I', Items.iron_ingot,
        		'R', Items.redstone,
        		'C', electrolysmCore.copperIngot);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.CPU),
        		"CTC", "TRT", "CTC",
        		'C', electrolysmCore.copperIngot,
        		'T', electrolysmCore.transistor,
        		'R', Items.redstone);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.BasicMicrochip),
        		"   ", "RTR", "CMC",
        		'T', electrolysmCore.transistor,
        		'R', Items.redstone,
        		'C', electrolysmCore.copperIngot,
        		'M', electrolysmCore.microchipBoard);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.advancedMicrochip, 1, 0),
        		"   ", "CPC", "BRB",
        		'C', electrolysmCore.copperIngot,
        		'P', electrolysmCore.CPU,
        		'B', electrolysmCore.BasicMicrochip,
        		'R', Items.redstone);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.grindStone, 1, 0),
        		"CCC", "CSC", "CCC",
        		Character.valueOf('C'), Blocks.cobblestone,
        		Character.valueOf('S'), Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.grindStone, 1, 1),
        		"III", "ISI", "III",
        		Character.valueOf('I'), Items.iron_ingot,
        		Character.valueOf('S'), new ItemStack(electrolysmCore.grindStone, 1, 0));
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.grindStone, 1, 2),
        		"III", "ISI", "III",
        		Character.valueOf('I'), Items.diamond,
        		Character.valueOf('S'), new ItemStack(electrolysmCore.grindStone, 1, 1));
        
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.inkAndQuill),
        		new ItemStack(Items.dye, 2, 0),
        		new ItemStack(Items.potionitem, 0),
        		new ItemStack(Items.feather));
        	
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.advancedCPU),
        		"RCR", "PDP", "RCR",
        		'R', Items.redstone,
        		'C', electrolysmCore.copperIngot,
        		'P', electrolysmCore.CPU,
        		'D', Items.diamond);
        	
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.experimentalMicrochip),
        		"   ", "ADA", "MCM",
        		'A', electrolysmCore.advancedCPU,
        		'D', Items.diamond,
        		'M', electrolysmCore.advancedMicrochip,
        		'C', electrolysmCore.copperIngot);
        
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.graphiteRod), 
        		 "X  ", "X  ", "   ",
        		 'X', electrolysmCore.chunkGraphite);
         	
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.charger),
        		 "CCC", "IRI", "IMI",
        		 'C', electrolysmCore.copperIngot,
        		 'I', Items.iron_ingot,
        		 'R', Items.redstone);
         
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.matterGen, 1),
        		 "AAA", "BEB", "BMB",
        		 'A', electrolysmCore.antiMatterCasing,
        		 'M', electrolysmCore.experimentalMicrochip,
        		 'B', electrolysmCore.blastProof,
        		 'E', electrolysmCore.electroMagnet);
         
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.ItemWire, 8),
        		 "III", "GGG", "III",
        		 Character.valueOf('I'), electrolysmCore.endoInsulator,
        		 Character.valueOf('G'), electrolysmCore.chunkGraphite);
         
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.electroMagnet),
        		 "C C", "DMD", "MDM",
        		 Character.valueOf('C'), electrolysmCore.advancedCPU,
        		 Character.valueOf('D'), Items.diamond,
        		 Character.valueOf('M'), electrolysmCore.magnet);
         
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.antiMatterCasing),
        		 "GBG", "BSB", "GBG",
        		 Character.valueOf('G'), Blocks.glass,
        		 Character.valueOf('B'), electrolysmCore.blastProof,
        		 Character.valueOf('S'), electrolysmCore.diamondShard);
         	
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.magnet),
        		 "III", "IBI", "III",
        		 Character.valueOf('I'), new ItemStack(electrolysmCore.Scandium, 1, 1),
        		 Character.valueOf('B'), electrolysmCore.Yttrium);
        		 
        		 
         GameRegistry.addRecipe(new ItemStack(electrolysmCore.crusher, 1, 3),
        		"IMI", "PGP", "ICI",
        		Character.valueOf('I'), Items.iron_ingot,
        		Character.valueOf('M'), electrolysmCore.BasicMicrochip,
        		Character.valueOf('P'), Blocks.cobblestone,
        		Character.valueOf('G'), electrolysmCore.grindStone,
        		Character.valueOf('C'), electrolysmCore.copperIngot);
        
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.liquidiser, 1, 3),
        		"ILI", "RLM", "IFI",
        		Character.valueOf('I'), Items.iron_ingot,
        		Character.valueOf('L'), electrolysmCore.fluidStorage,
        		Character.valueOf('R'), Items.redstone,
        		Character.valueOf('M'), electrolysmCore.advancedMicrochip,
        		Character.valueOf('F'), Blocks.furnace);

        GameRegistry.addRecipe(new ItemStack(electrolysmCore.smeltory, 1, 3),
        		"IRI", "IMI", "FFF",
        		Character.valueOf('I'), Items.iron_ingot,
        		Character.valueOf('R'), Items.redstone,
        		Character.valueOf('M'), electrolysmCore.advancedMicrochip,
        		Character.valueOf('F'), Blocks.furnace);
       
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.net),
        		"   S", " WS", "W  ",
        		'S', Items.string,
        		'W', Items.stick);
        
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.ballOfPlastic, 8),
        		new ItemStack(Blocks.sand),
        		new ItemStack(Items.slime_ball),
        		new ItemStack(electrolysmCore.sulphur),
        		new ItemStack(Items.water_bucket));
        
    }	

    public static void addFurnaceRecipes() 
	{
		Item impureID = electrolysmCore.impureDusts;
		Item pureID = electrolysmCore.dusts;
		ItemStack copperIngot = new ItemStack(electrolysmCore.copperIngot, 1);
		ItemStack tinIngot = new ItemStack(electrolysmCore.ingots, 1, 0);
		ItemStack silverIngot = new ItemStack(electrolysmCore.ingots, 1, 1);
		ItemStack leadIngot = new ItemStack(electrolysmCore.ingots, 1, 2);

		ItemStack ironIngot = new ItemStack(Items.iron_ingot, 1, 0);
        ItemStack goldIngot = new ItemStack(Items.gold_ingot, 1, 0);
        float impureXP = 1.23456789F;
        float pureXP = 5.789F;
        
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(impureID, 1, 0), copperIngot, impureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(impureID, 1, 1), tinIngot, impureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(impureID, 1, 2), ironIngot, impureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(impureID, 1, 3), goldIngot, impureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(impureID, 1, 4), silverIngot, impureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(impureID, 1, 5), leadIngot, impureXP);
		
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(pureID, 1, 0), copperIngot, pureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(pureID, 1, 0), tinIngot, pureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(pureID, 1, 0), ironIngot, pureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(pureID, 1, 0), goldIngot, pureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(pureID, 1, 0), silverIngot, pureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(pureID, 1, 0), leadIngot, pureXP);
	    
		GameRegistry.addSmelting(electrolysmCore.copperOre, new ItemStack(electrolysmCore.copperIngot, 1), 2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(electrolysmCore.Scandium),
                new ItemStack(electrolysmCore.Scandium, 1, 1), pureXP);
		
		//GameRegistry.addSmelting(pureID, goldIngot, pureXP);

	}
}
