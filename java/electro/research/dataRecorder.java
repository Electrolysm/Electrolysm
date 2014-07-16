package electro.research;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
//import electro.handlers.nei.NEIElectrolysmConfig;
import electro.research.te.TileEntityCollector;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

/**
 * Created by Ben on 21/06/2014.
 */
public class dataRecorder extends BlockContainer
{
    public dataRecorder()
    {
        super(Material.iron);
        this.setBlockName("dataRecorder");
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(2.5F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityCollector(1);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7,
                                    float par8, float par9)
    {
        if (player.isSneaking() && player.getHeldItem() == null && world.getTileEntity(x, y, z) instanceof TileEntityCollector)
        {
            TileEntityCollector te = (TileEntityCollector)world.getTileEntity(x, y, z);
            if(world.isRemote)
            {
                this.printMessage(te, player);
                System.out.println("text");
                return true;
            }
        }
        else if(!player.isSneaking() && world.getTileEntity(x, y, z) instanceof TileEntityCollector)
        {
            TileEntityCollector te = (TileEntityCollector)world.getTileEntity(x, y, z);
            if(player.getHeldItem() == null && te.getStackInSlot(0) != null)
            {
                player.inventory.setInventorySlotContents(player.inventory.getFirstEmptyStack(), te.getStackInSlot(0));
                te.setInventorySlotContents(0, null);
                System.out.println("out");

                return true;
            }
            else if((player.getHeldItem() != null && te.getStackInSlot(0) == null))
            {
                if(player.getHeldItem().getItem() instanceof ItemReel)
                {
                    te.setInventorySlotContents(0, player.getHeldItem());
                    player.setItemInUse(null, 0);
                    System.out.println("in");

                    return true;
                }
            }
        }
        return false;
    }

    @SideOnly(Side.CLIENT)
    private void printMessage(TileEntityCollector te, EntityPlayer player)
    {
        if(te.getStackInSlot(0) != null && te.getStackInSlot(0).stackTagCompound != null) {
            int sciValue = te.getStackInSlot(0).stackTagCompound.getInteger("sciValue");
            int engValue = te.getStackInSlot(0).stackTagCompound.getInteger("engValue");
            player.addChatMessage(new ChatComponentTranslation("This collector contains: " + engValue + " Engineering " +
                    "points and " + sciValue + " Science points."));
        }
    }

    @Override //on block placed
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
    {
        if(world.getTileEntity(x, y, z) instanceof TileEntityCollector)
        {
            TileEntityCollector te = (TileEntityCollector)world.getTileEntity(x, y, z);

            if(entity instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer)entity;

               // te.setOwner(player.getDisplayName());
            }
        }
    }

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
