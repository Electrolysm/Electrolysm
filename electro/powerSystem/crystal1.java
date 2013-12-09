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

	public crystal1(int id) {
		super(id);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}
	public static void putData(int damage)
	{
		TeslaTransmittingServer.putCrystalData(damage);
	}
	
	public String getUnlocalizedName(ItemStack stack)
	{
		int dmg = stack.getItemDamage();
		this.putData(dmg);
		return "crystal-tier-1";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		this.itemIcon = reg.registerIcon("electrolysm:" + "crystal1");
	}
	
	public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
    	for(int i = 0; i < TeslaTransmittingServer.crystalLst.length; i++)
    	{
    		list.add(new ItemStack(electrolysmCore.crystal1, 1, i));
    	}
    }
}