package assets.electrolysm.electro.powerSystem;

import assets.electrolysm.api.powerSystem.TileEntityPlug;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.te.TileEntityTeslaTower;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Ben on 27/01/14.
 */
public class keyTransCoppier extends Item
{
    public keyTransCoppier(int id)
    {
        super(id);

        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("keyTransCoppier");
        this.setMaxStackSize(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:" + "copier");
    }

    String key = "";

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x,
         int y, int z, int par7, float par8, float par9, float par10)
    {
        if(player.isSneaking())
        {
            if(world.getBlockId(x, y, z) == electrolysmCore.teslaTowerCore.blockID)
            {
                TileEntity teWorld = world.getBlockTileEntity(x, y, z);

                if(teWorld instanceof TileEntityTeslaTower)
                {
                    TileEntityTeslaTower te = (TileEntityTeslaTower)teWorld;

                    this.key = te.getKeyCode(world, x, y, z);
                    return true;
                }
            }
            else if(world.getBlockId(x, y, z) == electrolysmCore.plug.blockID)
            {
                TileEntity teWorld = world.getBlockTileEntity(x, y ,z);

                if(teWorld instanceof TileEntityPlug)
                {
                    TileEntityPlug te = (TileEntityPlug)teWorld;

                    te.setKey(key);
                    return true;
                }
            }
        }
        return false;
    }

}
