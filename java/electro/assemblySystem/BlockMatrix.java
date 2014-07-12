package electro.assemblySystem;

import electro.Electrolysm;
import electro.assemblySystem.crafting.TileEntityMatrix;
import electro.crafting.items.BasicMicrochip;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Ben on 10/07/2014.
 */
public class BlockMatrix extends BlockContainer
{
    public BlockMatrix()
    {
        super(Material.iron);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(5.256F);
        this.setBlockName("BlockMatrix");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityMatrix();
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

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axis, List list, Entity entity)
    {
        this.setBlockBounds(0, 0, 0, 1, 2, 1);

        super.addCollisionBoxesToList(world, x, y, z, axis, list, entity);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
        if(world.getTileEntity(x, y, z) instanceof TileEntityMatrix) {
            TileEntityMatrix entityMatrix = (TileEntityMatrix)world.getTileEntity(x, y, z);
            if(entityMatrix.isConstruct) {
                AxisAlignedBB axis = AxisAlignedBB.getBoundingBox(0, 0, 0, 1, 2, 1);
                return axis;
            }
        }
        AxisAlignedBB axis = AxisAlignedBB.getBoundingBox(0, 0, 0, 1, 1, 1);
        return axis;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_,
                                    float p_149727_7_, float p_149727_8_, float p_149727_9_) {

        if(player != null)
        {
            ItemStack inHand = player.getHeldItem();
            if(inHand != null && inHand.getItem() instanceof BasicMicrochip)
            {
                int size = inHand.stackSize;
                TileEntityMatrix te = (TileEntityMatrix)world.getTileEntity(x, y, z);
                te.setIsConstuct(true);
                if((size - 1) != 0) {
                    player.setItemInUse(new ItemStack(inHand.getItem(), size - 1, inHand.getItemDamage()), 1);
                }
                else
                {
                    player.setItemInUse(null, 1);
                }
                return true;
            }
        }

        return false;
    }
}
