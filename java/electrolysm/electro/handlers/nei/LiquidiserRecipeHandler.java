package electrolysm.electro.handlers.nei;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import electrolysm.api.items.RecipeStack;
import electrolysm.electro.oreProccessing.gui.GUICrusher;
import electrolysm.electro.oreProccessing.recipes.LiquidiserRecipes;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import electrolysm.electro.common.CommonProxy;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class LiquidiserRecipeHandler extends TemplateRecipeHandler
{
    private EntityPlayer player;

    public class SmeltingPair extends CachedRecipe
    {
        public SmeltingPair(ItemStack ingred, ItemStack result)
        {
            ingred.stackSize = 1;
            this.ingred = new PositionedStack(ingred, 75 , 15 - 16 + 3);
            this.result = new PositionedStack(result, 75, 50 + 1 - 2);
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
                while(NEIClientUtils.canItemFitInInventory(player, stack.item));

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
        transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "liquidising"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass()
    {
        return GUICrusher.class;
    }

    @Override
    public String getRecipeName()
    {
        return "liquidising";
    }

    @Override
    public TemplateRecipeHandler newInstance()
    {
        return super.newInstance();
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if(outputId.equals("liquidising") && getClass() == LiquidiserRecipeHandler.class)//don't want subclasses getting a hold of this
        {
            HashMap<List<RecipeStack>, RecipeStack> recipes = (HashMap<List<RecipeStack>, RecipeStack>) LiquidiserRecipes.liquidising().getLiquidsMap();

            for(Entry<List<RecipeStack>, RecipeStack> recipe : recipes.entrySet())
            {
                ItemStack item = recipe.getValue().getStackValue();
                arecipes.add(new SmeltingPair(recipe.getKey().get(0).getStackValue(), item));
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
        HashMap<List<RecipeStack>, RecipeStack> recipes = (HashMap<List<RecipeStack>, RecipeStack>) LiquidiserRecipes.liquidising().getLiquidsMap();

        for(Entry<List<RecipeStack>, RecipeStack> recipe : recipes.entrySet())
        {
            ItemStack item = recipe.getValue().getStackValue();
            if(NEIServerUtils.areStacksSameType(item, result))
            {
                arecipes.add(new SmeltingPair(recipe.getKey().get(0).getStackValue(), item));
            }
        }
    }

    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients)
    {
        if(inputId.equals("fuel") && this.getClass() == LiquidiserRecipeHandler.class)//don't want subclasses getting a hold of this
        {
            loadCraftingRecipes("liquidising");
        }
        else
        {
            super.loadUsageRecipes(inputId, ingredients);
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
        HashMap<List<RecipeStack>, RecipeStack> recipes = (HashMap<List<RecipeStack>, RecipeStack>) LiquidiserRecipes.liquidising().getLiquidsMap();

        for(Entry<List<RecipeStack>, RecipeStack> recipe : recipes.entrySet())
        {
            ItemStack item = recipe.getValue().getStackValue();
            if(ingredient == recipe.getKey().get(0).getStackValue())
            {
                arecipes.add(new SmeltingPair(ingredient, item));
            }
        }
    }

    @Override
    public String getGuiTexture()
    {
        return CommonProxy.LIQUIDISER_GUI.toString();
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
        return "Displacement Chamber";
    }

}