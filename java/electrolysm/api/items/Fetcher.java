package electrolysm.api.items;

import electrolysm.api.LoggerHandler;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Fetcher
{
    private static Class core;
 
    
    public static ItemStack getItem(String id, int stackSize)
    {
    	try
    	{
    		if(core == null)
    		{
    			core = Class.forName("electro.Electrolysm");
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
    		electrolysm.api.LoggerHandler.severe("Error fetching - " + id + " - form class");
    		return null;
    	}
    }
    
    public static ItemStack getItem(String id, int meta, int stackSize)
    {
    	try
    	{
    		if(core == null)
    		{
    			core = Class.forName("electro.Electrolysm");
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
    
    public static CreativeTabs getCreativeTab()
    {
    	try
    	{
    		if(core == null)
    		{
    			core = Class.forName("electro.Electrolysm");
    		}
    		Object ret = core.getField("TabElectrolysm").get(null);
    		
    		if(ret instanceof CreativeTabs)
    		{
    			return ((CreativeTabs)ret);
    		}
    		else
    		{
    			return null;
    		}
    	}
    	catch(Exception e)
    	{
    		LoggerHandler.severe("Error fetching - " + "TabElectrolysm" + " - form class");
    		return null;
    	}
    }
}