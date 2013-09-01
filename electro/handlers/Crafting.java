package assets.electrolysm.electro.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting {

	public static void addCrafting() {
	
		GameRegistry.addRecipe(new ItemStack(electrolysmCore.researchDesk),
				"x",
				Character.valueOf('x'), Block.dirt);
	}

}
