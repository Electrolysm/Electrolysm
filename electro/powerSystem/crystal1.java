package assets.electrolysm.electro.powerSystem;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.common.CommonProxy;

public class crystal1 extends Item {

	NBTTagCompound nbt = new NBTTagCompound();
	private int pin = nbt.getInteger("pinNumber");
	
	public crystal1(int id) {
		super(id);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.putPinToServer(this.pin);
	}
	/*public static void putData(int damage)
	{
		TeslaTransmittingServer.putCrystalData(damage);
	}*/
	
	public String getUnlocalizedName(ItemStack stack)
	{
		int dmg = stack.getItemDamage();
		//this.putData(dmg);
		return "crystal-tier-1";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		this.itemIcon = reg.registerIcon("electrolysm:" + "crystal1");
	}
	/*
	public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
    	for(int i = 0; i < TeslaTransmittingServer.crystalLst.length + 1; i++)
    	{
    		list.add(new ItemStack(electrolysmCore.crystal1, 1, i));
    	}
    }*/
	
	/**
	 * @return
	 * returns the pin number of the specified item.
	 */
	public int getPin()
	{
		return this.pin;
	}

	/**
	 * @param pin
	 * sets the nbt tag to the specified pin number (5 digits max eg. 99999)
	 */
	public void putPin(int pin)
	{
		nbt.setInteger("pinNumber", 00001);
	}
	
	public void putPinToServer(int pin)
	{
		ItemStack stack = new ItemStack(this);
		TeslaTransmittingServer.putCrystalData(stack.getItemDamage(), pin);
	}
	
	@Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) 
	{
		list.add("Crystal Frequency - " + stack.getItemDamage());
		list.add("Crystal Pin Number - " + this.getPin());
	}

}