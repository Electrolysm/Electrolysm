package assets.electrolysm.electro.powerSystem;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.te.TileEntityTeslaTower;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class teslaTowerCore extends BlockContainer 
{
	@SideOnly(Side.CLIENT)
	private Icon blockTopIcon;
	@SideOnly(Side.CLIENT)
	private Icon blockTopOffIcon;
	
	public teslaTowerCore(int id, Material mat) {
		super(id, Material.iron);
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("teslaTowerCore");
		this.setHardness(1F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
		return new TileEntityTeslaTower();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		if(side == 1)
		{
			if(meta == 1)
			{
				return this.blockTopOffIcon;
			}
			else
			{
				return this.blockTopIcon;
			}
		}
		else
		{
			return this.blockIcon;
		}
	}
	
    public void onNeighborBlockChange(World world, int x, int y, int z, int block) 
    {
    	if(this.isRecievingRedstonePower(world, x, y, z))
    	{
    		TileEntityTeslaTower te = (TileEntityTeslaTower)world.getBlockTileEntity(x, y, z);
    		
    		te.updateState(world, x, y, z);
    	}
    }

	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		this.blockIcon = reg.registerIcon("electrolysm:teslaTowerCore/" + "sides");
		this.blockTopIcon = reg.registerIcon("electrolysm:teslaTowerCore/" + "tier1Top");
		this.blockTopOffIcon = reg.registerIcon("electrolysm:teslaTowerCore/" + "tier1TopOff");
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
    		int par6, float par7, float par8, float par9)
	{
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
    public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side)
    {
        return true;
    }
	
	/**
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * returns true if the block is recieving a redstone signal
	 */
	public boolean isRecievingRedstonePower(World world, int x, int y, int z)
	{
		return (world.isBlockIndirectlyGettingPowered(x, y, z));
	}
	
    public int damageDropped(int par1)
    {
        return 0;
    }
}
