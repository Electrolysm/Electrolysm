package assets.electrolysm.electro.powerSystem;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.te.TileEntityPlug;

public class plug extends BlockContainer {

	public plug(int id, Material mat) {
		super(id, Material.ice);

		this.setUnlocalizedName("plug");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityPlug();
	}
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6,
    		float par7, float par8, float par9)
    {
    	TileEntityPlug te = new TileEntityPlug();
    	
    	if(player.isSneaking())
    	{
    		return false;
    	}
    	else if(te.isRecieving())
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
