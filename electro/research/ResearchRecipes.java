package assets.electrolysm.electro.research;

import java.lang.reflect.Method;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ResearchRecipes 
{
	private static ItemStack[] recipe = new ItemStack[9];
	
	public static ItemStack getResultBasedOnDamage(int damage) 
	{
		if(damage == 0)
		{
			return new ItemStack(electrolysmCore.blastProof, 8);
		}
		else
		{
			return null;
		}
	}
	
	public static ItemStack[] getRecipeBasedOnDamage(int damage)
	{
		if(damage == 0)
		{
			return blastProofRecipe();
		}
		else if(damage == 1)
		{
			return null;
		}
		else if(damage == 3)
		{
			 return teslaTowerRecipe();
		}
		else
		{
			return null;
		}
	}
	
	public static ItemStack[] teslaTowerRecipe()
	{
		recipe[0] = new ItemStack(Block.blockIron);
		recipe[1] = new ItemStack(Block.glass);
		recipe[2] = new ItemStack(Block.blockGold);
		recipe[3] = new ItemStack(electrolysmCore.stoneObsidian);
		//recipe[4] = new ItemStack(electrolysmCore.crystamTier1);
		recipe[5] = new ItemStack(electrolysmCore.stoneObsidian);
		recipe[6] = new ItemStack(electrolysmCore.diamondShard);
		recipe[7] = new ItemStack(Block.obsidian);
		recipe[8] = new ItemStack(electrolysmCore.diamondShard);

		return recipe;
	}
	
	public static ItemStack[] blastProofRecipe()
	{
		recipe[0] = new ItemStack(Item.ingotIron);
		recipe[1] = new ItemStack(electrolysmCore.stoneObsidian);
		recipe[2] = new ItemStack(Item.ingotIron);
		recipe[3] = new ItemStack(electrolysmCore.stoneObsidian);
		recipe[4] = null;
		recipe[5] = new ItemStack(electrolysmCore.stoneObsidian);
		recipe[6] = new ItemStack(Item.ingotIron);
		recipe[7] = new ItemStack(electrolysmCore.stoneObsidian);
		recipe[8] = new ItemStack(Item.ingotIron);
		
		return recipe;
	}


}
