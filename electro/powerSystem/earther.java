package assets.electrolysm.electro.powerSystem;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.te.TileEntityEarther;

public class earther extends BlockContainer {

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
	
}
