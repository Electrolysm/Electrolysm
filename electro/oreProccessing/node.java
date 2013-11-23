package assets.electrolysm.electro.oreProccessing;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class node extends Item {

	public node(int id) {
		super(id);
		this.setUnlocalizedName("anode");
		this.setMaxStackSize(1);
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "electrolysisNode");
    }
}
