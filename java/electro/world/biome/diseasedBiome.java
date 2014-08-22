package electro.world.biome;

import java.util.Random;

import electro.Electrolysm;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class diseasedBiome extends BiomeGenBase
{
    public diseasedBiome(int par1)
    {
        super(par1);
        this.theBiomeDecorator = new DiseasedBiomeDecorator(this);
        this.setBiomeName("Diseased Grassland");
        this.topBlock = Electrolysm.diseaseGrass;
        this.fillerBlock = Blocks.dirt;
        this.spawnableMonsterList.removeAll(spawnableMonsterList);
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie_Scientist.class, 5, 10, 50));
        this.setDisableRain();
        this.setColor(7160201);
        this.setTemperatureRainfall(100, 0);
        this.theBiomeDecorator.treesPerChunk = 1;
        this.theBiomeDecorator.deadBushPerChunk = 4;
    }
    
    @Override
    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);
        /*if (par1World.provider.dimensionId != 1 && par1World.provider.dimensionId != -1)
        {*/
            generateTreeSurface(par1World, par2Random, par3 * 16, par4 * 16);
        //}
    }
    
    
    private void generateTreeSurface(World world, Random random, int x, int z) 
    {
    	if (world.getBiomeGenForCoords(x, z) == Electrolysm.diseasedBiome)
        {
            if (random.nextInt(75) == 1)
            {
            	new WorldGenDiseasedTree(true, 6).generate(world, new Random(), x, getSurface(world, x, z), z);
            }
        }
	}
    
    private static int getSurface(World world, int x, int z)
    {
        int height = 256;
        boolean continueQ = true;

        while (continueQ)
        {
            if (world.isAirBlock(x, height, z))
            {
                height = height - 1;
            }
            else
            {
                continueQ = false;
            }
        }

        return height + 1;
    }
}
