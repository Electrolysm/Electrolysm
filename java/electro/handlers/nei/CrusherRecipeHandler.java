package electro.handlers.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeSet;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import electro.common.CommonProxy;
import assets.electrolysm.electro.oreProccessing.gui.GUICrusher;
import assets.electrolysm.electro.oreProccessing.recipes.CrusherRecipes;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class CrusherRecipeHandler extends TemplateRecipeHandler
{
    public class SmeltingPair extends CachedRecipe
    {
        public SmeltingPair(ItemStack ingred, ItemStack result)
        {
            ingred.stackSize = 1;
            this.ingred = new PositionedStack(ingred, 46 - 7, 17 + 16 - 9);
            this.result = new PositionedStack(result, 111, 24);
        }
        
        public PositionedStack getIngredient()
        {
            int cycle = cycleticks / 48;
            if(ingred.item.getItemDamage() == -1)
            {
                PositionedStack stack = ingred.copy();
                int maxDamage = 0;
                do
                {
                    maxDamage++;
                    stack.item.setItemDamage(maxDamage);
                }
                while(NEIClientUtils.isValidItem(stack.item));
                
                stack.item.setItemDamage(cycle % maxDamage);
                return stack;
            }
            return ingred;
        }
        
        public PositionedStack getResult()
        {
            return result;
        }
        
        
        PositionedStack ingred;
        PositionedStack result;
    }
    
        
        public PositionedStack stack;
        public int burnTime;
    

    @Override
    public void loadTransferRects()
    {
        transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "crushing"));
    }
    
    @Override
    public Class<? extends GuiContainer> getGuiClass()
    {
        return GUICrusher.class;
    }
    
    @Override
    public String getRecipeName()
    {
        return "Crushing";
    }
    
    @Override
    public TemplateRecipeHandler newInstance()
    {
        return super.newInstance();
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if(outputId.equals("crushing") && getClass() == CrusherRecipeHandler.class)//don't want subclasses getting a hold of this
        {
            HashMap<Integer, ItemStack> recipes = (HashMap<Integer, ItemStack>) CrusherRecipes.smelting().getCrushingMap();
            
            for(Entry<Integer, ItemStack> recipe : recipes.entrySet())
            {
                ItemStack item = recipe.getValue();
                arecipes.add(new SmeltingPair(new ItemStack(recipe.getKey(), 1, -1), item));
            }
        }
        else
        {
            super.loadCraftingRecipes(outputId, results);
        }
    }
    
    @Override
    public void loadCraftingRecipes(ItemStack result)
    {
        HashMap<Integer, ItemStack> recipes = (HashMap<Integer, ItemStack>) CrusherRecipes.smelting().getCrushingMap();
        
        for(Entry<Integer, ItemStack> recipe : recipes.entrySet())
        {
            ItemStack item = recipe.getValue();
            if(NEIServerUtils.areStacksSameType(item, result))
            {
                arecipes.add(new SmeltingPair(new ItemStack(recipe.getKey(), 1, -1), item));
            }
        }
    }
    
    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients)
    {
        if(inputId.equals("fuel") && getClass() == CrusherRecipeHandler.class)//don't want subclasses getting a hold of this
        {
            loadCraftingRecipes("crushing");
        }
        else
        {
            super.loadUsageRecipes(inputId, ingredients);
        }
    }
    
    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
        HashMap<Integer, ItemStack> recipes = (HashMap<Integer, ItemStack>) CrusherRecipes.smelting().getCrushingMap();
        
        for(Entry<Integer, ItemStack> recipe : recipes.entrySet())
        {
            ItemStack item = recipe.getValue();
            if(ingredient.itemID == recipe.getKey())
            {
                arecipes.add(new SmeltingPair(ingredient, item));
            }
        }
    }
    
    @Override
    public String getGuiTexture()
    {
        return CommonProxy.CRUSHER_GUI.toString();
    }

    @Override
    public void drawExtras(int recipe)
    {
        //drawProgressBar(51, 25, 176, 0, 14, 14, 48, 7);
        drawProgressBar(64 - 5, 20 - 11, 176, 0, 46, 46, 48, 0);
    }
    
    @Override
    public String getOverlayIdentifier()
    {
        return "Crusher";
    }
    
}
