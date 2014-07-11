package electro.crafting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import api.items.RecipeStack;
import electro.Electrolysm;
import electro.research.system.Research;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InjectorRecipes
{
    private static final InjectorRecipes smeltBase = new InjectorRecipes();

    private HashMap<List<RecipeStack>, RecipeStack> metaSmeltingList1 = new HashMap<List<RecipeStack>, RecipeStack>();
    private HashMap<List<Integer>, RecipeStack> metaSmeltingList2 = new HashMap<List<Integer>, RecipeStack>();
    private HashMap<List<RecipeStack>, RecipeStack> metaSmeltingCheckList1 = new HashMap<List<RecipeStack>, RecipeStack>();
    private HashMap<List<RecipeStack>, RecipeStack> metaSmeltingCheckList2 = new HashMap<List<RecipeStack>, RecipeStack>();

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
        this.metaSmeltingList1.put(Arrays.asList(new RecipeStack(bottom), new RecipeStack(top)), new RecipeStack(output));
        this.metaSmeltingList2.put(Arrays.asList(bottom.getItemDamage(), top.getItemDamage()), new RecipeStack(output));

        this.metaSmeltingCheckList1.put(Arrays.asList(new RecipeStack(bottom)), new RecipeStack(bottom));
        this.metaSmeltingCheckList2.put(Arrays.asList(new RecipeStack(top)), new RecipeStack(top));
    }
    
    public HashMap<List<RecipeStack>, RecipeStack> getInjectorMap()
    {
    	return this.metaSmeltingList1;
    }
    
    public HashMap<List<Integer>, RecipeStack> getInjectorMapMeta()
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

        RecipeStack outputItem1 = this.metaSmeltingList1.get(Arrays.asList(new RecipeStack(item1), new RecipeStack(item2)));
        RecipeStack outputItem2 = this.metaSmeltingList2.get(Arrays.asList(item1.getItemDamage(), item2.getItemDamage()));

        if (outputItem1 != null && outputItem2 != null && outputItem1.equals(outputItem2))
        {
            if (outputItem1.getStackValue().getItemDamage() == outputItem2.getStackValue().getItemDamage())
            {
                return outputItem1.getStackValue();
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
        if(this.metaSmeltingCheckList1.get(Arrays.asList(new RecipeStack(input))) != null)
        {
            return this.metaSmeltingCheckList1.get(Arrays.asList(new RecipeStack(input))).getStackValue();
        }

        return null;
    }

    public ItemStack getSlot2ReduceAmount(ItemStack input)
    {
        if(this.metaSmeltingCheckList2.get(Arrays.asList(new RecipeStack(input))) != null)
        {
            return this.metaSmeltingCheckList2.get(Arrays.asList(new RecipeStack(input))).getStackValue();
        }

        return null;
    }
}