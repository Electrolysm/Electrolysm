package electrolysm.api;

import electrolysm.api.powerSystem.tesla.TeslaTower;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Comparator;

/**
 * Created by Ben on 11/07/2014.
 */
public class CompareHandler
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
                                return 0;//(itemStack1.stackSize - itemStack2.stackSize);
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
                            return 0;
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


    public static Comparator<TeslaTower> comparatorTeslaTower = new Comparator<TeslaTower>() {
        @Override
        public int compare(TeslaTower te1, TeslaTower te2) {
            if(te1 != null && te2 != null){
                if(te1.getFreq() - te2.getFreq() == 0){
                    if(te1.getPower() - te2.getPower() == 0){
                        if(te1.getWorld() == null && te2.getWorld() == null) {
                            if (te1.getWorldData()[0] - te2.getWorldData()[0] == 0) {
                                if (te1.getWorldData()[1] - te2.getWorldData()[1] == 0) {
                                    if (te1.getWorldData()[2] - te2.getWorldData()[2] == 0) {
                                        if (te1.getWorldData()[3] - te2.getWorldData()[3] == 0) {
                                            return 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }
    };
}
