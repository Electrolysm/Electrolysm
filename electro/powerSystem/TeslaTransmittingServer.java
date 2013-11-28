package assets.electrolysm.electro.powerSystem;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//@SideOnly(Side.SERVER)
public class TeslaTransmittingServer {

	//@SideOnly(Side.SERVER)
	public static Map user = new HashMap();
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

	//SideOnly(Side.SERVER)
	public static void saveTransmition(String dimensionName, int x, int y, int z, int range, int freq,
			String username)
	{
		user.put(freq, username);
		xCoord.put(freq + ":" + username, x);
		yCoord.put(freq + ":" + username, y);
		zCoord.put(freq + ":" + username, z);
		transmitRange.put(freq + ":" + username, range);
		freqency.put(freq + ":" + username, freq);
		dName.put(freq + ":" + username, dimensionName);
	}
	
	//@SideOnly(Side.SERVER)
	public static String[] getData(int freq, String username)
	{
		String[] result= new String[5];
		
		result[0] = (xCoord.get(freq + ":" + username) + "");
		result[1] = (yCoord.get(freq + ":" + username) + "");
		result[2] = (zCoord.get(freq + ":" + username) + "");
		result[3] = (transmitRange.get(freq + ":" + username) + "");;
		result[4] = (String)dName.get(freq + ":" + username);
		
		return result;
	}
}
