package electro.handlers.nei;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import electro.common.CommonProxy;
import electro.oreProccessing.gui.GUIElectrolysisCore;
import electro.oreProccessing.recipes.electrolisisRecipes;

public class ElectrolysisRecipeHander extends TemplateRecipeHandler {

	public class SmeltingPair extends CachedRecipe
    {
        public SmeltingPair(ItemStack inStack, ItemStack result)
        {
        	inStack.stackSize = 1;
            this.ingred = new PositionedStack(inStack, 46 + 3 + 2, 17 + 16 - 9);
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
    
        
        public class InjectorRecipeHandler extends TemplateRecipeHandler {
	
		public class SmeltingPair extends CachedRecipe
	    {
	        private PositionedStack ingredStack;
	        
			public SmeltingPair(ItemStack ingred, ItemStack ingred2, ItemStack result)
	        {
	            ingred.stackSize = 1;
	            ingred2.stackSize = 1;
	            this.ingred = new PositionedStack(ingred, 46 - 7, 17 + 16 - 9);
	            //this.ingredStack = new PositionedStack(ingred2, 20, 20);
	            this.result = new PositionedStack(result, 111, 24);
	        }
	        
	        public PositionedStack getIngredient()
	        {
	            int cycle = cycleticks / 48;
	            if(ingred.item.getItemDamage() == 0)
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
	        PositionedStack ingredStack2;
	        PositionedStack result;
	    }
	    
	        
	        public PositionedStack stack;
	        public int burnTime;
	    
	
	    @Override
	    public void loadTransferRects()
	    {
	        transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "electrolysing"));
	    }
	    
	    @Override
	    public Class<? extends GuiContainer> getGuiClass()
	    {
	        return GUIElectrolysisCore.class;
	    }
	    
	    @Override
	    public String getRecipeName()
	    {
	        return "electrolysing";
	    }
	    
	    @Override
	    public TemplateRecipeHandler newInstance()
	    {
	        return super.newInstance();
	    }
	
	    @Override
	    public void loadCraftingRecipes(String outputId, Object... results)
	    {
	        if(outputId.equals("electrolysing") && getClass() == InjectorRecipeHandler.class)//don't want subclasses getting a hold of this
	        {
	        	HashMap<List<Integer>, ItemStack> recipes = (HashMap<List<Integer>, ItemStack>) electrolisisRecipes.smelting().getSmeltingMap();
	            
	            for(Entry<List<Integer>, ItemStack> recipe : recipes.entrySet())
	            {
	                ItemStack item = recipe.getValue();
	                arecipes.add(new SmeltingPair(new ItemStack(recipe.getKey().indexOf(0), 1, 0), new ItemStack(recipe.getKey().indexOf(1), 1, 0), item));
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
        	HashMap<List<Integer>, ItemStack> recipes = (HashMap<List<Integer>, ItemStack>) electrolisisRecipes.smelting().getSmeltingMap();
	        
	        for(Entry<List<Integer>, ItemStack> recipe : recipes.entrySet())
	        {
	            ItemStack item = recipe.getValue();
	            if(NEIServerUtils.areStacksSameType(item, result))
	            {
	                arecipes.add(new SmeltingPair(new ItemStack(recipe.getKey().indexOf(0), 1, 0), new ItemStack(recipe.getKey().indexOf(1), 1, 0), item));
	            }
	        }
	    }
	    
	    @Override
	    public void loadUsageRecipes(String inputId, Object... ingredients)
	    {
	        if(inputId.equals("fuel") && getClass() == InjectorRecipeHandler.class)//don't want subclasses getting a hold of this
	        {
	            loadCraftingRecipes("electrolysing");
	        }
	        else
	        {
	            super.loadUsageRecipes(inputId, ingredients);
	        }
	    }
	    
	    @Override
	    public void loadUsageRecipes(ItemStack ingredient)
	    {
        	HashMap<List<Integer>, ItemStack> recipes = (HashMap<List<Integer>, ItemStack>) electrolisisRecipes.smelting().getSmeltingMap();
	        
	        for(Entry<List<Integer>, ItemStack> recipe : recipes.entrySet())
	        {
	            ItemStack item = recipe.getValue();
	            if(NEIServerUtils.areStacksSameType(item, ingredient))
	            {
	                arecipes.add(new SmeltingPair(new ItemStack(recipe.getKey().indexOf(0), 1, 0), new ItemStack(recipe.getKey().indexOf(1), 1, 0), item));
	            }
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
	        //drawProgressBar(64 - 5, 20 - 11, 0, 166, 90, 16, 90, 0);
	    }
	    
	    public String getOverlayIdentifier()
	    {
	        return "Electrolysis";
	    }
	    
	}


		public PositionedStack stack;
        public int burnTime;
    

    @Override
    public void loadTransferRects()
    {
        transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "electrolysing"));
        //transferRects.add(new RecipeTransferRect(new Rectangle(80, 80, 80, 80), "electrolysing"));

    }
    
    @Override
    public Class<? extends GuiContainer> getGuiClass()
    {
        return GUIElectrolysisCore.class;
    }
    
    @Override
    public String getRecipeName()
    {
        return "Electrolysis";
    }
    
    @Override
    public TemplateRecipeHandler newInstance()
    {
        return super.newInstance();
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if(outputId.equals("electrolysing") && getClass() == ElectrolysisRecipeHander.class)//don't want subclasses getting a hold of this
        {
        	HashMap<List<Integer>, ItemStack> recipes = (HashMap<List<Integer>, ItemStack>) electrolisisRecipes.smelting().getSmeltingMap();
            
            for(Entry<List<Integer>, ItemStack> recipe : recipes.entrySet())
            {
                ItemStack item = recipe.getValue();
                arecipes.add(new SmeltingPair(new ItemStack(recipe.getKey().get(0), 1, recipe.getKey().get(1)), item));
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
    	HashMap<List<Integer>, ItemStack> recipes = (HashMap<List<Integer>, ItemStack>) electrolisisRecipes.smelting().getSmeltingMap();
        
        for(Entry<List<Integer>, ItemStack> recipe : recipes.entrySet())
        {
            ItemStack item = recipe.getValue();
            if(NEIServerUtils.areStacksSameType(item, result))
            {
                arecipes.add(new SmeltingPair(new ItemStack(recipe.getKey().get(0), 1, recipe.getKey().get(1)), item));
            }
        }
    }
    
    @Override
    public void loadUsageRecipes(String inputId, Object... ingredients)
    {
        if(inputId.equals("fuel") && getClass() == ElectrolysisRecipeHander.class)//don't want subclasses getting a hold of this
        {
            loadCraftingRecipes("electrolysing");
        }
        else
        {
            super.loadUsageRecipes(inputId, ingredients);
        }
    }
    
    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
    	HashMap<List<Integer>, ItemStack> recipes = (HashMap<List<Integer>, ItemStack>) electrolisisRecipes.smelting().getSmeltingMap();
        
        for(Entry<List<Integer>, ItemStack> recipe : recipes.entrySet())
        {
            ItemStack item = recipe.getValue();
            if(NEIServerUtils.areStacksSameType(item, ingredient))
            {
                arecipes.add(new SmeltingPair(new ItemStack(recipe.getKey().get(0), 1, recipe.getKey().get(1)), item));
            }
        }
    }
    
    @Override
    public String getGuiTexture()
    {
        return CommonProxy.NEI_ELECTROL_GUI.toString();
    }

    @Override
    public void drawExtras(int recipe)
    {/**
        * @param x X position on screen
        * @param y Y position on screen
        * @param tx Texture X position
        * @param ty Texture Y position
        * @param w Texture width
        * @param h Texture height
        * @param ticks The amount of ticks for the bar to complete
        * @param direction 0 right, 1 down, 2 left, 3 up. If bit 3 is set the bar will shrink rather extend
         * */
    }
    
    @Override
    public String getOverlayIdentifier()
    {
        return "Electrolysis Chamber";
    }
    
    @Override
    public int recipiesPerPage()
    {
    	return 1;
    }
}
