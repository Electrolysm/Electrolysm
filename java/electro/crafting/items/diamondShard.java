package electro.crafting.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class diamondShard extends Item
{
    public diamondShard(int par1)
    {
        super(par1);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("diamondShard");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:" + "diamondShard");
    }
}
