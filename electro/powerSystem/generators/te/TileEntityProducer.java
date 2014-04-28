package assets.electrolysm.electro.powerSystem.generators.te;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assets.electrolysm.api.powerSystem.IBatteryCharger;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import universalelectricity.api.CompatibilityModule;
import universalelectricity.api.UniversalClass;
import universalelectricity.api.energy.EnergyStorageHandler;
import universalelectricity.api.energy.IEnergyContainer;
import universalelectricity.api.energy.IEnergyInterface;
import universalelectricity.api.energy.IEnergyNetwork;
import universalelectricity.api.net.INetworkProvider;
import universalelectricity.api.net.NetworkEvent;
import universalelectricity.api.vector.Vector3;

@UniversalClass
public class TileEntityProducer extends TileEntity implements IBatteryCharger
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