package mods.Electrolysm.electro.basic.recipes;

import ic2.api.item.Items;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import cpw.mods.fml.common.Loader;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class platRecipes
{
	private static final platRecipes smeltBase = new platRecipes();

    private HashMap<List<Integer>, ItemStack> metaSmeltingList1 = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList2 = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> metaSmeltingCheckList1 = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> metaSmeltingCheckList2 = new HashMap<List<Integer>, ItemStack>();

	public static final platRecipes smelting() {
		return smeltBase;
	}

	private platRecipes()
	{	
		ItemStack nanoTech = new ItemStack(electrolysmCore.nanoTech, 4);
		ItemStack nanoBlock = new ItemStack(electrolysmCore.nanoBlock);
		
		this.addDoubleSmelting(nanoTech, new ItemStack(Item.bucketWater), nanoBlock);
		
		/*if(Loader.isModLoaded("IC2"))
		{
			 ItemStack tinCan = Items.getItem("fuelCan");
			 this.addDoubleSmelting(nanoTech, tinCan, nanoBlock);
		}*/
	}

	public void addDoubleSmelting(ItemStack input1, ItemStack input2, ItemStack output) {
		this.metaSmeltingList1.put(Arrays.asList(input1.itemID, input1.getItemDamage()), output);
		this.metaSmeltingList2.put(Arrays.asList(input2.itemID, input2.getItemDamage()), output);
		this.metaSmeltingCheckList1.put(Arrays.asList(input1.itemID, input1.getItemDamage()), input1);
		this.metaSmeltingCheckList2.put(Arrays.asList(input2.itemID, input2.getItemDamage()), input2);
	}

	public ItemStack getDoubleSmeltingResult(ItemStack item1, ItemStack item2) {
		if (item1 == null) {
			return null;
		}

		if (item2 == null) {
			return null;
		}

		ItemStack outputItem1 = this.metaSmeltingList1.get(Arrays.asList(item1.itemID, item1.getItemDamage()));
		ItemStack outputItem2 = this.metaSmeltingList2.get(Arrays.asList(item2.itemID, item2.getItemDamage()));
/*
		if (outputItem1.itemID == outputItem2.itemID) {
			if (outputItem1.getItemDamage() == outputItem2.getItemDamage()) {
				return outputItem1;
			} else {
				return outputItem2;
			}
		} else {
			return null;
		}
*/
		return outputItem1;
	}

	public ItemStack getSlot1ReduceAmount(ItemStack input) {
		return (ItemStack) this.metaSmeltingCheckList1.get(Arrays.asList(input.itemID, input.getItemDamage()));
	}

	public ItemStack getSlot2ReduceAmount(ItemStack input) {
		return (ItemStack) this.metaSmeltingCheckList2.get(Arrays.asList(input.itemID, input.getItemDamage()));
	}

}