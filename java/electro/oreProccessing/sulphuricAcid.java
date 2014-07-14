package electro.oreProccessing;

import java.util.Random;

import electro.Electrolysm;
import electro.handlers.helpers.Utilities;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import electro.block.liquids.ModFluidSulphuricAcid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class sulphuricAcid extends BlockFluidClassic
{
    @SideOnly(Side.CLIENT)
    public IIcon flowing;
    @SideOnly(Side.CLIENT)
    public IIcon still;

    public sulphuricAcid()
    {
        super(new ModFluidSulphuricAcid(), Material.water);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        //this.setResistance(1000000F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (side <= 1)
        {
            return this.still;
        }
        else
        {
            return this.flowing;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        this.flowing = register.registerIcon("electrolysm:" + "sulpur_flow");
        this.still = register.registerIcon("electrolysm:" + "sulpur_still");
    }

    private void erodeWorld(World world, int x, int y, int z, Random rand)
    {
        world.scheduleBlockUpdate(x, y, z, Electrolysm.sulpuricAcid, tickRate);

        if (rand.nextInt(50) == 1)
        {
            if (Utilities.Block.getBlock(world, x, y - 1, z) == Blocks.dirt ||
                    Utilities.Block.getBlock(world, x, y - 1, z) == Blocks.stone ||
                    Utilities.Block.getBlock(world, x, y - 1, z) == Blocks.grass ||
                    Utilities.Block.getBlockMaterial(world, x, y - 1, z) == Material.ground ||
                    Utilities.Block.getBlockMaterial(world, x, y - 1, z) == Material.rock ||
                    Utilities.Block.getBlockMaterial(world, x, y - 1, z) == Material.wood ||
                    Utilities.Block.getBlock(world, x, y - 1, z) == Blocks.sand ||
                    Utilities.Block.getBlock(world, x, y - 1, z) == Blocks.sandstone ||
                    Utilities.Block.getBlock(world, x, y - 1, z) == Blocks.glass ||
                    Utilities.Block.getBlockMaterial(world, x, y -1, z) == Material.plants ||
                    Utilities.Block.getBlockMaterial(world, x, y -1, z) == Material.ice ||
                    Utilities.Block.getBlockMaterial(world, x, y -1, z) == Material.packedIce)
            {
                if (Utilities.Block.getBlock(world, x, y - 1, z) == Blocks.bedrock ||
                        Utilities.Block.getBlock(world, x, y - 1, z) == Blocks.obsidian)
                {
                }
                else
                {
                    Utilities.Block.setBlock(world, x, y - 1, z, Electrolysm.sulpuricAcid);
                }
            }
            else
            {
                if(Utilities.Block.getBlock(world, x, y - 1, z) == Blocks.mossy_cobblestone)
                {
                    Utilities.Block.setBlock(world, x, y - 1, z, Blocks.cobblestone);
                }
                if(Utilities.Block.getBlock(world, x, y - 1, z) == Blocks.diamond_block)
                {
                    Utilities.Block.setBlock(world, x, y - 1, z, Blocks.gold_block);
                }
                if(Utilities.Block.getBlock(world, x, y - 1, z) == Blocks.gold_block)
                {
                    Utilities.Block.setBlock(world, x, y - 1, z, Blocks.iron_block);
                }
                if(Utilities.Block.getBlock(world, x, y - 1, z) == Blocks.iron_block)
                {
                    Utilities.Block.setBlock(world, x, y - 1, z, Blocks.coal_block);
                }
            }
        }
    }

    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        this.erodeWorld(world, x, y, z, rand);
        int quantaRemaining = quantaPerBlock - world.getBlockMetadata(x, y, z);
        int expQuanta = -101;

        // check adjacent block levels if non-source
        if (quantaRemaining < quantaPerBlock)
        {
            int y2 = y - densityDir;

            if (Utilities.Block.getBlock(world, x,     y2, z) == Electrolysm.sulpuricAcid ||
                    Utilities.Block.getBlock(world, x - 1, y2, z) == Electrolysm.sulpuricAcid ||
                    Utilities.Block.getBlock(world, x + 1, y2, z) == Electrolysm.sulpuricAcid ||
                    Utilities.Block.getBlock(world, x,     y2, z - 1) == Electrolysm.sulpuricAcid ||
                    Utilities.Block.getBlock(world, x,     y2, z + 1) == Electrolysm.sulpuricAcid)
            {
                expQuanta = quantaPerBlock - 1;
            }
            else
            {
                int maxQuanta = -100;
                maxQuanta = getLargerQuanta(world, x - 1, y, z,     maxQuanta);
                maxQuanta = getLargerQuanta(world, x + 1, y, z,     maxQuanta);
                maxQuanta = getLargerQuanta(world, x,     y, z - 1, maxQuanta);
                maxQuanta = getLargerQuanta(world, x,     y, z + 1, maxQuanta);
                expQuanta = maxQuanta - 1;
            }

            // decay calculation
            if (expQuanta != quantaRemaining)
            {
                quantaRemaining = expQuanta;

                if (expQuanta <= 0)
                {
                    world.setBlockToAir(x, y, z);
                }
                else
                {
                    world.setBlockMetadataWithNotify(x, y, z, quantaPerBlock - expQuanta, 3);
                    world.scheduleBlockUpdate(x, y, z, Electrolysm.sulpuricAcid, tickRate);
                    world.notifyBlocksOfNeighborChange(x, y, z, Electrolysm.sulpuricAcid);
                }
            }
        }
        else if (quantaRemaining > quantaPerBlock)
        {
            world.setBlockMetadataWithNotify(x, y, z, 0, 3);
        }

        // Flow vertically if possible
        if (canDisplace(world, x, y + densityDir, z))
        {
            flowIntoBlock(world, x, y + densityDir, z, 1);
            return;
        }

        // Flow outward if possible
        int flowMeta = quantaPerBlock - quantaRemaining + 1;

        if (flowMeta >= quantaPerBlock)
        {
            return;
        }

        if (isSourceBlock(world, x, y, z) || !isFlowingVertically(world, x, y, z))
        {
            if (Utilities.Block.getBlock(world, x, y - densityDir, z) == Electrolysm.sulpuricAcid)
            {
                flowMeta = 1;
            }

            boolean flowTo[] = getOptimalFlowDirections(world, x, y, z);

            if (flowTo[0])
            {
                flowIntoBlock(world, x - 1, y, z,     flowMeta);
            }

            if (flowTo[1])
            {
                flowIntoBlock(world, x + 1, y, z,     flowMeta);
            }

            if (flowTo[2])
            {
                flowIntoBlock(world, x,     y, z - 1, flowMeta);
            }

            if (flowTo[3])
            {
                flowIntoBlock(world, x,     y, z + 1, flowMeta);
            }
        }
    }
    
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) 
    {
    	Random rand = new Random();
    	
    	if(rand.nextInt(50) == 1)
    	{
    		//entity.attackEntityFrom(new DamageSourceSulphuricAcid("death.attack.sulphuricBurn"), rand.nextInt(8));
            if(entity instanceof EntityItem)
            {
                this.doNeutralisation(world, x, y, z, (EntityItem)entity);
            }
    		else if(entity instanceof EntityPlayer)
    		{
                entity.setFire(2);
    			((EntityPlayer)entity).addPotionEffect(new PotionEffect(Electrolysm.acidBurns.id, 200, 1));
    		}
    		else
    		{
                entity.setFire(2);
        		entity.attackEntityFrom(new DamageSourceSulphuricAcid("death.attack.sulphuricBurn"), rand.nextInt(8));
    		}
    	}
    }

    public void doNeutralisation(World world, int x, int y, int z, EntityItem entity)
    {
        if(entity.getEntityItem().getItem() instanceof ItemNeutraliser)
        {
            //neutralize
            this.neutraliseArea(world, x, y, z);
        }
        else
        {
            entity.attackEntityFrom(new DamageSourceSulphuricAcid("death.attack.sulphuricBurn"), new Random().nextInt(8));
        }
    }

    public void neutraliseArea(World world, int x, int y, int z)
    {
        world.setBlock(x, y, z, Blocks.water);

        if(Utilities.Block.getBlock(world, x + 1, y , z) == Electrolysm.sulpuricAcid) {
            sulphuricAcid block = (sulphuricAcid)Utilities.Block.getBlock(world, x + 1, y , z);
            block.neutraliseArea(world, x + 1, y, z);
        }
        if(Utilities.Block.getBlock(world, x - 1, y , z) == Electrolysm.sulpuricAcid) {
            sulphuricAcid block = (sulphuricAcid)Utilities.Block.getBlock(world, x - 1, y , z);
            block.neutraliseArea(world, x - 1, y, z);
        }
        if(Utilities.Block.getBlock(world, x, y + 1 , z) == Electrolysm.sulpuricAcid) {
            sulphuricAcid block = (sulphuricAcid)Utilities.Block.getBlock(world, x, y + 1, z);
            block.neutraliseArea(world, x, y + 1, z);
        }
        if(Utilities.Block.getBlock(world, x, y - 1, z) == Electrolysm.sulpuricAcid) {
            sulphuricAcid block = (sulphuricAcid)Utilities.Block.getBlock(world, x, y - 1, z);
            block.neutraliseArea(world, x, y - 1, z);
        }
        if(Utilities.Block.getBlock(world, x, y , z + 1) == Electrolysm.sulpuricAcid) {
            sulphuricAcid block = (sulphuricAcid)Utilities.Block.getBlock(world, x, y , z + 1);
            block.neutraliseArea(world, x, y, z + 1);
        }
        if(Utilities.Block.getBlock(world, x, y , z - 1) == Electrolysm.sulpuricAcid) {
            sulphuricAcid block = (sulphuricAcid)Utilities.Block.getBlock(world, x, y , z - 1);
            block.neutraliseArea(world, x, y, z - 1);
        }
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion)
    {
        Random rand = new Random();
        float radius = explosion.explosionSize;
        double splash = radius * Math.E;

        for(int xCoord = 0; xCoord < splash; xCoord++)
        {
            for(int zCoord = 0; zCoord < splash; zCoord++)
            {
                if(rand.nextInt(50) == 1)
                {
                    Utilities.Block.setBlock(world, xCoord, y, zCoord, Electrolysm.sulpuricAcid);
                }
            }
        }
    }


}
