package api.powerSystem;

import java.util.HashMap;

import electro.Electrolysm;
import net.minecraft.block.Block;

public class PowerUsage 
{

	//Crusher == 14;
	//Liquidiser == 0;
	//Electrolysis == 62;
	//Smeltory == 19
	
	private static HashMap<Block, TeU> energyUsageMap = new HashMap<Block, TeU>();
	private static HashMap<TeU, Block> energyUsageMapRev = new HashMap<TeU, Block>();
	
	static
	{
		addToMap(Electrolysm.crusher, new TeU(14));
		addToMap(Electrolysm.crusherActive, new TeU(14));
		addToMap(Electrolysm.smeltory, new TeU(19));
		addToMap(Electrolysm.smeltoryActive, new TeU(19));
		addToMap(Electrolysm.electrolisisCore, new TeU(62));
	}
	
	
	public static void addToMap(Block block, TeU teu)
	{
		energyUsageMap.put(block, teu);
		energyUsageMapRev.put(teu, block);
	}
	
	public static TeU getTeUFromMap(Block block)
	{
		return (TeU)(energyUsageMap.get(block));
	}
	
	public static Block getBlockFromTeU(TeU teu)
	{
		return (Block)(energyUsageMapRev.get(teu));
	}
}
