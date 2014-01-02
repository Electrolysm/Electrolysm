package assets.electrolysm.electro.powerSystem;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.api.powerSystem.TileEntityPlug;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.te.TileEntityPlugBasic;

public class plug extends BlockContainer {

	public plug(int id, Material mat) {
		super(id, Material.iron);

		this.setUnlocalizedName("plug");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.blockHardness = 1.25F;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityPlugBasic();
	}
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6,
    		float par7, float par8, float par9)
    {
    	ItemStack meterStack = new ItemStack(electrolysmCore.energyMeter);
    	TileEntityPlug te = (TileEntityPlug)world.getBlockTileEntity(x, y, z);
    	
    	if(player.isSneaking())
    	{
    		return false;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }
}
