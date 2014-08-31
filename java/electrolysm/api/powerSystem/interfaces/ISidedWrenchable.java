package electrolysm.api.powerSystem.interfaces;

/**
 * Created by Clarky158 on 30/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public interface ISidedWrenchable {

    /**
     * sets a state to a side
     * @param side
     */
    public void setSide(int side);

    /**
     * @param side
     * @return the current state of the specified side
     */
    public int getState(int side);
}
