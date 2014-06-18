package electro.crafting.items;

import electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCrafting extends Item
{

	public ItemCrafting() {
		super();

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
    	this.itemIcon = reg.registerIcon("electrolysm:" + this.getUnlocalizedName().replace("item.", ""));
    }

	
}
