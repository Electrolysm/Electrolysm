package electro.block.advMachines;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import electro.block.advMachines.te.TileEntityQuantumComp;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class quantumComp extends BlockContainer
{
    public static String unlocalName = "qunatumComp";
    public static String displayName = "Quantum Computer";

    @SideOnly(Side.CLIENT)
    public Icon machineFront;
    @SideOnly(Side.CLIENT)
    public Icon machineSide;
    @SideOnly(Side.CLIENT)
    public Icon machineTop;

    public quantumComp(int id, Material mat)
    {
        super(id, Material.iron);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName(this.unlocalName);
        this.setHardness(5.0F);
        this.setBlockBounds(0, 0, 0, 1, 3, 1);
    }

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return new TileEntityQuantumComp();
    }

    @SideOnly(Side.CLIENT)

    public void registerIcons(IconRegister par1IconRegister)
    {
        this.machineFront = par1IconRegister.registerIcon("Electrolysm:" + this.unlocalName + "_Front");
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

    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
