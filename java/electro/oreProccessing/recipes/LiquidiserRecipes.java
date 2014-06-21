package electro.oreProccessing.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import electro.Electrolysm;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
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
            this.addLiquidising(new ItemStack(Electrolysm.impureDusts, 1, i),
            		new ItemStack(Electrolysm.crystal, 1, i));
        }
        
        this.addLiquidising(new ItemStack(Blocks.redstone_ore), new ItemStack(Electrolysm.Scandium, 1, 0));
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

	public HashMap<List<ItemStack>, ItemStack> getLiquidsMap()
	{
		return this.metaSmeltingList;
	}

}