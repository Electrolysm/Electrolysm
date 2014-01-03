package assets.electrolysm.electro.oreProccessing.recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import assets.electrolysm.electro.electrolysmCore;

public class CrusherRecipes
{
	private static final CrusherRecipes smeltBase = new CrusherRecipes();

	private Map crushing1 = new HashMap();
	private Map crushing2 = new HashMap();
	
	public static final CrusherRecipes smelting() {
		return smeltBase;
	}

	private CrusherRecipes()
	{	
		//		"Copper", "Tin", "Iron", "Gold", "Silver", "Lead"};
		//METAs		0		   1	  2		  3			4		5
		
		ArrayList<ItemStack> copperOre = OreDictionary.getOres("oreCopper");
		ArrayList<ItemStack> tinOre = OreDictionary.getOres("oreTin");
		ArrayList<ItemStack> silverOre = OreDictionary.getOres("oreSilver");
		ArrayList<ItemStack> leadOre = OreDictionary.getOres("oreLead");
		
		ItemStack ironOre = new ItemStack(Block.oreIron);
		ItemStack goldOre = new ItemStack(Block.oreGold);
		
		this.addCrushing(ironOre, new ItemStack(electrolysmCore.impureDusts, 2, 2));
		this.addCrushing(goldOre, new ItemStack(electrolysmCore.impureDusts, 2, 3));
		for(int i = 0; i < copperOre.size(); i++)
		{
			this.addCrushing(copperOre.get(i), new ItemStack(electrolysmCore.impureDusts, 2, 0));
		}
		for(int i = 0; i < tinOre.size(); i++)
		{
			this.addCrushing(tinOre.get(i), new ItemStack(electrolysmCore.impureDusts, 2, 2));
		}
		for(int i = 0; i < silverOre.size(); i++)
		{
			this.addCrushing(silverOre.get(i), new ItemStack(electrolysmCore.impureDusts, 2, 4));
		}
		for(int i = 0; i < leadOre.size(); i++)
		{
			this.addCrushing(leadOre.get(i), new ItemStack(electrolysmCore.impureDusts, 2, 5));
		}
	}

	public void addCrushing(ItemStack input, ItemStack output) {
		this.crushing1.put(input, output);
		this.crushing2.put(input, output);
	}

	public ItemStack getCrushingResult(ItemStack input) 
	{
		if (input == null) 
		{
			return null;
		}

		ItemStack outputItem1 = (ItemStack)this.crushing1.get(input);
		ItemStack outputItem2 = (ItemStack)this.crushing2.get(input);

		if (outputItem1 == outputItem2) 
		{
			if (outputItem1.getItemDamage() == outputItem2.getItemDamage()) 
			{
				return outputItem1;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	public ItemStack getSlot1ReduceAmount(ItemStack input) 
	{
		return (ItemStack) this.crushing1.get(input);
	}

	public ItemStack getSlot2ReduceAmount(ItemStack input) 
	{
		return (ItemStack) this.crushing2.get(input);
	}

}