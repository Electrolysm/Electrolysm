package electro.powerSystem.generators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import electro.powerSystem.generators.te.TileEntityGeneratorCoal;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class generator extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    private IIcon frontActive;
    @SideOnly(Side.CLIENT)
    private IIcon front;
    
    private static boolean keepInventory;

    private Random furnaceRand = new Random();
    private Map name = new HashMap();

    public generator()
    {
        super(Material.iron);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(5.2165F);
        LanguageRegistry.addName(this, "Coal Generator");
        this.setResistance(100F);
    }

    @Override
    public void registerBlockIcons(IIconRegister reg)
    {
        String modID = "electrolysm:";
        this.blockIcon = reg.registerIcon(modID + "generatorSide");
        this.front = reg.registerIcon(modID + "generatorFront");
        this.frontActive = reg.registerIcon(modID + "matterReactorActive");
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
    	if(side == 0 || side == 1)
    	{
    		return this.blockIcon;
    	}
    	else if(side != 0 && side != 1)
    	{
    		if(meta == 1)
    		{
    			return this.frontActive;
    		}
    		else
    		{
    			return this.front;
    		}
    	}
    	return null;
    }
    
    public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
        TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
        keepInventory = true;

        if (par0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
        }
        else
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
        }

        keepInventory = false;

        if (tileentity != null)
        {
            tileentity.validate();
            par1World.setTileEntity(par2, par3, par4, tileentity);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityGeneratorCoal();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
                                    int par6, float par7, float par8, float par9)
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

    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
    {
    	if(par1World.getTileEntity(par2, par3, par4) instanceof TileEntityGeneratorCoal)
    	{
	        TileEntityGeneratorCoal tileentityfurnace = (TileEntityGeneratorCoal)par1World.getTileEntity(par2, par3, par4);
	
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
    	}
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
    
    @Override
    public void getSubBlocks(Item id, CreativeTabs tab, List list)
    {
   		list.add(new ItemStack(this, 1, 0));
    }
}