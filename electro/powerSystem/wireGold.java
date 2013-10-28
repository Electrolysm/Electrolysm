package assets.electrolysm.electro.powerSystem;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.te.TileEntityWire;

public class wireGold extends BlockContainer {

	public wireGold(int par1, Material par2Material) {
		super(par1, Material.cloth);
		
		this.setUnlocalizedName("wireGold");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setHardness(1F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityWire();
	}
}
