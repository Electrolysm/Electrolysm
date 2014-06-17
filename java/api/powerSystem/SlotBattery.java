package api.powerSystem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.electrolysmCore;
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
		if(stack.getItem() == electrolysmCore.battery1)
		{
			return true;
		}
		else if(stack.getItem() == electrolysmCore.battery2)
		{
			return true;
		}
		else if(stack.getItem() == electrolysmCore.battery3)
		{
			return true;
		}
		else if(stack.getItem() == electrolysmCore.battery4)
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
