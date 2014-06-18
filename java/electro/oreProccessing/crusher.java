package electro.oreProccessing;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import electro.electrolysmCore;
import electro.oreProccessing.te.TileEntityCrusher;
import electro.oreProccessing.te.TileEntityLiquidiser;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class crusher extends oreProcessMachineBase
{
	
	public crusher(boolean isActive)
    {
        super(isActive);
        this.setHardness(6.0F);
    	this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.active = isActive;
    }
	
    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        // TODO Auto-generated method stub
        return new TileEntityCrusher();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
        String modID = "electrolysm:";

        this.frontIcon = reg.registerIcon(modID + "oreProcessMachines/" + "crusher_Front");
        this.frontActive = reg.registerIcon(modID + "oreProcessMachines/" + "crusher_Front_Active");
        this.blockIcon = reg.registerIcon(modID + "oreProcessMachines/" + "sidePanels");
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (player.isSneaking())
        {
            return false;
        }
        else
        {
            player.openGui(electrolysmCore.GUIInstance, 0, world, x, y, z);
            return true;
        }
    }

    Random furnaceRand = new Random();
    
    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
    {
        TileEntityCrusher tileentityfurnace = (TileEntityCrusher)par1World.getTileEntity(par2, par3, par4);

        if (tileentityfurnace != null && !(keepInventory))
        {
            for (int j1 = 0; j1 < tileentityfurnace.getSizeInventory(); ++j1)
            {
                ItemStack itemstack = tileentityfurnace.getStackInSlot(j1);

                if (itemstack != null)
                {
                    float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                    float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                    while (itemstack.stackSize > 0)
                    {
                        int k1 = this.furnaceRand.nextInt(21) + 10;

                        if (k1 > itemstack.stackSize)
                        {
                            k1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= k1;
                        EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }

                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)this.furnaceRand.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)this.furnaceRand.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)this.furnaceRand.nextGaussian() * f3);
                        par1World.spawnEntityInWorld(entityitem);
                    }
                }
            }

            par1World.scheduleBlockUpdate(par2, par3, par4, par5, 0);
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
    
    /**
     * Update which block ID the furnace is using depending on whether or not it is burning
     */
    public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
        keepInventory = true;

        if (par0)
        {
            par1World.setBlock(par2, par3, par4, electrolysmCore.crusherActive);
        }
        else
        {
            par1World.setBlock(par2, par3, par4, electrolysmCore.crusher);
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
