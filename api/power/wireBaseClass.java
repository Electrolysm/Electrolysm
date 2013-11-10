package assets.electrolysm.api.power;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.BlockCopperWire;
import assets.electrolysm.electro.powerSystem.te.TileEntityWire;

public class wireBaseClass extends BlockCopperWire{

	public static int[] xValue = {1, -1, 0, 0, 0, 0};
	public static int[] yValue = {0, 0, 1, -1, 0, 0};
	public static int[] zValue = {0, 0, 0, 0, 1, -1};
	public static int coordsLength = xValue.length;
	
	public static class wiresIDs
	{
		public static class goldIds
		{
			public static int goldWireActive = electrolysmCore.wireGoldActive.blockID;
			public static int goldWireNactive = electrolysmCore.wireGold.blockID;
			public static int goldWireOff = electrolysmCore.wireGoldOff.blockID;
			public static int[] goldWireIDs = {goldWireActive, goldWireNactive, goldWireOff};
		}
	}

	public wireBaseClass(int id, Material mat) {
		super(id, Material.cloth);
	}
	
	@SuppressWarnings("finally")
	public Block getConversionFor(int thisBlockID)
	{
		try
		{
			if(thisBlockID == electrolysmCore.wireGoldActive.blockID)
			{
				return electrolysmCore.wireGold;
			}
			if(thisBlockID == electrolysmCore.wireGoldOff.blockID)
			{
				return electrolysmCore.wireGoldActive;
			}
		}
		finally
		{
			return null;
		}
	}
	
	@SuppressWarnings("finally")
	public Block getConversionToo(int thisBlockID)
	{
		try
		{
			if(thisBlockID == electrolysmCore.wireGoldActive.blockID)
			{
				return electrolysmCore.wireGoldActive;
			}
		}
		finally
		{
			return null;
		}
	}
	
	public void setNetorkPower(World world, int x, int y, int z)
	{
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
		return new TileEntityWire();
	}

	
	
}
