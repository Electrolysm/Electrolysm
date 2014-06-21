package electro.sciences.robotics;

import electro.Electrolysm;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import electro.sciences.robotics.tile.TileEntitySoldering;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class soldering extends BlockContainer
{
    public soldering()
    {
        super(Material.iron);
        // TODO Auto-generated constructor stub
        this.setCreativeTab(Electrolysm.TabElectrolysm);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Electrolysm:" + this.getUnlocalizedName().replace("item.", ""));
    }
    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        // TODO Auto-generated method stub
        return new TileEntitySoldering();
    }

    //You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType()
    {
        return -1;
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
}
