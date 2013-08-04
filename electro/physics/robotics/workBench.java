package mods.Electrolysm.electro.physics.robotics;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class workBench extends Block {

	private byte b0 = 0;
	private byte b1 = 1;
	
	public workBench(int id, Material mat) {
		super(id, Material.iron);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(electrolysmCore.TabElectrolysmPhysics);
		this.setUnlocalizedName("workBench");
	}

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving player, ItemStack stack)
    {
    	int i1 = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (i1 == 0)
        {
            b1 = 1;
        }

        if (i1 == 1)
        {
            b0 = -1;
        }

        if (i1 == 2)
        {
            b1 = -1;
        }

        if (i1 == 3)
        {
            b0 = 1;
        }
        world.setBlock(x + b0, y, z + b1, electrolysmCore.workBench.blockID, i1 + 8, 3);
    }
    
    	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) 
    	{
    		world.setBlockToAir(x, y, z);
    		world.setBlockToAir(x + b0, y, z + b1);
    	}

	
}
