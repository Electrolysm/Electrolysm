package assets.electrolysm.electro.block.basic;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import assets.electrolysm.electro.block.basic.te.TileEntityBlastDesk;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class blastDesk extends blastProof
{
    @SideOnly(Side.CLIENT)
    Icon icon;

    public blastDesk(int id, Material mat)
    {
        super(id, Material.iron);
        this.setUnlocalizedName("blastDesk");
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

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return new TileEntityBlastDesk();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        ItemStack stackHeld;
        stackHeld = player.getHeldItem();

        if (stackHeld != null)
        {
            icon = stackHeld.getIconIndex();
            this.blockIcon = icon;
        }

        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = icon;
    }
}
