package electro.handlers;

import cpw.mods.fml.common.registry.GameRegistry;
import electro.Electrolysm;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler
{
    private double coalsConstant = Math.sqrt(Math.PI);

    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if (fuel.getItem() == Electrolysm.sulphur) { return 200; }
        else if(fuel.getItem() == Electrolysm.improvedCoal) {
            return (int)(1600 * coalsConstant); }
        else
        {

          return 0;
        }
    }
}
