package electro.oreProccessing.recipes;

import api.items.RecipeStack;
import electro.Electrolysm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class CrusherRecipes
{
    private static final CrusherRecipes smeltBase = new CrusherRecipes();

    //private Map<RecipeStack, RecipeStack> crushing1 = new HashMap<RecipeStack, RecipeStack>();
    private Map<RecipeStack, RecipeStack> crushing2 = new HashMap<RecipeStack, RecipeStack>();

    public static final CrusherRecipes smelting()
    {
        return smeltBase;
    }

    private CrusherRecipes()
    {/*
    	if(ModLoader.isModLoaded("IC2"))
    	{
    	}
    	*/

        //		"Copper", "Tin", "Iron", "Gold", "Silver", "Lead"};
        //METAs		0		   1	  2		  3			4		5
        //Ore Blocks
        ArrayList<ItemStack> copperOre = OreDictionary.getOres("oreCopper");
        ArrayList<ItemStack> tinOre = OreDictionary.getOres("oreTin");
        ArrayList<ItemStack> silverOre = OreDictionary.getOres("oreSilver");
        ArrayList<ItemStack> leadOre = OreDictionary.getOres("oreLead");
        ItemStack ironOre = new ItemStack(Blocks.iron_ore);
        ItemStack goldOre = new ItemStack(Blocks.gold_ore);

        //Ore
        this.addCrushing(ironOre, new ItemStack(Electrolysm.impureDusts, 2, 2));
        this.addCrushing(goldOre, new ItemStack(Electrolysm.impureDusts, 2, 3));

        for (int i = 0; i < copperOre.size(); i++)
        {
            this.addCrushing(copperOre.get(i), new ItemStack(Electrolysm.impureDusts, 2, 0));
        }

        for (int i = 0; i < tinOre.size(); i++)
        {
            this.addCrushing(tinOre.get(i), new ItemStack(Electrolysm.impureDusts, 2, 1));
        }

        for (int i = 0; i < silverOre.size(); i++)
        {
            this.addCrushing(silverOre.get(i), new ItemStack(Electrolysm.impureDusts, 2, 4));
        }

        for (int i = 0; i < leadOre.size(); i++)
        {
            this.addCrushing(leadOre.get(i), new ItemStack(Electrolysm.impureDusts, 2, 5));
        }

        this.addCrushing(new ItemStack(Items.diamond), new ItemStack(Electrolysm.diamondDust));
        this.addCrushing(new ItemStack(Blocks.diamond_ore), new ItemStack(Electrolysm.diamondDust, 2));

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
        //this.crushing1.put((input), Integer.valueOf(output.getItemDamage()));
        this.crushing2.put(new RecipeStack(input), new RecipeStack(output));
    }

    public Map<RecipeStack, RecipeStack> getCrushingMap()
    {
        return this.crushing2;
    }

    public ItemStack getCrushingResult(ItemStack input)
    {
        if (input == null)
        {
            return null;
        }

        if (this.crushing2.get(new RecipeStack(input)) == null)
        {
            System.out.println("getNull");
            return null;
        }

        RecipeStack output2 = this.crushing2.get(new RecipeStack(input));

        if (output2 != null)
        {
            return output2.getStackValue();
        }
        else
        {
            return null;
        }
    }
}