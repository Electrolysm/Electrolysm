package assets.electrolysm.electro.powerSystem;

import assets.electrolysm.electro.powerSystem.te.TileEntityAdvEarther;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class advEarther extends BlockContainer {

	public advEarther(int id, Material mat) {
		super(id, Material.iron);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityAdvEarther();
	}

}
