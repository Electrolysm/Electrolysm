package electro.oreProccessing.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;
import electro.electrolysmCore;
import electro.common.CommonProxy;

public class electrolisisRecipes
{
    private static final electrolisisRecipes smeltingBase = new electrolisisRecipes();

    /** The list of smelting results. */
    private HashMap<ItemStack, ItemStack> electrolysisMap = new HashMap<ItemStack, ItemStack>();

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
        int ironSul = 4;
        int goldSul = 5;
        int tinSul = 6;
        int leadSul = 7;
        int silverSul = 8;
        
        //ItemStacks - Dusts
        ItemStack pureCopper = new ItemStack(electrolysmCore.dusts, 4, 0);
        ItemStack pureIron = new ItemStack(electrolysmCore.dusts, 4, 2);
        ItemStack pureGold = new ItemStack(electrolysmCore.dusts, 4, 3);
        ItemStack pureTin = new ItemStack(electrolysmCore.dusts, 4, 1);
        ItemStack pureLead = new ItemStack(electrolysmCore.dusts, 4, 5);
        ItemStack pureSilver = new ItemStack(electrolysmCore.dusts, 4, 4);
        //Local MOD Recipes
        this.addElectrolisis(new ItemStack(electrolysmCore.fluidStorage, 1, copperSul), pureCopper);
        this.addElectrolisis(new ItemStack(electrolysmCore.fluidStorage, 1, ironSul), pureIron);
        this.addElectrolisis(new ItemStack(electrolysmCore.fluidStorage, 1, goldSul), pureGold);
        this.addElectrolisis(new ItemStack(electrolysmCore.fluidStorage, 1, tinSul), pureTin);
        this.addElectrolisis(new ItemStack(electrolysmCore.fluidStorage, 1, leadSul), pureLead);
        this.addElectrolisis(new ItemStack(electrolysmCore.fluidStorage, 1, silverSul), pureSilver);
        
        for(int i = 0; i < CommonProxy.DUSTS.length; i++)
        {
        	ItemStack crystalStack = new ItemStack(electrolysmCore.crystal, 1, i);
        	ItemStack dustStack = new ItemStack(electrolysmCore.dusts, 4, i);
        	
        	this.addElectrolisis(crystalStack, dustStack);
        }
        //End
    }

    /**
     * Adds a smelting recipe.
     */
    public void addElectrolisis(ItemStack input, ItemStack output)
    {
        this.electrolysisMap.put(input, output);
    }

    public ItemStack getSmeltingResult(ItemStack item)
    {
        if (item != null)
        {
            ItemStack result = (ItemStack)this.electrolysisMap.get((item));

            if (result != null)
            {
                return result;
            }
        }

        return null;
    }

	public Map getSmeltingMap() {
		// TODO Auto-generated method stub
		return this.electrolysisMap;
	}
}