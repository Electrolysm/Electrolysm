package assets.electrolysm.api.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import assets.electrolysm.electro.handlers.LoggerHandler;

public class ItemFetcher
{
    private static Class core;
 
    
    public static ItemStack getItem(String id, int stackSize)
    {
    	try
    	{
    		if(core == null)
    		{
    			core = Class.forName("");
    		}
    		Object ret = core.getField(id).get(null);
    		
    		if(ret instanceof Item)
    		{
    			return (new ItemStack((Item)ret, stackSize));
    		}
    		else if(ret instanceof Block)
    		{
    			return (new ItemStack((Block)ret, stackSize));
    		}
    		else
    		{
    			return null;
    		}
    	}
    	catch(Exception e)
    	{
    		LoggerHandler.severe("Error fetching - " + id + " - form class");
    		return null;
    	}
    }
    
    public static ItemStack getItem(String id, int meta, int stackSize)
    {
    	try
    	{
    		if(core == null)
    		{
    			core = Class.forName("");
    		}
    		Object ret = core.getField(id).get(null);
    		
    		if(ret instanceof Item)
    		{
    			return (new ItemStack((Item)ret, stackSize, meta));
    		}
    		else if(ret instanceof Block)
    		{
    			return (new ItemStack((Block)ret, stackSize, meta));
    		}
    		else
    		{
    			return null;
    		}
    	}
    	catch(Exception e)
    	{
    		LoggerHandler.severe("Error fetching - " + id + " - form class");
    		return null;
    	}
    }
}