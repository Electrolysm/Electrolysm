package assets.electrolysm.electro.research;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Research
{
    private static final Research researchBase = new Research();

    /** The list of smelting results. */
    private static Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private static HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final Research smelting()
    {
        return researchBase;
    }

    private Research()
    {
        this.addResearch(Item.bucketEmpty.itemID, new ItemStack(Item.bucketLava), 0.5F);
    }

    /**
     * Adds a smelting recipe.
     */
    public void addResearch(int par1, ItemStack par2ItemStack, float par3)
    {
        //this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
        //this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3));
    }
    public static ItemStack getResearch(ItemStack item) 
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