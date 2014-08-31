package electrolysm.api.powerSystem.interfaces;

import net.minecraft.item.ItemStack;

public interface IBatteryCharger 
{
    /**
     * Charges the battery (stack) by 1 TeU
     * @param stack
     * @param maxCharge
     * @return The charged battery (Battery charged by 1 TeU)
     */
	public ItemStack chargedBattery(ItemStack stack, int maxCharge);

    /**
     * Charges the battery by a given amount
     * @param amount
     * @param stack
     * @param maxCharge
     * @return the new battery stack
     */
	public ItemStack chargedBatteryWithAmount(int amount, ItemStack stack, int maxCharge);
}
