package electro.crafting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import electro.electrolysmCore;

import cpw.mods.fml.common.Loader;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnergiserRecipes
{
    private static final EnergiserRecipes smeltBase = new EnergiserRecipes();

    private HashMap<List<ItemStack>, ItemStack> metaSmeltingList1 = new HashMap<List<ItemStack>, ItemStack>();
    private HashMap<List<ItemStack>, ItemStack> metaSmeltingList2 = new HashMap<List<ItemStack>, ItemStack>();
    private HashMap<List<ItemStack>, ItemStack> metaSmeltingCheckList1 = new HashMap<List<ItemStack>, ItemStack>();
    private HashMap<List<ItemStack>, ItemStack> metaSmeltingCheckList2 = new HashMap<List<ItemStack>, ItemStack>();

    public static final EnergiserRecipes smelting()
    {
        return smeltBase;
    }

    private EnergiserRecipes()
    {
        this.addDoubleSmelting(new ItemStack(Items.water_bucket), new ItemStack(electrolysmCore.fluidStorage, 4, 0),
                               new ItemStack(electrolysmCore.fluidStorage, 4, 1));
    }

    public void addDoubleSmelting(ItemStack input1, ItemStack input2, ItemStack output)
    {
        this.metaSmeltingList1.put(Arrays.asList(input1), output);
        this.metaSmeltingList2.put(Arrays.asList(input2), output);
        this.metaSmeltingCheckList1.put(Arrays.asList(input1), input1);
        this.metaSmeltingCheckList2.put(Arrays.asList(input2), input2);
    }

    public ItemStack getDoubleSmeltingResult(ItemStack item1, ItemStack item2)
    {
        if (item1 == null)
        {
            return null;
        }

        if (item2 == null)
        {
            return null;
        }

        ItemStack outputItem1 = this.metaSmeltingList1.get(Arrays.asList(item1));
        ItemStack outputItem2 = this.metaSmeltingList2.get(Arrays.asList(item2));

        if (outputItem1 == outputItem2)
        {
            if (outputItem1.getItemDamage() == outputItem2.getItemDamage())
            {
                return outputItem1;
            }
            else
            {
                ItemStack outputItem3 = this.metaSmeltingList1.get(Arrays.asList(item2));
                ItemStack outputItem4 = this.metaSmeltingList2.get(Arrays.asList(item1));

                if (outputItem3 == outputItem4)
                {
                    if (outputItem3.getItemDamage() == outputItem4.getItemDamage())
                    {
                        return outputItem3;
                    }
                    else
                    {
                        return null;
                    }
                }
                else
                {
                    return null;
                }
            }
        }
        else
        {
            ItemStack outputItem3 = this.metaSmeltingList1.get(Arrays.asList(item2));
            ItemStack outputItem4 = this.metaSmeltingList2.get(Arrays.asList(item1));

            if (outputItem3 == outputItem4)
            {
                if (outputItem3.getItemDamage() == outputItem4.getItemDamage())
                {
                    return outputItem3;
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }
        }
    }

    public ItemStack getSlot1ReduceAmount(ItemStack input)
    {
        return (ItemStack) this.metaSmeltingCheckList1.get(Arrays.asList(input));
    }

    public ItemStack getSlot2ReduceAmount(ItemStack input)
    {
        return (ItemStack) this.metaSmeltingCheckList2.get(Arrays.asList(input));
    }
}