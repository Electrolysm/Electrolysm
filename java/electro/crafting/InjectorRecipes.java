package electro.crafting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import electro.Electrolysm;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class InjectorRecipes
{
    private static final InjectorRecipes smeltBase = new InjectorRecipes();

    private HashMap<List<ItemStack>, ItemStack> metaSmeltingList1 = new HashMap<List<ItemStack>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList2 = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<ItemStack>, ItemStack> metaSmeltingCheckList1 = new HashMap<List<ItemStack>, ItemStack>();
    private HashMap<List<ItemStack>, ItemStack> metaSmeltingCheckList2 = new HashMap<List<ItemStack>, ItemStack>();

    public static final InjectorRecipes smelting()
    {
        return smeltBase;
    }

    private InjectorRecipes()
    {
        this.addDoubleSmelting(new ItemStack(Electrolysm.drillCasing), new ItemStack(Electrolysm.fluidStorage, 16, 1),
                               new ItemStack(Electrolysm.plasmaDrill, 1, 1));
        
        this.addDoubleSmelting(new ItemStack(Items.water_bucket), new ItemStack(Electrolysm.fluidStorage, 1, 0),
                new ItemStack(Electrolysm.fluidStorage, 1, 9));
        
        this.addDoubleSmelting(new ItemStack(Electrolysm.sulphur, 16), new ItemStack(Electrolysm.fluidStorage, 1, 9),
                new ItemStack(Electrolysm.fluidStorage, 1, 2));
    }

    public void addDoubleSmelting(ItemStack bottom, ItemStack top, ItemStack output)
    {
        this.metaSmeltingList1.put(Arrays.asList(bottom, top), output);
        //this.metaSmeltingList2.put(Arrays.asList(bottom.getItemDamage(), top.getItemDamage()), output);
        
        this.metaSmeltingCheckList1.put(Arrays.asList(bottom), bottom);
        this.metaSmeltingCheckList2.put(Arrays.asList(top), top);
    }
    
    public HashMap<List<ItemStack>, ItemStack> getInjectorMap()
    {
    	return this.metaSmeltingList1;
    }
    
    public HashMap<List<Integer>, ItemStack> getInjectorMapMeta()
    {
    	return this.metaSmeltingList2;
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

        ItemStack outputItem1 = this.metaSmeltingList1.get(Arrays.asList(item1, item2));
        ItemStack outputItem2 = this.metaSmeltingList2.get(Arrays.asList(item1.getItemDamage(), item2.getItemDamage()));

        if (outputItem1 == outputItem2)
        {
            if (outputItem1.getItemDamage() == outputItem2.getItemDamage())
            {
                return outputItem1;
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

    public ItemStack getSlot1ReduceAmount(ItemStack input)
    {
        return (ItemStack) this.metaSmeltingCheckList1.get(Arrays.asList(input));
    }

    public ItemStack getSlot2ReduceAmount(ItemStack input)
    {
        return (ItemStack) this.metaSmeltingCheckList2.get(Arrays.asList(input));
    }
}