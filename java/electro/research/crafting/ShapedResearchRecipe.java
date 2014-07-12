package electro.research.crafting;

import api.items.RecipeStack;
import electro.research.system.Research;
import net.minecraft.item.ItemStack;

/**
 * Created by Ben on 12/07/2014.
 */
public class ShapedResearchRecipe
{
    public RecipeStack[] recipeItems;
    public ItemStack result;
    public Research research;

    public ShapedResearchRecipe(RecipeStack[] recipeItems, ItemStack resutl, Research research)
    {
        this.recipeItems = recipeItems;
        this.research = research;
        this.result = resutl;
    }
}
