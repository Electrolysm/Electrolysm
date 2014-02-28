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
                               'X', Item.book,
                               'Y', Item.ingotIron,
                               'Z', Block.enchantmentTable,
                               'B', Block.workbench,
                               'M', Item.diamond);
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
                               " XY", "XZX", "BX ",
                               'X', Item.ingotIron,
                               'Y', Item.diamond,
                               'Z', Block.blockDiamond,
                               'B', Block.tnt);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.fluidStorage, 4),
                               " X ", "Y Y", " Y ",
                               'X', electrolysmCore.blastGlass,
                               'Y', electrolysmCore.blastProof);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.injector),
                               "XMX", "BYN", "XMX",
                               'X', electrolysmCore.graphite,
                               'Y', electrolysmCore.blastProof,
                               'B', Item.bucketEmpty,
                               'N', electrolysmCore.injectionArm,
                               'M', Item.diamond);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.energiser),
                               "XDX", "IYB", "XDX",
                               'X', electrolysmCore.blastProof,
                               'Y', electrolysmCore.graphite,
                               'B', Item.bucketEmpty,
                               'I', electrolysmCore.energisingRod,
                               'D', Item.diamond);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.injectionArm),
                               "GBG", "CIC", " I ",
                               'G', Block.glowStone,
                               'B', Item.bucketEmpty,
                               'C', electrolysmCore.chunkGraphite,
                               'I', Item.ingotIron);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.energisingRod),
                               "ZXZ", " X ", " Y ",
                               'X', Item.ingotGold,
                               'Y', electrolysmCore.chunkGraphite,
                               'Z', electrolysmCore.graphite);
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.chunkGraphite, 9),
                                        new ItemStack(electrolysmCore.graphite));
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.graphite),
                               "XXX", "XXX", "XXX",
                               'X', electrolysmCore.chunkGraphite);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.blastProof, 2),
                               "XYX", "YZY", "XYX",
                               'X', Item.ingotIron,
                               'Y', electrolysmCore.stoneObsidian,
                               'Z', new ItemStack(electrolysmCore.researchPaper, 1, 0));
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
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.luminousRedstone, 2),
                                        new ItemStack(Item.redstone),
                                        new ItemStack(Item.redstone),
                                        new ItemStack(Item.glowstone),
                                        new ItemStack(electrolysmCore.sulphur));
        GameRegistry.addShapelessRecipe(new ItemStack(electrolysmCore.diamondShard, 4),
                                        new ItemStack(electrolysmCore.hammer),
                                        new ItemStack(electrolysmCore.fluidStorage, 1, 2),
                                        new ItemStack(Item.diamond));
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.hammer),
                               "XYX", " Z ", " Z ",
                               'X', Item.ingotIron,
                               'Y', Item.ingotGold,
                               'Z', Block.stone);
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
                               " C ", "LBL", "CRC",
                               'C', electrolysmCore.copperCoil,
                               'L', electrolysmCore.luminousRedstone,
                               'R', Item.redstone,
                               'B', Block.blockGold);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.copperCoil, 2),
                               "XXX", "XYX", "XXX",
                               'Y', Item.ingotIron,
                               'X', ingotCopper);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.energyMeter),
                               "C C", "IRI", "IGI",
                               'C', ingotCopper,
                               'I', Item.ingotIron,
                               'R', Item.redstone,
                               'G', Item.ingotGold);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.largeCopperCoil),
                               "XXX", "XYX", "XXX",
                               'X', electrolysmCore.copperCoil,
                               'Y', Item.ingotIron);
        GameRegistry.addRecipe(new ItemStack(electrolysmCore.generator),
                               "III", "IRI", "FFF",
                               'F', Block.furnaceIdle,
                               'R', Item.redstone,
                               'I', Item.ingotIron);
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
    }
    //		"Copper", "Tin", "Iron", "Gold", "Silver", "Lead"};
    //METAs		0		   1	  2		  3			4		5
	public static void addFurnaceRecipes() 
	{
		int impureID = electrolysmCore.impureDusts.itemID;
		ItemStack copperIngot = new ItemStack(electrolysmCore.copperIngot);
		ItemStack tinIngot = new ItemStack(electrolysmCore.ingots, 1, 0);
		ItemStack silverIngot = new ItemStack(electrolysmCore.ingots, 1, 1);
		ItemStack leadIngot = new ItemStack(electrolysmCore.ingots, 1, 2);

		ItemStack ironIngot = new ItemStack(Item.ingotIron);
        ItemStack goldIngot = new ItemStack(Item.ingotGold);
        float impureXP = 1.23456789F;
        
		FurnaceRecipes.smelting().addSmelting(impureID, 0, copperIngot, impureXP);
		FurnaceRecipes.smelting().addSmelting(impureID, 1, tinIngot, impureXP);
		FurnaceRecipes.smelting().addSmelting(impureID, 2, ironIngot, impureXP);
		FurnaceRecipes.smelting().addSmelting(impureID, 3, goldIngot, impureXP);
		FurnaceRecipes.smelting().addSmelting(impureID, 4, silverIngot, impureXP);
		FurnaceRecipes.smelting().addSmelting(impureID, 5, leadIngot, impureXP);

	}
}
