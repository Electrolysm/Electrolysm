package electro.crafting.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class CPU extends Item
{
    public CPU()
    {
        super();
        // TODO Auto-generated constructor stub
        {
            this.setCreativeTab(electrolysmCore.TabElectrolysm);
            this.setUnlocalizedName("CPU");
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
    	this.itemIcon = reg.registerIcon("electrolysm:" + "CPU");
    }
}