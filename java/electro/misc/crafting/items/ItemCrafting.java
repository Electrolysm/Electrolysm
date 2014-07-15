package electro.misc.crafting.items;

import electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCrafting extends Item
{

	public ItemCrafting() {
		super();

		this.setCreativeTab(Electrolysm.TabElectrolysm);
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
    	this.itemIcon = reg.registerIcon("electrolysm:" + this.getUnlocalizedName().replace("item.", ""));
    }

	
}
