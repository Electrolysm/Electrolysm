package electro.research;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
//import electro.handlers.nei.NEIElectrolysmConfig;
import electro.research.gui.TileEntityCollector;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by Ben on 21/06/2014.
 */
public class dataRecorder extends BlockContainer
{
    private IIcon sideIcon;

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
        return new TileEntityCollector();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7,
                                    float par8, float par9)
    {
        if(!player.isSneaking()) {
            player.openGui(Electrolysm.GUIInstance, 0, world, x, y, z);
            return true;
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

               // gui.setOwner(player.getDisplayName());
            }
        }
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        this.blockIcon = reg.registerIcon("electrolysm:dataEvironment_top");
        this.sideIcon = reg.registerIcon("electrolysm:dataEvironment_side");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (side == 0 || side == 1) {
            return blockIcon;
        } else {
            return sideIcon;
        }
    }

    /*
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
    }*/

}
