package electro.oreProccessing.recipes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import electro.electrolysmCore;
import electro.common.CommonProxy;

public class LiquidiserRecipes
{
    private static final LiquidiserRecipes smeltBase = new LiquidiserRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<ItemStack>, ItemStack> metaSmeltingList = new HashMap<List<ItemStack>, ItemStack>();
    private HashMap<List<ItemStack>, Float> metaExperience = new HashMap<List<ItemStack>, Float>();

    public static final LiquidiserRecipes liquidising()
    {
        return smeltBase;
    }

    private LiquidiserRecipes()
    {
        for (int i = 0; i < CommonProxy.DUSTS.length; i++)
        {
            this.addLiquidising(new ItemStack(electrolysmCore.impureDusts, 1, i),
            		new ItemStack(electrolysmCore.crystal, 1, i));
        }
        
        this.addLiquidising(new ItemStack(Blocks.redstone_ore), new ItemStack(electrolysmCore.Scandium, 1, 0));
    }

    public void addLiquidising(ItemStack stack, ItemStack itemstack)
    {
        metaSmeltingList.put(Arrays.asList(stack), itemstack);
    }
    
    public ItemStack getLiquidisingResult(ItemStack item)
    {
        if (item == null)
        {
            return null;
        }/*
	    for(int i = 0; i < CommonProxy.DUSTS.length; i++)
	    { 
	    	ItemStack impureDust = new ItemStack(electrolysmCore.impureDusts, 1, i);
	        if(item.isItemEqual(impureDust))
	        {
	        	return (new ItemStack(electrolysmCore.crystal, 1, i));
	        }
	    }*/
        return (ItemStack)metaSmeltingList.get(Arrays.asList(item));
    }

	public Map getLiquidsMap() 
	{
		return this.metaSmeltingList;
	}

}