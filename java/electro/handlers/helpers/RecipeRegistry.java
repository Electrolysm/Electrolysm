package electro.handlers.helpers;

import electro.research.crafting.ResearchCraftingHandler;
import electro.research.system.Research;
import net.minecraft.item.ItemStack;

/**
 * Created by Ben on 12/07/2014.
 */
public class RecipeRegistry
{
    public static ItemStack getResearchResult(ItemStack[] stacks)
    {
        return new ResearchCraftingHandler(true).getResult(stacks);
    }

    public static Research getResearch(ItemStack[] stacks)
    {
        return new ResearchCraftingHandler(true).getResearch(stacks);
    }

}
