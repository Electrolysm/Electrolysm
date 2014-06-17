package assets.electrolysm.api.powerSystem;

import net.minecraft.item.ItemStack;

public interface IBatteryCharger 
{
	public ItemStack chargedBattery(ItemStack stack, int maxCharge);
	
	public ItemStack chargedBatteryWithAmount(int amount, ItemStack stack, int maxCharge);
}
