package api.powerSystem;

import java.util.HashMap;

import api.items.RecipeStack;
import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class PowerUsage 
{

	//Crusher == 14;
	//Liquidiser == 0;
	//Electrolysis == 62;
	//Smeltory == 19
	
	private static HashMap<RecipeStack, Integer> energyUsageMap = new HashMap<RecipeStack, Integer>();
	private static HashMap<Integer, RecipeStack> energyUsageMapRev = new HashMap<Integer, RecipeStack>();
	
	static
	{
		addToMap(Electrolysm.crusher, 14);
		addToMap(Electrolysm.crusherActive, 14);
		addToMap(Electrolysm.smeltory, 19);
		addToMap(Electrolysm.smeltoryActive, 19);
		addToMap(Electrolysm.electrolisisCore, 62);

        addToMap(Electrolysm.solarPanel, 2);
        addToMap(Electrolysm.generator, 3);
        addToMap(Electrolysm.advancedGenerator, 19);
        addToMap(Electrolysm.thermalGenerator, 42);
        addToMap(Electrolysm.matterGen, 100000);
	}
	
	
	public static void addToMap(ItemStack stack, int teu)
	{
		energyUsageMap.put(new RecipeStack(stack), teu);
		energyUsageMapRev.put(teu, new RecipeStack(stack));
	}

    public static void addToMap(Block block, int teu)
    {
        addToMap(new ItemStack(block), teu);
    }
	
	public static int getTeUFromMap(Block block)
	{
		return getTeUFromMap(new ItemStack(block));
	}

    public static int getTeUFromMap(ItemStack stack) { return energyUsageMap.get(new RecipeStack(stack)); }

	public static Block getBlockFromTeU(TeU teu)
	{
		return Block.getBlockFromItem((energyUsageMapRev.get(teu)).getStackValue().getItem());
	}
}
