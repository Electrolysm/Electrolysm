package electro.research;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class idifier extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon blockTop;

    public idifier()
    {
        super(Material.iron);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness((float)Math.PI);
    }
    //idifierTop
    //idifierSide

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:" + "idifierSide");
        this.blockTop = reg.registerIcon("electrolysm:" + "idifierTop");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (side == 1 || side == 0)
        {
            return this.blockTop;
        }
        else
        {
            return this.blockIcon;
        }
    }
}
