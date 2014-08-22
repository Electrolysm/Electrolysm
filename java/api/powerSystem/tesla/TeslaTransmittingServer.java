package api.powerSystem.tesla;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Clarky158 on 01/08/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class TeslaTransmittingServer// implements ICustomTeslaServer
{

    static List<TeslaTower> towerList = new ArrayList<TeslaTower>();

    public static void registerSendingTesla(TeslaTower tower) {
        if (!towerList.contains(tower)) {
            towerList.add(tower);
        }
    }

    public static boolean removeTesla(TeslaTower tower) {
        if(towerList.contains(tower))
        {
            towerList.remove(tower);
            return true;
        }
        return false;
    }

    public static TeslaTower getTeslaTower(int worldID, int x, int y, int z, int freq, int range) {
        for(int i = 0; i < towerList.size(); i++)
        {
            TeslaTower teslaTower = towerList.get(i);
            if(isInRange(teslaTower, x, y, z, range) && statsMatch(teslaTower, worldID, x, y, z, freq))
            {
                return teslaTower;
            }
        }
        return null;
    }

    private static boolean statsMatch(TeslaTower teslaTower, int worldID, int x, int y, int z, int freq) {
        return teslaTower.getWorldData()[0] == worldID;
    }

    private static boolean isInRange(TeslaTower teslaTower, int x, int y, int z, int range) {
        return calculateDistance(x, y, z, teslaTower.getWorldData()[1], teslaTower.getWorldData()[2], teslaTower.getWorldData()[3]) <= range;
    }


    public static int calculateDistance(int x, int y, int z, int towerX, int towerY, int towerZ) {
        int xPower = (int) Math.pow((x - towerX), 2);
        int yPower = (int) Math.pow((y - towerY), 2);
        int zPower = (int) Math.pow((z - towerZ), 2);

        return (int) (Math.sqrt(xPower + yPower + zPower));
    }

}
