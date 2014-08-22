package electrolysm.electro.handlers.helpers;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by Ben on 05/07/2014.
 */
public class CollectorHelper
{
    public static Object[] getEnvironmentalData(World world, int x, int y, int z)
    {
        BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
        float rainfall = biome.getFloatRainfall();
        float temp = biome.getFloatTemperature(x, y, z);
        boolean humidityHigh = biome.isHighHumidity();
        return new Object[] { biome, rainfall, temp, humidityHigh};
    }
}
