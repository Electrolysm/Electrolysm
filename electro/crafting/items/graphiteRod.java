package assets.electrolysm.electro.crafting.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class graphiteRod extends Item
{
    public graphiteRod(int par1)
    {
        super(par1);
            this.setCreativeTab(electrolysmCore.TabElectrolysm);
            this.setUnlocalizedName("Graphite Rod");
    }
    
        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister reg)
        {
        	this.itemIcon = reg.registerIcon("electrolysm:" + this.getUnlocalizedName().replace(".item", ""));
        }
}