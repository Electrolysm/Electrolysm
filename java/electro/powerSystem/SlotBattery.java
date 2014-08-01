package electro.powerSystem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import electro.common.CommonProxy;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class SlotBattery extends Slot {

	public SlotBattery(IInventory inventory, int id, int x, int y) {
		super(inventory, id, x, y);
		
	}
	
	@Override
    public boolean isItemValid(ItemStack stack)
    {
        if (isStackBattery(stack))
        {
            return true;
        }

        return false;
    }

	private boolean isStackBattery(ItemStack stack) 
	{
		if(stack.getItem() == Electrolysm.basicBattery)
		{
			return true;
		}
		else if(stack.getItem() == Electrolysm.advancedBattery)
		{
			return true;
		}
		else if(stack.getItem() == Electrolysm.experimentalBattery)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public ResourceLocation getBackgroundIconTexture()
    {
    	return CommonProxy.SLOT_ICON;
    }

}
