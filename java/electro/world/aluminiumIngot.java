package electro.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class aluminiumIngot extends Item
{
    public aluminiumIngot()
    {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setUnlocalizedName("aluminiumIngot");
    }
}