package assets.electrolysm.electro.handlers;

import java.util.Random;
import assets.electrolysm.electro.configHandler;
import assets.electrolysm.electro.client.ClientProxy;

public class BetaHandler {
	
	public static boolean beta()
	{
		if(configHandler.modID.contains("beta"))
		{
			return true;
		}
		
		if(configHandler.modID.contains("gamer"))
		{
		return false;
		}
		
		return false;
	}


	public static int setID() {
		// TODO Auto-generated method stub
		return 0;
	}
}
