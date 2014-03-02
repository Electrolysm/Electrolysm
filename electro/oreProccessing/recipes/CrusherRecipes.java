package assets.electrolysm.electro.oreProccessing.recipes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import assets.electrolysm.electro.electrolysmCore;

public class CrusherRecipes
{
    private static final CrusherRecipes smeltBase = new CrusherRecipes();

    private Map crushing1 = new HashMap();
    private Map crushing2 = new HashMap();

    public static final CrusherRecipes smelting()
    {
        return smeltBase;
    }

    private CrusherRecipes()
    {
        //		"Copper", "Tin", "Iron", "Gold", "Silver", "Lead"};
        //METAs		0		   1	  2		  3			4		5
        //Ore Blocks
        ArrayList<ItemStack> copperOre = OreDictionary.getOres("oreCopper");
        ArrayList<ItemStack> tinOre = OreDictionary.getOres("oreTin");
        ArrayList<ItemStack> silverOre = OreDictionary.getOres("oreSilver");
        ArrayList<ItemStack> leadOre = OreDictionary.getOres("oreLead");
        ItemStack ironOre = new ItemStack(Block.oreIron);
        ItemStack goldOre = new ItemStack(Block.oreGold);

        //Ore
        this.addCrushing(ironOre, new ItemStack(electrolysmCore.impureDusts, 2, 2));
        this.addCrushing(goldOre, new ItemStack(electrolysmCore.impureDusts, 2, 3));

        for (int i = 0; i < copperOre.size(); i++)
        {
            this.addCrushing(copperOre.get(i), new ItemStack(electrolysmCore.impureDusts, 2, 0));
        }

        for (int i = 0; i < tinOre.size(); i++)
        {
            this.addCrushing(tinOre.get(i), new ItemStack(electrolysmCore.impureDusts, 2, 1));
        }

        for (int i = 0; i < silverOre.size(); i++)
        {
            this.addCrushing(silverOre.get(i), new ItemStack(electrolysmCore.impureDusts, 2, 4));
        }

        for (int i = 0; i < leadOre.size(); i++)
        {
            this.addCrushing(leadOre.get(i), new ItemStack(electrolysmCore.impureDusts, 2, 5));
        }

        //Ingots
        /*
        this.addCrushing(ironIngot, new ItemStack(electrolysmCore.impureDusts, 2, 2));
        this.addCrushing(goldIngot, new ItemStack(electrolysmCore.impureDusts, 2, 3));

        for(int i = 0; i < copperIngot.size(); i++)
        {
        	this.addCrushing(copperIngot.get(i), new ItemStack(electrolysmCore.impureDusts, 2, 0));
        }
        for(int i = 0; i < tinIngot.size(); i++)
        {
        	this.addCrushing(tinIngot.get(i), new ItemStack(electrolysmCore.impureDusts, 2, 2));
        }
        for(int i = 0; i < silverIngot.size(); i++)
        {
        	this.addCrushing(silverIngot.get(i), new ItemStack(electrolysmCore.impureDusts, 2, 4));
        }
        for(int i = 0; i < leadIngot.size(); i++)
        {
        	this.addCrushing(leadIngot.get(i), new ItemStack(electrolysmCore.impureDusts, 2, 5));
        }
        */
    }

    public void addCrushing(ItemStack input, ItemStack output)
    {
        this.crushing1.put(Integer.valueOf(input.itemID), Integer.valueOf(output.getItemDamage()));
        this.crushing2.put(Integer.valueOf(input.itemID), output);
    }

    public ItemStack getCrushingResult(ItemStack input)
    {
        if (input == null)
        {
            return null;
        }

        if (this.crushing1.get(Integer.valueOf(input.itemID)) == null)
        {
            return null;
        }

        int meta = Integer.valueOf((String.valueOf(this.crushing1.get(Integer.valueOf(input.itemID)))));
        ItemStack output2 = (ItemStack)this.crushing2.get(Integer.valueOf(input.itemID));
        ItemStack output = new ItemStack(electrolysmCore.impureDusts, 2, meta);

        if (output2 != null)
        {
            if (output2.isItemEqual(output))
            {
                return output;
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
        return (ItemStack) this.crushing1.get(input);
    }
}