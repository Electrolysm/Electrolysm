package electro;

import net.minecraft.item.Item;
import electro.misc.block.basic.hammer;

public enum electrolysmItems
{
    HAMMER(hammer.unlocalName(), hammer.class);

    electrolysmItems[] itemList = electrolysmItems.values();

    private electrolysmItems(String someStuff, Class <? extends Item > itemClass)
    {
    }
}
