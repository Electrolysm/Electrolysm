package assets.electrolysm.electro.research;

import net.minecraft.item.ItemStack;

public interface IResearch
{
    int getResearch(ItemStack input, ItemStack card, ItemStack output);
}
