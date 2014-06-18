package electro.item.basic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class drillHead extends Item
{
  public drillHead()
    {
        super();
        // TODO Auto-generated constructor stub
        {
            this.setCreativeTab(electrolysmCore.TabElectrolysm);
            this.setUnlocalizedName("Drill Head");
        }
    }
}

