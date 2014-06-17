package electro.research.system;

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

    @Override
    public String toString()
    {
        String ret = "";
        for(int i = 0; i < requirement.length; i++)
        {
            if(requirement[i] instanceof Block)
            {
                ret = ret + ((Block)requirement[i]).getUnlocalizedName() + " : ";
            }
            else if(requirement[i] instanceof Item)
            {
                ret = ret + ((Item)requirement[i]).getUnlocalizedName() + " : ";
            }
            else if(requirement[i] instanceof Material)
            {
                ret = ret + ((Material)requirement[i]) + " : ";
            }

        }
        return ret;
    }

}
