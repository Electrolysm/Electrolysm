package assets.electrolysm.api.power;

import java.util.HashMap;
import java.util.Map;

public class PowerHandler {

	public static String[] cableTypes = {"goldCable", "graphiteCable", "copperCable"};
	public static Map wireMap = new HashMap();
	
	public static class cableTypesClass{
		public static String goldCable = cableTypes[0];
		public static String graphiteCable = cableTypes[1];
		public static String copperCable = cableTypes[2];
		}
	
	public static void loadMap()
	{
		wireMap.put(cableTypesClass.goldCable, 200);
	}
}
