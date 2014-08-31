package electrolysm.api.items;

import electrolysm.api.CompareHandler;
import net.minecraft.item.Item;

import java.util.Comparator;

/**
 * Created by Ben on 11/07/2014.
 */
public class RecipeItem
{
    private Item stackValue = null;

    public RecipeItem(Item stack)
    {
        stackValue = stack;
    }

    public Item getStackValue()
    {
        return stackValue;
    }

    public void setStackValue(Item stack)
    {
        stackValue = stack;
    }

    public static Comparator<RecipeItem> comparator = new Comparator<RecipeItem>()
    {

        @Override
        public int compare(RecipeItem stack0, RecipeItem stack1)
        {

            if (stack0.stackValue instanceof Item)
            {
                if (stack1.stackValue instanceof Item)
                {
                    return CompareHandler.comparatorItem.compare(stack0.stackValue, stack1.stackValue);
                }
                else
                {
                    return 1;
                }
            }

            return 0;
        }
    };

    @Override
    public int hashCode()
    {
        int code = 1;
        code = (37 * code);

        code = (37 * code) + Item.getIdFromItem((stackValue));

        return code;
    }

    @Override
    public boolean equals(Object object)
    {
        return object instanceof RecipeItem && (this.compareTo((RecipeItem) object) == 0);
    }

    public int compareTo(RecipeItem stack)
    {
        return comparator.compare(this, stack);
    }
}
