package assets.electrolysm.electro.powerSystem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.powerSystem.te.TileEntityAdvEarther;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class advEarther extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private Icon blockTop;
	
	public advEarther(int id, Material mat) {
		super(id, Material.iron);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityAdvEarther();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister reg)
	{
		this.blockIcon = reg.registerIcon("electrolysm:" + "advEartherSide");
		this.blockTop = reg.registerIcon("electrolysm:" + "advEartherTop");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		if(side == 1 || side == 0)
		{
			return this.blockTop;
		}
		else
		{
			return this.blockIcon;
		}
	}

}
