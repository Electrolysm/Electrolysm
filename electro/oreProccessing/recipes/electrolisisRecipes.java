package assets.electrolysm.electro.oreProccessing.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

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
        this.addElectrolisis(copperSul, pureCopper);
        this.addElectrolisis(ironSul, pureIron);
        this.addElectrolisis(goldSul, pureGold);
        this.addElectrolisis(tinSul, pureTin);
        this.addElectrolisis(leadSul, pureLead);
        this.addElectrolisis(silverSul, pureSilver);
        //Ore Dictionary Recipes
        //OreDictionary.getOres("");
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