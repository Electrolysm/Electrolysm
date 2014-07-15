package electro.research.machines;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class autoDesk extends workBench
{
    public autoDesk()
    {
        super();
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return null/*new TileEntityAutoDesk()*/;
    }
}
