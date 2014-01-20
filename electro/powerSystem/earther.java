package assets.electrolysm.electro.powerSystem;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.te.TileEntityEarther;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class earther extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private Icon blockTop;

	public earther(int id, Material mat) {
		super(id, Material.iron);

		this.setUnlocalizedName("earther");
		this.setHardness(2.356575F);
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityEarther();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister reg)
	{
		this.blockIcon = reg.registerIcon("electrolysm:" + "eartherSide");
		this.blockTop = reg.registerIcon("electrolysm:" + "eartherTop");
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
