package electro.oreProccessing;

import electro.Electrolysm;
import electro.handlers.helpers.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import electro.oreProccessing.te.TileEntityElectrolisisCore;
/**
 *
 * @author Ben
 * @TODO Create texture rendering system, based on ItemStack in specified slot.
 *
 */
public class electrolisisCore extends BlockContainer
{
    public String className = "" + this.getClass();
    public String unlocalName = className.replace("assets.electrolysm.electro", "");
    public String textureName = unlocalName.replace(".", "/");

    public electrolisisCore()
    {
        super(Material.iron);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(6.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityElectrolisisCore();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        Block chamberID = Electrolysm.electrolisisCore;
        Block waterID = Blocks.water;

        if (player.isSneaking() && !this.isFormed(x, y, z, world, chamberID, waterID))
        {
            return false;
        }
        else if (!player.isSneaking() && this.isFormed(x, y, z, world, chamberID, waterID))
        {
            player.openGui(Electrolysm.GUIInstance, 0, world, x, y, z);
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isFormed(int x, int y, int z, World world, Block chamberID, Block waterID)
    {
        Block chamber = Electrolysm.electrolChamber;
        Block water = Blocks.water;
        Block air = null;
        boolean isFormed = false;

        //Top row
        if (Utilities.Block.getBlock(world, x, y + 1, z) != chamber)
        {
            if (Utilities.Block.getBlock(world, x + 1, y + 1, z) == chamber)
            {
                if (Utilities.Block.getBlock(world, x + 1, y + 1, z + 1) == chamber)
                {
                    if (Utilities.Block.getBlock(world, x + 1, y + 1, z - 1) == chamber)
                    {
                        if (Utilities.Block.getBlock(world, x - 1, y + 1, z) == chamber)
                        {
                            if (Utilities.Block.getBlock(world, x - 1, y + 1, z + 1) == chamber)
                            {
                                if (Utilities.Block.getBlock(world, x - 1, y + 1, z - 1) == chamber)
                                {
                                    if (Utilities.Block.getBlock(world, x, y + 1, z + 1) == chamber)
                                    {
                                        if (Utilities.Block.getBlock(world, x, y + 1, z - 1) == chamber)
                                        {
                                            //Bottom Row
                                            if (Utilities.Block.getBlock(world, x + 1, y - 1, z) == chamber)
                                            {
                                                if (Utilities.Block.getBlock(world, x + 1, y - 1, z + 1) == chamber)
                                                {
                                                    if (Utilities.Block.getBlock(world, x + 1, y - 1, z - 1) == chamber)
                                                    {
                                                        if (Utilities.Block.getBlock(world, x - 1, y - 1, z) == chamber)
                                                        {
                                                            if (Utilities.Block.getBlock(world, x - 1, y - 1, z + 1) == chamber)
                                                            {
                                                                if (Utilities.Block.getBlock(world, x - 1, y - 1, z - 1) == chamber)
                                                                {
                                                                    if (Utilities.Block.getBlock(world, x, y - 1, z + 1) == chamber)
                                                                    {
                                                                        if (Utilities.Block.getBlock(world, x, y - 1, z - 1) == chamber)
                                                                        {
                                                                            //Middle Row
                                                                            if (Utilities.Block.getBlock(world, x + 1, y, z + 1) == chamber)
                                                                            {
                                                                                if (Utilities.Block.getBlock(world, x - 1, y, z + 1) == chamber)
                                                                                {
                                                                                    if (Utilities.Block.getBlock(world, x + 1, y, z - 1) == chamber)
                                                                                    {
                                                                                        if (Utilities.Block.getBlock(world, x - 1, y, z - 1) == chamber)
                                                                                        {
                                                                                            return true;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return isFormed;
    }

    @Override
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
