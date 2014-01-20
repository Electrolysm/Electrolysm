package assets.electrolysm.electro.powerSystem;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.te.TileEntityWire;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class wire extends BlockContainer {

	public wire(int par1, Material par2Material) {
		super(par1, Material.cloth);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("wireTeU");
		this.setHardness(0.25F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityWire();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister reg)
	{
		this.blockIcon = reg.registerIcon("electrolysm:" + "graphiteWire");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int dmg)
	{
		return this.blockIcon;
	}
	
	
	@Override
	public int getRenderType() 
	{
        	return -1;	
	}

	@Override
	public boolean isOpaqueCube() 
	{
			return false;
	}

	public boolean renderAsNormalBlock() 
	{
        return false;
	}
	
	@Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int x, int y, int z)
    {
        TileEntity tileEntity = par1IBlockAccess.getBlockTileEntity(x, y, z);
        if (tileEntity instanceof TileEntityWire)
        {
        	TileEntityWire te = (TileEntityWire) tileEntity;
            this.minX = te.getAdjacentConnections()[4] != null ? 0F : 0.3F;
            this.minY = te.getAdjacentConnections()[0] != null ? 0F : 0.3F;
            this.minZ = te.getAdjacentConnections()[2] != null ? 0F : 0.3F;
            this.maxX = te.getAdjacentConnections()[5] != null ? 1F : 0.7F;
            this.maxY = te.getAdjacentConnections()[1] != null ? 1F : 0.7F;
            this.maxZ = te.getAdjacentConnections()[3] != null ? 1F : 0.7F;
        }
    }

}
