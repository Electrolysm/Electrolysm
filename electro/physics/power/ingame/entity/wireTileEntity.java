package mods.Electrolysm.electro.physics.power.ingame.entity;

import net.minecraft.block.Block;
import universalelectricity.prefab.tile.TileEntityConductor;

public class wireTileEntity extends TileEntityConductor
{
	/**
	 * Changed this if your mod wants to nerf Basic Component's copper wire.
	 */
	public static double RESISTANCE = 0.05;
	public static double MAX_AMPS = 200;

	public wireTileEntity()
	{
		this.channel = "Electrolysm";
	}

	@Override
	public double getResistance()
	{
		return RESISTANCE;
	}

	@Override
	public double getCurrentCapcity()
	{
		return MAX_AMPS;
	}

	@Override
	public void updateEntity()
	{
		super.updateEntity();

		if (this.getNetwork() != null && this.ticks % 20 == 0)
		{
			if (this.getNetwork().getProduced().amperes > this.getCurrentCapcity())
			{
				if (!this.worldObj.isRemote)
				{
					this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, Block.fire.blockID);
				}
			}
		}
	}
}