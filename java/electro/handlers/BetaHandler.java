package electro.handlers;

import java.util.Random;
import electro.configHandler;
import electro.client.ClientProxy;

public class BetaHandler
{
    public static boolean beta()
    {
        if (configHandler.modID.contains("beta"))
        {
            return true;
        }

        if (configHandler.modID.contains("gamer"))
        {
            return false;
        }

        return false;
    }

    public static int setID()
    {
        Random rand = new Random();

        if (configHandler.idSet)
        {
            return configHandler.modIDInt;
        }
        else
        {
            configHandler.idSetD = true;
            configHandler.idSet = true;
            return rand.nextInt(100);
        }
    }
}
