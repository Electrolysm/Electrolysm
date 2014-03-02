package assets.electrolysm.electro.oreProccessing.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.common.CommonProxy;

public class LiquidiserRecipes
{
    private static final LiquidiserRecipes smeltBase = new LiquidiserRecipes();

    private Map crushing1 = new HashMap();
    private Map crushing2 = new HashMap();
    private HashMap<List<Integer>, Integer> inputSize = new HashMap<List<Integer>, Integer>();

    public static final LiquidiserRecipes liquidising()
    {
        return smeltBase;
    }

    private LiquidiserRecipes()
    {
        for(int i = 0; i < CommonProxy.DUSTS.length; i++)
        {
        	this.addLiquidising(new ItemStack(electrolysmCore.impureDusts, 2, i), 
        			new ItemStack(electrolysmCore.crystal, 2, i));
        }
    }

    public void addLiquidising(ItemStack input, ItemStack output)
    {
        this.crushing1.put(Integer.valueOf(input.itemID), Integer.valueOf(output.getItemDamage()));
        this.crushing2.put(Integer.valueOf(input.itemID), output);
        
        inputSize.put(Arrays.asList(output.itemID, output.getItemDamage()), Integer.valueOf(input.stackSize));
    }

    public ItemStack getLiquidisingResult(ItemStack input)
    {
        if (input == null)
        {
            return null;
        }

        if (this.crushing1.get(Integer.valueOf(input.itemID)) == null)
        {
            return null;
        }

        int meta = Integer.valueOf((String.valueOf(this.crushing1.get(Integer.valueOf(input.itemID)))));
        ItemStack output = (ItemStack)this.crushing2.get(Integer.valueOf(input.itemID));

        if (output != null)
        {
        	return output;
        }
        else
        {
            return null;
        }
    }

    public int getNoInput(ItemStack result)
    {
    	if(result == null)
    	{
    		return 0;
    	}
    	
        int size = inputSize.get(Arrays.asList(result.itemID, result.getItemDamage()));
        
		return size;
    }
    
    public ItemStack getSlot1ReduceAmount(ItemStack input)
    {
        return (ItemStack) this.crushing1.get(input);
    }
}