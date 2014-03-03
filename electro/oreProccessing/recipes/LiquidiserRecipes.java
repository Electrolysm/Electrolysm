package assets.electrolysm.electro.oreProccessing.recipes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.common.CommonProxy;

public class LiquidiserRecipes
{
    private static final LiquidiserRecipes smeltBase = new LiquidiserRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    public static final LiquidiserRecipes liquidising()
    {
        return smeltBase;
    }

    private LiquidiserRecipes()
    {
        for (int i = 0; i < CommonProxy.DUSTS.length; i++)
        {
            this.addLiquidising(electrolysmCore.impureDusts.itemID, i, 
            		new ItemStack(electrolysmCore.crystal, 1, 1));
        }
    }

    public void addLiquidising(int itemID, int metadata, ItemStack itemstack)
    {
        metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
    }
    
    public ItemStack getLiquidisingResult(ItemStack item)
    {
        if (item == null)
        {
            return null;
        }
	    for(int i = 0; i <) 
        ItemStack crystal = new ItemStack
	        if()

        return (ItemStack)smeltingList.get(Integer.valueOf(item.itemID));
    }

}