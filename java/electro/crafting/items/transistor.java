package electro.crafting.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class transistor extends Item
{
    public transistor()
    {
        super();
        // TODO Auto-generated constructor stub
            this.setCreativeTab(electrolysmCore.TabElectrolysm);
            this.setUnlocalizedName("transistor");
        //transistor
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
    	this.itemIcon = reg.registerIcon("electrolysm:" + "transistor");
    }
}