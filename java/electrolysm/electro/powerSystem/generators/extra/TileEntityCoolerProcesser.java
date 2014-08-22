package electrolysm.electro.powerSystem.generators.extra;

import electrolysm.electro.handlers.helpers.Utilities;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityCoolerProcesser extends TileEntity 
{
	@Override
	public void updateEntity()
	{
		System.out.println(this.isMultiBlockShell(worldObj, xCoord, yCoord, zCoord));
	}
	
	public boolean isMultiBlockShell(World world, int x, int y, int z)
	{
		Material iron = Material.iron;
		
        if (Utilities.Block.getBlockMaterial(world, x + 1, y, z) == iron)
        {
            if (Utilities.Block.getBlockMaterial(world, x + 1, y, z + 1) == iron)
            {
                if (Utilities.Block.getBlockMaterial(world, x + 1, y, z - 1) == iron)
                {
                    if (Utilities.Block.getBlockMaterial(world, x - 1, y, z) == iron)
                    {
                        if (Utilities.Block.getBlockMaterial(world, x - 1, y, z + 1) == iron)
                        {
                            if (Utilities.Block.getBlockMaterial(world, x - 1, y, z - 1) == iron)
                            {
                                if (Utilities.Block.getBlockMaterial(world, x, y, z + 1) == iron)
                                {
                                    if (Utilities.Block.getBlockMaterial(world, x, y, z - 1) == iron)
                                    {
                                    	//middle 2 rows
                                    	if (Utilities.Block.getBlockMaterial(world, x + 1, y - 1, z + 1) == iron)
                                        {
                                            if (Utilities.Block.getBlockMaterial(world, x - 1, y - 1, z + 1) == iron)
                                            {
                                                if (Utilities.Block.getBlockMaterial(world, x + 1, y - 1, z - 1) == iron)
                                                {
                                                    if (Utilities.Block.getBlockMaterial(world, x - 1, y - 1, z - 1) == iron)
                                                    {
                                                    	if (Utilities.Block.getBlockMaterial(world, x + 1, y - 2, z + 1) == iron)
                                                        {
                                                            if (Utilities.Block.getBlockMaterial(world, x - 1, y - 2, z + 1) == iron)
                                                            {
                                                                if (Utilities.Block.getBlockMaterial(world, x + 1, y - 1, z - 1) == iron)
                                                                {
                                                                    if (Utilities.Block.getBlockMaterial(world, x - 1, y - 2, z - 1) == iron)
                                                                    {
                                                                    	//bottom layer
                                                                    	if (Utilities.Block.getBlockMaterial(world, x, y - 3, z) == iron)
                                                                        {
                                                                            if (Utilities.Block.getBlockMaterial(world, x, y - 3, z) == iron)
                                                                            {
                                                                                if (Utilities.Block.getBlockMaterial(world, x, y - 3, z) == iron)
                                                                                {
                                                                                    if (Utilities.Block.getBlockMaterial(world, x, y - 3, z) == iron)
                                                                                    {
                                                                                        if (Utilities.Block.getBlockMaterial(world, x, y - 3, z) == iron)
                                                                                        {
                                                                                            if (Utilities.Block.getBlockMaterial(world, x, y - 3, z) == iron)
                                                                                            {
                                                                                                if (Utilities.Block.getBlockMaterial(world, x, y - 3, z) == iron)
                                                                                                {
                                                                                                    if (Utilities.Block.getBlockMaterial(world, x, y - 3, z) == iron)
                                                                                                    {
                                                                                                        if (Utilities.Block.getBlockMaterial(world, x, y - 3, z) == iron)
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
}
