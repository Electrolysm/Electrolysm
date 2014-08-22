package electrolysm.electro.world.biome;

import java.util.Random;

import electrolysm.electro.Electrolysm;
import electrolysm.electro.handlers.helpers.Utilities;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDiseasedTree extends WorldGenerator
{
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;

	private Block log;
	private Block leaves;
	private Block sapling;
	public static Block treeLog = new BlockTreeLog(0, "treeLog").setBlockName("diseasedLog");
    public static Block treeLeaves = new BlockTreeLeaves(1).setBlockName("diseaseLeaves");
    public static Block treeSapling = new treeSapling().setBlockName("diseasedSapling");

    public static Block initialiseTree(String id)
    {
        if(id.contains("log"))
        {
            return (treeLog = new BlockTreeLog(0, "treeLog"));
        }
        else if(id.contains("leaves"))
        {
            return (treeLeaves = new BlockTreeLeaves(1)).setBlockName("diseasedLeaves");
        }
        else if(id.contains("sapling"))
        {
            return (treeSapling = new treeSapling());
        }
        else
        {
            return null;
        }
    }
    
    public WorldGenDiseasedTree(boolean par1)
    {
        this(par1, 4);
    }

    public WorldGenDiseasedTree(boolean par1, int par2)
    {
        super(par1);
        this.minTreeHeight = par2;
        /*treeLog = new BlockTree(configHandler.treeLogID, 0, "treeLog");
        treeLeaves = new BlockTree(configHandler.treeLeavesID, 1, "treeLeaf");
        treeSapling = new treeSapling(configHandler.treeSaplingID);*/
        log = treeLog;
    	leaves = treeLeaves;
    	sapling = treeSapling;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        int l = par2Random.nextInt(3) + this.minTreeHeight;
        boolean flag = true;

        if (par4 >= 1 && par4 + l + 1 <= 256)
        {
            int i1;
            byte b0;
            int j1;
            int k1;

            for (i1 = par4; i1 <= par4 + 1 + l; ++i1)
            {
                b0 = 1;

                if (i1 == par4)
                {
                    b0 = 0;
                }

                if (i1 >= par4 + 1 + l - 2)
                {
                    b0 = 2;
                }

                for (int l1 = par3 - b0; l1 <= par3 + b0 && flag; ++l1)
                {
                    for (j1 = par5 - b0; j1 <= par5 + b0 && flag; ++j1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {
                            Block block = par1World.getBlock(l1, i1, j1);

                            if (!par1World.isAirBlock(l1, i1, j1) &&
                                !block.isLeaves(par1World, l1, i1, j1) &&
                                 block != Blocks.grass &&
                                 block != Blocks.dirt &&
                                 block != Electrolysm.diseaseGrass &&
                                !block.isWood(par1World, l1, i1, j1))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                //i1 = par1World.getBlock(par3, par4 - 1, par5);
                Block soil = par1World.getBlock(par3, par4 - 1, par5);
                boolean isSoil = true;//(soil != null && soil.canSustainPlant(par1World, par3, par4 - 1, par5, ForgeDirection.UP, (BlockSapling)sapling) || soil.blockID == this.log);

                if (isSoil && par4 < 256 - l - 1)
                {
                    soil.onPlantGrow(par1World, par3, par4 - 1, par5, par3, par4, par5);
                    b0 = 3;
                    byte b1 = 0;
                    int i2;
                    int j2;
                    int k2;

                    for (j1 = par4 - b0 + l; j1 <= par4 + l; ++j1)
                    {
                        k1 = j1 - (par4 + l);
                        i2 = b1 + 1 - k1 / 2;

                        for (j2 = par3 - i2; j2 <= par3 + i2; ++j2)
                        {
                            k2 = j2 - par3;

                            for (int l2 = par5 - i2; l2 <= par5 + i2; ++l2)
                            {
                                int i3 = l2 - par5;

                                if (Math.abs(k2) != i2 || Math.abs(i3) != i2 || par2Random.nextInt(2) != 0 && k1 != 0)
                                {
                                    //int j3 = par1World.getBlockId(j2, j1, l2);
                                    Block block = par1World.getBlock(j2, j1, l2);

                                    if (block == null || block.canBeReplacedByLeaves(par1World, j2, j1, l2))
                                    {
                                        Utilities.Block.setBlockAndMetadata(par1World, j2, j1, l2, this.leaves, 0);
                                    }
                                }
                            }
                        }
                    }

                    for (j1 = 0; j1 < l; ++j1)
                    {
                        Block block =  par1World.getBlock(par3, par4 + j1, par5);

                        if (block == null || block.isAir(par1World, par3, par4, par5) || block.isLeaves(par1World, par3, par4 + j1, par5))
                        {
                            Utilities.Block.setBlockAndMetadata(par1World, par3, par4 + j1, par5, this.log, 0);
                            par1World.setBlock(par3, par4 + 1, par5, this.log, 0, 0);
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
    
    public boolean canGenerate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
    	int l = par2Random.nextInt(3) + this.minTreeHeight;
        boolean flag = true;

        if (par4 >= 1 && par4 + l + 1 <= 256)
        {
            int i1;
            byte b0;
            int j1;
            int k1;

            for (i1 = par4; i1 <= par4 + 1 + l; ++i1)
            {
                b0 = 1;

                if (i1 == par4)
                {
                    b0 = 0;
                }

                if (i1 >= par4 + 1 + l - 2)
                {
                    b0 = 2;
                }

                for (int l1 = par3 - b0; l1 <= par3 + b0 && flag; ++l1)
                {
                    for (j1 = par5 - b0; j1 <= par5 + b0 && flag; ++j1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {
                            Block block = par1World.getBlock(l1, i1, j1);

                            if (!par1World.isAirBlock(l1, i1, j1) &&
                                !block.isLeaves(par1World, l1, i1, j1) &&
                                 block != Blocks.grass &&
                                 block != Blocks.dirt &&
                                 block != Electrolysm.diseaseGrass &&
                                !block.isWood(par1World, l1, i1, j1))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
            	return true;
            }
        }
        return false;
    }
}
