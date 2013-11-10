package assets.electrolysm.electro.powerSystem.te;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import assets.electrolysm.api.power.wireBaseClass;
import assets.electrolysm.api.power.wireBaseClass.wiresIDs;
import assets.electrolysm.electro.electrolysmCore;

public class TileEntityWire extends TileEntity
{

	public boolean canConnect(ForgeDirection direction)
	{
        if (direction == null || direction.equals(ForgeDirection.UNKNOWN))
        {
                return false;
        }
        this.updateEntity();
        return true;
	}
	
	public void updateEntity()
	{
		int idBlock = worldObj.getBlockId(xCoord, yCoord, zCoord);

		if(idBlock == wireBaseClass.wiresIDs.goldIds.goldWireActive)
		{
			for(int i = 0; i < wireBaseClass.coordsLength; i++)
			{
				int id;
				
				id = worldObj.getBlockId(xCoord + wireBaseClass.xValue[i],
						yCoord + wireBaseClass.yValue[i], zCoord + wireBaseClass.zValue[i]);
				
				if(id != 0)
				{
					if(id == electrolysmCore.wireGold.blockID)
					{
						worldObj.setBlock(xCoord + wireBaseClass.xValue[i],
								yCoord + wireBaseClass.yValue[i], zCoord + wireBaseClass.zValue[i],
								id);
					}
				}
			}
		}
		else if(idBlock == wireBaseClass.wiresIDs.goldIds.goldWireOff)
		{
			for(int i = 0; i < wireBaseClass.coordsLength; i++)
			{
				for(int wireIDs = 0; wireIDs < wiresIDs.goldIds.goldWireIDs.length; wireIDs++)
				{
					int id;
				
					id = worldObj.getBlockId(xCoord + wireBaseClass.xValue[i],
							yCoord + wireBaseClass.yValue[i], zCoord + wireBaseClass.zValue[i]);
					
					if(id != 0)
					{
						if(id != wiresIDs.goldIds.goldWireActive)
						{
							if(id != wiresIDs.goldIds.goldWireNactive)
							{
								if(id == wiresIDs.goldIds.goldWireOff)
								{
									worldObj.setBlock(xCoord, yCoord, zCoord,
											wiresIDs.goldIds.goldWireNactive);
								}
							}
						}
					}
				}
			}
		}
		
	}
	
}
