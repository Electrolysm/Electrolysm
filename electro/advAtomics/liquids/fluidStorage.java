package assets.electrolysm.electro.advAtomics.liquids;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.research.Research;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class fluidStorage extends Item {

	@SideOnly(Side.CLIENT)
	private Icon[] fluidIcons;
	
	public fluidStorage(int ID) {
		super(ID);
	
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.hasSubtypes = true;
	}
	
	
	public String getUnlocalizedName(ItemStack stack)
	{
		int dmg = stack.getItemDamage();
		return "fluidStorage_" + CommonProxy.holdableFluids[dmg];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		fluidIcons = new Icon[CommonProxy.holdableFluids.length];
		
		for(int i = 0; i < CommonProxy.holdableFluids.length; i ++)
		{
			fluidIcons[i] = reg.registerIcon("electrolysm:fluidStorage/" + "fluidStorage_" + CommonProxy.holdableFluids[i]);
		}
	}
   
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg)
	{
		return fluidIcons[dmg];
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) 
    {
    	for(int i = 0; i < Research.researchNames1.length; i++)
    	{
    		if(stack.getItemDamage() == i)
    		{
    			list.add("Holding 1000mB of: " + CommonProxy.holdableFluids[i]);
    		}
    	}
    }
	
    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
    	for(int i = 0; i < CommonProxy.holdableFluids.length; i++)
    	{
    		list.add(new ItemStack(electrolysmCore.fluidStorage, 1, i));
    	}
    }


}
