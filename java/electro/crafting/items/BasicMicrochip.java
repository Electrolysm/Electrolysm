package electro.crafting.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class BasicMicrochip extends Item
{
    public BasicMicrochip()
    {
        super();
        // TODO Auto-generated constructor stub
        {
            this.setCreativeTab(Electrolysm.TabElectrolysm);
            this.setUnlocalizedName("Basic Microchip");
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
    	this.itemIcon = reg.registerIcon("electrolysm:" + "basicMicro");
    }
}