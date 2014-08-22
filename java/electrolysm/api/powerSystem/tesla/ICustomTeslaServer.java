package electrolysm.api.powerSystem.tesla;

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
public interface ICustomTeslaServer
{
    public abstract void registerSendingTesla(TeslaTower tower);

    public boolean removeTesla(TeslaTower tower);

    public TeslaTower getTeslaTower(int worldID, int x, int y, int z, int freq, int range);
}
