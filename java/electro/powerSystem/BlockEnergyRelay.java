package electro.powerSystem;

import api.powerSystem.prefab.BlockEnergy;
import api.powerSystem.prefab.TileEntityRelay;
import electro.Electrolysm;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 30/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class BlockEnergyRelay extends BlockEnergy
{
    public BlockEnergyRelay()
    {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness((float) Math.PI);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityRelay();
    }

    IIcon[] icons = new IIcon[3];

    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        icons[0] = reg.registerIcon("electrolysm:energyRelay_DEFAULT");
        icons[1] = reg.registerIcon("electrolysm:energyRelay_INPUT");
        icons[2] = reg.registerIcon("electrolysm:energyRelay_OUTPUT");
    }

    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        TileEntityRelay te = (TileEntityRelay)world.getTileEntity(x, y, z);
        return icons[te.getState(side)];
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return icons[0];
    }
}
