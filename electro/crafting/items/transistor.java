package assets.electrolysm.electro.crafting.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class transistor extends Item
{
    public transistor(int par1)
    {
        super(par1);
        // TODO Auto-generated constructor stub
            this.setCreativeTab(electrolysmCore.TabElectrolysm);
            this.setUnlocalizedName("transistor");
        //transistor
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
    	this.itemIcon = reg.registerIcon("electrolysm:" + "transistor");
    }
}