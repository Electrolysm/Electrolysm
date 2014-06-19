package electro.research.pointsSystem;

import electro.electrolysmCore;
import net.minecraft.init.Blocks;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.RecipesCrafting;
import net.minecraft.item.crafting.RecipesIngots;
import net.minecraft.item.crafting.RecipesMapCloning;
import net.minecraft.item.crafting.RecipesWeapons;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

public class ResearchPoint
{
    private static HashMap<String, String> vanillaMap = new HashMap<String, String>();
    
    //private static Point[] modMap = new Point[100000000];

    static 
    {
        //addPoints(new ItemStack(Blocks.coal_block), new EngPoint(10), new SciPoint(3));
        addPoints(new ItemStack(Items.coal), 20, 10);
        addPoints(new ItemStack(Blocks.stone), new EngPoint(1), new SciPoint(1));
        addPoints(new ItemStack(electrolysmCore.chunkGraphite), 15, 80);
        addPoints(new ItemStack(Blocks.log, 1, 0), 12, 3);
    }
    
    public static void addPoints(ItemStack stack, EngPoint engPoint, SciPoint sciPoint)
    {
        vanillaMap.put(stack.getUnlocalizedName(), (new Point(engPoint, sciPoint)).toString());
    }
    public static void addPoints(ItemStack stack, int engPoint, int sciPoint)
    {
        vanillaMap.put(stack.getUnlocalizedName(), (new Point(new EngPoint(engPoint), new SciPoint(sciPoint))).toString());
    }
    /*
    public static void addModPoints(ItemStack stack, EngPoint engPoint, SciPoint sciPoint)
    {
        modMap[stack.itemID] = (new Point(engPoint, sciPoint));
    }    */

    public static Point getPoints(ItemStack stack)
    {
        Point point = null;
        ItemStack result = null;
        System.out.println(stack.getDisplayName() + " : " + vanillaMap.get(stack.getUnlocalizedName()) + " : " + stack.getUnlocalizedName());
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

        if(getVanillaValue(stack) != null)
        {
            System.out.println("trueStack");
            return getVanillaValue(stack);
        }
        else {
            System.out.println("elseStack");
            for (int i = 0; i < recipes.size(); i++) {
                IRecipe iRecipe = recipes.get(i);

                if (iRecipe instanceof ShapedRecipes) {
                    ShapedRecipes shapeRecipe = (ShapedRecipes) iRecipe;
                    result = shapeRecipe.getRecipeOutput();

                    if (result.isItemEqual(stack)) {
                        point = getRecipePoints(shapeRecipe);
                    }
                } else if (iRecipe instanceof ShapelessRecipes) {
                    ShapelessRecipes shapelessRecipe = (ShapelessRecipes) iRecipe;
                    result = shapelessRecipe.getRecipeOutput();

                    if (result.isItemEqual(stack)) {
                        point = getRecipePoints(shapelessRecipe);
                    }
                }
            }
        }
        /*
        HashMap<List<Integer>, ItemStack> map = (HashMap<List<Integer>, ItemStack>) FurnaceRecipes.smelting().
                getSmeltingList();
        Set<List<Integer>> keySet = map.keySet();
        Object[] keys = keySet.toArray();
        
        for(int i = 0; i < keys.length; i++)
        {
            ItemStack keyStack = new ItemStack(Integer.parseInt(String.valueOf(keys[i])), 1, 0);
            if(FurnaceRecipes.smelting().getSmeltingResult(keyStack).isItemEqual(stack))
            {
                //return getFurnacePoints(keyStack);
            }
        }*/
        return divideByProducedSize(point, stack.stackSize);
    }

    private static Point divideByProducedSize(Point point, int stackSize)
    {
        int newEng = ((point.getEngPoint().getValue()) / stackSize);
        int newSci = ((point.getSciPoint().getValue()) / stackSize);

        return new Point(newEng, newSci);
    }

    private static Point getFurnacePoints(ItemStack input)
    {
        Point pointStack;
        
        if(getVanillaValue(input) != null)
        {
            pointStack = getVanillaValue(input);
        }
        else if(getElectroValue(input) != null)
        {
            pointStack = getElectroValue(input);
        }
        else
        {
            pointStack = getPoints(input);
        }
        if(pointStack != null)
        {
            return new Point(pointStack.getEngPoint(), new SciPoint(pointStack.getEngPoint().getValue() + 5));
        }
        else
        {
            return null;
        }
    }

    private static Point getRecipePoints(ShapelessRecipes shapelessRecipe)
    {
        ItemStack[] stack = new ItemStack[shapelessRecipe.getRecipeSize()];
        Point[] pointStack = new Point[stack.length];
        
        for(int i = 0; i < stack.length; i++)
        {
            stack[i] = (ItemStack)shapelessRecipe.recipeItems.get(i);
            
            if(getVanillaValue(stack[i]) != null)
            {
                pointStack[i] = getVanillaValue(stack[i]);
            }
            else if(getElectroValue(stack[i]) != null)
            {
                pointStack[i] = getElectroValue(stack[i]);
            }
            else
            {
                pointStack[i] = getPoints(stack[i]);
            }
        }
        int engValue = 0;
        int sciValue = 0;
        for(int i = 0; i < stack.length; i++)
        {
            engValue = engValue + pointStack[i].getEngPoint().getValue();
            sciValue = sciValue + pointStack[i].getSciPoint().getValue();
        }
        return new Point(new EngPoint(engValue), new SciPoint(sciValue));
    }

    private static Point getRecipePoints(ShapedRecipes shapeRecipe)
    {
        ItemStack[] stack = new ItemStack[shapeRecipe.getRecipeSize()];
        Point[] pointStack = new Point[stack.length];
        
        for(int i = 0; i < stack.length; i++)
        {
            stack[i] = shapeRecipe.recipeItems[i];
            
            if(getVanillaValue(stack[i]) != null)
            {
                pointStack[i] = getVanillaValue(stack[i]);
            }
            else if(getElectroValue(stack[i]) != null)
            {
                pointStack[i] = getElectroValue(stack[i]);
            }
            else
            {
                pointStack[i] = getPoints(stack[i]);
            }
        }
        
        int engValue = 0;
        int sciValue = 0;
        for(int i = 0; i < stack.length; i++)
        {
            engValue = engValue + pointStack[i].getEngPoint().getValue();
            sciValue = sciValue + pointStack[i].getSciPoint().getValue();
        }
        return new Point(new EngPoint(engValue), new SciPoint(sciValue));
    }

    private static Point getVanillaValue(ItemStack stack) 
    {
        return stringToPoint(vanillaMap.get(stack.getUnlocalizedName()));
    }

    private static Point stringToPoint(String pointString)
    {
        if(pointString != null) {
            String[] array = (String[]) pointString.split("--");
            int engPoint = Integer.parseInt(array[0]);
            int sciPoint = Integer.parseInt(array[1]);

            return new Point(engPoint, sciPoint);
        }
        else
        {
            return null;
        }
    }

    private static Point getElectroValue(ItemStack stack) 
    {
        //return modMap[stack.itemID];
        return null;
    }

    public static String getPointString(ItemStack itemStack)
    {
        Point map = getPoints(itemStack);
        String pointMessage;
        
        if(map != null)
        {
            pointMessage = "Engineering Points: " + map.getEngPoint().getValue() + " - Science Points: " + 
                        map.getSciPoint().getValue();
        }
        else
        {
            pointMessage = "Unknown Point";
        }
        return pointMessage;
    }
}