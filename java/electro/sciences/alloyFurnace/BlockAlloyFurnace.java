package electro.sciences.alloyFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import electro.handlers.helpers.Utilities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Ben on 15/07/2014.
 */
public class BlockAlloyFurnace extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    IIcon[] icons;
    public BlockAlloyFurnace()
    {
        super(Material.iron);

        this.setBlockName("blockAlloyFurnace");
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness((12F / 4F) + 0.056F);

    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        icons = new IIcon[2];
        icons[0] = reg.registerIcon("electrolysm:alloyFurnaceSide");
        icons[1] = reg.registerIcon("electrolysm:alloyFurnaceTop");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if(side == 0 || side == 1) {
            return icons[1];
        } else {
            return icons[0];
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityAlloyFurnace();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
                                    int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {

        if(!player.isSneaking() && isFormed(x, y, z, world))
        {
            player.openGui(Electrolysm.GUIInstance, 0, world, x, y, z);
            return true;
        }

        return false;
    }

    @SideOnly(Side.CLIENT)
    public void printWarning(EntityPlayer player)
    {
    }

    public static boolean isFormed(int x, int y, int z, World world)
    {
        Block chamber = Blocks.brick_block;
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

}
