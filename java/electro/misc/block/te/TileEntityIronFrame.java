package electro.misc.block.te;

import net.minecraft.tileentity.TileEntity;

public class TileEntityIronFrame extends TileEntity
{/*
    public boolean isRecieving()
    {
        World world = this.getWorldObj();
        int x = xCoord;
        int y = yCoord;
        int z = zCoord;
        int generatorID = electrolysmCore.generator.blockID;
        boolean[] overall = new boolean[4];
        boolean canRecieve = false;
        TileEntityTeslaTower te = (TileEntityTeslaTower)world.getBlockTileEntity(x, y + 5, z);

        //x + 1
        if (world.getBlockId(x + 1, y, z) == generatorID)
        {
            if (te instanceof TileEntityTeslaTower && te.isTowerFormed(world, x, y + 5, z))
            {
                TileEntityGenerator teGen = (TileEntityGenerator)world.getBlockTileEntity(x + 1, y, z);

                if (teGen.isWorking(world, x + 1, y, z))
                {
                    overall[0] = true;
                }
            }
        }
        //x - 1
        else if (world.getBlockId(x - 1, y, z) == generatorID && te != null)
        {
            if (te.isTowerFormed(world, x, y + 5, z))
            {
                TileEntityGenerator teGen = (TileEntityGenerator)world.getBlockTileEntity(x - 1, y, z);

                if (teGen.isWorking(world, x - 1, y, z))
                {
                    overall[1] = true;
                }
            }
        }
        //z + 1
        else if (world.getBlockId(x, y, z + 1) == generatorID)
        {
            if (te instanceof TileEntityTeslaTower && te.isTowerFormed(world, x, y + 5, z))
            {
                TileEntityGenerator teGen = (TileEntityGenerator)world.getBlockTileEntity(x, y, z + 1);

                if (teGen.isWorking(world, x, y, z + 1))
                {
                    overall[2] = true;
                }
            }
        }
        //z - 1
        else if (world.getBlockId(x, y, z - 1) == generatorID)
        {
            if (te instanceof TileEntityTeslaTower && te.isTowerFormed(world, x, y + 5, z))
            {
                TileEntityGenerator teGen = (TileEntityGenerator)world.getBlockTileEntity(x, y, z - 1);

                if (teGen.isWorking(world, x, y, z - 1))
                {
                    overall[3] = true;
                }
            }
        }
        else
        {
            for (int i = 1; i < overall.length; i++)
            {
                overall[i] = false;
            }
        }

        for (int i = 0; i < overall.length; i++)
        {
            if (overall[i])
            {
                if (this.isEarthed(world, x, y, z))
                {
                    canRecieve = true;
                }
            }
        }

        return canRecieve;
    }

    public boolean isEarthed(World world, int x, int y, int z)
    {
        int wireID = electrolysmCore.wire.blockID;
        TileEntityWire teWire = new TileEntityWire();

        if (world.getBlockId(x, y - 1, z) == wireID)
        {
            if (world.getBlockId(x, y - 2, z) == wireID)
            {
                if (world.getBlockId(x, y - 3, z) == wireID)
                {
                    if (world.getBlockId(x, y - 4, z) == wireID)
                    {
                        if (world.getBlockId(x, y - 5, z) == wireID)
                        {
                            if (world.getBlockId(x, y - 6, z) == wireID)
                            {
                                if (world.getBlockId(x, y - 7, z) == wireID)
                                {
                                    if (world.getBlockId(x, y - 8, z) == wireID)
                                    {
                                        if (world.getBlockId(x, y - 9, z) == wireID)
                                        {
                                            if (world.getBlockId(x, y - 10, z) == wireID)
                                            {
                                                if (world.getBlockId(x, y - 11, z) == wireID)
                                                {
                                                    if (world.getBlockId(x, y - 12, z) == wireID)
                                                    {
                                                        if (this.checkEarthing(world, x, y - 12, z))
                                                        {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean checkEarthing(World world, int x, int y, int z)
    {
        if (world.getBlockTileEntity(x + 1, y, z) instanceof TileEntityEarther)
        {
            if (world.getBlockTileEntity(x - 1, y, z) instanceof TileEntityEarther)
            {
                if (world.getBlockTileEntity(x, y, z + 1) instanceof TileEntityEarther)
                {
                    if (world.getBlockTileEntity(x, y, z - 1) instanceof TileEntityEarther)
                    {
                        //if(world.getBlockTileEntity(x, y - 1, z) instanceof TileEntityAdvEarther)
                        //{
                        TileEntityEarther te = new TileEntityEarther();
                        //TileEntityAdvEarther teAdv = new TileEntityAdvEarther();

                        if (te.isSetUp(world, x + 1, y, z))
                        {
                            if (te.isSetUp(world, x - 1, y, z))
                            {
                                if (te.isSetUp(world, x, y, z + 1))
                                {
                                    if (te.isSetUp(world, x, y, z - 1))
                                    {
                                        //if(teAdv.isSetUp(world, x, y - 1, z))
                                        //{
                                        return true;
                                        //}
                                    }
                                }
                            }
                        }

                        //}
                    }
                }
            }
        }

        return false;
    }

    public boolean isTowerBase(World world, int x, int y, int z)
    {
        if (world.getBlockId(x, y + 5, z) == electrolysmCore.teslaTowerCore.blockID)
        {
            if (world.getBlockTileEntity(x, y + 5, z) instanceof TileEntityTeslaTower)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public int getRecievingTeU(World world, int x, int y, int z)
    {
        int generatorID = electrolysmCore.generator.blockID;
        int teu1 = 0;
        int teu2 = 0;
        int teu3 = 0;
        int teu4 = 0;

        //x + 1
        if (world.getBlockId(x + 1, y, z) == generatorID)
        {
            TileEntityGenerator teGen = (TileEntityGenerator)world.getBlockTileEntity(x + 1, y, z);
            teu1 = teGen.getSendTeU(world, x + 1, y, z);
        }

        //x - 1
        if (world.getBlockId(x - 1, y, z) == generatorID)
        {
            TileEntityGenerator teGen = (TileEntityGenerator)world.getBlockTileEntity(x - 1, y, z);
            teu2 = teGen.getSendTeU(world, x - 1, y, z);
        }

        //z + 1
        if (world.getBlockId(x, y, z + 1) == generatorID)
        {
            TileEntityGenerator teGen = (TileEntityGenerator)world.getBlockTileEntity(x, y, z + 1);
            teu3 = teGen.getSendTeU(world, x, y, z + 1);
        }

        //z - 1
        if (world.getBlockId(x, y, z - 1) == generatorID)
        {
            TileEntityGenerator teGen = (TileEntityGenerator)world.getBlockTileEntity(x, y, z - 1);
            teu4 = teGen.getSendTeU(world, x, y, z - 1);
        }

        return (teu1 + teu2 + teu3 + teu4);
    }

    public boolean canConnect(ForgeDirection side)
    {
        if (side == side.DOWN)
        {
            return true;
        }

        return false;
    }*/
}
