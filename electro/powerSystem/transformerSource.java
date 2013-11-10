package assets.electrolysm.electro.powerSystem;

import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.te.TileEntityTransformerSource;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class transformerSource extends BlockContainer {

	public transformerSource(int par1, Material par2Material) {
		super(par1, Material.iron);

	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName("transformerSource");
	this.setHardness(6);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityTransformerSource();
	}
	
	@Override
	public int getRenderType() {
        	return -1;	
	}

	//It's not an opaque cube, so you need this.
	@Override
	public boolean isOpaqueCube() {
			return false;
	}

	//It's not a normal block, so you need this too.
	public boolean renderAsNormalBlock() {
        return false;
	}

}
