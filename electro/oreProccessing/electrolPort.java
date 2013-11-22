package assets.electrolysm.electro.oreProccessing;

import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.oreProccessing.te.TileEntityPort;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class electrolPort extends BlockContainer {

	public electrolPort(int id, Material mat) {
		super(id, Material.iron);
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("electrolPort");
		this.setHardness(4F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityPort();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if(player.isSneaking())
		{
			return false;
		}
		else if(!player.isSneaking())
		{
            player.openGui(electrolysmCore.GUIInstance, 0, world, x, y, z);
            return true;
		}
		else
		{
			return false;
		}
	}
}
