package assets.electrolysm.electro.powerSystem.te;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.te.TileEntityIronFrame;
import assets.electrolysm.electro.powerSystem.generators.te.TileEntityGenerator;

public class TileEntityWire extends TileEntity
{
    protected boolean[] visuallyConnected = new boolean[6];
    protected TileEntity[] adjacentConnections = new TileEntity[6];
    /*
    @Override
    public void updateEntity()
    {
        for (byte i = 0; i < 6; i++)
        {
            ForgeDirection dir = ForgeDirection.getOrientation(i);
            this.updateConnection(this.worldObj.getBlockTileEntity(this.xCoord + dir.offsetX, this.yCoord + dir.offsetY,
            		this.zCoord + dir.offsetZ), dir);
        }
    }
    
    public void updateConnection(TileEntity that, ForgeDirection side)
    {
        if (!this.worldObj.isRemote && that != null && this.canConnect(side))
        {
        }
        else if (that instanceof TileEntityWire)
        {
          	TileEntityWire tileEntityIns = (TileEntityWire) that;
               
            if (((TileEntityWire) that).canConnect(side.getOpposite()))
            {
                  this.adjacentConnections[side.ordinal()] = that;
                  this.visuallyConnected[side.ordinal()] = true;
                      
                  return;
            }
        }
        else if (that instanceof TileEntityIronFrame)
        {
        	TileEntityIronFrame tileEntityIns = (TileEntityIronFrame) that;
	           
	        if (((TileEntityIronFrame) that).canConnect(side.getOpposite()))
	        {
	             this.adjacentConnections[side.ordinal()] = that;
	             this.visuallyConnected[side.ordinal()] = true;
	                
	             return;
	        }
	    }
        else if (that instanceof TileEntityGenerator)
	    {
        	TileEntityGenerator tileEntityIns = (TileEntityGenerator) that;
	            
	        if (((TileEntityGenerator) that).canConnect(side.getOpposite()))
	        {
	            this.adjacentConnections[side.ordinal()] = that;
	            this.visuallyConnected[side.ordinal()] = true;
	                
	            return;
	        }
	    }
        
        this.adjacentConnections[side.ordinal()] = null;
        this.visuallyConnected[side.ordinal()] = false;
    }

	public boolean canConnect(ForgeDirection side) 
	{
		return true;
	}	
	
    public boolean[] getVisualConnections()
    {
        return this.visuallyConnected;
    }

	public TileEntity[] getAdjacentConnections() 
	{
		return adjacentConnections;
	}
	
	public int getRecievingTeUOverall(World world, int x, int y, int z, int thisX, int thisY, int thisZ)
	{
		return this.getRecievingTeUGenerator(world, x, y, z) + this.getRecievingTeUWire(world, x, y, z, thisX, thisY, thisZ);
	}
	
	public int getRecievingTeUGenerator(World world, int x, int y, int z)
	{
		int generatorID = electrolysmCore.generator.blockID;
		
		int teu1 = 0;
		int teu2 = 0;
		int teu3 = 0;
		int teu4 = 0;
		
		//x + 1
		if(world.getBlockId(x + 1, y, z) == generatorID)
		{
			TileEntityGenerator teGen = (TileEntityGenerator)world.getBlockTileEntity(x + 1, y, z);
			teu1 = teGen.getSendTeU(world, x + 1, y, z);
		}
		//x - 1
		if(world.getBlockId(x - 1, y, z) == generatorID)
		{
			TileEntityGenerator teGen = (TileEntityGenerator)world.getBlockTileEntity(x - 1, y, z);
			teu2 = teGen.getSendTeU(world, x - 1, y, z);
		}
		//z + 1
		if(world.getBlockId(x, y, z + 1) == generatorID)
		{
			TileEntityGenerator teGen = (TileEntityGenerator)world.getBlockTileEntity(x, y, z + 1);
			teu3 = teGen.getSendTeU(world, x, y, z + 1);
		}
		//z - 1
		if(world.getBlockId(x, y, z - 1) == generatorID)
		{
			TileEntityGenerator teGen = (TileEntityGenerator)world.getBlockTileEntity(x, y, z - 1);
			teu4 = teGen.getSendTeU(world, x, y, z - 1);
		}
		
		return (teu1 + teu2 + teu3 + teu4);
	}
	
	public int getRecievingTeUWire(World world, int x, int y, int z , int thisX, int thisY, int thisZ)
	{
		int wireID = electrolysmCore.wire.blockID;
		
		int teu1 = 0;
		int teu2 = 0;
		int teu3 = 0;
		int teu4 = 0;
		int teu5 = 0;
		int teu6 = 0;
		
		System.out.println("wireTEUCheck");
		//x + 1
		if((x + 1) != thisX)
		{
			System.out.println("x+1");
			if(world.getBlockId(x + 1, y, z) == wireID)
			{
				System.out.println("x+1True");
				TileEntityWire teGen = (TileEntityWire)world.getBlockTileEntity(x + 1, y, z);
				teu1 = teGen.getRecievingTeUOverall(world, x + 1, y, z, x, y, z);
			}
		}
		//x - 1
		if((x - 1) != thisX)
		{
			System.out.println("x-1");
			if(world.getBlockId(x - 1, y, z) == wireID)
			{
				System.out.println("x-1True");
				TileEntityWire teGen = (TileEntityWire)world.getBlockTileEntity(x - 1, y, z);
				teu2 = teGen.getRecievingTeUOverall(world, x - 1, y, z, x, y, z);
			}
		}
		//z + 1
		if((z + 1) != thisZ)
		{
			System.out.println("z+1");
			if(world.getBlockId(x, y, z + 1) == wireID)
			{
				System.out.println("z+1True");
				TileEntityWire teGen = (TileEntityWire)world.getBlockTileEntity(x, y, z + 1);
				teu3 = teGen.getRecievingTeUOverall(world, x, y, z + 1, x, y, z);
			}
		}
		//z - 1
		if((z - 1) != thisZ)
		{
			System.out.println("z-1");
			if(world.getBlockId(x, y, z - 1) == wireID)
			{
				System.out.println("z-1True");
				TileEntityWire teGen = (TileEntityWire)world.getBlockTileEntity(x, y, z - 1);
				teu4 = teGen.getRecievingTeUOverall(world, x, y, z - 1, x, y, z);
			}
		}
		//y + 1
		if((y + 1) != thisY)
		{
			System.out.println("y+1");
			if(world.getBlockId(x, y + 1, z) == wireID)
			{
				System.out.println("y+1True");
				TileEntityWire teGen = (TileEntityWire)world.getBlockTileEntity(x, y + 1, z);
				teu5 = teGen.getRecievingTeUOverall(world, x, y + 1, z, x, y, z);
			}
		}
		//y - 1
		if((y - 1) != thisY)
		{
			System.out.println("y-1");
			if(world.getBlockId(x, y - 1, z) == wireID)
			{
				System.out.println("y-1True");
				TileEntityWire teGen = (TileEntityWire)world.getBlockTileEntity(x, y - 1, z);
				teu6 = teGen.getRecievingTeUOverall(world, x, y - 1, z, x, y, z);
			}
		}
		return (teu1 + teu2 + teu3 + teu4 + teu5 + teu6);
	}

	public boolean backToTesla(World world, int x, int y, int z, int thisX, int thisY, int thisZ) 
	{
		System.out.println("TraceBack");
		for(int i = 0; i < adjacentConnections.length; i++)
		{
			if(visuallyConnected[i])
			{
				System.out.println("visual");
				TileEntity tete = adjacentConnections[i];
				
				System.out.println("coordCheck");
				if(world.getBlockTileEntity(tete.xCoord, tete.yCoord, tete.zCoord) instanceof TileEntityIronFrame)
				{
					System.out.println("teCheck");
					TileEntityIronFrame teFrame = (TileEntityIronFrame)tete;
					if(teFrame.canBePowered(world, teFrame.xCoord, teFrame.yCoord, teFrame.zCoord));
					{
						System.out.println("powerCheck");
							return true;
					}
				}
				else if(world.getBlockTileEntity(tete.xCoord, tete.yCoord, tete.zCoord) instanceof TileEntityWire)
				{
					System.out.println("elseTECheck");
					TileEntityWire te = (TileEntityWire)adjacentConnections[i];
					//if(te.xCoord != xCoord && te.yCoord != yCoord && te.zCoord != zCoord)
					//{
						System.out.println("CoordCheck1");
						if(te.xCoord != thisX && te.yCoord != thisY && te.zCoord != thisY)
						{
							System.out.println("CoordCheck2");
							if(te.backToTesla(world, te.xCoord, te.yCoord, te.zCoord, x, y, z))
							{
								System.out.println("wireCheck");
								return true;
							}
							else
							{
								return false;
							}
					//	}
					}
				}
			}
		}
		return false;
	}
	*/
}
