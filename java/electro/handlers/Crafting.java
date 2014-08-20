package electro.handlers;

import electro.Electrolysm;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Crafting
{

    public static void addCrafting()
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(Electrolysm.steelBlock, true, new Object[] {
                "XXX", "XXX", "XXX",
                Character.valueOf('X'), "ingotSteel"
        }));

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Electrolysm.steel, 9), new Object[] {
                "blockSteel"
        }));
/*
        GameRegistry.addRecipe(new ItemStack(Electrolysm.nitrocelluloseBlock),
                "XXX", "XXX", "XXX",
                Character.valueOf('X'), Electrolysm.nitrocellulose);

        GameRegistry.addRecipe(new ItemStack(Electrolysm.film),
                "CNC", "BCB",
                Character.valueOf('C'), Electrolysm.camphor,
                Character.valueOf('N'), Electrolysm.nitrocellulose,
                Character.valueOf('B'), Electrolysm.nitrocelluloseBlock);

        GameRegistry.addRecipe(new ItemStack(Electrolysm.reel, 1, 0),
                "IPI", "PGP", "IPI",
                Character.valueOf('I'), Items.iron_ingot,
                Character.valueOf('G'), Items.gold_ingot,
                Character.valueOf('P'), Items.paper);

        GameRegistry.addRecipe(new ItemStack(Electrolysm.reel, 1, 2),
                "IPI", "PGP", "IPI",
                Character.valueOf('I'), new ItemStack(Electrolysm.reel, 1, 0),
                Character.valueOf('G'), Items.gold_ingot,
                Character.valueOf('P'), Items.paper);

        GameRegistry.addRecipe(new ItemStack(Electrolysm.reel, 2, 2),
                "IPI", "PGP", "IPI",
                Character.valueOf('I'), new ItemStack(Electrolysm.reel, 1, 1),
                Character.valueOf('G'), Items.nether_star,
                Character.valueOf('P'), Electrolysm.film);
*/
        GameRegistry.addRecipe(new ItemStack(Electrolysm.blastDoor),
                               "XX", "XX", "XX",
                               'X', Electrolysm.blastProof);

        GameRegistry.addRecipe(new ItemStack(Electrolysm.blastGlass, 4),
                               "XYX", "Y Y", "XYX",
                               'X', Electrolysm.blastProof,
                               'Y', Blocks.glass);
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.drillCasing),
                               " YY", "XZY", "XX ",
                               'X', Items.iron_ingot,
                               'Y', Items.diamond,
                               'Z', Electrolysm.experimentalMicrochip);
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.fluidStorage, 4),
                               " I ", "G G", " G ",
                               'G', Blocks.glass,
                               'I', Items.iron_ingot );
        
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.energiser),
                               "XFX", "YIY", "XDX",
                               'X', Electrolysm.blastProof,
                               'Y', Electrolysm.graphiteRod,
                               'F', Electrolysm.fluidStorage,
                               'I', Electrolysm.energisingRod,
                               'D', Electrolysm.advancedMicrochip);
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.injectionArm),
                               " IB", "III", "CI ",
                               'B', Electrolysm.fluidStorage,
                               'C', Electrolysm.BasicMicrochip,
                               'I', Items.iron_ingot);
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.energisingRod),
                               "XYX", " Z ", " Z ",
                               'X', Items.gold_ingot,
                               'Y', Items.redstone,
                               'Z', Electrolysm.graphiteRod);
        
        GameRegistry.addShapelessRecipe(new ItemStack(Electrolysm.chunkGraphite, 9),
                                        new ItemStack(Electrolysm.graphite, 1, 0));
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.graphite),
                               "XXX", "XXX", "XXX",
                               'X', Electrolysm.chunkGraphite);
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.blastProof, 2),
                               "XYX", "Y Y", "XYX",
                               'X', Items.iron_ingot,
                               'Y', Electrolysm.stoneObsidian);
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.stoneObsidian, 8),
                               "XXX", "XYX", "XXX",
                               'X', Blocks.stone,
                               'Y', Blocks.obsidian);
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.glassModifire),
                               "XGX", " Y ", " Y ",
                               Character.valueOf('X'), Items.iron_ingot,
                               Character.valueOf('G'), Items.gold_ingot,
                               Character.valueOf('Y'), Items.stick);

        GameRegistry.addRecipe(new ItemStack(Electrolysm.electrolChamber, 4),
                               "XYX", "YYY", "XYX",
                               'X', Electrolysm.blastProof,
                               'Y', Items.iron_ingot);
        
        GameRegistry.addRecipe(new ShapedOreRecipe(Electrolysm.node, true, new Object[]{
                               " Y ", " Y ", "ICI",
                               'I', Items.iron_ingot,
                               'Y', Electrolysm.graphiteRod,
                               'C', "ingotCopper"}));
        
        GameRegistry.addRecipe(new ItemStack(Blocks.tnt),
                               "XYX", "XXX", "XYX",
                               'X', Electrolysm.sulphur,
                               'Y', Blocks.sand);
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.luminousRedstone),
        		               " R ", "RGR", " R ",
        		               'R', Items.redstone,
        		               'G', Items.glowstone_dust);
        
        GameRegistry.addShapelessRecipe(new ItemStack(Electrolysm.diamondShard, 4),
        		//new ItemStack(electrolysmCore.hammer),
        		new ItemStack(Items.diamond));
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.hammer),
                               "XYX", " Z ", " Z ",
                               'X', Items.iron_ingot,
                               'Y', Blocks.cobblestone,
                               'Z', Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.crystalBase),
                               "XYX", "YGY", "XYX",
                               'X', Electrolysm.diamondShard,
                               Character.valueOf('Y'), new ItemStack(Electrolysm.BlockLumRed, 1, 0),
                               'G', Items.diamond);

        GameRegistry.addShapelessRecipe(new ItemStack(Electrolysm.BlockLumRed, 1, 0),
                                        new ItemStack(Electrolysm.luminousRedstone),
                                        new ItemStack(Electrolysm.luminousRedstone),
                                        new ItemStack(Electrolysm.luminousRedstone),
                                        new ItemStack(Electrolysm.luminousRedstone));


        GameRegistry.addShapelessRecipe(new ItemStack(Electrolysm.luminousRedstone, 4),
        		new ItemStack(Electrolysm.BlockLumRed));
        
        GameRegistry.addShapelessRecipe(new ItemStack(Electrolysm.BlockLumRed),
        		new ItemStack(Blocks.redstone_block),
        		new ItemStack(Blocks.glowstone),
        		new ItemStack(Electrolysm.sulphur));

        GameRegistry.addShapelessRecipe(new ItemStack(Electrolysm.endoInsulator, 6),
        		new ItemStack(Electrolysm.ballOfPlastic),
        		new ItemStack(Electrolysm.ballOfPlastic),
        		new ItemStack(Items.ender_pearl));
        
        GameRegistry.addShapelessRecipe(new ItemStack(Electrolysm.blastBrick),
                new ItemStack(Electrolysm.blastProof),
                new ItemStack(Electrolysm.blastProof),
                new ItemStack(Electrolysm.blastProof),
                new ItemStack(Electrolysm.blastProof));
        
        GameRegistry.addShapelessRecipe(new ItemStack(Electrolysm.blastProof, 4),
        		new ItemStack(Electrolysm.blastBrick));

        GameRegistry.addRecipe(new ShapedOreRecipe(Electrolysm.transistor, true, new Object[]{
                " I ", " R ", "C C",
                'I', Items.iron_ingot,
                'R', Items.redstone,
                'C', Electrolysm.copperIngot}));

        GameRegistry.addRecipe(new ShapedOreRecipe(Electrolysm.BasicMicrochip, true, new Object[] {
        		"   ", "RTR", "CMC",
        		'T', Electrolysm.transistor,
        		'R', Items.redstone,
        		'C', "ingotCopper",
        		'M', Electrolysm.microchipBoard}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Electrolysm.advancedMicrochip, 1, 0), true, new Object[]{
        		"   ", "CPC", "BRB",
        		'C', "ingotCopper",
        		'P', Electrolysm.CPU,
        		'B', Electrolysm.BasicMicrochip,
        		'R', Items.redstone}));
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Electrolysm.experimentalMicrochip, 1, 0), true, new Object[]{
        	"   ", "CAC", "MRM",
        	'C', "ingotCopper",
        	'A', Electrolysm.advancedCPU,
        	'M', Electrolysm.advancedMicrochip,
        	'R', Items.redstone}));

    GameRegistry.addRecipe(new ItemStack(Electrolysm.grindStone, 1, 0),
        		"CCC", "CSC", "CCC",
        		Character.valueOf('C'), Blocks.cobblestone,
        		Character.valueOf('S'), Items.stick);
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.grindStone, 1, 1),
        		"III", "ISI", "III",
        		Character.valueOf('I'), Items.iron_ingot,
        		Character.valueOf('S'), new ItemStack(Electrolysm.grindStone, 1, 0));
        
        GameRegistry.addRecipe(new ItemStack(Electrolysm.grindStone, 1, 2),
        		"III", "ISI", "III",
        		Character.valueOf('I'), Items.diamond,
        		Character.valueOf('S'), new ItemStack(Electrolysm.grindStone, 1, 1));
        
        GameRegistry.addShapelessRecipe(new ItemStack(Electrolysm.inkAndQuill),
        		new ItemStack(Items.dye, 2, 0),
        		new ItemStack(Items.potionitem, 0),
        		new ItemStack(Items.feather));
        	

        
         GameRegistry.addRecipe(new ItemStack(Electrolysm.graphiteRod),
        		 "X  ", "X  ", "   ",
        		 'X', Electrolysm.chunkGraphite);
         	
         GameRegistry.addRecipe(new ShapedOreRecipe(Electrolysm.charger, true, new Object[]{
        		 "CCC", "IRI", "IMI",
        		 'C', "ingotCopper",
        		 'I', Items.iron_ingot,
        		 'R', Items.redstone}));
         
         GameRegistry.addRecipe(new ItemStack(Electrolysm.matterGen, 1),
        		 "AAA", "BEB", "BMB",
        		 'A', Electrolysm.antiMatterCasing,
        		 'M', Electrolysm.experimentalMicrochip,
        		 'B', Electrolysm.blastProof,
        		 'E', Electrolysm.electroMagnet);
         
         GameRegistry.addRecipe(new ItemStack(Electrolysm.electroMagnet),
        		 "C C", "DMD", "MDM",
        		 Character.valueOf('C'), Electrolysm.advancedCPU,
        		 Character.valueOf('D'), Items.diamond,
        		 Character.valueOf('M'), Electrolysm.magnet);
         
         GameRegistry.addRecipe(new ItemStack(Electrolysm.antiMatterCasing),
        		 "GBG", "BSB", "GBG",
        		 Character.valueOf('G'), Blocks.glass,
        		 Character.valueOf('B'), Electrolysm.blastProof,
        		 Character.valueOf('S'), Electrolysm.diamondShard);
         	
         GameRegistry.addRecipe(new ItemStack(Electrolysm.magnet),
        		 "III", "IBI", "III",
        		 Character.valueOf('I'), new ItemStack(Electrolysm.Scandium, 1, 1),
        		 Character.valueOf('B'), Electrolysm.Yttrium);

        GameRegistry.addRecipe(new ItemStack(Electrolysm.net),
        		"   S", " WS", "W  ",
        		'S', Items.string,
        		'W', Items.stick);
        
        GameRegistry.addShapelessRecipe(new ItemStack(Electrolysm.ballOfPlastic, 8),
        		new ItemStack(Blocks.sand),
        		new ItemStack(Items.slime_ball),
        		new ItemStack(Electrolysm.sulphur),
        		new ItemStack(Items.water_bucket));



        GameRegistry.addRecipe(new ItemStack(Electrolysm.basicEnergyStorage),
                new Object[] {
                        "IRI", "GCG", "IRI",
                        Character.valueOf('R'), Electrolysm.basicCable,
                        Character.valueOf('G'), Blocks.glass,
                        Character.valueOf('C'), Electrolysm.crystal1,
                        Character.valueOf('I'), Items.iron_ingot,
                });

        GameRegistry.addRecipe(new ItemStack(Electrolysm.generator, 1, 3),
                new Object[] {
                        "ICI", "RCR", "IFI",
                        Character.valueOf('R'), Items.redstone,
                        Character.valueOf('I'), Items.iron_ingot,
                        Character.valueOf('C'), Electrolysm.basicCable,
                        Character.valueOf('F'), Blocks.furnace
                });

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Electrolysm.advancedGenerator, 1, 3),
                true, new Object[] {
                        "SCS", "NMN", "SGS",
                        Character.valueOf('G'), Electrolysm.generator,
                        Character.valueOf('S'), "ingotSteel",
                        Character.valueOf('C'), Electrolysm.basicCable,
                        Character.valueOf('N'), Blocks.stone,
                        Character.valueOf('M'), Electrolysm.BasicMicrochip
                }));

        GameRegistry.addRecipe(new ItemStack(Electrolysm.thermalGenerator),
                new Object[] {
                        "IBI", "FMF", "IBI",
                        Character.valueOf('B'), Items.bucket,
                        Character.valueOf('I'), Items.iron_ingot,
                        Character.valueOf('L'), Items.lava_bucket,
                        Character.valueOf('M'), Electrolysm.advancedMicrochip
                });

        GameRegistry.addRecipe(new ItemStack(Electrolysm.solarPanel),
                new Object[] {
                        "GGG", "IDI", "IMI",
                        Character.valueOf('D'), Blocks.daylight_detector,
                        Character.valueOf('I'), Items.iron_ingot,
                        Character.valueOf('G'), Blocks.glass,
                        Character.valueOf('M'), Electrolysm.BasicMicrochip
                });

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Electrolysm.basicCable), true,
                new Object[] {
                        "WWW", "CCC", "WWW",
                        Character.valueOf('W'), Blocks.wool,
                        Character.valueOf('C'), "ingotCopper",
                }));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Electrolysm.electrolisisCore), true,
                new Object[] {
                        "YIY", "RXR", "YIY",
                        'I', "ingotCopper",
                        'Y', new ItemStack(Electrolysm.electrolChamber, 1, 0),
                        'X', Electrolysm.advancedMicrochip,
                        'R', Items.redstone
                }));

        GameRegistry.addRecipe(new ItemStack(Electrolysm.microchipBoard), new Object[]{
                "   ", "   ", "RRR",
                'R', Items.redstone});



        GameRegistry.addRecipe( new ShapedOreRecipe(Electrolysm.CPU, true, new Object[]{
                "CTC", "TRT", "CTC",
                'C', "ingotCopper",
                'T', Electrolysm.transistor,
                'R', Items.redstone}));

        GameRegistry.addRecipe(new ShapedOreRecipe(Electrolysm.advancedCPU, true, new Object[]{
                "RCR", "PDP", "RCR",
                'R', Items.redstone,
                'C', "ingotCopper",
                'P', Electrolysm.CPU,
                'D', Items.diamond}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Electrolysm.crusher, 1, 3),
                true, new Object[]{
                "IMI", "PGP", "ICI",
                Character.valueOf('I'), "ingotSteel",
                Character.valueOf('M'), Electrolysm.BasicMicrochip,
                Character.valueOf('P'), Blocks.cobblestone,
                Character.valueOf('G'), Electrolysm.grindStone,
                Character.valueOf('C'), Items.redstone}));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Electrolysm.smeltory, 1, 3),
                true, new Object[]{
                        "IRI", "IMI", "FFF",
                        Character.valueOf('I'), "ingotSteel",
                        Character.valueOf('R'), Items.redstone,
                        Character.valueOf('M'), Electrolysm.advancedMicrochip,
                        Character.valueOf('F'), Blocks.furnace
                }));

      /*  addRecipe(ResearchRegistry.getResearch("endothermic_cable"), new ItemStack(Electrolysm.experimentalCable, 8),
                new Object[]{
                        "III", "GGG", "III",
                        Character.valueOf('I'), Electrolysm.endoInsulator,
                        Character.valueOf('G'), Electrolysm.chunkGraphite
                });
*/
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Electrolysm.liquidiser, 1, 3),
                true, new Object[]{
                        "ILI", "RLM", "IFI",
                        Character.valueOf('I'), "ingotSteel",
                        Character.valueOf('L'), Electrolysm.fluidStorage,
                        Character.valueOf('R'), Items.redstone,
                        Character.valueOf('M'), Electrolysm.advancedMicrochip,
                        Character.valueOf('F'), Blocks.furnace
                }));

        GameRegistry.addRecipe(new ItemStack(Electrolysm.injector, 1, 3),
                new Object[]{
                        "SFS", "FMF", "SIS",
                        Character.valueOf('I'), Electrolysm.injectionArm,
                        Character.valueOf('F'), Electrolysm.fluidStorage,
                        Character.valueOf('M'), Electrolysm.advancedMicrochip,
                        Character.valueOf('S'), Electrolysm.steel
                });

        GameRegistry.addRecipe(new ItemStack(Electrolysm.improvedCoal),
                new Object[]{
                        "CH ", "R  ", "   ",
                        Character.valueOf('C'), new ItemStack(Items.coal, 1, 0),
                        Character.valueOf('H'), new ItemStack(Items.coal, 1, 1),
                        Character.valueOf('R'), Items.redstone
                });




    }	

    public static void addFurnaceRecipes() 
	{
		Item impureID = Electrolysm.impureDusts;
		Item pureID = Electrolysm.dusts;
		ItemStack copperIngot = new ItemStack(Electrolysm.copperIngot, 1);
		ItemStack tinIngot = new ItemStack(Electrolysm.ingots, 1, 0);
		ItemStack silverIngot = new ItemStack(Electrolysm.ingots, 1, 1);
		ItemStack leadIngot = new ItemStack(Electrolysm.ingots, 1, 2);

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
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(pureID, 1, 1), tinIngot, pureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(pureID, 1, 2), ironIngot, pureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(pureID, 1, 3), goldIngot, pureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(pureID, 1, 4), silverIngot, pureXP);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(pureID, 1, 5), leadIngot, pureXP);
	    
		GameRegistry.addSmelting(Electrolysm.copperOre, new ItemStack(Electrolysm.copperIngot, 1), 2F);
		FurnaceRecipes.smelting().func_151394_a(new ItemStack(Electrolysm.Scandium),
                new ItemStack(Electrolysm.Scandium, 1, 1), pureXP);
		//GameRegistry.addSmelting((Electrolysm.diseasedLog), new ItemStack(Electrolysm.camphor), 2F);
        GameRegistry.addSmelting(Items.coal, new ItemStack(Electrolysm.improvedCoal), 1F);
        GameRegistry.addSmelting(Blocks.coal_block, new ItemStack(Electrolysm.improvedCoal, 10), 10F);

		//GameRegistry.addSmelting(pureID, goldIngot, pureXP);

	}
}
