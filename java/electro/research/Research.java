package electro.research;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import electro.electrolysmCore;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Research
{
    //=====================================================
    //                                        Research Behind the Scenes
    //=====================================================

    private static final Research researchBase = new Research();

    /** The list of smelting results. */
    private HashMap<ItemStack, ItemStack> researchList = new HashMap<ItemStack, ItemStack>();
    private HashMap<ItemStack, Integer> cardIDList = new HashMap<ItemStack, Integer>();

    private static Map onlineCardIDList = new HashMap();
    private static Map onlineResearchList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final Research research()
    {
        return researchBase;
    }

    private Research()
    {
        this.addResearch(new ItemStack(Blocks.iron_block), new ItemStack(electrolysmCore.researchPaper, 1, 0), 1);
        this.addResearch(new ItemStack(Items.fish), new ItemStack(electrolysmCore.researchPaper, 1, 1), 1);
        this.addResearch(new ItemStack(Items.cooked_fished), new ItemStack(electrolysmCore.researchPaper, 1, 1), 1);
    }

    /**
     * Adds a smelting recipe.
     */
    public void addResearch(ItemStack stack, ItemStack output, int cardIDRequired)
    {
        this.researchList.put(stack, output);
        this.cardIDList.put(output, Integer.valueOf(cardIDRequired));
    }

    public ItemStack getResearch(ItemStack item, ItemStack card)
    {
        if (item == null)
        {
            return null;
        }

        if (card == null)
        {
            return null;
        }

        ItemStack output1 = (ItemStack)this.researchList.get(item);

        if (output1 != null)
        {
            int cardIDRequired = (Integer) this.cardIDList.get(output1);

            if (card.getItemDamage() >= cardIDRequired)
            {
                return output1;
            }
            else
            {/*
                ItemStack outputOnline = (ItemStack)this.onlineResearchList.get(Integer.valueOf(item.itemID));

                if (outputOnline != null)
                {
                    int onlineCardIDRequired = (Integer)this.onlineCardIDList.get(outputOnline);

                    if (card.getItemDamage() >= onlineCardIDRequired)
                    {
                        return outputOnline;
                    }
                    else
                    {
                        return null;
                    }
                }
                else
                {
                    return null;
                }*/
            }
        }
        else
        {/*
            ItemStack outputOnline = (ItemStack)this.onlineResearchList.get(Integer.valueOf(item.itemID));

            if (outputOnline != null)
            {
                int onlineCardIDRequired = (Integer)this.onlineCardIDList.get(outputOnline);

                if (card.getItemDamage() >= onlineCardIDRequired)
                {
                    return outputOnline;
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }*/
        }
        return null;
    }

    public static int cardToDesk(int itemDamage)
    {
        if (itemDamage == 1)
        {
            return 0;
        }

        int result = itemDamage * 3;
        result = (int)result + 2;
        return (int)result;
    }

    public static void onlineResearch(ItemStack stack, ItemStack output, int cardID)
    {
        onlineResearchList.put(stack, output);
        onlineCardIDList.put(output, Integer.valueOf(cardID));
    }
}
