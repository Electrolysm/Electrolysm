package electro.research.crafting;

import api.items.RecipeStack;
import electro.handlers.helpers.RecipeRegistry;
import electro.research.ResearchRecipes;
import electro.research.system.Research;
import electro.research.system.ResearchRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ben on 12/07/2014.
 */
public class ResearchCraftingHandler
{
    public HashMap<List<RecipeStack>, String> ShapedResearchMap = new HashMap<List<RecipeStack>, String>();
    public HashMap<List<RecipeStack>, RecipeStack> ShapedResultMap = new HashMap<List<RecipeStack>, RecipeStack>();

    public ResearchCraftingHandler(boolean getting)
    {
        addRecipe(ResearchRegistry.getResearch("improved_coal"), new ItemStack(Items.coal, 2),
                new Object[]{
                        "XXX", "XXY", "XXX",
                        Character.valueOf('X'), Items.iron_ingot,
                        Character.valueOf('Y'), Items.gold_ingot});
    }

    public static HashMap<List<RecipeStack>, RecipeStack> getResultMap()
    {
        return new ResearchCraftingHandler().ShapedResultMap;
    }

    public ResearchCraftingHandler() { }

    private void addRecipes(List<RecipeStack> list, Research research)
    {
        ShapedResearchMap.put(list, research.toAdvString());
    }

    private void addRecipes(List<RecipeStack> list, RecipeStack result)
    {
        ShapedResultMap.put(list, result);
    }

    public Research getResearch(ItemStack[] stacks)
    {
        if(stacks == null) { return null; }

        RecipeStack[] recipeStacks = new RecipeStack[stacks.length];
        for(int i = 0; i < stacks.length; i++)
        {
            recipeStacks[i] = new RecipeStack(stacks[i]);
        }

        if(ShapedResearchMap.get(Arrays.asList(recipeStacks)) != null)
        {
            return ResearchRegistry.getResearchFromString(ShapedResearchMap.get(Arrays.asList(recipeStacks)));
        }

        return null;
    }

    public ItemStack getResult(ItemStack[] stacks)
    {
        if(stacks == null) { return null; }

        RecipeStack[] recipeStacks = new RecipeStack[stacks.length];
        for(int i = 0; i < stacks.length; i++)
        {
            recipeStacks[i] = new RecipeStack(stacks[i]);
        }
        //System.out.println(ShapedResultMap);

        if(ShapedResultMap.get(Arrays.asList(recipeStacks)) == null) { return null; }

        return ShapedResultMap.get(Arrays.asList(recipeStacks)).getStackValue();
    }

    private void addShapedRecipe(Research research, ItemStack result, Object... objects) throws Exception
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (objects[i] instanceof String[])
        {
            String[] astring = (String[])((String[])objects[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (objects[i] instanceof String)
            {
                String s2 = (String)objects[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < objects.length; i += 2)
        {
            Character character = (Character)objects[i];
            ItemStack itemstack1 = null;

            if (objects[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)objects[i + 1]);
            }
            else if (objects[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)objects[i + 1], 1, 32767);
            }
            else if (objects[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)objects[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        RecipeStack[] aitemstack = new RecipeStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = new RecipeStack(((ItemStack)hashmap.get(Character.valueOf(c0))));
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        ShapedResearchRecipe recipe = new ShapedResearchRecipe(aitemstack, result, research);
        this.addRecipes(Arrays.asList(aitemstack), research);
        this.addRecipes(Arrays.asList(aitemstack), new RecipeStack(result));

        //ShapedResultMap.put(Arrays.asList(aitemstack), new RecipeStack(result));
        //System.out.println(Arrays.asList(aitemstack) + " : " + research + " : " + result.getDisplayName());
    }

    public void addRecipe(Research research, ItemStack result, Object... objects)
    {
        try
        {
            addShapedRecipe(research, result, objects);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
