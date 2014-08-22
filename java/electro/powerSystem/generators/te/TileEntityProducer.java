package electro.powerSystem.generators.te;

import api.powerSystem.interfaces.IBatteryCharger;
import api.powerSystem.prefab.TileEntityGenerator;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;


public class TileEntityProducer extends TileEntityGenerator implements IBatteryCharger
{
	public static int capacity;
	
	public TileEntityProducer(int capacity)
	{
		this.capacity = capacity;
	}
	
	@Override
	public ItemStack chargedBattery(ItemStack stack, int maxCharge)
	{
		return this.chargedBatteryWithAmount(1, stack, maxCharge);
	}
	
	@Override
	public ItemStack chargedBatteryWithAmount(int amount, ItemStack stack, int maxCharge)
	{
		if(stack.getMaxDamage() == maxCharge)
		{
			if(maxCharge >= (stack.getItemDamage() + amount))
			{
				return new ItemStack(stack.getItem(), stack.stackSize, stack.getItemDamage() + amount);
			}
		}
		
		return stack;
	}
}