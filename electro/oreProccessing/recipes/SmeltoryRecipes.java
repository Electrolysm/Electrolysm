package assets.electrolysm.electro.oreProccessing.recipes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import assets.electrolysm.electro.electrolysmCore;

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
        this.crushing1.put(Integer.valueOf(input.itemID), Integer.valueOf(output.getItemDamage()));
        this.crushing2.put(Integer.valueOf(input.itemID), output);
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

        int meta = Integer.valueOf((String.valueOf(this.crushing1.get(Integer.valueOf(input.itemID)))));
        ItemStack output1 = (ItemStack)this.crushing2.get(Integer.valueOf(input.itemID));
        ItemStack output2 = FurnaceRecipes.smelting().getSmeltingResult(input.itemID);

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