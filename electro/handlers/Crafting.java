package assets.electrolysm.electro.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting {

	public static void addCrafting() {
	
		GameRegistry.addRecipe(new ItemStack(electrolysmCore.researchDesk),
				" X ", "YZY", "BMB",
				Character.valueOf('X'), Item.book,
				Character.valueOf('Y'), Item.ingotIron,
				Character.valueOf('Z'), Block.enchantmentTable,
				Character.valueOf('B'), Block.workbench,
				Character.valueOf('M'), Item.diamond);
		
		GameRegistry.addRecipe(new ItemStack(electrolysmCore.workBench),
				"YXY", "Y Y", "Y Y",
				Character.valueOf('X'), Block.workbench,
				Character.valueOf('Y'), Item.ingotIron);
		
		GameRegistry.addRecipe(new ItemStack(electrolysmCore.card, 1, 1),
				"   ", "XYX", "   ",
				Character.valueOf('X'), Item.stick,
				Character.valueOf('Y'), Item.paper);

		for(int i = 1; i <= 9; i++)
		{
			ItemStack cardLevels = new ItemStack(electrolysmCore.card, 1, i);
			
			GameRegistry.addRecipe(new ItemStack(electrolysmCore.card, 1, i + 1),
					"XXX", "XZX", "XXX",
					Character.valueOf('X'), electrolysmCore.knowledge,
					Character.valueOf('Z'), cardLevels);
		}
		
		GameRegistry.addRecipe(new ItemStack(electrolysmCore.blastProof, 2),
				"XYX", "YZY", "XYX",
				Character.valueOf('X'), Block.blockIron,
				Character.valueOf('Y'), Block.stone,
				Character.valueOf('Z'), new ItemStack(electrolysmCore.researchPaper, 1, 0));
		
		GameRegistry.addRecipe(new ItemStack(electrolysmCore.blastDoor),
				"XX", "XX", "XX",
				Character.valueOf('X'), electrolysmCore.blastProof);
		
		GameRegistry.addRecipe(new ItemStack(electrolysmCore.blastGlass, 4),
				"XYX", "YXY", "XYX",
				Character.valueOf('X'), electrolysmCore.blastProof,
				Character.valueOf('Y'), Block.glass);
		
		
		GameRegistry.addRecipe(new ItemStack(electrolysmCore.drillCasing),
				" XY", "XZX", "BX ",
				Character.valueOf('X'), Item.ingotIron,
				Character.valueOf('Y'), Item.diamond,
				Character.valueOf('Z'), Block.blockDiamond,
				Character.valueOf('B'), Block.tnt);
		
		GameRegistry.addRecipe(new ItemStack(electrolysmCore.fluidStorage),
				" X ", "Y Y", " Y ",
				Character.valueOf('X'), electrolysmCore.blastGlass,
				Character.valueOf('y'), electrolysmCore.blastProof);
		
		
		//Temporary Only - Remove!
		ItemStack cardL5 = new ItemStack(electrolysmCore.card, 1, 5);
		
		GameRegistry.addRecipe(new ItemStack(electrolysmCore.desk),
				"XXX", "XYX", "XXX",
				Character.valueOf('X'), cardL5,
				Character.valueOf('Y'), Block.bookShelf);
		
		
	}

}
