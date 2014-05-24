package assets.electrolysm.electro.research.system;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class Requirement 
{
	public Object[] requirement;
	
	public Requirement(Item[] item)
	{
		this((Object[])item);
	}
	
	public Requirement(Block[] block)
	{
		this((Object[])block);
	}
	
	public Requirement(Material[] material)
	{
		this((Object[])material);
	}
	
	public Requirement(Object[] object)
	{
		this.requirement = object;
	}
}
