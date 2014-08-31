package electrolysm.api.items;

import electrolysm.api.CompareHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Comparator;

/**
 * Created by Ben on 11/07/2014.
 */
public class RecipeStack
{
    private ItemStack stackValue = null;

    public RecipeStack(ItemStack stack)
    {
        stackValue = stack;
    }

    public ItemStack getStackValue()
    {
        return stackValue;
    }

    public void setStackValue(ItemStack stack)
    {
        stackValue = stack;
    }

    public static Comparator<RecipeStack> comparator = new Comparator<RecipeStack>()
    {

        @Override
        public int compare(RecipeStack stack0, RecipeStack stack1)
        {

            if (stack0.stackValue instanceof ItemStack)
            {
                if (stack1.stackValue instanceof ItemStack)
                {
                    return CompareHandler.comparatorItemStack.compare(stack0.stackValue, stack1.stackValue);
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
        if(stackValue != null) {
            //code = (37 * code) + stackValue.stackSize;

            code = (37 * code) + Item.getIdFromItem((stackValue).getItem());
            code = (37 * code) + stackValue.getItemDamage();

            if (stackValue.getTagCompound() != null) {
                code = (37 * code) + stackValue.getTagCompound().hashCode();
            }
        }
        return code;
    }

    @Override
    public boolean equals(Object object)
    {
        return object instanceof RecipeStack && (this.compareTo((RecipeStack) object) == 0);
    }

    public int compareTo(RecipeStack stack)
    {
        return comparator.compare(this, stack);
    }
}
