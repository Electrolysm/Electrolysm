package assets.electrolysm.electro.powerSystem.generators.extra;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;

public class coolerProccesser extends BlockContainer {

	public coolerProccesser(int id, Material mat) {
		super(id, Material.iron);
		
		this.setUnlocalizedName("coolerProccesser");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityCoolerProcesser();
	}

}
