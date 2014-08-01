package electro.powerSystem.generators.te;

import electro.powerSystem.PowerUsage;
import api.powerSystem.prefab.TileEntityGenerator;
import net.minecraft.init.Blocks;
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

        product = PowerUsage.SOLAR_PANEL;
        int produce = 0;
        if(canProduce(product)) {
            if(worldObj.getBlock(xCoord, yCoord + 1, zCoord) == Blocks.water) {
                World world = getWorldObj();
                WorldProvider provider = world.provider;
                boolean dayTime = provider.isDaytime();
                boolean seeSky = world.canBlockSeeTheSky(xCoord, yCoord + 2, zCoord);
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
            } else {
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
}
