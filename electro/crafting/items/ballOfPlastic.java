package assets.electrolysm.electro.crafting.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ballOfPlastic extends Item {

	public ballOfPlastic(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
		{

	    this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("Ball of plasic");
	}
}
}