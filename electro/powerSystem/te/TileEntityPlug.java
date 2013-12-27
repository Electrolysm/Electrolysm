package assets.electrolysm.electro.powerSystem.te;

import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.tile.IEnergySource;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import assets.electrolysm.electro.powerSystem.TeslaTransmittingServer;
import cpw.mods.fml.common.Loader;

public class TileEntityPlug extends TileEntity{

	public void updateEntity()
	{
		if(this.getClosestTowerWithinRange(worldObj, xCoord, yCoord, zCoord, 1, "username") != null)
		{
			//System.out.println("Power is being transfered");
		}
		//System.out.println(this.getRecievedTeUAfterResistance(worldObj, xCoord, yCoord, zCoord));
		//System.out.println(this.getRecievedTeUPure(worldObj, xCoord, yCoord, zCoord));
	}

	private int[] getClosestTowerWithinRange(World world, int x, int y, int z, int freq, String username) 
	{
		int[] result = new int[6];
		for(int i = 0; i < TeslaTransmittingServer.user.size(); i++)
		{
			String[] serverData = TeslaTransmittingServer.getData(freq, username);
			if(serverData != null && serverData[1] != null)
			{
				int towerX = Integer.parseInt(serverData[0]);
				int towerY = Integer.parseInt(serverData[1]);
				int towerZ = Integer.parseInt(serverData[2]);
				
				int distance = this.calculateDistance(x, y, z, towerX, towerY, towerZ);
				int towerRange = Integer.parseInt(serverData[3]);
				int TeU = Integer.parseInt(serverData[5]);
				
				//System.out.print(TeU);
				
				result[0] = towerX;
				result[1] = towerY;
				result[2] = towerZ;
				result[3] = distance;
				result[4] = towerRange;
				result[5] = TeU;
				
				if(distance <= towerRange)
				{
					return result;
				}
			}
		}
		return null;
	}
	public int getRecievedTeUPure(World world, int x, int y, int z)
	{
		
		if(this.getClosestTowerWithinRange(world, x, y, z, 1, "username") != null)
		{
			int[] towerData = this.getClosestTowerWithinRange(world, x, y, z, 1, "username");
			
			int TeUBefore = towerData[5];
			return TeUBefore;
		}
		return 0;
		
	}
	public int getRecievedTeUAfterResistance(World world, int x, int y, int z)
	{
		int frequency = 1;
		String username = "username";
		
		if(this.getClosestTowerWithinRange(world, x, y, z, frequency, username) != null)
		{
			int[] towerData = this.getClosestTowerWithinRange(world, x, y, z, frequency, username);
	
			int TeUBefore = towerData[5];
			int towerRange = towerData[4];
			int distanceTower = towerData[3];

			int TeU = (int) (TeUBefore * this.calculateFraction(towerRange, distanceTower));
			
			return TeU;
		}
		return 0;
	}
	
	private float calculateFraction(int total, int fractionOfTotal)
	{
		float faction = (fractionOfTotal / total);
		return faction;
	}
	
	private int calculateDistance(int x, int y, int z, int towerX, int towerY, int towerZ) 
	{
		int xPower = (int)Math.pow((x - towerX), 2);
		int yPower = (int)Math.pow((y - towerY), 2);
		int zPower = (int)Math.pow((z - towerZ), 2);
		
		return (int)(Math.sqrt(xPower + yPower + zPower));
	}

	//This is a temporary equation this will be changed!!
	public float TeUtoAmps(int TeU)
	{
		float amps1 = (float)((Math.sqrt((TeU*Math.pow((Math.PI - 3), 2)) / Math.pow(Math.E, 2))));
		if(amps1 > 1 && amps1 < 10)
		{
			return (amps1 / 10);
		}
		else if(amps1 > 10 && amps1 < 100)
		{
			return (amps1 / 100);
		}
		else
		{
			return 0.5F;
		}
	
	}
	
	public int TeUtoVolts(int TeU)
	{
		return (TeU * 1000);
	}
	
	
    public int TeUtoEU(int TeU)
    {
    	float amps = this.TeUtoAmps(TeU);
    	int volts = this.TeUtoVolts(TeU);
    	
    	int EU = (int)(((volts * amps) * (Math.PI - 3)) * 5);
    	return EU;
    }
}