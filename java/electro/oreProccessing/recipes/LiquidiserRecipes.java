package electro.oreProccessing.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import api.items.RecipeStack;
import electro.Electrolysm;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import electro.common.CommonProxy;

public class LiquidiserRecipes
{
    private static final LiquidiserRecipes smeltBase = new LiquidiserRecipes();

    /** The list of smelting results. */
    /*private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();*/
    private HashMap<List<RecipeStack>, RecipeStack> metaSmeltingList = new HashMap<List<RecipeStack>, RecipeStack>();
    //private HashMap<List<RecipeStack>, Float> metaExperience = new HashMap<List<RecipeStack>, Float>();

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
        metaSmeltingList.put(Arrays.asList(new RecipeStack(stack)), new RecipeStack(itemstack));
    }
    
    public ItemStack getLiquidisingResult(ItemStack item)
    {
        if (item == null) { return null; }
        if(metaSmeltingList.get(Arrays.asList(new RecipeStack(item))) == null) { return null; }

        return metaSmeltingList.get(Arrays.asList(new RecipeStack(item))).getStackValue();
    }

	public HashMap<List<RecipeStack>, RecipeStack> getLiquidsMap()
	{
		return this.metaSmeltingList;
	}

}