package electro.misc.crafting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import electrolysm.api.items.RecipeStack;
import electro.Electrolysm;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class EnergiserRecipes
{
    private static final EnergiserRecipes smeltBase = new EnergiserRecipes();

    private HashMap<List<RecipeStack>, RecipeStack> metaSmeltingList1 = new HashMap<List<RecipeStack>, RecipeStack>();
    private HashMap<List<RecipeStack>, RecipeStack> metaSmeltingList2 = new HashMap<List<RecipeStack>, RecipeStack>();
    private HashMap<List<RecipeStack>, RecipeStack> metaSmeltingCheckList1 = new HashMap<List<RecipeStack>, RecipeStack>();
    private HashMap<List<RecipeStack>, RecipeStack> metaSmeltingCheckList2 = new HashMap<List<RecipeStack>, RecipeStack>();

    private HashMap<List<RecipeStack>, RecipeStack> bothSmeltingList = new HashMap<List<RecipeStack>, RecipeStack>();

    public static final EnergiserRecipes smelting()
    {
        return smeltBase;
    }

    private EnergiserRecipes()
    {
        this.addDoubleSmelting(new ItemStack(Items.water_bucket), new ItemStack(Electrolysm.fluidStorage, 4, 0),
                new ItemStack(Electrolysm.fluidStorage, 4, 1));
        this.addDoubleSmelting(new ItemStack(Electrolysm.crystalBase), new ItemStack(Items.redstone),
                new ItemStack(Electrolysm.crystal1));

        ArrayList<ItemStack> diamondDust = OreDictionary.getOres("dustDiamond");
        for (int i = 0; i < diamondDust.size(); i++) {
            this.addDoubleSmelting(new ItemStack(diamondDust.get(i).getItem(), 4, diamondDust.get(i).getItemDamage()), new ItemStack(Electrolysm.crystal1),
                    new ItemStack(Electrolysm.crystal2));
        }
    }

    public void addDoubleSmelting(ItemStack input1, ItemStack input2, ItemStack output)
    {
        this.metaSmeltingList1.put(Arrays.asList(new RecipeStack(input1)), new RecipeStack(output));
        this.metaSmeltingList2.put(Arrays.asList(new RecipeStack(input2)), new RecipeStack(output));
        this.metaSmeltingCheckList1.put(Arrays.asList(new RecipeStack(input1)), new RecipeStack(input1));
        this.metaSmeltingCheckList2.put(Arrays.asList(new RecipeStack(input2)), new RecipeStack(input2));
        this.bothSmeltingList.put(Arrays.asList(new RecipeStack(input1), new RecipeStack(input2)), new RecipeStack(output));
    }

    public HashMap<List<RecipeStack>, RecipeStack> getMap()
    {
        return bothSmeltingList;
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