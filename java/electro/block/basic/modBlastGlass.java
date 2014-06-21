package electro.block.basic;

import electro.Electrolysm;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import electro.block.GlassBlockConnectedMeta;

public class modBlastGlass extends GlassBlockConnectedMeta
{
    public modBlastGlass(String location, boolean hasAlpha,
                         String[] textures)
    {
        super(location, hasAlpha, textures);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(9000);
        this.setBlockUnbreakable();
    }

    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return null;
    }
}
