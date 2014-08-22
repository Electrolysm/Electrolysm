package electrolysm.electro.powerSystem.generators;

import electrolysm.api.powerSystem.prefab.BlockEnergy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electrolysm.electro.Electrolysm;
import electrolysm.electro.powerSystem.generators.te.TileEntityAdvGenerator;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;


public class advancedGenerator extends BlockEnergy
{
    @SideOnly(Side.CLIENT)
    public IIcon frontIcon;
    @SideOnly(Side.CLIENT)
    public IIcon bottom;

    public advancedGenerator()
    {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(2F);
        setHarvestLevel("pickaxe",1);
        setStepSound(soundTypeMetal);
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        this.blockIcon = reg.registerIcon("electrolysm:powerGenSide");
        this.bottom = reg.registerIcon("electrolysm:powerGenTop");
        frontIcon = reg.registerIcon("electrolysm:advGeneratorFront");
    }

    public void getSubBlocks(Item id, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(this, 1, 3));
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if(side == meta) { return frontIcon; }
        else {
            if (side == 0 || side == 1) { return bottom; }
            else { return blockIcon; }
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if(!player.isSneaking()) {
            player.openGui(Electrolysm.GUIInstance, 0, world, x, y, z);
            return true;
        }
        return false;
    }

    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            Block l = par1World.getBlock(par2, par3, par4 - 1);
            Block i1 = par1World.getBlock(par2, par3, par4 + 1);
            Block j1 = par1World.getBlock(par2 - 1, par3, par4);
            Block k1 = par1World.getBlock(par2 + 1, par3, par4);
            byte b0 = 3;

            if (l.isOpaqueCube() && !i1.isOpaqueCube())
            {
                b0 = 3;
            }

            if (i1.isOpaqueCube() && !l.isOpaqueCube())
            {
                b0 = 2;
            }

            if (j1.isOpaqueCube() && !k1.isOpaqueCube())
            {
                b0 = 5;
            }

            if (k1.isOpaqueCube() && !j1.isOpaqueCube())
            {
                b0 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }

    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double) (par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityAdvGenerator();
    }

    public static boolean keepInventory;

    public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
        keepInventory = true;

        if (par0)
        {
            par1World.setBlock(par2, par3, par4, Electrolysm.advGenActive);
        }
        else
        {
            par1World.setBlock(par2, par3, par4, Electrolysm.advancedGenerator);
        }

        keepInventory = false;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            par1World.setTileEntity(par2, par3, par4, tileentity);
        }
    }
}