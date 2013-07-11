package mods.Electrolysm.electro.world;

import static net.minecraftforge.common.ChestGenHooks.STRONGHOLD_CORRIDOR;

import java.util.Random;

import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenStructures implements IWorldGenerator{
	@Override
	public void generate(Random random, int x, int z, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider){

		//Make sure it's not generating in the end or nether
		if(world.provider.dimensionId != 1 && world.provider.dimensionId != -1){
			
			generateSurface(world, random, x*16, z*16);
			
		}

		}

    
	public static void generateSurface(World world, Random random, int x, int z){

		//Science Lab Generation Code:
		if(random.nextInt(100) == 1)
		{
			for(int i = 0; i < 1; i++)
			{		
				int xCoord = x + random.nextInt(16);
				int zCoord = z + random.nextInt(16);
				int yCoord = getSurface(world, xCoord, zCoord);
				int mossyStone = Block.cobblestoneMossy.blockID;
				int glow = Block.glowStone.blockID;
				int bar = Block.fenceIron.blockID;
				int wood = Block.wood.blockID;
				int grass = Block.grass.blockID;
				int mossyStairs = Block.stairsCobblestone.blockID;
				int pressure = Block.pressurePlateStone.blockID;
				int dispenser = Block.dispenser.blockID;


				
				createBlock(world, xCoord + 3, yCoord, zCoord + 4, dispenser, 0);
				
				
				
				TileEntityDispenser tileEntityChest = new TileEntityDispenser();
				world.setBlockTileEntity(xCoord + 3, yCoord, zCoord + 4, tileEntityChest);

				for (int slot = 0; slot < tileEntityChest.getSizeInventory(); slot++) {
					int item = random.nextInt(9);

					if (item == 1 || item == 2 || item == 3) {
						tileEntityChest.setInventorySlotContents(0, new ItemStack(electrolysmCore.copperOre, 20));
					}
				}
			}
	
		}
	}

	private static void createBlock(World world, int xCoord, int yCoord, int zCoord, int blockID, int metadata)
	{
		world.setBlock(xCoord, yCoord, zCoord, blockID, metadata, 2);
	}

	private static int getSurface(World world, int x, int z)
	{
		int height = 256;

		boolean continueQ = true;

		while(continueQ)
		{
			if(world.isAirBlock(x, height, z))
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
