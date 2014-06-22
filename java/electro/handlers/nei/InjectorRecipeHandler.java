/*package electro.handlers.nei;

import java.awt.Rectangle;
import java.util.*;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import electro.block.advMachines.gui.GUIInjector;
import electro.common.CommonProxy;
import electro.crafting.InjectorRecipes;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class InjectorRecipeHandler extends TemplateRecipeHandler {

    private EntityPlayer player;

	public class SmeltingPair extends CachedRecipe
    {
        public SmeltingPair(ItemStack inStack, ItemStack input2, ItemStack result)
        {
        	inStack.stackSize = 1;
        	input2.stackSize = 1;
            this.inStack = new PositionedStack(inStack, 49 + 2, 24 - 16 - 2);
            this.input2 = new PositionedStack(input2, 46 + 3 + 2, 17 - 10 + 16 + 16 + 2);// - +
            this.result = new PositionedStack(result, 111, 24);
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
        transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "Injecting"));
    }
    
    @Override
    public Class<? extends GuiContainer> getGuiClass()
    {
        return GUIInjector.class;
    }
    
    @Override
    public String getRecipeName()
    {
        return "Injecting";
    }
    
    @Override
    public TemplateRecipeHandler newInstance()
    {
        return super.newInstance();
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if(outputId.equals("Injecting") && getClass() == InjectorRecipeHandler.class)//don't want subclasses getting a hold of this
        {
        	HashMap<List<ItemStack>, ItemStack> recipes = (HashMap<List<ItemStack>, ItemStack>) InjectorRecipes.smelting().getInjectorMap();
        	//HashMap<List<Integer>, ItemStack> recipesMeta = (HashMap<List<Integer>, ItemStack>) InjectorRecipes.smelting().getInjectorMapMeta();

            for(Map.Entry<List<ItemStack>, ItemStack> recipe : recipes.entrySet())
            {
                ItemStack bottom = recipe.getKey().get(0);
                ItemStack top = recipe.getKey().get(1);
                ItemStack result = recipes.get(Arrays.asList(bottom, top));
                arecipes.add(new SmeltingPair(bottom, top, result));
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
        HashMap<List<ItemStack>, ItemStack> recipes = (HashMap<List<ItemStack>, ItemStack>) InjectorRecipes.smelting().getInjectorMap();
        //HashMap<List<Integer>, ItemStack> recipesMeta = (HashMap<List<Integer>, ItemStack>) InjectorRecipes.smelting().getInjectorMapMeta();

        for(Map.Entry<List<ItemStack>, ItemStack> recipe : recipes.entrySet()) {
            ItemStack bottom = recipe.getKey().get(0);
            ItemStack top = recipe.getKey().get(1);
            ItemStack output = recipes.get(Arrays.asList(bottom, top));

            if (NEIServerUtils.areStacksSameType(output, result)) {
                arecipes.add(new SmeltingPair(bottom, top, output));
            }
        }
    }
    
    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients)
    {
        if(inputId.equals("fuel") && getClass() == InjectorRecipeHandler.class)//don't want subclasses getting a hold of this
        {
            loadCraftingRecipes("Injecting");
        }
        else
        {
            super.loadUsageRecipes(inputId, ingredients);
        }
    }
    
    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
        HashMap<List<ItemStack>, ItemStack> recipes = (HashMap<List<ItemStack>, ItemStack>) InjectorRecipes.smelting().getInjectorMap();
        //HashMap<List<Integer>, ItemStack> recipesMeta = (HashMap<List<Integer>, ItemStack>) InjectorRecipes.smelting().getInjectorMapMeta();

        for(Map.Entry<List<ItemStack>, ItemStack> recipe : recipes.entrySet())
        {
            ItemStack bottom = recipe.getKey().get(0);
            ItemStack top = recipe.getKey().get(1);
            ItemStack output = recipes.get(Arrays.asList(bottom, top));

            if(NEIServerUtils.areStacksSameType(bottom, ingredient) || NEIServerUtils.areStacksSameType(top, ingredient))
            arecipes.add(new SmeltingPair(bottom, top, output));
        }
    }
    
    @Override
    public String getGuiTexture()
    {
        return CommonProxy.INJECTOR_GUI.toString();
    }

    @Override
    public void drawExtras(int recipe)
    {
        //drawProgressBar(51, 25, 176, 0, 14, 14, 48, 7);
        drawProgressBar(64 - 5, 20 - 11, 0, 166, 90, 16, 90, 0);
    }
    
    public String getOverlayIdentifier()
    {
        return "Injector";
    }
    
}*/
