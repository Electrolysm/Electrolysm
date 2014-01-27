package assets.electrolysm.electro.powerSystem;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//@SideOnly(Side.SERVER)
public class TeslaTransmittingServer {

	public static Map transmitRange = new HashMap();
	public static Map TeUMap = new HashMap();
	
	//SideOnly(Side.SERVER)
	public static void saveTransmition(String dimensionName, int x, int y, int z, int range, int TeU)
	{
        String key = x + ":" + y + ":" + z + ":" + dimensionName;

		transmitRange.put(key, range);
		TeUMap.put(key, TeU);

		//System.out.println("Transmition Saved");
	}
	
	//@SideOnly(Side.SERVER)
	public static String[] getData(String key)
	{
		String[] result= new String[2];
		
		if(!(transmitRange.isEmpty()))
		{
			result[0] = (String)transmitRange.get(key);
            result[1] = (String)TeUMap.get(key);

			//System.out.println("Data Pulled");

			return result;
		}
		else
		{
			return null;
		}
	}
	
	public static void clearAll()
	{

		transmitRange.clear();
		TeUMap.clear();
		
		//System.out.println("Data Cleared");
	}
}
