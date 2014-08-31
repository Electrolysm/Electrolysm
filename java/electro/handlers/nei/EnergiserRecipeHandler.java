package electro.handlers.nei;

import electrolysm.api.items.RecipeStack;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import electro.common.CommonProxy;
import electro.machines.advMachines.gui.GUIEnergiser;
import electro.misc.crafting.EnergiserRecipes;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Clarky158 on 05/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class EnergiserRecipeHandler extends TemplateRecipeHandler
{
    private EntityPlayer player;

    public class SmeltingPair extends CachedRecipe
    {
        public SmeltingPair(ItemStack ingred, ItemStack ingred1, ItemStack result)
        {
            this.inStack = new PositionedStack(ingred, 46 + 15, 24 + 1 - 16 - 3);
            this.input2 = new PositionedStack(ingred1, 46 + 15, 24 + 17);
            this.result = new PositionedStack(result, 127, 24);
        }

        @Override
        public List<PositionedStack> getIngredients()
        {
            int cycle = cycleticks / 48;
            if(inStack.item.getItemDamage() == -1 || input2.item.getItemDamage() == -1)
            {
                PositionedStack stack = inStack.copy();
                PositionedStack stack2 = input2.copy();
                int maxDamage = 0;
                do
                {
                    maxDamage++;
                    stack.item.setItemDamage(maxDamage);
                    stack2.item.setItemDamage(maxDamage);
                }
                while(NEIClientUtils.canItemFitInInventory(player, stack.item));
                {
                    stack.item.setItemDamage(cycle % maxDamage);
                    stack2.item.setItemDamage(cycle % maxDamage);

                    List<PositionedStack> list = new ArrayList<PositionedStack>();
                    list.add(0, stack);
                    list.add(1, stack2);
                    return list;
                }
            }
            List<PositionedStack> list = new ArrayList<PositionedStack>();
            list.add(0, inStack);
            list.add(1, input2);
            return list;
        }

        public PositionedStack getResult()
        {
            return result;
        }


        PositionedStack inStack;
        PositionedStack input2;
        PositionedStack result;
    }


    public PositionedStack stack;
    public int burnTime;


    @Override
    public void loadTransferRects()
    {
        transferRects.add(new RecipeTransferRect(new Rectangle(74, 23 + 12, 24, 16), "energising"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass()
    {
        return GUIEnergiser.class;
    }

    @Override
    public String getRecipeName()
    {
        return "Energiser";
    }

    @Override
    public TemplateRecipeHandler newInstance()
    {
        return super.newInstance();
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if(outputId.equals("energising") && getClass() == EnergiserRecipeHandler.class)//don't want subclasses getting a hold of this
        {
            HashMap<List<RecipeStack>, RecipeStack> recipes = EnergiserRecipes.smelting().getMap();

            for(Map.Entry<List<RecipeStack>, RecipeStack> recipe : recipes.entrySet())
            {
                ItemStack item = recipe.getValue().getStackValue();
                arecipes.add(new SmeltingPair(recipe.getKey().get(0).getStackValue(), recipe.getKey().get(1).getStackValue(), item));
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
        HashMap<List<RecipeStack>, RecipeStack> recipes = EnergiserRecipes.smelting().getMap();

        for(Map.Entry<List<RecipeStack>, RecipeStack> recipe : recipes.entrySet())
        {
            ItemStack item = recipe.getValue().getStackValue();
            if(NEIServerUtils.areStacksSameType(item, result))
            {
                arecipes.add(new SmeltingPair(recipe.getKey().get(0).getStackValue(), recipe.getKey().get(1).getStackValue(), item));
            }
        }
    }

    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients)
    {
        if(inputId.equals("fuel") && getClass() == EnergiserRecipeHandler.class)//don't want subclasses getting a hold of this
        {
            loadCraftingRecipes("energising");
        }
        else
        {
            super.loadUsageRecipes(inputId, ingredients);
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
        HashMap<List<RecipeStack>, RecipeStack> recipes = EnergiserRecipes.smelting().getMap();

        for(Map.Entry<List<RecipeStack>, RecipeStack> recipe : recipes.entrySet())
        {
            ItemStack item = recipe.getValue().getStackValue();
            if(ingredient == recipe.getKey().get(0).getStackValue() || ingredient == recipe.getKey().get(1).getStackValue())
            {
                arecipes.add(new SmeltingPair(recipe.getKey().get(0).getStackValue(), recipe.getKey().get(1).getStackValue(), item));
            }
        }
    }

    @Override
    public String getGuiTexture()
    {
        return CommonProxy.ENERGISER_GUI.toString();
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
        return "Energiser";
    }

}
