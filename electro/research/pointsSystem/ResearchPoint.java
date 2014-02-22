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

    static
    {
        Object x;
        CraftingManager.getInstance().getRecipeList();
    }
}
