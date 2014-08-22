package electrolysm.electro.handlers.helpers;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 02/07/2014.
 */
public class BlockResource {

    public static List<ItemStack> resourceList;

    public static List<ItemStack> getResourceList()
    {
        resourceList = new ArrayList<ItemStack>();

        addData();

        return resourceList;
    }

    public static void addData()
    {
        ArrayList<ItemStack> copperOre = OreDictionary.getOres("oreCopper");
        ArrayList<ItemStack> tinOre = OreDictionary.getOres("oreTin");
        ArrayList<ItemStack> silverOre = OreDictionary.getOres("oreSilver");
        ArrayList<ItemStack> leadOre = OreDictionary.getOres("oreLead");
        ItemStack ironOre = new ItemStack(Blocks.iron_ore);
        ItemStack goldOre = new ItemStack(Blocks.gold_ore);

        //Ore
        addResource(ironOre);
        addResource(goldOre);

        for (int i = 0; i < copperOre.size(); i++)
        {
            addResource(copperOre.get(i));
        }

        for (int i = 0; i < tinOre.size(); i++)
        {
            addResource(tinOre.get(i));
        }

        for (int i = 0; i < silverOre.size(); i++)
        {
            addResource(silverOre.get(i));
        }

        for (int i = 0; i < leadOre.size(); i++)
        {
            addResource(leadOre.get(i));
        }

        addResource(Blocks.coal_ore);
        addResource(Blocks.diamond_ore);
        addResource(Blocks.emerald_ore);
        addResource(Blocks.lapis_ore);
        addResource(Blocks.redstone_ore);
        addResource(Blocks.quartz_ore);
        addResource(Blocks.planks);
        addResource(Blocks.log);
        addResource(Blocks.glowstone);
    }

    public static void addResource(Block block)
    {
        resourceList.add(new ItemStack(block));
    }


    public static void addResource(Item item)
    {
        resourceList.add(new ItemStack(item));
    }

    public static void addResource(ItemStack stack)
    {
        resourceList.add(stack);
    }
}
