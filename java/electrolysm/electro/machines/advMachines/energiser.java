package electrolysm.electro.machines.advMachines;

import electrolysm.electro.Electrolysm;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import electrolysm.electro.machines.advMachines.te.TileEntityEnergiser;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class energiser extends BlockContainer
{
    public static String unlocalName = "energiser";;
    public static String displayName = "Fluid Energiser";
    public static TileEntity te;

    @SideOnly(Side.CLIENT)
    public IIcon machineFront;
    @SideOnly(Side.CLIENT)
    public IIcon machineSide;
    @SideOnly(Side.CLIENT)
    public IIcon machineTop;

    public energiser()
    {
        super(Material.iron);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(5.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityEnergiser();
    }

    @Override
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.machineTop : (par1 == 0 ? this.machineTop :
                                              (par1 != par2 ? this.machineSide : this.machineFront));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.machineSide = par1IconRegister.registerIcon("electrolysm:" + this.unlocalName + "_side");
        //this.machineFront = par1IconRegister.registerIcon("electrolysm:" + this.unlocalName + "_front");
        this.machineTop = par1IconRegister.registerIcon("electrolysm:" + this.unlocalName + "_top");
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving living, ItemStack stack)
    {
        int l = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }

    public static String getDisplayName()
    {
        return displayName;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (player.isSneaking())
        {
            return false;
        }
        else
        {
            player.openGui(Electrolysm.GUIInstance, 0, world, x, y, z);
            return true;
        }
    }
}
