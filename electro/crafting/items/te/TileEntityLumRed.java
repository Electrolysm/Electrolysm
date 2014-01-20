package assets.electrolysm.electro.crafting.items.te;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityLumRed extends TileEntity 
{

	public boolean canConnect(ForgeDirection side, int thisID) 
	{
		if(thisID == electrolysmCore.advWire.blockID)
		{
			if(side == side.UP)
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
	
}
