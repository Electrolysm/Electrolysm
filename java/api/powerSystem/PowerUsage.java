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
	
	private static HashMap<RecipeStack, TeU> energyUsageMap = new HashMap<RecipeStack, TeU>();
	private static HashMap<TeU, RecipeStack> energyUsageMapRev = new HashMap<TeU, RecipeStack>();
	
	static
	{
		addToMap(Electrolysm.crusher, new TeU(14));
		addToMap(Electrolysm.crusherActive, new TeU(14));
		addToMap(Electrolysm.smeltory, new TeU(19));
		addToMap(Electrolysm.smeltoryActive, new TeU(19));
		addToMap(Electrolysm.electrolisisCore, new TeU(62));

        addToMap(Electrolysm.generator, new TeU(3));
	}
	
	
	public static void addToMap(ItemStack stack, TeU teu)
	{
		energyUsageMap.put(new RecipeStack(stack), teu);
		energyUsageMapRev.put(teu, new RecipeStack(stack));
	}

    public static void addToMap(Block block, TeU teu)
    {
        addToMap(new ItemStack(block), teu);
    }
	
	public static TeU getTeUFromMap(Block block)
	{
		return getTeUFromMap(new ItemStack(block));
	}

    public static TeU getTeUFromMap(ItemStack stack) { return energyUsageMap.get(new RecipeStack(stack)); }

	public static Block getBlockFromTeU(TeU teu)
	{
		return Block.getBlockFromItem((energyUsageMapRev.get(teu)).getStackValue().getItem());
	}
}
