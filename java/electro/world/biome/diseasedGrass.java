package electro.world.biome;

import java.util.Random;

import electro.Electrolysm;
import electro.handlers.helpers.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.util.ForgeDirection;

public class diseasedGrass extends BlockContainer
{
    int sec;

    public diseasedGrass()
    {
    	
        super(Material.ground);
        // TODO Auto-generated constructor stub
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(1);
        this.setStepSound(Block.soundTypeGrass);
    }

    @SideOnly(Side.CLIENT)
    private IIcon iconGrassTop;

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta)
    {
        if(side == 1)
        {
            return this.iconGrassTop;
        }
        else if(side == 0)
        {
            return Blocks.dirt.getBlockTextureFromSide(1);
        }
        else
        {
            return this.blockIcon;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("electrolysm:" + "grass_side");
        this.iconGrassTop = par1IconRegister.registerIcon("electrolysm:" + "grass_top");
    }

    /**
     * Called whenever an entity is walking on top of this block. Args: world, x, y, z, entity
     */
    public void onEntityWalking(World world, int par2, int par3, int par4, Entity entity)
    {
        if (entity instanceof EntityLiving)
        {
            if (entity.getClass() == EntityZombie_Scientist.class)
            {
            }
            else
            {
                ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.poison.getId(), 500, 200));
            }
        }
    	else if(entity instanceof EntityPlayer)
    	{
            ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.poison.getId(), 500, 200));
    	}
    }

    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return Item.getItemFromBlock(Blocks.dirt);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
        for (int i = 0; i < 4; i++)
        {
            float particleX = x + rand.nextFloat();
            float particleY = y + rand.nextFloat();
            float particleZ = z + rand.nextFloat();
            float particleMotionX = -0.5F + rand.nextFloat();
            float particleMotionY = -0.5F + rand.nextFloat();
            float particleMotionZ = -0.5F + rand.nextFloat();

            if (rand.nextInt(20) == 20)
            {
                this.sec = this.sec + 1;

                if (this.sec == rand.nextInt(60))
                {
                    world.spawnParticle("lava", particleX, particleY, particleZ, particleMotionX, particleMotionY, particleMotionZ);
                }
            }

            if (this.sec >= 60)
            {
                this.sec = 0;
            }
        }
    }
    
    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant)
    {
    	if(plant != null)
    	{
	        if(direction == ForgeDirection.UP)
	        {
	        	if(plant == WorldGenDiseasedTree.treeSapling || plant == Blocks.deadbush)
	        	{
	        		return true;
	        	}
	        }
	        else
	        {
	        	return false;
	        }
    	}
    	return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityGrass();
    }
}
