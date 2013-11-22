package assets.electrolysm.electro.oreProccessing;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.oreProccessing.te.TileEntityElectrolisisCore;
/**
 * 
 * @author Ben
 * @TODO Create texture rendering system, based on ItemStack in specified slot.
 * 
 */
public class electrolisisCore extends BlockContainer {

	public String className = "" + this.getClass();
	public String unlocalName = className.replace("assets.electrolysm.electro", "");
	public String textureName = unlocalName.replace(".", "/");
	
	public electrolisisCore(int par1, Material par2Material) {
		super(par1, Material.iron);

	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName(unlocalName);
	this.setHardness(6.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityElectrolisisCore();
	}

	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		int chamberID = electrolysmCore.electrolisisCore.blockID;
		int waterID = Block.waterStill.blockID;
		
		if(player.isSneaking() && !this.isFormed(x, y, z, world, chamberID, waterID))
		{
			return false;
		}
		else if(!player.isSneaking() && this.isFormed(x, y, z, world, chamberID, waterID))
		{
            player.openGui(electrolysmCore.GUIInstance, 0, world, x, y, z);
            return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isFormed(int x, int y, int z, World world, int chamberID, int waterID)
	{
		int chamber = electrolysmCore.electrolChamber.blockID;
		int water = Block.waterStill.blockID;
		int port = electrolysmCore.electrolPort.blockID;
		int air = 0;
		boolean isFormed = false;
		
		//Top row
		if(world.getBlockId(x, y + 1, z) == water || world.getBlockId(x, y + 1, z) == air)
		{
			if(world.getBlockId(x + 1, y + 1, z) == chamber)
			{
				if(world.getBlockId(x + 1, y + 1, z + 1) == chamber)
				{
					if(world.getBlockId(x + 1, y + 1, z - 1) == chamber)
					{
						if(world.getBlockId(x - 1, y + 1, z) == chamber)
						{
							if(world.getBlockId(x - 1, y + 1, z + 1) == chamber)
							{
								if(world.getBlockId(x - 1, y + 1, z - 1) == chamber)
								{
									if(world.getBlockId(x, y + 1, z + 1) == chamber)
									{
										if(world.getBlockId(x, y + 1, z - 1) == chamber)
										{
		//Bottom Row
		if(world.getBlockId(x, y - 1, z) == chamber)
		{
			if(world.getBlockId(x + 1, y - 1, z) == chamber)
			{
				if(world.getBlockId(x + 1, y - 1, z + 1) == chamber)
				{
					if(world.getBlockId(x + 1, y - 1, z - 1) == chamber)
					{
						if(world.getBlockId(x - 1, y - 1, z) == chamber)
						{
							if(world.getBlockId(x - 1, y - 1, z + 1) == chamber)
							{
								if(world.getBlockId(x - 1, y - 1, z - 1) == chamber)
								{
									if(world.getBlockId(x, y - 1, z + 1) == chamber)
									{
										if(world.getBlockId(x, y - 1, z - 1) == chamber)
										{
		
		//Middle Row
		if(world.getBlockId(x + 1, y, z) == chamber || world.getBlockId(x + 1, y, z) == port)
		{
			if(world.getBlockId(x - 1, y, z) == chamber || world.getBlockId(x - 1, y, z) == port)
			{
				if(world.getBlockId(x, y, z + 1) == chamber || world.getBlockId(x, y, z + 1) == port)
				{
					if(world.getBlockId(x, y, z - 1) == chamber || world.getBlockId(x, y, z - 1) == port)
					{
						if(world.getBlockId(x + 1, y, z + 1) == chamber)
						{
							if(world.getBlockId(x - 1, y, z + 1) == chamber)
							{
								if(world.getBlockId(x + 1, y, z - 1) == chamber)
								{
									if(world.getBlockId(x - 1, y, z - 1) == chamber)
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
							}
						}
					}
				}
			}
		}
		
		return isFormed;
	}
	
	@Override
	public int getRenderType() 
	{
        	return -1;	
	}

	@Override
	public boolean isOpaqueCube() 
	{
			return false;
	}

	public boolean renderAsNormalBlock() 
	{
        return false;
	}
}
