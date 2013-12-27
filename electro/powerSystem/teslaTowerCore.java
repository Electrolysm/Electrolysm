package assets.electrolysm.electro.powerSystem;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.generators.te.TileEntityGenerator;
import assets.electrolysm.electro.powerSystem.te.TileEntityTeslaTower;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class teslaTowerCore extends BlockContainer 
{
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
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
    		int par6, float par7, float par8, float par9)
	{
		if(player.isSneaking())
		{
			if(player.getHeldItem() == null)
			{
				this.printChatMessage(world, x, y, z);
				return true;
			}
			return false;
		}
		else
		{
			//player.openGui(electrolysmCore.GUIInstance, 0, world, x, y, z);
			//System.out.println(this.isTowerFormed(world, x, y, z));
			return false;
		}
	}
	
	@SideOnly(Side.CLIENT)
    private void printChatMessage(World world, int x, int y, int z) 
    {
		String message = "";
		
    	if(world.isRemote)
    	{
    		TileEntityTeslaTower te = (TileEntityTeslaTower)world.getBlockTileEntity(x, y, z);
    		if(this.isTowerFormed(world, x, y, z))
    		{	
    			if(te.canDistribute(world, x, y, z))
    			{
    	    		message = "This Tesla Tower is transmitting " + String.valueOf(te.getRecievingTeU(world, x, y, z)) + " TeU";
    			}
    			else
    			{
    				message = "This Tesla Tower is formed, but isn't transmitting energy!";
    			}
    		}
    		else
    		{
    			message = "This Tesla Towers isn't correctly formed!";
    		}
    		
    		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);	
    	}
    	else
    	{
    		
    	}
    }
	
	public boolean isTowerFormed(World world, int x, int y, int z)
	{
		int copperCoil = electrolysmCore.largeCopperCoil.blockID;
		int ironFrame = electrolysmCore.ironFrames.blockID;
		
		if(world.canBlockSeeTheSky(x, y + 1, z))
		{
			if(world.getBlockId(x, y - 1, z) == ironFrame)
			{
				if(world.getBlockId(x, y - 2, z) == ironFrame)
				{
					if(world.getBlockId(x, y - 3, z) == ironFrame)
					{
						if(world.getBlockId(x, y - 4, z) == ironFrame)
						{
							if(world.getBlockId(x, y - 5, z) == ironFrame)
							{
								for(int xx = -1; xx <= 1; xx++)
								{
									for(int zz = -1; zz <= 1; zz++)
									{
										if(zz == 0 && xx == 0)
										{}
										else
										{
											if(world.getBlockId(x + xx, y - 1, z + zz) == copperCoil)
											{
												return true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	/*
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	 
	 public int getRenderType()
	 {
		 return -1;
	 }
*/
}
