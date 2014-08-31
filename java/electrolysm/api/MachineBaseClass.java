package electrolysm.api;

import electrolysm.api.items.Fetcher;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MachineBaseClass extends BlockContainer implements ITileEntityProvider
{
    public static String unlocalName;
    public static String displayName;
    public static TileEntity te;

    @SideOnly(Side.CLIENT)
    public IIcon machineFront;
    @SideOnly(Side.CLIENT)
    public IIcon machineSide;
    @SideOnly(Side.CLIENT)
    public IIcon machineTop;

    public MachineBaseClass()
    {
        super(Material.iron);
        this.setCreativeTab(Fetcher.getCreativeTab());
        //this.setUnlocalizedName(this.unlocalName);
        this.setHardness(5.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return te;
    }

    public IIcon getIIcon(int par1, int par2)
    {
        return par1 == 1 ? this.machineTop : (par1 == 0 ? this.machineTop :
                                              (par1 != par2 ? this.machineSide : this.machineFront));
    }

    @SideOnly(Side.CLIENT)

    public void registerIIcons(IIconRegister par1IIconRegister)
    {
        this.machineSide = par1IIconRegister.registerIcon("Electrolysm:" + this.unlocalName + "_side");
        this.machineFront = par1IIconRegister.registerIcon("Electrolysm:" + this.unlocalName + "_Front");
        this.machineTop = par1IIconRegister.registerIcon("Electrolysm:" + this.unlocalName + "_Top");
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
}
