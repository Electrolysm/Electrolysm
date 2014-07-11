package api.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Comparator;

/**
 * Created by Ben on 11/07/2014.
 */
public class ItemCompare
{
    public static Comparator<ItemStack> comparatorItemStack = new Comparator<ItemStack>()
    {
        public int compare(ItemStack itemStack1, ItemStack itemStack2)
        {
            if (itemStack1 != null && itemStack2 != null)
            {
                // Sort on itemID
                if (Item.getIdFromItem(itemStack1.getItem()) - Item.getIdFromItem(itemStack2.getItem()) == 0)
                {
                    // Then sort on meta
                    if (itemStack1.getItemDamage() == itemStack2.getItemDamage())
                    {
                        // Then sort on NBT
                        if (itemStack1.hasTagCompound() && itemStack2.hasTagCompound())
                        {
                            // Then sort on stack size
                            if (itemStack1.getTagCompound().equals(itemStack2.getTagCompound()))
                            {
                                return (itemStack1.stackSize - itemStack2.stackSize);
                            }
                            else
                            {
                                return (itemStack1.getTagCompound().hashCode() - itemStack2.getTagCompound().hashCode());
                            }
                        }
                        else if (!(itemStack1.hasTagCompound()) && itemStack2.hasTagCompound())
                        {
                            return -1;
                        }
                        else if (itemStack1.hasTagCompound() && !(itemStack2.hasTagCompound()))
                        {
                            return 1;
                        }
                        else
                        {
                            return (itemStack1.stackSize - itemStack2.stackSize);
                        }
                    }
                    else
                    {
                        return (itemStack1.getItemDamage() - itemStack2.getItemDamage());
                    }
                }
                else
                {
                    return Item.getIdFromItem(itemStack1.getItem()) - Item.getIdFromItem(itemStack2.getItem());
                }
            }
            else if (itemStack1 != null && itemStack2 == null)
            {
                return -1;
            }
            else if (itemStack1 == null && itemStack2 != null)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    };

    public static Comparator<Item> comparatorItem = new Comparator<Item>()
    {
        public int compare(Item itemStack1, Item itemStack2)
        {
            if (itemStack1 != null && itemStack2 != null)
            {
                // Sort on itemID
                if (Item.getIdFromItem(itemStack1) - Item.getIdFromItem(itemStack2) == 0)
                {
                    return 0;
                }
                else
                {
                    return Item.getIdFromItem(itemStack1) - Item.getIdFromItem(itemStack2);
                }
            }
            else if (itemStack1 != null && itemStack2 == null)
            {
                return -1;
            }
            else if (itemStack1 == null && itemStack2 != null)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    };
}
