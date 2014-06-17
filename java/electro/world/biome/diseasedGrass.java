package electro.world.biome;

import java.util.Random;

import assets.electrolysm.api.LoggerHandler;
import assets.electrolysm.electro.configHandler;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class diseasedGrass extends BlockDirt
{
    int sec;

    public diseasedGrass(int par1, Material par2Material)
    {
    	
        super(checkID(par1));
        // TODO Auto-generated constructor stub
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setHardness(1);
        this.setStepSound(Block.soundGrassFootstep);
        this.setUnlocalizedName("diseasedGrass");
    }

    private static int checkID(int par1) 
    {
    	String unlocalizedName1 = "tile.diseasedGrass";

        if(par1 > 255)
        {
			String message = ("Block '" + unlocalizedName1  + 
        			"' has a ID bigger than 255! Please change the blockID in the config file.");
        	for(int i = 0; i < 10; i++)
        	{
        		LoggerHandler.severe(message);
        	}
        	LoggerHandler.severe("Attempting to set '" + unlocalizedName1 + "' to ID 200.");
        	if(blocksList[200] == null)
        	{
        		LoggerHandler.info("Successfully set block ID to 200.");
        		configHandler.diseaseGrassID = 200;
        		return 200;
        	}
        	else
        	{
        		LoggerHandler.severe("Failed to set block ID to 200! Closing Minecraft!");
        		System.exit(0);
        	}
        }
        return par1;
	}

	@SideOnly(Side.CLIENT)
    private Icon iconGrassTop;

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.iconGrassTop : (par1 == 0 ? Block.dirt.getBlockTextureFromSide(par1) : this.blockIcon);
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Electrolysm:" + "grass_side");
        this.iconGrassTop = par1IconRegister.registerIcon("Electrolysm:" + "grass_top");
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

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Block.dirt.blockID;
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
    public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant)
    {
    	if(plant != null)
    	{
	        int plantID = plant.getPlantID(world, x, y + 1, z);
	        
	        if(direction == ForgeDirection.UP && world.provider.dimensionId != 1 && world.provider.dimensionId != -1)
	        {
	        	if(plantID == WorldGenDiseasedTree.treeSapling.blockID || plantID == Block.deadBush.blockID)
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
}
