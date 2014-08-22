package electro.misc.block.basic;

import electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import electro.misc.block.basic.te.TileEntityBlastDoor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class blastDoor extends blastProof
{
    @SideOnly(Side.CLIENT)
    private IIcon closed;
    @SideOnly(Side.CLIENT)
    private IIcon open;

    private boolean opened;
    public boolean firstTime;

    public blastDoor()
    {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setResistance(6000000.0F);
        this.setHardness(9000);
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        TileEntityBlastDoor te = new TileEntityBlastDoor();

        if (player.getHeldItem() == null)
        {
            te.tpThrough(player, x, y, z);
        }

        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon("electrolysm:" + this.getUnlocalizedName().replace("tile.", ""));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityBlastDoor();
    }
}