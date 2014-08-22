package electrolysm.electro.misc.crafting.items;

import electrolysm.electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class transistor extends Item
{
    public transistor()
    {
        super();
            this.setCreativeTab(Electrolysm.TabElectrolysm);
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