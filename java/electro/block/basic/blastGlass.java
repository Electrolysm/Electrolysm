package electro.block.basic;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import electro.electrolysmCore;
import electro.block.GlassBlockConnectedMeta;

public class blastGlass extends GlassBlockConnectedMeta
{
    public blastGlass(String location, boolean hasAlpha, String[] textures)
    {
        super(location, hasAlpha, textures);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
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

    public TileEntity createNewTileEntity(World world, int i) { return null; }
}
