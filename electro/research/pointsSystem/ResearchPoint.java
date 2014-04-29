package assets.electrolysm.electro.research.pointsSystem;

import org.bouncycastle.asn1.cms.RecipientIdentifier;
import org.bouncycastle.asn1.cms.RecipientInfo;

import net.minecraft.item.Item;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.RecipesCrafting;
import net.minecraft.item.crafting.RecipesIngots;
import net.minecraft.item.crafting.RecipesMapCloning;
import net.minecraft.item.crafting.RecipesWeapons;
import net.minecraftforge.oredict.RecipeSorter;

public class ResearchPoint
{
    Item stack;

    private static void RemoveRecipe(ItemStack resultItem)
{
         List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
         for (int i = 0; i < recipes.size(); i++)
         {
                         IRecipe tmpRecipe = recipes.get(i);
                         {
                         if (tmpRecipe instanceof ShapedRecipes) {
                                         ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
                                         ItemStack recipeResult = recipe.getRecipeOutput();
                        
                                         if (ItemStack.areItemStacksEqual(resultItem, recipeResult)) {
                                                         recipes.remove(i--);
                                         }
                         }
         }
}

}
