package assets.electrolysm.electro.world.biome;

import java.util.Collection;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class diseasedBiome extends BiomeGenBase
{
    public diseasedBiome(int par1)
    {
        super(par1);
        this.setBiomeName("Diseased Grassland");
        this.topBlock = (byte)electrolysmCore.diseaseGrass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.spawnableMonsterList.removeAll(spawnableMonsterList);
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie_Scientist.class, 5, 10, 50));
        this.setDisableRain();
        this.setTemperatureRainfall(10000, 0);
    }
}
