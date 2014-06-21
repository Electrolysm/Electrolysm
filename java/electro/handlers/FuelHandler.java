package electro.handlers;

import electro.Electrolysm;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if (fuel.getItem() == Electrolysm.sulphur)
        {
            return 200;
        }
        else
        {
            return 0;
        }
    }
}
