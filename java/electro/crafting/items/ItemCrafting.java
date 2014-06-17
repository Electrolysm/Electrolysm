package electro.crafting.items;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCrafting extends Item
{

	public ItemCrafting(int id) {
		super(id);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
    	this.itemIcon = reg.registerIcon("electrolysm:" + this.getUnlocalizedName().replace("item.", ""));
    }

	
}
