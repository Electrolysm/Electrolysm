package electro.oreProccessing.recipes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class SmeltoryRecipes
{
    private static final SmeltoryRecipes smeltBase = new SmeltoryRecipes();

    private Map crushing1 = new HashMap();
    private Map crushing2 = new HashMap();

    public static final SmeltoryRecipes smelting()
    {
        return smeltBase;
    }

    private SmeltoryRecipes()
    {
    }
    
    public void addSmelting(ItemStack input, ItemStack output)
    {
        this.crushing1.put(input, Integer.valueOf(output.getItemDamage()));
        this.crushing2.put(input, output);
    }

    public Map getSmeltingMap()
    {
    	return this.crushing2;
    }
    
    public ItemStack getSmeltingResult(ItemStack input)
    {
        if (input == null)
        {
            return null;
        }

        ItemStack output1 = (ItemStack)this.crushing2.get((input));
        ItemStack output2 = FurnaceRecipes.smelting().getSmeltingResult(input);

        if (output1 != null)
        {
       		return output1;
        }
        else if(output2 != null)
        {
        	return output2;
        }
        else
        {
        	return null;
        }
    }

    public ItemStack getSlot1ReduceAmount(ItemStack input)
    {
        return (ItemStack) this.crushing1.get(input);
    }
}