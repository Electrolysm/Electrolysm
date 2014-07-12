package electro.crafting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import api.items.RecipeStack;
import electro.Electrolysm;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class EnergiserRecipes
{
    private static final EnergiserRecipes smeltBase = new EnergiserRecipes();

    private HashMap<List<RecipeStack>, RecipeStack> metaSmeltingList1 = new HashMap<List<RecipeStack>, RecipeStack>();
    private HashMap<List<RecipeStack>, RecipeStack> metaSmeltingList2 = new HashMap<List<RecipeStack>, RecipeStack>();
    private HashMap<List<RecipeStack>, RecipeStack> metaSmeltingCheckList1 = new HashMap<List<RecipeStack>, RecipeStack>();
    private HashMap<List<RecipeStack>, RecipeStack> metaSmeltingCheckList2 = new HashMap<List<RecipeStack>, RecipeStack>();

    public static final EnergiserRecipes smelting()
    {
        return smeltBase;
    }

    private EnergiserRecipes()
    {
        this.addDoubleSmelting(new ItemStack(Items.water_bucket), new ItemStack(Electrolysm.fluidStorage, 4, 0),
                               new ItemStack(Electrolysm.fluidStorage, 4, 1));
    }

    public void addDoubleSmelting(ItemStack input1, ItemStack input2, ItemStack output)
    {
        this.metaSmeltingList1.put(Arrays.asList(new RecipeStack(input1)), new RecipeStack(output));
        this.metaSmeltingList2.put(Arrays.asList(new RecipeStack(input2)), new RecipeStack(output));
        this.metaSmeltingCheckList1.put(Arrays.asList(new RecipeStack(input1)), new RecipeStack(input1));
        this.metaSmeltingCheckList2.put(Arrays.asList(new RecipeStack(input2)), new RecipeStack(input2));
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

        RecipeStack outputItem1 = this.metaSmeltingList1.get(Arrays.asList(new RecipeStack(item1)));
        RecipeStack outputItem2 = this.metaSmeltingList2.get(Arrays.asList(new RecipeStack(item2)));

        if (outputItem1 != null && outputItem2 != null)
        {
            if (outputItem1.equals(outputItem2))
            {
                return outputItem1.getStackValue();
            }
            else
            {
                RecipeStack outputItem3 = this.metaSmeltingList1.get(Arrays.asList(new RecipeStack(item2)));
                RecipeStack outputItem4 = this.metaSmeltingList2.get(Arrays.asList(new RecipeStack(item1)));

                if (outputItem3 != null && outputItem4 != null)
                {
                    if (outputItem3.equals(outputItem4))
                    {
                        return outputItem3.getStackValue();
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
            RecipeStack outputItem3 = this.metaSmeltingList1.get(Arrays.asList(new RecipeStack(item2)));
            RecipeStack outputItem4 = this.metaSmeltingList2.get(Arrays.asList(new RecipeStack(item1)));

            if (outputItem3 != null && outputItem4 != null)
            {
                if (outputItem3.equals(outputItem4))
                {
                    return outputItem3.getStackValue();
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
        return (ItemStack) this.metaSmeltingCheckList1.get(Arrays.asList(new RecipeStack(input))).getStackValue();
    }

    public ItemStack getSlot2ReduceAmount(ItemStack input)
    {
        return (ItemStack) this.metaSmeltingCheckList2.get(Arrays.asList(new RecipeStack(input))).getStackValue();
    }
}