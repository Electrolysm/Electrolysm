package electrolysm.electro.world;

import electrolysm.electro.Electrolysm;
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

    @Override
    public void registerIcons(IIconRegister reg) {
        itemIcon = reg.registerIcon("electrolysm:ingotAluminium");
    }
}