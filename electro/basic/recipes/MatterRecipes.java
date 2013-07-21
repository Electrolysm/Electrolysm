package mods.Electrolysm.electro.basic.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MatterRecipes
{
    private static final MatterRecipes smeltingBase = new MatterRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final MatterRecipes smelting()
    {
        return smeltingBase;
    }

    private MatterRecipes()
    {
/*
* ===========================================================================================================
* 										Recipes
* ===========================================================================================================
*/
        this.addMatterCreation(Item.diamond.itemID, new ItemStack(electrolysmCore.hiddenDust), 10F);
        this.addMatterCreation(Block.blockDiamond.blockID, new ItemStack(electrolysmCore.hiddenDust, 5), 10F);
        this.addMatterCreation(Block.blockGold.blockID, new ItemStack(electrolysmCore.hiddenDust), 10F);
        this.addMatterCreation(Block.blockEmerald.blockID, new ItemStack(electrolysmCore.hiddenDust, 10), 20F);
        this.addMatterCreation(Item.emerald.itemID, new ItemStack(electrolysmCore.hiddenDust, 2), 10F);
        
        this.addMatterCreation2(new ItemStack(electrolysmCore.tibetanSilver,  4), new ItemStack(electrolysmCore.hiddenDust), 1F);
 
/*
 * ====================================================================================================================
 */
    }

    /**
     * Adds a smelting recipe.
     */
    public void addMatterCreation(int Input, ItemStack Output, float experience)
    {
        this.smeltingList.put(Integer.valueOf(Input), Output);
        this.experienceList.put(Integer.valueOf(Output.itemID), Float.valueOf(experience));
    }
    
    public void addMatterCreation2(ItemStack Input, ItemStack Output, float experience)
    {
        this.smeltingList.put(Integer.valueOf(Input.itemID), Output);
        this.experienceList.put(Integer.valueOf(Output.itemID), Float.valueOf(experience));
    }
    
    public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(Integer.valueOf(item.itemID));
    }
}