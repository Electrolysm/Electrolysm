package electro.block.machines;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import electro.electrolysmCore;
import electro.block.machines.tile.TileEntityDesk;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class desk extends BlockContainer
{
    public TileEntityDesk tileEntity = new TileEntityDesk();

    public desk()
    {
        super(Material.iron);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setHardness(4);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        // TODO Auto-generated method stub
        return new TileEntityDesk();
    }

    @SideOnly(Side.CLIENT)
    public boolean addBlockHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer)
    {
        return true;
    }

    //You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType()
    {
        return -1;
    }

    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        /*
        ItemStack stack = player.getHeldItem();
        if(stack == new ItemStack(electrolysmCore.researchPaper))
        {
        	stack.setItemDamage(stack.getItemDamage() - 1);
        }
        return true;*/
        return false;
    }
}
