package assets.electrolysm.api.powerSystem;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public interface ITeUReciever
{
    void keepChunkLoaded(World world, int x, int y, int z, TileEntity te);

    int[] getClosestTowerWithinRange(World world, int x, int y, int z, int freq, String username);

    int getRecievedTeUPure(World world, int x, int y, int z);

    float getRecievedTeUAfterResistance(World world, int x, int y, int z);

    int calculateDistance(int x, int y, int z, int towerX, int towerY, int towerZ);

    float TeUtoAmps(int TeU);

    int TeUtoVolts(int TeU);

    int TeUtoEU(int TeU);
}
