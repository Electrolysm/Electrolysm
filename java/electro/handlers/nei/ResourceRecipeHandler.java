package electro.handlers.nei;

import java.awt.Rectangle;
import java.util.*;

import codechicken.nei.NEIServerUtils;
import electro.handlers.helpers.BlockResource;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import electro.common.CommonProxy;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class ResourceRecipeHandler extends TemplateRecipeHandler {

    private EntityPlayer player;

    public class SmeltingPair extends CachedRecipe
    {
        public SmeltingPair(ItemStack inStack)
        {
            inStack.stackSize = 1;
            this.inStack = new PositionedStack(inStack, 49 + 8 + 18, 26);
        }

        @Override
        public List<PositionedStack> getIngredients()
        {
            int cycle = cycleticks / 48;
            if(inStack.item.getItemDamage() == -1)
            {
                PositionedStack stack = inStack.copy();
                int maxDamage = 0;
                do
                {
                    maxDamage++;
                    stack.item.setItemDamage(maxDamage);
                }
                while(NEIClientUtils.canItemFitInInventory(player, stack.item));
                {
                    stack.item.setItemDamage(cycle % maxDamage);

                    List<PositionedStack> list = new ArrayList<PositionedStack>();
                    list.add(0, stack);
                    return list;
                }
            }
            List<PositionedStack> list = new ArrayList<PositionedStack>();
            list.add(0, inStack);
            return list;
        }

        @Override
        public PositionedStack getResult()
        {
            return inStack;
        }

        PositionedStack inStack;
    }


    public PositionedStack stack;
    public int burnTime;


    @Override
    public void loadTransferRects()
    {
        //transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "Resource"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass()
    {
        return NEIResourceGUI.class;
    }

    @Override
    public String getRecipeName()
    {
        return "Resource";
    }

    @Override
    public TemplateRecipeHandler newInstance()
    {
        return super.newInstance();
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if(outputId.equals("Resource") && getClass() == ResourceRecipeHandler.class)//don't want subclasses getting a hold of this
        {
            List<ItemStack> list = BlockResource.getResourceList();

            for(int i = 0; i < list.size(); i++)
            {
                arecipes.add(new SmeltingPair(list.get(i)));
            }
        }
        else
        {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result)
    {/*
        List<ItemStack> list = BlockResource.getResourceList();

        for(int i = 0; i < list.size(); i++)
        {
            if (NEIServerUtils.areStacksSameType(list.get(i), result)) {
                arecipes.add(new SmeltingPair(list.get(i)));
            }
        }*/
    }

    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients)
    {
        if(inputId.equals("fuel") && getClass() == ResourceRecipeHandler.class)//don't want subclasses getting a hold of this
        {
            loadCraftingRecipes("Resource");
        }
        else
        {
            super.loadUsageRecipes(inputId, ingredients);
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
        List<ItemStack> list = BlockResource.getResourceList();

        for(int i = 0; i < list.size(); i++)
        {
            if(NEIServerUtils.areStacksSameType(list.get(i), ingredient)) {
                arecipes.add(new SmeltingPair(list.get(i)));
            }
        }
    }

    @Override
    public String getGuiTexture()
    {
        return CommonProxy.RESOURCE_GUI_NEI.toString();
    }

    @Override
    public void drawExtras(int recipe)
    {

        //drawProgressBar(51, 25, 176, 0, 14, 14, 48, 7);
        //drawProgressBar(64 - 5, 20 - 11, 0, 166, 90, 16, 90, 0);
    }

    public String getOverlayIdentifier()
    {
        return "Resources";
    }

}
