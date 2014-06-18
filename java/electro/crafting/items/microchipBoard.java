package electro.crafting.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class microchipBoard extends Item
{
    public microchipBoard()
    {
        super();
        // TODO Auto-generated constructor stub
        {
            this.setCreativeTab(electrolysmCore.TabElectrolysm);
            this.setUnlocalizedName("Microchip Board");
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
    	this.itemIcon = reg.registerIcon("electrolysm:" + "microBoard");
    }
}