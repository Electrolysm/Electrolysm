package electro.handlers.nei;

import api.items.RecipeStack;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import electro.research.machines.gui.GUIWorkBench;
import electro.common.CommonProxy;
import electro.research.crafting.ResearchCraftingHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ben on 12/07/2014.
 */
public class ResearchRecipeHandler extends TemplateRecipeHandler
{
    private EntityPlayer player;

    public class SmeltingPair extends TemplateRecipeHandler.CachedRecipe
    {
        public SmeltingPair(java.util.List<RecipeStack> in, ItemStack result)
        {
            for(int i = 0; i < in.size(); i++) {
                this.ingred[i] = new PositionedStack((in.get(i)).getStackValue(), 46 + 5, 17 + 16 - 9);
            }
            this.result = new PositionedStack(result, 111, 24);
        }

        public PositionedStack getIngredient()
        {
            for(int i = 0; i < ingred.length; i++) {
                int cycle = cycleticks / 48;
                if (ingred[i].item.getItemDamage() == -1) {
                    PositionedStack stack = ingred[i].copy();
                    int maxDamage = 0;
                    do {
                        maxDamage++;
                        stack.item.setItemDamage(maxDamage);
                    }
                    while (NEIClientUtils.canItemFitInInventory(player, stack.item));

                    stack.item.setItemDamage(cycle % maxDamage);
                    return stack;
                }
                return ingred[i];
            }

            return ingred[0];
        }

        public PositionedStack getResult()
        {
            return result;
        }


        PositionedStack[] ingred;
        PositionedStack result;
    }


    public PositionedStack stack;
    public int burnTime;


    @Override
    public void loadTransferRects()
    {
        transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(74, 23, 24, 18), "researchCrafting"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass()
    {
        return GUIWorkBench.class;
    }

    @Override
    public String getRecipeName()
    {
        return "researchCrafting";
    }

    @Override
    public TemplateRecipeHandler newInstance()
    {
        return super.newInstance();
    }

    //@Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if(outputId.equals("researchCrafting") && getClass() == ResearchRecipeHandler.class)//don't want subclasses getting a hold of this
        {
            HashMap<List<RecipeStack>, RecipeStack> recipes = ResearchCraftingHandler.getResultMap();

            for(Map.Entry<java.util.List<RecipeStack>, RecipeStack> recipe : recipes.entrySet())
            {
                ItemStack item = recipe.getValue().getStackValue();
                arecipes.add(new SmeltingPair(recipe.getKey(), item));
            }
        }
        else
        {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    //@Override
    public void loadCraftingRecipes(ItemStack result)
    {
        HashMap<List<RecipeStack>, RecipeStack> recipes = (HashMap< List<RecipeStack>, RecipeStack>) ResearchCraftingHandler.getResultMap();

        for(Map.Entry<List<RecipeStack>, RecipeStack> recipe : recipes.entrySet())
        {
            ItemStack item = recipe.getValue().getStackValue();
            if(NEIServerUtils.areStacksSameType(item, result))
            {
                arecipes.add(new SmeltingPair(recipe.getKey(), item));
            }
        }
    }

    //@Override
    public void loadUsageRecipes(String inputId, Object... ingredients)
    {
        if(inputId.equals("fuel") && this.getClass() == ResearchRecipeHandler.class)//don't want subclasses getting a hold of this
        {
            loadCraftingRecipes("researchCrafting");
        }
        else
        {
            super.loadUsageRecipes(inputId, ingredients);
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
        HashMap<List<RecipeStack>, RecipeStack> recipes =  ResearchCraftingHandler.getResultMap();

        for(Map.Entry<List<RecipeStack>, RecipeStack> recipe : recipes.entrySet())
        {
            for(int i = 0; i < recipe.getKey().size(); i++)
            {
                ItemStack item = recipe.getValue().getStackValue();
                if (ingredient == recipe.getKey().get(i).getStackValue())
                {
                    arecipes.add(new SmeltingPair(recipe.getKey(), item));
                }
            }
        }
    }

    @Override
    public String getGuiTexture()
    {
        return CommonProxy.WORK_BENCH_GUI.toString();
    }

    @Override
    public void drawExtras(int recipe)
    {
        //drawProgressBar(51, 25, 176, 0, 14, 14, 48, 7);
        //drawProgressBar(64 - 5, 20 - 11, 176, 0, 46, 46, 48, 0);
    }

    @Override
    public String getOverlayIdentifier()
    {
        return "researchCrafting";
    }
}
