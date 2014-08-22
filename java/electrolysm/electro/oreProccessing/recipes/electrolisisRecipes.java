package electrolysm.electro.oreProccessing.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import electrolysm.api.items.RecipeStack;
import electrolysm.electro.Electrolysm;
import net.minecraft.item.ItemStack;
import electrolysm.electro.common.CommonProxy;
import net.minecraftforge.oredict.OreDictionary;

public class electrolisisRecipes
{
    private static final electrolisisRecipes smeltingBase = new electrolisisRecipes();

    /** The list of smelting results. */
    private HashMap<RecipeStack, RecipeStack> electrolysisMap = new HashMap<RecipeStack, RecipeStack>();

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
        ItemStack pureCopper = new ItemStack(Electrolysm.dusts, 4, 0);
        ItemStack pureIron = new ItemStack(Electrolysm.dusts, 4, 2);
        ItemStack pureGold = new ItemStack(Electrolysm.dusts, 4, 3);
        ItemStack pureTin = new ItemStack(Electrolysm.dusts, 4, 1);
        ItemStack pureLead = new ItemStack(Electrolysm.dusts, 4, 5);
        ItemStack pureSilver = new ItemStack(Electrolysm.dusts, 4, 4);
        //Local MOD Recipes
        this.addElectrolisis(new ItemStack(Electrolysm.fluidStorage, 1, copperSul), pureCopper);
        this.addElectrolisis(new ItemStack(Electrolysm.fluidStorage, 1, ironSul), pureIron);
        this.addElectrolisis(new ItemStack(Electrolysm.fluidStorage, 1, goldSul), pureGold);
        this.addElectrolisis(new ItemStack(Electrolysm.fluidStorage, 1, tinSul), pureTin);
        this.addElectrolisis(new ItemStack(Electrolysm.fluidStorage, 1, leadSul), pureLead);
        this.addElectrolisis(new ItemStack(Electrolysm.fluidStorage, 1, silverSul), pureSilver);
        
        for(int i = 0; i < CommonProxy.DUSTS.length; i++)
        {
        	ItemStack crystalStack = new ItemStack(Electrolysm.crystal, 1, i);
        	ItemStack dustStack = new ItemStack(Electrolysm.dusts, 4, i);
        	
        	this.addElectrolisis(crystalStack, dustStack);
        }

        List<ItemStack> aluminiumOre = OreDictionary.getOres("oreAluminium");
        for(int i = 0; i < aluminiumOre.size(); i++) {
            this.addElectrolisis(aluminiumOre.get(i), new ItemStack(Electrolysm.aluminiumIngot));
        }

        ArrayList<ItemStack> copper = OreDictionary.getOres("ingotCopper");
        for(int i = 0; i < copper.size(); i++) {
            this.addElectrolisis(copper.get(i), new ItemStack(Electrolysm.pureCopperIngot));
        }
        //End
    }

    /**
     * Adds a smelting recipe.
     */
    public void addElectrolisis(ItemStack input, ItemStack output)
    {
        this.electrolysisMap.put(new RecipeStack(input), new RecipeStack(output));
    }

    public ItemStack getSmeltingResult(ItemStack item)
    {
        if (item != null)
        {
            RecipeStack result = this.electrolysisMap.get(new RecipeStack(item));

            if (result != null)
            {
                return result.getStackValue();
            }
        }

        return null;
    }

	public HashMap<RecipeStack, RecipeStack> getSmeltingMap() {
		return this.electrolysisMap;
	}
}