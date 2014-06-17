package electro.block.basic;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import electro.block.basic.te.TileEntityBlastDoor;
import assets.electrolysm.electro.client.ClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class blastDoor extends blastProof
{
    @SideOnly(Side.CLIENT)
    private Icon closed;
    @SideOnly(Side.CLIENT)
    private Icon open;

    private boolean opened;
    public boolean firstTime;

    public blastDoor(int id, Material mat)
    {
        super(id, mat);
        // TODO Auto-generated constructor stub
        this.setUnlocalizedName("blastDoor");
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
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
    public void registerIcons(IconRegister register)
    {
        this.blockIcon = register.registerIcon("electrolysm:" + this.getUnlocalizedName().replace("tile.", ""));
    }

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return new TileEntityBlastDoor();
    }
}