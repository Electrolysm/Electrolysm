package electro.powerSystem.generators.te;

import api.powerSystem.PowerUsage;
import api.powerSystem.prefab.TileEntityGenerator;
import electro.Electrolysm;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

/**
 * Created by Ben on 19/07/2014.
 */
public class TileEntitySolarPanel extends TileEntityGenerator
{
    int product;

    @Override
    public void updateEntity() {
        super.updateEntity();

        if(worldObj.isRemote) { return; }

        product = PowerUsage.getTeUFromMap(Electrolysm.solarPanel);
        int produce = 0;
        if(canProduce(product)) {
            World world = getWorldObj();
            WorldProvider provider = world.provider;
            boolean dayTime = provider.isDaytime();
            boolean seeSky = world.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord);
            boolean isRaining = world.isRaining();
            long worldTime = world.getWorldTime();

            if (dayTime && seeSky) {
                if (!isRaining) {
                    produce = product;
                } else {
                    produce = product / 2;
                }
                this.produce(produce);
            }

        }
    }
}
