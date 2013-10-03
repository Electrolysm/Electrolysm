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
		
		GameRegistry.addRecipe(new ItemStack(electrolysmCore.card),
				"   ", "XYX", "   ",
				Character.valueOf('X'), Item.stick,
				Character.valueOf('Y'), Item.paper);
		
		//Temporary Only Remove!
		ItemStack cardL5 = new ItemStack(electrolysmCore.card, 1, 5);
		
		GameRegistry.addRecipe(new ItemStack(electrolysmCore.desk),
				"XXX", "XYX", "XXX",
				Character.valueOf('X'), cardL5,
				Character.valueOf('Y'), Block.bookShelf);
		
		
	}

}
