package electro.powerSystem.te;

import api.powerSystem.prefab.TEPowerCore;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Clarky158 on 27/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class TileEntityAdvCore extends TEPowerCore
{
    public TileEntityAdvCore()
    {
        this.maxTeU = 40000000;
        this.isCreative = false;
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
    }
}
