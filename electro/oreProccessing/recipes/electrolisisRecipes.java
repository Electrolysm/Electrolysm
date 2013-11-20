package assets.electrolysm.electro.oreProccessing.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class electrolisisRecipes
{
    private static final electrolisisRecipes smeltingBase = new electrolisisRecipes();

    /** The list of smelting results. */
    private Map electrolysisMap = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final electrolisisRecipes smelting()
    {
        return smeltingBase;
    }

    private electrolisisRecipes()
    {
    	//XP
    	float xp = 10;
    	//ItemStacks - fluid
    	int copperSul = 3;
    	//ItemStacks - Dusts
    	ItemStack impureCopper = new ItemStack(electrolysmCore.impureDusts, 2, 0);
    	//Recipes
    	this.addElectrolisis(copperSul, impureCopper);
    	//End
    }

    /**
     * Adds a smelting recipe.
     */
    public void addElectrolisis(int inputMeta, ItemStack output)
    {
        this.electrolysisMap.put(Integer.valueOf(inputMeta), output);
    }
    
    public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item != null)
        {
        	ItemStack result = (ItemStack)this.electrolysisMap.get(Integer.valueOf(item.getItemDamage()));
        
        	if (result != null) 
        	{
        		return result;
        	}
        }
		return null;
    }
}