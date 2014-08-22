package electrolysm.electro.misc.crafting.items;

import electrolysm.electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class graphiteRod extends Item
{
    public graphiteRod()
    {
        super();
            this.setCreativeTab(Electrolysm.TabElectrolysm);
            this.setUnlocalizedName("graphiteRod");
    }
    
        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IIconRegister reg)
        {
        	this.itemIcon = reg.registerIcon("electrolysm:" + this.getUnlocalizedName().replace("item.", ""));
        }
}