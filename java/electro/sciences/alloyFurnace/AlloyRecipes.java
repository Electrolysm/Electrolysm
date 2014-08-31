package electro.sciences.alloyFurnace;

import electrolysm.api.items.RecipeStack;
import electro.Electrolysm;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ben on 15/07/2014.
 */
public class AlloyRecipes
{
    private HashMap<List<RecipeStack>, RecipeStack> listRecipeStackHashMap = new HashMap<List<RecipeStack>, RecipeStack>();
    private HashMap<RecipeStack, RecipeStack> reduceMap = new HashMap<RecipeStack, RecipeStack>();

    public static AlloyRecipes smelting() { return new AlloyRecipes(); }

    public AlloyRecipes()
    {
        this.addAlloyRecipe(new ItemStack(Items.coal), new ItemStack(Items.iron_ingot), new ItemStack(Electrolysm.steel));
        this.addAlloyRecipe(new ItemStack(Blocks.coal_block), new ItemStack(Blocks.iron_block), new ItemStack(Electrolysm.steelBlock));
        this.addAlloyRecipe(new ItemStack(Electrolysm.copperIngot, 3), new ItemStack(Electrolysm.ingots, 1, 0), new ItemStack(Electrolysm.bronze));
    }

    public void addAlloyRecipe(ItemStack input1, ItemStack input2, ItemStack output)
    {
        List<RecipeStack> list = Arrays.asList(new RecipeStack(input1), new RecipeStack(input2));
        listRecipeStackHashMap.put(list, new RecipeStack(output));
        reduceMap.put(new RecipeStack(input1), new RecipeStack(input1));
        reduceMap.put(new RecipeStack(input2), new RecipeStack(input2));
    }

    public ItemStack getResult(ItemStack in1, ItemStack in2)
    {
        if(in1 == null || in2 == null) { return null; }

        RecipeStack stack = listRecipeStackHashMap.get(Arrays.asList(new RecipeStack(in1), new RecipeStack(in2)));

        if(stack != null) {
            return stack.getStackValue();
        }
        else
        {
            return null;
        }
    }

    public int getStackReduceAmount(ItemStack stack)
    {
        RecipeStack recipeStack = reduceMap.get(new RecipeStack(stack));
        if(recipeStack != null)
        {
            return recipeStack.getStackValue().stackSize;
        }

        return 0;
    }

    public HashMap<List<RecipeStack>, RecipeStack> getMap()
    {
        return listRecipeStackHashMap;
    }
}
