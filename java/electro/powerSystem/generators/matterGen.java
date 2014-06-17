package electro.powerSystem.generators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import electro.powerSystem.generators.te.TileEntityGeneratorAntimatter;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class matterGen extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    private Icon frontActive;
    @SideOnly(Side.CLIENT)
    private Icon front;
    
    private static boolean keepInventory;

    private Random furnaceRand = new Random();
    private Map name = new HashMap();

    public matterGen(int id, Material mat, int genID)
    {
        super(id, Material.iron);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("matterGenerator");
        this.setHardness(5.2165F);
        GameRegistry.registerBlock(this);
        LanguageRegistry.addName(this, "Matter-Antimatter Reactor");
        this.setResistance(100F);
    }

    @Override
    public void registerIcons(IconRegister reg)
    {
        String modID = "electrolysm:";
        this.blockIcon = reg.registerIcon(modID + "blastProof");
        this.front = reg.registerIcon(modID + "matterReactor");
        this.frontActive = reg.registerIcon(modID + "matterReactorActive");
    }

    @Override
    public Icon getIcon(int side, int meta)
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
        TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
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
            par1World.setBlockTileEntity(par2, par3, par4, tileentity);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return new TileEntityGeneratorAntimatter();
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
            player.openGui(electrolysmCore.GUIInstance, 0, world, x, y, z);
            return true;
        }
    }

    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        TileEntityGeneratorAntimatter tileentityfurnace = (TileEntityGeneratorAntimatter)par1World.getBlockTileEntity(par2, par3, par4);

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
                        EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

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

            par1World.func_96440_m(par2, par3, par4, par5);
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
    
    @Override
    public void getSubBlocks(int id, CreativeTabs tab, List list)
    {
   		list.add(new ItemStack(this.blockID, 1, 0));
    }
}