package electro.block.machines;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class autoDesk extends workBench
{
    public autoDesk(int id, Material mat)
    {
        super(id, Material.iron);
        this.setUnlocalizedName("autoBench");
    }

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return null/*new TileEntityAutoDesk()*/;
    }
}
