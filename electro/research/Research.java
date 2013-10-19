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
    private Map researchList = new HashMap();
    private Map cardIDList = new HashMap();
    
    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final Research research()
    {
        return researchBase;
    }

    private Research()
    {
        this.addResearch(Item.bucketEmpty.itemID, new ItemStack(Item.bucketLava), 1);
    }

    /**
     * Adds a smelting recipe.
     */
    public void addResearch(int inputID, ItemStack output, int cardIDRequired)
    {
        this.researchList.put(Integer.valueOf(inputID), output);
        this.cardIDList.put(Integer.valueOf(cardIDRequired), output);
    }
    public ItemStack getResearch(ItemStack item, ItemStack card) 
    {
        if (item == null)
        {
            return null;
        }
        if(card == null)
        {
        	return null;
        }
        ItemStack output1 = (ItemStack)this.researchList.get(Integer.valueOf(item.itemID));
        ItemStack output2 = (ItemStack)this.cardIDList.get(Integer.valueOf(card.getItemDamage()));
        
        if(output1 == output2)
        {
        	return output1;
        }
        else
        {
        	return null;
        }
        
    }
}