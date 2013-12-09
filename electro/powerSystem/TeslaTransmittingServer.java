package assets.electrolysm.electro.powerSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

//@SideOnly(Side.SERVER)
public class TeslaTransmittingServer {

	//@SideOnly(Side.SERVER)
	public static Map taken = new HashMap();
	//@SideOnly(Side.SERVER)
	public static Map xCoord = new HashMap();
	//@SideOnly(Side.SERVER)
	public static Map yCoord = new HashMap();
	//@SideOnly(Side.SERVER)
	public static Map zCoord = new HashMap();
	//@SideOnly(Side.SERVER)
	public static Map transmitRange = new HashMap();
	//@SideOnly(Side.SERVER)
	public static Map freqency = new HashMap();
	//@SideOnly(Side.SERVER)
	public static Map dName = new HashMap();
	public static Map randomMap = new HashMap();
	public static int[] crystalLst;

	//SideOnly(Side.SERVER)
	public static void saveTransmition(String dimensionName, int x, int y, int z, int range, int freq,
			String username, ItemStack patternID)
	{
		if(((ItemStack)taken.get(patternID)) == null)
		{
			taken.put(patternID, patternID);
			xCoord.put(patternID, x);
			yCoord.put(patternID, y);
			zCoord.put(patternID, z);
			transmitRange.put(patternID, range);
			freqency.put(patternID, freq);
			dName.put(patternID, dimensionName);
		}
		else
		{
			System.out.println("[Electrolysm] This item is already being used!");
		}
	}
	
	//@SideOnly(Side.SERVER)
	public static String[] getData(ItemStack patternID)
	{
		String[] result= new String[5];
		
		if((ItemStack)taken.get(patternID) != null)
		{
			result[0] = (xCoord.get(patternID) + "");
			result[1] = (yCoord.get(patternID) + "");
			result[2] = (zCoord.get(patternID) + "");
			result[3] = (transmitRange.get(patternID) + "");;
			result[4] = (String)dName.get(patternID);
		}
		else
		{
			System.out.println("[Electrolysm] There is not registered tower with this pattern!");
			return null;
		}
		return result;
	}
	
	public static int[] getNearestTowerWithSamePatternID(World World, int x, int y, int z, ItemStack patternID)
	{
	/*
		user.put(freq, username);
		xCoord.put(patternID, x);
		yCoord.put(patternID, y);
		zCoord.put(patternID, z);
		transmitRange.put(patternID, range);
		freqency.put(patternID, freq);
		dName.put(patternID, dimensionName);
		*/
		int[] xCoordX = new int[4];
		int[] yCoordY = new int[4];
		int[] zCoordZ = new int[4];
		
		if(taken.get(patternID) != null)
		{
			int towerX = Integer.parseInt((xCoord.get(patternID) + ""));
			int towerY = Integer.parseInt((yCoord.get(patternID) + ""));
			int towerZ = Integer.parseInt((zCoord.get(patternID) + ""));
			int range = Integer.parseInt((transmitRange.get(patternID) + ""));
			String dimension = (String) dName.get(patternID + "");
			
			if(getDistance(x, y, z, towerX, towerY, towerZ) <= getArcRange(range, range))
			{
				
			}
		}
		return null; 
	}
	
	private static int getArcRange(int TeU, int range) 
	{
		int volts = (TeU * 10000);
		float amps = (float)((Math.sqrt((100*Math.pow(Math.PI, 2)) / Math.pow(Math.E, 2))));
		return (int)((amps * volts) / 10000);
	}

	public static int getDistance(int posX, int posY, int posZ, int x, int y, int z)
	{
		int xPower = (int)Math.pow((x - posX), 2);
		int yPower = (int)Math.pow((y - posY), 2);
		int zPower = (int)Math.pow((z - posZ), 2);
		
		return (int)(Math.sqrt(xPower + yPower + zPower));
	}
	
	public static void putCrystalData(int damage)
	{
		crystalLst[damage] = damage;
	}
	
}
