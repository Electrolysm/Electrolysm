package assets.electrolysm.electro.research;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assets.electrolysm.electro.electrolysmCore;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Research
{
	
	public static String[] researchNames1 = {"Blast-Proof Iron", "Schrodinger's Cat"};
	//Research Note metadata ID						0					1
	
	
	
	
	
	//=====================================================
	//					Research Behind the Scenes
	//=====================================================
	
    private static final Research researchBase = new Research();

    /** The list of smelting results. */
    public static Map researchList = new HashMap();
    public static Map cardIDList = new HashMap();
    
    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final Research research()
    {
        return researchBase;
    }

	private Research()
    {
        this.addResearch(Block.blockIron.blockID,new ItemStack(electrolysmCore.researchPaper, 1, 0), 1);
        this.addResearch(Item.fishRaw.itemID, new ItemStack(electrolysmCore.researchPaper, 1, 1), 1);
        this.addResearch(Item.fishCooked.itemID, new ItemStack(electrolysmCore.researchPaper, 1, 1), 1);
        this.addResearch(Item.appleGold.itemID, new ItemStack(electrolysmCore.researchPaper, 1, 0), 2);
    }
    
    
    /**
     * Adds a smelting recipe.
     */
    public void addResearch(int inputID, ItemStack output, int cardIDRequired)
    {
        this.researchList.put(Integer.valueOf(inputID), output.getItemDamage());
        this.cardIDList.put(output.getItemDamage(), Integer.valueOf(cardIDRequired));
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
        
        if(output1 != null)
        {
        	int cardIDRequired = (Integer) this.cardIDList.get(output1.getItemDamage());
        
        	if(card.getItemDamage() >= cardIDRequired)
        	{
        		return output1;
       		}
	        else
	        {
	        	return null; 
	        }
        }
        else
        {
        	return null;
        }
    }
	
	public static int cardToDesk(int itemDamage)
	{
		if(itemDamage == 1)
		{
			return 0;
		}
		int result = itemDamage * 3;
		result = (int)result + 2;
		
		return (int)result;
	}
}