package assets.electrolysm.electro.powerSystem;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//@SideOnly(Side.SERVER)
public class TeslaTransmittingServer {

	public static Map user = new HashMap();
	public static Map xCoord = new HashMap();
	public static Map yCoord = new HashMap();
	public static Map zCoord = new HashMap();
	public static Map transmitRange = new HashMap();
	public static Map freqency = new HashMap();
	public static Map dName = new HashMap();
	public static Map TeUMap = new HashMap();
	
	//SideOnly(Side.SERVER)
	public static void saveTransmition(String dimensionName, int x, int y, int z, int range, int freq,
			String username, int TeU)
	{
		user.put(freq, username);
		xCoord.put(freq + ":" + username, x);
		yCoord.put(freq + ":" + username, y);
		zCoord.put(freq + ":" + username, z);
		transmitRange.put(freq + ":" + username, range);
		freqency.put(freq + ":" + username, freq);
		dName.put(freq + ":" + username, dimensionName);
		TeUMap.put(freq + ":" + username, TeU);
	}
	
	//@SideOnly(Side.SERVER)
	public static String[] getData(int freq, String username)
	{
		String[] result= new String[6];
		
		result[0] = (xCoord.get(freq + ":" + username) + "");
		result[1] = (yCoord.get(freq + ":" + username) + "");
		result[2] = (zCoord.get(freq + ":" + username) + "");
		result[3] = (transmitRange.get(freq + ":" + username) + "");;
		result[4] = (String)dName.get(freq + ":" + username);
		result[5] = String.valueOf(TeUMap.get(freq + ":" + username));
		
		return result;
	}
	
	public static void clearAll()
	{
		user.clear();
		xCoord.clear();
		yCoord.clear();
		zCoord.clear();
		transmitRange.clear();
		freqency.clear();
		dName.clear();
		TeUMap.clear();
	}
}
