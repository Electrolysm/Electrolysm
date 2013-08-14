package mods.Electrolysm.electro.basic.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MicroscopeRecipes
{
    private static final MicroscopeRecipes smeltingBase = new MicroscopeRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final MicroscopeRecipes smelting()
    {
        return smeltingBase;
    }

    private MicroscopeRecipes()
    {
    	//Recipes
    	this.addCrushing(electrolysmCore.copperOre.blockID, new ItemStack(electrolysmCore.copperDust, 2), 2);
    	//End
    }

    /**
     * Adds a smelting recipe.
     */
    public void addCrushing(int input, ItemStack output, float xp)
    {
        this.smeltingList.put(Integer.valueOf(input), output);
        this.experienceList.put(Integer.valueOf(output.itemID), Float.valueOf(xp));
    }
    public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(Integer.valueOf(item.itemID));
    }
}